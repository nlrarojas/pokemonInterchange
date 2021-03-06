package controller;

import domain.Player;
import domain.Pokemon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.IConstants;

/**
 *
 * @author Nelson
 */
public class Client extends Thread implements IConstants {

    private String funcion;
    private int coachNumber;

    private OriginPlayerHandler originPlayerHandler;
    private ForeignPlayerHandler foreignPlayerHandler;
    private PokemonEvolutionHandler evolutionHandler;
    private RefreshPokedex refreshPokedex;

    private Player originCoach;
    private Player foreignCoach;

    private Pokemon originPokemon;
    private Pokemon foreignPokemon;

    public Client(String pFuncion) {
        this.funcion = pFuncion;
        this.originPlayerHandler = new OriginPlayerHandler();
        this.foreignPlayerHandler = new ForeignPlayerHandler();
    }

    public Client(String pFuncion, int pCoachNumber) {
        this.funcion = pFuncion;
        this.coachNumber = pCoachNumber;
        this.originPlayerHandler = new OriginPlayerHandler();
        this.foreignPlayerHandler = new ForeignPlayerHandler();
        this.evolutionHandler = new PokemonEvolutionHandler();
        this.refreshPokedex = new RefreshPokedex();
    }

    public Client(String pFuncion, int pCoachNumber, Player originPlayer) {
        this.funcion = pFuncion;
        this.coachNumber = pCoachNumber;
        this.originPlayerHandler = new OriginPlayerHandler();
        this.foreignPlayerHandler = new ForeignPlayerHandler();
        this.originCoach = originPlayer;
    }

    public Client(String pFuncion, Player pOriginCoach, Player pForeighCoach, Pokemon originTradePokemon, Pokemon foreignTradePokemon) {
        this.funcion = pFuncion;
        this.originPlayerHandler = new OriginPlayerHandler();
        this.foreignPlayerHandler = new ForeignPlayerHandler();
        this.originCoach = pOriginCoach;
        this.foreignCoach = pForeighCoach;
        this.originPokemon = originTradePokemon;
        this.foreignPokemon = foreignTradePokemon;
    }

    public Client(String pFuncion, int originCoachNumber, Pokemon originTradePokemon, Pokemon pokemonEvolution) {
        this.funcion = pFuncion;
        this.coachNumber = originCoachNumber;
        this.originPokemon = originTradePokemon;
        this.foreignPokemon = pokemonEvolution;
        this.evolutionHandler = new PokemonEvolutionHandler();
    }

