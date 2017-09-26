package view;

import controller.Client;
import controller.OriginPlayerHandler;
import Domain.Player;
import Domain.Pokemon;
import controller.ForeignPlayerHandler;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import util.IConstants;

/**
 *
 * @author Nelson
 */
public class PrincipalWindow extends javax.swing.JFrame implements Observer, IConstants {

    private JLabel[][] pokemonOringinImages;
    private JLabel[][] pokemonOriginNames;
    private JLabel[][] pokemonForeignImages;
    private JLabel[][] pokemonForeignNames;

    private JPanel[][] selectOriginPokemon;
    private JPanel[][] selectForeignPokemon;

    private int originCoachNumber;
    private int foreignCoachNumber;

    private Player originCoach;
    private Player foreighCoach;

    private Client client;

    private Pokemon[][] pokedexOrigin;
    private Pokemon[][] pokedexForeign;
    
    private Pokemon originTradePokemon;
    private Pokemon foreignTradePokemon;

    /**
     * Creates new form PrincipalWindow
     */
    public PrincipalWindow() {
        initComponents();
        initial();
    }

    private void initial() {
        this.setSize(1152, 768);
        this.setLocationRelativeTo(null);
        enterExistingPlayerPane.setVisible(false);
        createPlayerPane.setVisible(false);
        originPlayerPokemonsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = evt.getX() / 150;
                int j = evt.getY() / 150;

                if(originCoach != null) {
                    for (JPanel[] selectOriginPokemon1 : selectOriginPokemon) {
                        for (int l = 0; l < selectOriginPokemon[0].length; l++) {
                            selectOriginPokemon1[l].setBorder(null);
                        }
                    }
                    originTradePokemon = pokedexOrigin[i][j];
                    
                    selectOriginPokemon[i][j].setBorder(BorderFactory.createLineBorder(Color.red));
                    originPokemonName.setText("Nombre: " + originTradePokemon.getName());
                    originPokemonType1.setText("Tipo 1: " + originTradePokemon.getType1());
                    originPokemonType2.setText("Tipo 2: " + originTradePokemon.getType2());
                    originPokemonEggGroup1.setText("Huevo grupo 1: " + originTradePokemon.getEggGroup1());
                    originPokemonEggGroup2.setText("Huevo grupo 2: " + originTradePokemon.getEggGroup2());
                    originPokemonOriginalCoach.setText("Entrenador original: " + originTradePokemon.getOriginalCoach());
                    originPokemonCoach.setText("Entrenador actual: " + originTradePokemon.getCoach());
                }
            }
        });

        foreingPlayerPokemonsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int i = evt.getX() / 150;
                int j = evt.getY() / 150;

                if (foreighCoach != null) {
                    for (JPanel[] selectForeignPokemon1 : selectForeignPokemon) {
                        for (int l = 0; l < selectForeignPokemon[0].length; l++) {
                            selectForeignPokemon1[l].setBorder(null);
                        }
                    }
                    foreignTradePokemon = pokedexForeign[i][j];
                    
                    selectForeignPokemon[i][j].setBorder(BorderFactory.createLineBorder(Color.blue));
                    foreignPokemonName.setText("Nombre: " + foreignTradePokemon.getName());
                    foreignPokemonType1.setText("Tipo 1: " + foreignTradePokemon.getType1());
                    foreignPokemonType2.setText("Tipo 2: " + foreignTradePokemon.getType2());
                    foreignPokemonEggGroup1.setText("Huevo grupo 1: " + foreignTradePokemon.getEggGroup1());
                    foreignPokemonEggGroup2.setText("Huevo grupo 2: " + foreignTradePokemon.getEggGroup2());
                    foreignPokemonOriginalCoach.setText("Entrenador original: " + foreignTradePokemon.getOriginalCoach());
                    foreignPokemonCoach.setText("Entrenador actual: " + foreignTradePokemon.getCoach());
                }
            }
        });
        pokemonOringinImages = new JLabel[3][2];
        pokemonOriginNames = new JLabel[3][2];

        pokemonForeignImages = new JLabel[3][2];
        pokemonForeignNames = new JLabel[3][2];

        selectOriginPokemon = new JPanel[3][2];
        selectForeignPokemon = new JPanel[3][2];

        pokedexOrigin = new Pokemon[3][2];
        pokedexForeign = new Pokemon[3][2];

        this.originCoachNumber = 0;
        this.foreignCoachNumber = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        loginConnectionPane = new javax.swing.JPanel();
        loadLoginPanelBtn = new javax.swing.JButton();
        createPlayerBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        enterExistingPlayerPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        coachNumberTextField = new javax.swing.JTextField();
        createPlayerLabel = new javax.swing.JLabel();
        createPlayerPane = new javax.swing.JPanel();
        originPlayerPokemonsPanel = new javax.swing.JPanel();
        foreingPlayerPokemonsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        originPokemonName = new javax.swing.JLabel();
        originPokemonType1 = new javax.swing.JLabel();
        originPokemonType2 = new javax.swing.JLabel();
        originPokemonEggGroup1 = new javax.swing.JLabel();
        originPokemonEggGroup2 = new javax.swing.JLabel();
        originPokemonOriginalCoach = new javax.swing.JLabel();
        originPokemonCoach = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tradePokemonBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        foreingCoachNumberTxtField = new javax.swing.JTextField();
        searchForeignCoachBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        foreignPokemonName = new javax.swing.JLabel();
        foreignPokemonType1 = new javax.swing.JLabel();
        foreignPokemonType2 = new javax.swing.JLabel();
        foreignPokemonEggGroup1 = new javax.swing.JLabel();
        foreignPokemonEggGroup2 = new javax.swing.JLabel();
        foreignPokemonOriginalCoach = new javax.swing.JLabel();
        foreignPokemonCoach = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1152, 1200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(1152, 864));

        loginConnectionPane.setBackground(new java.awt.Color(255, 255, 255));
        loginConnectionPane.setPreferredSize(new java.awt.Dimension(1152, 864));
        loginConnectionPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loadLoginPanelBtn.setText("Ingresar");
        loadLoginPanelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadLoginPanelBtnActionPerformed(evt);
            }
        });
        loginConnectionPane.add(loadLoginPanelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 100, 40));

        createPlayerBtn.setText("Crear jugador");
        createPlayerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPlayerBtnActionPerformed(evt);
            }
        });
        loginConnectionPane.add(createPlayerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, -1, 40));

        jLabel1.setText("Seleccione la opción de ingreso");
        loginConnectionPane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        enterExistingPlayerPane.setBackground(new java.awt.Color(255, 255, 255));
        enterExistingPlayerPane.setPreferredSize(new java.awt.Dimension(1152, 864));
        enterExistingPlayerPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Ingrese su número de entrenador");
        enterExistingPlayerPane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        loginBtn.setText("Ingresar");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        loginBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginBtnKeyPressed(evt);
            }
        });
        enterExistingPlayerPane.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, -1));

        coachNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                coachNumberTextFieldKeyPressed(evt);
            }
        });
        enterExistingPlayerPane.add(coachNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 150, -1));

        createPlayerLabel.setBackground(new java.awt.Color(0, 0, 0));
        createPlayerLabel.setForeground(new java.awt.Color(0, 0, 204));
        createPlayerLabel.setText("Crear jugador");
        createPlayerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createPlayerLabelMouseClicked(evt);
            }
        });
        enterExistingPlayerPane.add(createPlayerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 90, -1));

        createPlayerPane.setBackground(new java.awt.Color(255, 255, 255));
        createPlayerPane.setPreferredSize(new java.awt.Dimension(1152, 864));

        originPlayerPokemonsPanel.setBackground(new java.awt.Color(153, 204, 255));
        originPlayerPokemonsPanel.setPreferredSize(new java.awt.Dimension(475, 300));

        javax.swing.GroupLayout originPlayerPokemonsPanelLayout = new javax.swing.GroupLayout(originPlayerPokemonsPanel);
        originPlayerPokemonsPanel.setLayout(originPlayerPokemonsPanelLayout);
        originPlayerPokemonsPanelLayout.setHorizontalGroup(
            originPlayerPokemonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        originPlayerPokemonsPanelLayout.setVerticalGroup(
            originPlayerPokemonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        foreingPlayerPokemonsPanel.setBackground(new java.awt.Color(153, 204, 255));
        foreingPlayerPokemonsPanel.setPreferredSize(new java.awt.Dimension(475, 300));

        javax.swing.GroupLayout foreingPlayerPokemonsPanelLayout = new javax.swing.GroupLayout(foreingPlayerPokemonsPanel);
        foreingPlayerPokemonsPanel.setLayout(foreingPlayerPokemonsPanelLayout);
        foreingPlayerPokemonsPanelLayout.setHorizontalGroup(
            foreingPlayerPokemonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        foreingPlayerPokemonsPanelLayout.setVerticalGroup(
            foreingPlayerPokemonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        originPokemonName.setText("Nombre: ");

        originPokemonType1.setText("Tipo 1:");

        originPokemonType2.setText("Tipo 2:");

        originPokemonEggGroup1.setText("Huevo grupo 1:");

        originPokemonEggGroup2.setText("Huevo grupo 2:");

        originPokemonOriginalCoach.setText("Entrenador original:");

        originPokemonCoach.setText("Entrenador actual:");

        jLabel4.setText("Pokemon origin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(originPokemonType1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(originPokemonName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(originPokemonType2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(originPokemonEggGroup1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(originPokemonEggGroup2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(originPokemonOriginalCoach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(originPokemonCoach, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(originPokemonName)
                .addGap(18, 18, 18)
                .addComponent(originPokemonType1)
                .addGap(18, 18, 18)
                .addComponent(originPokemonType2)
                .addGap(18, 18, 18)
                .addComponent(originPokemonEggGroup1)
                .addGap(18, 18, 18)
                .addComponent(originPokemonEggGroup2)
                .addGap(18, 18, 18)
                .addComponent(originPokemonOriginalCoach)
                .addGap(18, 18, 18)
                .addComponent(originPokemonCoach)
                .addContainerGap())
        );

        tradePokemonBtn.setText("Intercambiar Pokemon");
        tradePokemonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tradePokemonBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Encontrar entrenador");

        foreingCoachNumberTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                foreingCoachNumberTxtFieldKeyPressed(evt);
            }
        });

        searchForeignCoachBtn.setText("Buscar");
        searchForeignCoachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchForeignCoachBtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        foreignPokemonName.setText("Nombre: ");

        foreignPokemonType1.setText("Tipo 1:");

        foreignPokemonType2.setText("Tipo 2:");

        foreignPokemonEggGroup1.setText("Huevo grupo 1:");

        foreignPokemonEggGroup2.setText("Huevo grupo 2:");

        foreignPokemonOriginalCoach.setText("Entrenador original:");

        foreignPokemonCoach.setText("Entrenador actual:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(foreignPokemonType1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(foreignPokemonName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(foreignPokemonType2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(foreignPokemonEggGroup1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(foreignPokemonEggGroup2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(foreignPokemonOriginalCoach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(foreignPokemonCoach, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(foreignPokemonName)
                    .addGap(18, 18, 18)
                    .addComponent(foreignPokemonType1)
                    .addGap(18, 18, 18)
                    .addComponent(foreignPokemonType2)
                    .addGap(18, 18, 18)
                    .addComponent(foreignPokemonEggGroup1)
                    .addGap(18, 18, 18)
                    .addComponent(foreignPokemonEggGroup2)
                    .addGap(18, 18, 18)
                    .addComponent(foreignPokemonOriginalCoach)
                    .addGap(18, 18, 18)
                    .addComponent(foreignPokemonCoach)
                    .addContainerGap(31, Short.MAX_VALUE)))
        );

        jLabel5.setText("Tu lista de pokemons");

        jLabel6.setText("Lista de pokemones otro entrenador");

        javax.swing.GroupLayout createPlayerPaneLayout = new javax.swing.GroupLayout(createPlayerPane);
        createPlayerPane.setLayout(createPlayerPaneLayout);
        createPlayerPaneLayout.setHorizontalGroup(
            createPlayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPlayerPaneLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(createPlayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(originPlayerPokemonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(foreingPlayerPokemonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(createPlayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createPlayerPaneLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(tradePokemonBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(createPlayerPaneLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(createPlayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(createPlayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(createPlayerPaneLayout.createSequentialGroup()
                                .addGap(18, 44, Short.MAX_VALUE)
                                .addGroup(createPlayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(foreingCoachNumberTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(169, 169, 169))
                            .addGroup(createPlayerPaneLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(searchForeignCoachBtn)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(createPlayerPaneLayout.createSequentialGroup()
                .addGroup(createPlayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createPlayerPaneLayout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel5))
                    .addGroup(createPlayerPaneLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel6)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        createPlayerPaneLayout.setVerticalGroup(
            createPlayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPlayerPaneLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createPlayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(originPlayerPokemonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(createPlayerPaneLayout.createSequentialGroup()
                        .addGroup(createPlayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(createPlayerPaneLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(foreingCoachNumberTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchForeignCoachBtn))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tradePokemonBtn)))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createPlayerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(foreingPlayerPokemonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(loginConnectionPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(enterExistingPlayerPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(createPlayerPane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginConnectionPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(enterExistingPlayerPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(createPlayerPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(loginConnectionPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(enterExistingPlayerPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(createPlayerPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadLoginPanelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadLoginPanelBtnActionPerformed
        loginConnectionPane.setVisible(false);
        enterExistingPlayerPane.setVisible(true);
        coachNumberTextField.grabFocus();
    }//GEN-LAST:event_loadLoginPanelBtnActionPerformed

    public void createPlayerView() {
        createPlayerPane.setVisible(true);
        enterExistingPlayerPane.setVisible(false);
        loginConnectionPane.setVisible(false);

        for (int i = 0; i < pokemonOringinImages.length; i++) {
            for (int j = 0; j < pokemonOringinImages.length - 1; j++) {
                //Jugador local
                pokemonOringinImages[i][j] = new JLabel();
                originPlayerPokemonsPanel.add(pokemonOringinImages[i][j]).setBounds((i * 150) + 25, (j * 150), 150, 150);

                pokemonOriginNames[i][j] = new JLabel();
                originPlayerPokemonsPanel.add(pokemonOriginNames[i][j]).setBounds((i * 150) + 50, (j * 150) + 5, 100, 25);

                selectOriginPokemon[i][j] = new JPanel();
                originPlayerPokemonsPanel.add(selectOriginPokemon[i][j]).setBounds((i * 150) + 11, (j * 140) + 11, 130, 130);
                selectOriginPokemon[i][j].setOpaque(false);

                //Jugador externo                
                pokemonForeignImages[i][j] = new JLabel();
                foreingPlayerPokemonsPanel.add(pokemonForeignImages[i][j]).setBounds((i * 150) + 25, (j * 150), 150, 150);

                pokemonForeignNames[i][j] = new JLabel();
                foreingPlayerPokemonsPanel.add(pokemonForeignNames[i][j]).setBounds((i * 150) + 50, (j * 150) + 5, 100, 25);

                selectForeignPokemon[i][j] = new JPanel();
                foreingPlayerPokemonsPanel.add(selectForeignPokemon[i][j]).setBounds((i * 150) + 11, (j * 140) + 11, 130, 130);
                selectForeignPokemon[i][j].setOpaque(false);
            }
        }
    }

    private void createPlayerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPlayerBtnActionPerformed
        client = new Client(CREATE_NEW_PLAYER);
        client.getOriginPlayerHandler().addObserver(this);
        client.start();
    }//GEN-LAST:event_createPlayerBtnActionPerformed

    private void createPlayerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createPlayerLabelMouseClicked
        client = new Client(CREATE_NEW_PLAYER);
        client.getOriginPlayerHandler().addObserver(this);
        client.start();
    }//GEN-LAST:event_createPlayerLabelMouseClicked

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        loadOriginPlayer();
    }//GEN-LAST:event_loginBtnActionPerformed

    private void searchForeignCoachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchForeignCoachBtnActionPerformed
        loadForeignPlayer();
    }//GEN-LAST:event_searchForeignCoachBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        client = new Client(LOG_OUT, originCoachNumber, originCoach);
        client.getOriginPlayerHandler().addObserver(this);
        client.start();
    }//GEN-LAST:event_formWindowClosing

    private void loginBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginBtnKeyPressed
        
    }//GEN-LAST:event_loginBtnKeyPressed

    private void coachNumberTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coachNumberTextFieldKeyPressed
        if (evt.getKeyChar()== KeyEvent.VK_ENTER){
            loadOriginPlayer();
        }        
    }//GEN-LAST:event_coachNumberTextFieldKeyPressed

    private void foreingCoachNumberTxtFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_foreingCoachNumberTxtFieldKeyPressed
        if (evt.getKeyChar()== KeyEvent.VK_ENTER){
            loadForeignPlayer();
        }
    }//GEN-LAST:event_foreingCoachNumberTxtFieldKeyPressed

    private void tradePokemonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tradePokemonBtnActionPerformed
        if (originTradePokemon == null && foreignTradePokemon == null) {
            JOptionPane.showMessageDialog(null, "Debe de seleccionar los pokemones para el intercambio");
        } else if (originTradePokemon == null) {
            JOptionPane.showMessageDialog(null, "Seleccina el pokemon que deseas intercambiar con el otro entrenador");
        } else if (foreignTradePokemon == null) {
            JOptionPane.showMessageDialog(null, "Selecciona el pokemon del otro entrenador que deseas obtener por intercambio");
        } else {
            client = new Client(TRADE_POKEMONS, originCoach, foreighCoach, originTradePokemon, foreignTradePokemon);
            client.getOriginPlayerHandler().addObserver(this);
            client.start();
        }            
    }//GEN-LAST:event_tradePokemonBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField coachNumberTextField;
    private javax.swing.JButton createPlayerBtn;
    private javax.swing.JLabel createPlayerLabel;
    private javax.swing.JPanel createPlayerPane;
    private javax.swing.JPanel enterExistingPlayerPane;
    private javax.swing.JLabel foreignPokemonCoach;
    private javax.swing.JLabel foreignPokemonEggGroup1;
    private javax.swing.JLabel foreignPokemonEggGroup2;
    private javax.swing.JLabel foreignPokemonName;
    private javax.swing.JLabel foreignPokemonOriginalCoach;
    private javax.swing.JLabel foreignPokemonType1;
    private javax.swing.JLabel foreignPokemonType2;
    private javax.swing.JTextField foreingCoachNumberTxtField;
    private javax.swing.JPanel foreingPlayerPokemonsPanel;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loadLoginPanelBtn;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel loginConnectionPane;
    private javax.swing.JPanel originPlayerPokemonsPanel;
    private javax.swing.JLabel originPokemonCoach;
    private javax.swing.JLabel originPokemonEggGroup1;
    private javax.swing.JLabel originPokemonEggGroup2;
    private javax.swing.JLabel originPokemonName;
    private javax.swing.JLabel originPokemonOriginalCoach;
    private javax.swing.JLabel originPokemonType1;
    private javax.swing.JLabel originPokemonType2;
    private javax.swing.JButton searchForeignCoachBtn;
    private javax.swing.JButton tradePokemonBtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof OriginPlayerHandler) { 
            if (arg instanceof Player){
                originCoach = (Player) arg;
                
                createPlayerView();
                Pokemon pokemon;
                int k = 0;
                for (int i = 0; i < pokemonOringinImages.length; i++) {
                    for (int j = 0; j < pokemonOringinImages.length - 1; j++) {
                        pokemon = originCoach.getPokedex()[k++];
                        pokemonOringinImages[i][j].setIcon(new ImageIcon(getClass().getResource(pokemon.getImage())));
                        pokemonOriginNames[i][j].setText(pokemon.getName());
                        pokedexOrigin[i][j] = pokemon;
                    }
                }
                originCoachNumber = client.getPlayer().getCoachNumber();
                JOptionPane.showMessageDialog(null, "Su número de entrenador es: " + originCoachNumber);
            } else if (arg instanceof Boolean){
                if (!(Boolean) arg){
                    JOptionPane.showMessageDialog(null, "No existe el entrenador indicado");               
                }
            }
        } else if (o instanceof ForeignPlayerHandler) {
            if (arg instanceof Player){
                foreighCoach = (Player) arg;
                if (foreighCoach != null) {
                    Pokemon pokemon;
                    int k = 0;
                    for (int i = 0; i < pokemonForeignImages.length; i++) {
                        for (int j = 0; j < pokemonForeignImages.length - 1; j++) {
                            pokemon = foreighCoach.getPokedex()[k++];
                            pokemonForeignImages[i][j].setIcon(new ImageIcon(getClass().getResource(pokemon.getImage())));
                            pokemonForeignNames[i][j].setText(pokemon.getName());
                            pokedexForeign[i][j] = pokemon;
                        }
                    }
                    foreignCoachNumber = client.getPlayer().getCoachNumber();
                } else {
                    JOptionPane.showMessageDialog(null, "No existe el entrenador indicado");
                }
            } else if (arg instanceof Boolean){
                if (!(Boolean) arg){                    
                    JOptionPane.showMessageDialog(null, "No existe un entrenador con ese número");
                }                
            }
        }
    }

    private void loadOriginPlayer() {
        try {
            if (!"".equals(coachNumberTextField.getText())) {                
                int coachNumberToFind = Integer.parseInt(coachNumberTextField.getText());
                client = new Client(LOAD_EXISTING_PLAYER, coachNumberToFind);
                client.getOriginPlayerHandler().addObserver(this);
                client.start();
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese su número de entrenador");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El número de entrenador ingresado es incorrecto");
        }
    }

    private void loadForeignPlayer() {
        try {
            if (!"".equals(foreingCoachNumberTxtField.getText())) {
                int coachNumberToFind = Integer.parseInt(foreingCoachNumberTxtField.getText());
                if (originCoachNumber != coachNumberToFind){                    
                    client = new Client(LOAD_FOREIGN_PLAYER, coachNumberToFind);
                    client.getForeignPlayerHandler().addObserver(this);
                    client.start();
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un número de entrenador distinto al suyo");
                }                  
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el número del otro entrenador");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El número de entrenador ingresado es incorrecto");
        }
    }
}
