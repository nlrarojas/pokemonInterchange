package controller;

import Domain.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JPanel;
import util.IConstants;

/**
 *
 * @author Nelson
 */
public class Client extends Thread implements IConstants{

    private String funcion;
    private OriginPlayerHandler originPlayerHandler;
    private ForeignPlayerHandler foreignPlayerHandler;
    private Player player;
    private int coachNumber;    
    
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
                } else if (funcion.equalsIgnoreCase(LOAD_EXISTING_PLAYER)){
                    send.println(coachNumber);
                    loadOriginPlayer(socket);
                } else if (funcion.equalsIgnoreCase(LOAD_FOREIGN_PLAYER)){
                    send.println(coachNumber);
                    loadForeignPlayer(socket);
                }
            }
        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }       
    
    private void newPlayer(Socket socket) throws IOException, ClassNotFoundException{
        System.out.println(CREATE_NEW_PLAYER);
        ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());
        player = (Player) objectIn.readObject();
        System.out.println(player.getPokedex()[0]);
        originPlayerHandler.setChanged(player);
    }
    
    private void loadOriginPlayer(Socket socket) throws IOException, ClassNotFoundException{
        System.out.println(LOAD_EXISTING_PLAYER);
        ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());
        player = (Player) objectIn.readObject();
        System.out.println(player.getPokedex()[0]);
        originPlayerHandler.setChanged(player);
    }
    
    private void loadForeignPlayer(Socket socket) throws IOException, ClassNotFoundException{
        System.out.println(LOAD_FOREIGN_PLAYER);
        ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());
        player = (Player) objectIn.readObject();
        foreignPlayerHandler.setChanged(player);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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
}