    @Override
    public void run() {
        try {
            InetAddress direccionIP = InetAddress.getByName(LOOPBACK);//"127.0.0.1"
            Socket socket = new Socket(direccionIP, PORT);

            PrintStream send = new PrintStream(socket.getOutputStream());// output
            BufferedReader receive = new BufferedReader(new InputStreamReader(socket.getInputStream()));// input

            send.println(this.funcion);//primer output

            System.out.println("Tipo de función enviada: " + this.funcion);

            System.out.println("El servidor me envía: " + receive.readLine());//primer input
            String respuestaServidor = receive.readLine();//segundo input
            System.out.println(respuestaServidor);

            if (respuestaServidor.equals(SERVER_READY)) {
                if (funcion.equalsIgnoreCase(CREATE_NEW_PLAYER)) {
                    newPlayer(socket);
                } else if (funcion.equalsIgnoreCase(LOAD_EXISTING_PLAYER)) {
                    send.println(coachNumber);
                    loadOriginPlayer(socket);
                } else if (funcion.equalsIgnoreCase(LOAD_FOREIGN_PLAYER)) {
                    send.println(coachNumber);
                    loadForeignPlayer(socket);
                } else if (funcion.equalsIgnoreCase(LOG_OUT)) {
                    send.println(coachNumber);
                    logOutPlayer(socket);
                } else if (funcion.equalsIgnoreCase(TRADE_POKEMONS)) {
                    tradePokemons(socket);
                } else if (funcion.equalsIgnoreCase(POKEMON_EVOLUTION)) {
                    send.println(coachNumber);
                    getNextEvolutionForPokemon(socket);
                } else if (funcion.equalsIgnoreCase(UPDATE_POKEDEX)) {
                    send.println(coachNumber);
                    updatePokedexOfCoach(socket);
                } else if (funcion.equalsIgnoreCase(REFRESH_POKEDEX)) {
                    send.println(coachNumber);
                    refreshPokedex(socket);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se puede realizar la conexión con el servidor");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void newPlayer(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());
        originCoach = (Player) objectIn.readObject();
        originPlayerHandler.setChanged(originCoach);
    }

    private void loadOriginPlayer(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());
        Object inputObject = objectIn.readObject();

        if (inputObject instanceof Player) {
            originCoach = (Player) inputObject;
            originPlayerHandler.setChanged(originCoach);
        } else if (inputObject instanceof Boolean) {
            originPlayerHandler.setChanged(false);
        }
    }

    private void loadForeignPlayer(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());
        Object inputObject = objectIn.readObject();

        if (inputObject instanceof Player) {
            originCoach = (Player) inputObject;
            foreignPlayerHandler.setChanged(originCoach);
        } else if (inputObject instanceof Boolean) {
            foreignPlayerHandler.setChanged(false);
        }
    }

    private void logOutPlayer(Socket socket) throws IOException {
        ObjectOutputStream objectOut = new ObjectOutputStream(socket.getOutputStream());
        objectOut.writeObject(originCoach);
    }

    private void tradePokemons(Socket socket) throws IOException, ClassNotFoundException {
        System.out.println("Enviando información");
        ObjectOutputStream objectOut = new ObjectOutputStream(socket.getOutputStream());
        objectOut.writeObject(originCoach);
        objectOut.writeObject(foreignCoach);
        objectOut.writeObject(originPokemon);
        objectOut.writeObject(foreignPokemon);

        ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());
        originCoach = (Player) objectIn.readObject();
        foreignCoach = (Player) objectIn.readObject();

        Player[] playersUpdated = {originCoach, foreignCoach};

        if (originCoach != null && foreignCoach != null) {
            originPlayerHandler.setChanged(playersUpdated);
        }
    }

    private void getNextEvolutionForPokemon(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());
        Pokemon nextPokemonEvolution = (Pokemon) objectIn.readObject();
        evolutionHandler.setChanged(nextPokemonEvolution);
    }

    private void updatePokedexOfCoach(Socket socket) throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOut = new ObjectOutputStream(socket.getOutputStream());
        objectOut.writeObject(originPokemon);
        objectOut.writeObject(foreignPokemon);

        ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());
        int answer = (int) objectIn.readObject();
        evolutionHandler.setChanged(answer);
    }
    
    private void refreshPokedex(Socket socket) throws IOException, ClassNotFoundException {
        ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());
        Object inputObject = objectIn.readObject();
        
        refreshPokedex.setAtributeChanged(inputObject);
    }

    public Player getPlayer() {
        return originCoach;
    }

    public void setPlayer(Player player) {
        this.originCoach = player;
    }

    public OriginPlayerHandler getOriginPlayerHandler() {
        return originPlayerHandler;
    }

    public void setOriginPlayerHandler(OriginPlayerHandler originPlayerHandler) {
        this.originPlayerHandler = originPlayerHandler;
    }

    public ForeignPlayerHandler getForeignPlayerHandler() {
        return foreignPlayerHandler;
    }

    public void setForeignPlayerHandler(ForeignPlayerHandler foreignPlayerHandler) {
        this.foreignPlayerHandler = foreignPlayerHandler;
    }

    public PokemonEvolutionHandler getEvolutionHandler() {
        return evolutionHandler;
    }

    public void setEvolutionHandler(PokemonEvolutionHandler evolutionHandler) {
        this.evolutionHandler = evolutionHandler;
    }

    public RefreshPokedex getRefreshPokedex() {
        return refreshPokedex;
    }

    public void setRefreshPokedex(RefreshPokedex refreshPokedex) {
        this.refreshPokedex = refreshPokedex;
    }        
}
