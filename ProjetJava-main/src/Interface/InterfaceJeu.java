/**
* Represents the Game.getGame() interface that displays nodes and allows interactions.
*/

package Interface;
import Representation.* ;
import univers.competences.CompetencesActives;
import univers.personnages.PersoGroupe;
//import univers.personnages.PersoGroupe;
import univers.personnages.PersonnageAdversaire;
import univers.personnages.PersonnageCombattant;
import univers.Collectibles;
//import univers.* ;
import univers.competences.CompetenceDammage;
import univers.competences.CompetenceSoin;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
//import java.util.List;
import javax.swing.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import Event.*;



public class InterfaceJeu {
	
	private static JFrame fenetre = new JFrame(); // Reference to the main frame of the Game.getGame() interface.
	private static JMenuBar barreMenu = new JMenuBar() ;//Reference to the menu bar of the Game.getGame() interface.
    private static JLayeredPane layeredPane =new JLayeredPane();
    private static final Font maFont = new Font("Courier New", Font.PLAIN, 15);
    private static Clip clip;




	 /**
     * Constructs a new Game.getGame() interface and configures the frame.
     */

	public InterfaceJeu() {
		
		configFenetre();
	}

     /**
     * Get the main frame of the Game.getGame() interface.
     * @return The main frame.
     */

    public static JFrame getFenetre() {
	    return fenetre;
    }

     /**
     * Set the main frame of the Game.getGame() interface.
     * @param fenetre The main frame to set.
     */

    public static void setFenetre(JFrame fenetre) {
	    InterfaceJeu.fenetre = fenetre;
    }

     /**
     * Get the menu bar of the Game.getGame() interface.
     * @return The menu bar.
     */

    public static JMenuBar getBarreMenu() {
	    return barreMenu;
    }
    
     /**
     * Set the menu bar of the Game.getGame() interface.
     * @param barreMenu The menu bar to set.
     */
    public static void setBarreMenu(JMenuBar barreMenu) {
	    InterfaceJeu.barreMenu = barreMenu;
    }

    public static JLayeredPane getLayeredPane(){
        return layeredPane;
    }

    public static void setLayeredPane(JLayeredPane layeredPane){
        InterfaceJeu.layeredPane=layeredPane;
    }

     /**
     * Clears the content of the Game.getGame() frame.
     */

    public static void cleanFenetre() {
	    getFenetre().getContentPane().removeAll();
	    getFenetre().revalidate() ;
	    getFenetre().repaint();
    }

     
    public static void POPUP(JButton chooseButton){
     
        configPanel();
        JPanel panelPopUp = new JPanel();
        panelPopUp.setBounds(50, 50, 300, 200);
        panelPopUp.setBackground(Color.white);
        panelPopUp.setVisible(false);
        layeredPane.add(panelPopUp, JLayeredPane.DRAG_LAYER);
        getFenetre().add(layeredPane);
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panelPopUp.isVisible()) {
                    panelPopUp.setVisible(false);
                } else {
                    panelPopUp.setVisible(true);
                }
            }
        });
    }

     /**
     * Configures the Game.getGame() menu including options for inventory, story, and status.
     */

    public static void showMenu(){
        getBarreMenu().setVisible(true);
    }

    public static void hideMenu(){
        getBarreMenu().setVisible(false);
    }

    public static void configMenu() {
        JMenu inventaire = new JMenu("Inventaire");
        JMenu statut = new JMenu("Statut");
        JMenu systeme = new JMenu("Système") ;
    
        JMenuItem stats = new JMenuItem("Statut");
        JMenuItem sauvegarder = new JMenuItem("Sauvegarder") ;
        JMenuItem sauvegarderEtQuitter = new JMenuItem("Sauvegarder et Quitter") ;
        JMenuItem quitter = new JMenuItem("Quitter") ;
        JMenuItem ecranTitre = new JMenuItem("Ecran Titre") ;
        JMenuItem inventairessmenu = new JMenuItem("Inventaire");

        quitter(quitter) ;
        sauvegarder(sauvegarder);
        sauvegarderEtQuitter(sauvegarderEtQuitter);
        ecranTitre(ecranTitre) ;
        statut(stats);
        inventaire(inventairessmenu);
    
        systeme.add(sauvegarder);
        systeme.add(sauvegarderEtQuitter);
        systeme.add(quitter) ;
        systeme.add(ecranTitre) ;
        statut.add(stats);
        inventaire.add(inventairessmenu);
        
        getBarreMenu().add(systeme) ;
        getBarreMenu().add(inventaire);
        getBarreMenu().add(statut);
        getFenetre().setJMenuBar(getBarreMenu());
       
    }

    public static void quitter(JMenuItem quitter){
        quitter.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                            getFenetre().dispose(); // Fermer la fenêtre

                        }
            });
    }

    public static void sauvegarder(JMenuItem sauvegarder) {
        sauvegarder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getGame().sauvegarde() ;
            }
        });
    }

    public static void sauvegarderEtQuitter(JMenuItem sauvegarderEtQuitter){
        sauvegarderEtQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getGame().sauvegarde() ;
                if (!(Game.getGame().getCurrentNode() instanceof FightNode)){
                getFenetre().dispose(); // Fermer la fenêtre
                }

            }
        });
    }

    public static void statut(JMenuItem statut){
        statut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(Game.getGame().getCurrentNode() instanceof FightNode)){
                    ecranStatut();             
                }

            }
        });
    }

    public static void inventaire(JMenuItem statut){
        statut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(Game.getGame().getCurrentNode() instanceof FightNode)){
                    ecranInventaire();
                }

            }
        });
    }

    public static void ecranInventaire(){
        configPanel();
            layeredPane.removeAll();
            layeredPane.revalidate();
            layeredPane.repaint();
    
            getFenetre().getContentPane().setLayout(null);
            getFenetre().revalidate();
            getFenetre().repaint();
    
            configPanel();
            ImageIcon imageIconFon = new ImageIcon("image/ForetJolie.png");
            JLabel labelFond = new JLabel(imageIconFon);
            labelFond.setBounds(0, 0, 1000, 1000);
            layeredPane.add(labelFond, JLayeredPane.DEFAULT_LAYER);

            JPanel panel = new JPanel();
             panel.setBounds(50, 50, 400, 250);
            panel.setOpaque(false);
            ImageIcon imageIcon = new ImageIcon("image/inventaire.png");
            java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(225, 225, java.awt.Image.SCALE_SMOOTH);
            ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
            JLabel label = new JLabel(imageRedimensionneeIcon);
            panel.add(label);
            layeredPane.add(panel, JLayeredPane.POPUP_LAYER);


            JPanel panelText = new JPanel();
            panelText.setBounds(450, 50, 400, 100);
            panelText.setOpaque(false);
            panelText.setBackground(Color.CYAN);

            JEditorPane editorPane = new JEditorPane();
            editorPane.setPreferredSize(new Dimension(400, 100));
            editorPane.setOpaque(false);
            editorPane.setEditable(false);
            editorPane.setContentType("text/html");
            editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));
            editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">"
            + "Liste des objets du groupe :"
            + "</div>");

    JScrollPane panelFight = new JScrollPane();
    panelFight.setBounds(450, 170, 400, 410);
    
    JPanel contentPanel = new JPanel();
    int numberOfColumns = 1; 
    contentPanel.setLayout(new GridLayout(0, numberOfColumns)); 
    panelFight.setViewportView(contentPanel);
    contentPanel.setBackground(Color.BLACK);

    contentPanel.addMouseWheelListener(new MouseWheelListener() {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            JScrollBar verticalScrollBar = panelFight.getVerticalScrollBar();
            verticalScrollBar.setValue(verticalScrollBar.getValue() - e.getUnitsToScroll());
        }
    });
    
    layeredPane.add(panelFight, JLayeredPane.POPUP_LAYER);


    ButtonGroup buttonGroup = new ButtonGroup();
    // JLabel cmp = new JLabel("Liste des Compétences : ", JLabel.CENTER);
    // cmp.setFont(new Font("Courier New", Font.PLAIN, 15));
    // cmp.setForeground(Color.WHITE);
    // contentPanel.add(cmp);
    Map<Collectibles, Integer> inventaire = Game.getGame().getInventaire();
    
    for (Collectibles objet : inventaire.keySet()) {
        JRadioButton radioButton = new JRadioButton("<html>"+objet.getName()+" x"+inventaire.get(objet));
        radioButton.setActionCommand(objet.getName());
        radioButton.setFont(new Font("Courier New", Font.PLAIN, 15));
        radioButton.setForeground(Color.WHITE);
        buttonGroup.add(radioButton);
        contentPanel.add(radioButton); // on crée un radio button pour chacune des compétences du personnage
    }
    JPanel panelText2 = new JPanel();

    JButton validateButton = new JButton("Obtenir plus d'info");
    contentPanel.add(validateButton);
    validateButton.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) { 
                   Collectibles objet = null ;
                    String n = buttonGroup.getSelection().getActionCommand() ;
                    for (Collectibles objet2 : inventaire.keySet()) {
                        if (objet2.getName().equals(n)) {
                            objet = objet2 ;
                        } // on récupère la compétence (un radio button ne peut renvoyer qu'un String)
                    }
                    if (objet!=null){
                        ecranInventaire();
                        afficherDetailObjet(panelText2, objet) ;
                        System.out.println("Bouton cliqué !");
                        
                    }
                }
            });
        
    ButtonRetour();
    ButtonFermer();
    panelText.add(editorPane);
    layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);


    }

    public static void afficherDetailObjet(JPanel panel, Collectibles objet){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    
        panel.setBounds(50, 300, 400, 250);
        panel.setOpaque(false);
        panel.setBackground(Color.CYAN);
        panel.setVisible(true);
                        
        JEditorPane editorPane = new JEditorPane();
        editorPane.setPreferredSize(new Dimension(400, 250));
        editorPane.setOpaque(false);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));
        editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">"
        + "Détail de l'objet : " + objet.getName() + "<br>"
        + "</div>");
    
        // editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">"
        // + "</div>");
        panel.add(editorPane);
        layeredPane.add(panel, JLayeredPane.POPUP_LAYER);
    }

    
    

    public static void ecranStatut() {
        ArrayList<String> imagePathGroupList = new ArrayList<String>();
        for (int i = 0; i < Game.getGame().getGroupeJoueur().size(); i++) {
            imagePathGroupList.add(Game.getGame().getGroupeJoueur().get(i).getImageLien());
        }
    
        if (imagePathGroupList != null) {
            configPanel();
            layeredPane.removeAll();
            layeredPane.revalidate();
            layeredPane.repaint();
    
            getFenetre().getContentPane().setLayout(null);
            getFenetre().revalidate();
            getFenetre().repaint();
    
            configPanel();
            ImageIcon imageIcon = new ImageIcon("image/ForetJolie.png");
            JLabel labelFond = new JLabel(imageIcon);
            labelFond.setBounds(0, 0, 1000, 1000);
            layeredPane.add(labelFond, JLayeredPane.DEFAULT_LAYER);
    
            addPanelWithImage(imagePathGroupList.get(0), 50, 100);
            addTextPanel(Game.getGame().getGroupeJoueurVivant().get(0), 250, 100);
            addTextPanel(Game.getGame().getGroupeJoueurVivant().get(1), 700, 400);
            addTextPanel(Game.getGame().getGroupeJoueurVivant().get(2), 700, 100);
            addTextPanel(Game.getGame().getGroupeJoueurVivant().get(3), 250, 400);

    
            addPanelWithImage(imagePathGroupList.get(1), 500, 400);
            addPanelWithImage(imagePathGroupList.get(2), 500, 100);
            addPanelWithImage(imagePathGroupList.get(2), 50, 400);
            ButtonFermer();
    
            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
        }
    }
    
    public static void ButtonFermer(){
        JPanel panelInner = new JPanel();
		panelInner.setBounds(800, 600, 144, 62);
        
        // Add the "Next" panel to the layered pane
		layeredPane.add(panelInner, JLayeredPane.POPUP_LAYER);
        panelInner.setBackground(Color.yellow);
        panelInner.setOpaque(false);
        
        
        JButton suivant = new JButton("Fermer"); // Create a "Next" button
        suivant.setFont(new Font("Courier New", Font.PLAIN, 11));
        suivant.setBackground(Color.WHITE);
		suivant.setForeground(Color.BLACK);
        panelInner.add(suivant);
        getFenetre().revalidate() ;
        suivant.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                            Game.getGame().getCurrentNode().display();
                            System.out.println("test");	
                        }
            });

    }

    public static void ButtonRetour(){
        JPanel panelInner = new JPanel();
		panelInner.setBounds(650, 600, 144, 62);
        
        // Add the "Next" panel to the layered pane
		layeredPane.add(panelInner, JLayeredPane.POPUP_LAYER);
        panelInner.setBackground(Color.yellow);
        panelInner.setOpaque(false);
        
        
        JButton suivant = new JButton("Retour"); // Create a "Next" button
        suivant.setFont(new Font("Courier New", Font.PLAIN, 11));
        suivant.setBackground(Color.WHITE);
		suivant.setForeground(Color.BLACK);
        panelInner.add(suivant);
        getFenetre().revalidate() ;
        suivant.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                            ecranStatut();
                        }
            });
    }

    public static void ecranDetail(PersoGroupe personnage){
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();

        getFenetre().getContentPane().setLayout(null);
        getFenetre().revalidate();
        getFenetre().repaint();
        ImageIcon imageIconFond = new ImageIcon("image/ForetJolie.png");
        JLabel labelFond = new JLabel(imageIconFond);
        labelFond.setBounds(0, 0, 1000, 1000);
        layeredPane.add(labelFond, JLayeredPane.DEFAULT_LAYER);

    JPanel panel = new JPanel();
    panel.setBounds(50, 50, 400, 250);
    panel.setOpaque(false);
    ImageIcon imageIcon = new ImageIcon(personnage.getImageLien());
    java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(225, 225, java.awt.Image.SCALE_SMOOTH);
    ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
    JLabel label = new JLabel(imageRedimensionneeIcon);
    panel.add(label);
    layeredPane.add(panel, JLayeredPane.POPUP_LAYER);

    JPanel panelText = new JPanel();
    panelText.setBounds(450, 50, 400, 250);
    panelText.setOpaque(false);
    panelText.setBackground(Color.CYAN);

    JEditorPane editorPane = new JEditorPane();
    editorPane.setPreferredSize(new Dimension(400, 250));
    editorPane.setOpaque(false);
    editorPane.setEditable(false);
    editorPane.setContentType("text/html");
    editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));
    editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">"
            + personnage.getName() + "<br>"
            + "Niveau : " + personnage.getLevel() + "<br>"
            + "PV : " + personnage.getLifePoints() + "/" + personnage.getMaxLifePoints() + "<br>"
            + "PM : " + personnage.getMana() + "/" + personnage.getMaxMana() + "<br>"
            + "Force : "+ personnage.getStrength()+ "<br>"
            + "Intelligence : " + personnage.getIntelligence()+ "<br>"
            + "Vitesse : " + personnage.getSpeed()+ "<br>"
            + "Endurance : " + personnage.getEndurance() +  "<br>"
            + "Dextérité : "+ personnage.getDexterity()
            + "</div>");

    JScrollPane panelFight = new JScrollPane();
    panelFight.setBounds(450, 300, 400, 250);
    
    JPanel contentPanel = new JPanel();
    int numberOfColumns = 1; 
    contentPanel.setLayout(new GridLayout(0, numberOfColumns)); 
    panelFight.setViewportView(contentPanel);
    contentPanel.setBackground(Color.BLACK);

    contentPanel.addMouseWheelListener(new MouseWheelListener() {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            JScrollBar verticalScrollBar = panelFight.getVerticalScrollBar();
            verticalScrollBar.setValue(verticalScrollBar.getValue() - e.getUnitsToScroll());
        }
    });
    
    layeredPane.add(panelFight, JLayeredPane.POPUP_LAYER);


    ButtonGroup buttonGroup = new ButtonGroup();
    JLabel cmp = new JLabel("Liste des Compétences : ", JLabel.CENTER);
    cmp.setFont(new Font("Courier New", Font.PLAIN, 15));
    cmp.setForeground(Color.WHITE);
    contentPanel.add(cmp);
    for (int j = 0; j < personnage.getCompetences().size(); j++) {
        JRadioButton radioButton = new JRadioButton("<html>"+personnage.getCompetences().get(j).getName()+personnage.getCompetences().get(j).affichageCoutMana());
        radioButton.setActionCommand(personnage.getCompetences().get(j).getName());
        radioButton.setFont(new Font("Courier New", Font.PLAIN, 15));
        radioButton.setForeground(Color.WHITE);
        buttonGroup.add(radioButton);
        contentPanel.add(radioButton); // on crée un radio button pour chacune des compétences du personnage
    }
    JPanel panelText2 = new JPanel();

    JButton validateButton = new JButton("Obtenir plus d'info");
    contentPanel.add(validateButton);
    validateButton.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) { 
                   CompetencesActives competence = null ;
                    String n = buttonGroup.getSelection().getActionCommand() ;
                    for (int i = 0 ; i<personnage.getCompetences().size();i++) {
                        if (personnage.getCompetences().get(i).getName().equals(n)) {
                            competence = personnage.getCompetences().get(i) ;
                        } // on récupère la compétence (un radio button ne peut renvoyer qu'un String)
                    }
                    if (competence!=null){
                        ecranDetail(personnage);
                        afficherDetailCompetence(competence, panelText2, personnage);
                        System.out.println("Bouton cliqué !");
                        
                    }
                }
            });
        
    ButtonRetour();
    ButtonFermer();
    panelText.add(editorPane);
    layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
}

private static void afficherDetailCompetence(CompetencesActives competence, JPanel panel, PersoGroupe personnage){
    
    panel.removeAll();
    panel.revalidate();
    panel.repaint();
    
    panel.setBounds(50, 300, 400, 250);
    panel.setOpaque(false);
    panel.setBackground(Color.CYAN);
    panel.setVisible(true);
                        
    JEditorPane editorPane = new JEditorPane();
    editorPane.setPreferredSize(new Dimension(400, 250));
    editorPane.setOpaque(false);
    editorPane.setEditable(false);
    editorPane.setContentType("text/html");
    editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));
    if (competence instanceof CompetenceDammage){
        CompetenceDammage competence2 = (CompetenceDammage) competence;
        editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">"
    + competence.getName() + "<br>"
    + "Type : Compétence de dégâts <br>"
    + "Description : "+competence.getDescription()+"<br>"
    + "Cout Mana : "+competence.getCoutMana()+"<br>"
    + "Competence de groupe : " + competence.isGroup()+"<br>"
    + "Puissance : "+ competence2.getPower()+"<br>"
    + "Élément : "+ competence2.getElement()+"<br>"
    + "Précision : "+ competence2.getAccuracy()+"<br>"
    + "Nombre de coup : "+ competence2.getNbHits()
    + "</div>");
    }
    if (competence instanceof CompetenceSoin){
        CompetenceSoin competence2 = (CompetenceSoin) competence;
        editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">"
    + competence.getName() + "<br>"
    + "Type : Compétence de soin <br>"
    + "Description : "+competence.getDescription()+"<br>"
    + "Cout Mana : "+competence.getCoutMana()+"<br>"
    + "Competence de groupe : " + competence.isGroup()+"<br>"
    + "Puissance : "+ competence2.getPowerHeal()+"<br>"
    + "</div>");
    }

    panel.add(editorPane);
    layeredPane.add(panel, JLayeredPane.POPUP_LAYER);
}


    private static void addPanelWithImage(String imagePath, int x, int y) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, 200, 200);
        panel.setOpaque(false);
        ImageIcon imageIcon = new ImageIcon(imagePath);
        java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(190, 190, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
        JLabel label = new JLabel(imageRedimensionneeIcon);
        panel.add(label);
        layeredPane.add(panel, JLayeredPane.POPUP_LAYER);
    }
    
    private static void addTextPanel(PersonnageCombattant personnage, int x, int y) {
        JPanel panelText = new JPanel();
        panelText.setBounds(x, y, 200, 200);
        panelText.setOpaque(false);
        panelText.setBackground(Color.CYAN);
    
        JEditorPane editorPane = new JEditorPane();
        editorPane.setPreferredSize(new Dimension(200, 200));
        editorPane.setOpaque(false);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));
        editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">"
                + personnage.getName() + "<br>"
                + "Niveau : " + personnage.getLevel() + "<br>"
                + "PV : " + personnage.getLifePoints() + "/" + personnage.getMaxLifePoints() + "<br>"
                + "PM : " + personnage.getMana() + "/" + personnage.getMaxMana()
                + "</div>");
        
        

        JButton detail = new JButton("Détails"); // Create a "Next" button
        detail.setFont(new Font("Courier New", Font.PLAIN, 11));
        detail.setBackground(Color.WHITE);
		detail.setForeground(Color.BLACK);
        panelText.add(detail);
        getFenetre().revalidate() ;
        detail.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                            ecranDetail((PersoGroupe)personnage);
                            System.out.println("test");	
                        }
            });
        
        panelText.add(editorPane);
        layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
    }

    public static void ecranTitre(JMenuItem ecranTitre){
        ecranTitre.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                            ecranTitre() ;      
                        }
            });
    }
     /**
     * Configures the Game.getGame() frame including its size, location, and visibility.
     */

    public static void ecranTitre(){
        SwingUtilities.invokeLater(()-> {
        getFenetre().setSize(1000, 1000); //taille fenetre
        getFenetre().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; //sortir correctement de la fenetre
        getFenetre().setLocationRelativeTo(null); // centrer la fenetre sur l'ecran
        cleanFenetre();
        getFenetre().remove(getBarreMenu());
        hideMenu();
        layeredPane.removeAll();
        getFenetre().revalidate();
        getFenetre().repaint();
        getFenetre().setVisible(true); // rendre la fenetre visible
        configPanel();

        getFenetre().getContentPane().setLayout(null);

        
        configPanel();
        ImageIcon imageIcon= new ImageIcon("image/ForetJolie.png");
        JLabel labelFond = new JLabel(imageIcon);
        JPanel panel = new JPanel();
        panel.add(labelFond);
        panel.setOpaque(false);
        panel.setBounds(0, 0, 1000, 1000);
        layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);
        getFenetre().add(layeredPane);
        getFenetre().setVisible(true);
            
    
        JPanel panelText= new JPanel();
        
        panelText.setBounds(80, 200, 850, 300);
        layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
        getFenetre().add(layeredPane);
        JLabel label = new JLabel("<html> <strong>Titre du Jeu </strong>", JLabel.CENTER);// Create a label for displaying the description of the node
        panelText.add(label);
        panelText.setBackground(Color.CYAN); 
        panelText.setOpaque(false);
        label.setFont(new Font("Courier New", Font.PLAIN, 100));
        getFenetre().revalidate();
        getFenetre().repaint();


            try {
            File audioFile = new File("sound/emotional-inspiring-epic-trailer-11258.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Ajoutez un événement pour réinitialiser la position de lecture à 0 lorsque la lecture est terminée
            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.setFramePosition(0);
                        clip.start();
                    }
                }
            });

            // Créez un thread séparé pour jouer en boucle
            Thread loopThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    clip.start();
                }
            });

            loopThread.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

        JPanel panelChoose= new JPanel(); // Create a panel to hold the ChooseNode buttons
        getFenetre().add(layeredPane);
        panelChoose.setBounds(120, 400, 770, 100);
        layeredPane.add(panelChoose, JLayeredPane.POPUP_LAYER);
	    panelChoose.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        panelChoose.setBackground(Color.RED);
        panelChoose.setOpaque(false); 

        // Create buttons for each option in the ChooseNode
            JButton btn1 = new JButton("Nouvelle Partie");
            btn1.setSize(150, 50);

            btn1.setFont(new Font("Courier New", Font.PLAIN, 15));
            btn1.setBackground(Color.WHITE);
		    btn1.setForeground(Color.BLACK);
            panelChoose.add(btn1);

            // Add an ActionListener to handle button clicks
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showMenu();
                    Game.getGame().getFirstNode().display() ; 
                         
                }
            });
        
            File dossierSauvegardes = new File("Sauvegardes");
        if (dossierSauvegardes.exists()) {
        
        JButton btn2 = new JButton("Charger une partie");
        btn2.setSize(300, 100);
    
        btn2.setFont(new Font("Courier New", Font.PLAIN, 15));
            btn2.setBackground(Color.WHITE);
		    btn2.setForeground(Color.BLACK);
            panelChoose.add(btn2);

            // Add an ActionListener to handle button clicks
            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ecranSauvegarde() ;
                }
            });
        
        }

        JButton btn3 = new JButton("Quitter le jeu");
        btn3.setSize(300, 100);
        btn3.setFont(new Font("Courier New", Font.PLAIN, 15));
            btn3.setBackground(Color.WHITE);
		    btn3.setForeground(Color.BLACK);
            panelChoose.add(btn3);

            // Add an ActionListener to handle button clicks
            btn3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getFenetre().dispose(); // Fermer la fenêtre
                }
            });

        getFenetre().add(layeredPane) ;
        });
    }

    public static void ecranSauvegarde(){
        
        SwingUtilities.invokeLater(()-> {
        configPanel();
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        
	    getFenetre().getContentPane().setLayout(null);
        getFenetre().revalidate();
        getFenetre().repaint();

         configPanel();
            ImageIcon imageIcon= new ImageIcon("image/ForetJolie.png");
            JLabel labelFond = new JLabel(imageIcon);
            JPanel panel = new JPanel();
            panel.add(labelFond);
            panel.setOpaque(false);
            panel.setBounds(0, 0, 1000, 1000);
            layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);
            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
    
        JScrollPane panelSauvegarde = new JScrollPane();
        panelSauvegarde.setBounds(250, 110, 500, 500);
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        panelSauvegarde.setOpaque(false);
        int numberOfColumns = 1; // Vous pouvez ajuster le nombre de colonnes en fonction de vos besoins
        contentPanel.setLayout(new GridLayout(0, numberOfColumns)); // 0 pour un nombre de lignes dynamique
        panelSauvegarde.setViewportView(contentPanel);

        layeredPane.add(panelSauvegarde, JLayeredPane.POPUP_LAYER);
        JLabel label = new JLabel("<html> <div style=\"color: #ffffff;\"><strong> Choisissez la partie à charger </strong></div>", JLabel.CENTER);// Create a label for displaying the description of the node
        contentPanel.add(label);
        contentPanel.setBackground(Color.BLACK); 
        label.setFont(new Font("Courier New", Font.PLAIN, 25));
        contentPanel.setOpaque(true);

        // Ajoute un écouteur pour gérer la molette de la souris au premier JScrollPane
        contentPanel.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                // Défilement vertical en fonction de l'événement de la molette
                JScrollBar verticalScrollBar = panelSauvegarde.getVerticalScrollBar();
                verticalScrollBar.setValue(verticalScrollBar.getValue() - e.getUnitsToScroll());
            }
        });

    
        ButtonGroup buttonGroup = new ButtonGroup();
        String cheminDossier = "Sauvegardes";
        File dossier = new File(cheminDossier);
        
        // Vérifiez si le chemin correspond à un dossier existant
        if (dossier.isDirectory()) {
            // Obtenez la liste des fichiers et dossiers dans le dossier
            File[] fichiers = dossier.listFiles();
            // Parcourez la liste des fichiers et dossiers
            if (fichiers != null) {
                ArrayList<File> listeFichier = new ArrayList<File>() ;
                for (File fichier : fichiers){
                    listeFichier.add(fichier);
                }

            Comparator<File> comparateurDate = (fichier1, fichier2) -> {
                try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
                Date date1 = sdf.parse(fichier1.getName().substring(11, 30));
                Date date2 = sdf.parse(fichier2.getName().substring(11, 30));
                return date2.compareTo(date1);
                } catch (ParseException e) {
                    e.printStackTrace();
                return 0;
                }
            };

            Collections.sort(listeFichier, comparateurDate);
                
                for (File fichier : listeFichier) {

                    JRadioButton radioButton = new JRadioButton(fichier.getName());
                    radioButton.setFont(new Font("Courier new", Font.PLAIN, 15));
                    radioButton.setActionCommand(fichier.getName());
                    radioButton.setForeground(Color.WHITE);
                    buttonGroup.add(radioButton);
                    contentPanel.add(radioButton);
                }


            }
        } else {
            System.out.println("Le chemin spécifié ne correspond pas à un dossier existant.");
        }


        JButton validateButton = new JButton("Valider");
        validateButton.setFont(new Font("Courier new", Font.PLAIN, 15));
        contentPanel.add(validateButton);
        validateButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) { 
                        String n = buttonGroup.getSelection().getActionCommand() ;
                        if (dossier.isDirectory()) {
                            File[] fichiers = dossier.listFiles();
                            if (fichiers != null) {
                                for (File fichier : fichiers) {
                                    if (fichier.getName().equals(n)){
                                        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Sauvegardes/"+n))) {
                                            Game partieAcharger = (Game)ois.readObject();
                                            Game.setGame(partieAcharger) ;
                                            showMenu();                                            
                                            Game.getGame().getCurrentNode().display();
                                            break ;
                                        } catch (IOException | ClassNotFoundException f) {
                                            f.printStackTrace();
                                        }
                                        
                                        
                                    }
                                }
                            } else {
                                System.out.println("Le chemin spécifié ne correspond pas à un dossier existant.");
                            }
                        }
                        
                        layeredPane.remove(panelSauvegarde);
                        layeredPane.revalidate();
                        layeredPane.repaint();
                    }
                    
                });        
        getFenetre().revalidate();
        getFenetre().repaint();
        getFenetre().add(layeredPane);

        });

        
    }
    

    public static void configFenetre() {

        getFenetre().setSize(1000, 1000); //taille fenetre
        getFenetre().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; //sortir correctement de la fenetre
        getFenetre().setLocationRelativeTo(null); // centrer la fenetre sur l'ecran
        configMenu() ;
        getFenetre().setVisible(true); // rendre la fenetre visible

    
    }
    public static void configPanel(){
        layeredPane.setBounds(0, 0, 1000, 1000);
    }

    /**
     * Displays a base node in the Game.getGame() interface.
     * @param node The node to be displayed.
     */

    public void afficherperso(Node node){
        if (node.getImagePersoList().size()>5){
            throw new IllegalArgumentException("Le jeu ne peut afficher que 5 persos à la fois ! Node concerné : "+node.getNom());
        }
        ArrayList<String> imageperso = node.getImagePersoList();
        if (imageperso!=null){
            JPanel panel= new JPanel(new FlowLayout());
            panel.setBounds(60, 350, 650, 270);
            panel.setOpaque(false);
            for (String  element : imageperso) {
                ImageIcon imageIcon= new ImageIcon(element);
                // Redimensionnement de l'image
                // On redimentionne en width 130 pour pouvoir faire rentrer 5 personnages
                java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
                JLabel label = new JLabel(imageRedimensionneeIcon);
                panel.add(label);
            }
            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
            layeredPane.add(panel, JLayeredPane.POPUP_LAYER);
            
            getFenetre().revalidate();
            getFenetre().repaint();
        }
    }


 public void afficherNodeBase(Node node) {
        
        configPanel();
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        afficherImageDansInterface(node.getImageName());
        Clip clip =afficherSoundDansInterface(node.getSoundName());

	    getFenetre().getContentPane().setLayout(null);

        this.afficherperso(node) ;
        
        JPanel panelText= new JPanel();// Create a panel for the text content of the node
        JEditorPane editorPane = new JEditorPane();
 
        panelText.setBounds(60, 50, 850, 300);
        editorPane.setPreferredSize(new Dimension(850, 300));
        layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
        getFenetre().add(layeredPane);
         

        JLabel label = new JLabel("", JLabel.CENTER);// Create a label for displaying the description of the node
        
        panelText.add(label);

        
        label.setOpaque(false);
        panelText.setOpaque(false);
        label.setFont(new Font("Courier new", Font.PLAIN, 20));
        label.setForeground(Color.BLACK);
        editorPane.setOpaque(false);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));

        getFenetre().revalidate();
        getFenetre().repaint();


        editorPane.setOpaque(false);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));
        
        panelText.add(editorPane);
	
        char[] texts = node.getDescription().toCharArray(); // Convert the description text of the node to a character array
        
        Timer timer = new Timer(10, new ActionListener() { // Create a timer to display the description character by character
        int index = 0; // Index to retrieve each character from the description
        StringBuilder textBuilder = new StringBuilder("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\"></div>");
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (index < texts.length) { 
                char nextChar = texts[index];
                    if ((nextChar == '/') && !(texts[index - 1] == '<')) {
                        String balise = "</div>";
                        int position = textBuilder.indexOf(balise);

                        // Vérifier si la balise a été trouvée
                        if (position != -1) {
                             // Insérer le texte juste avant la balise </font>
                            textBuilder.insert(position, "<br>");

                            // Afficher le résultat
                        } else {
                            throw new IllegalStateException("Balise </font> non trouvée dans la chaîne !");
                        }
                        
                        
                        editorPane.setText(textBuilder.toString());
                        index++;
                
                }
                else{
                    String balise = "</div>";
                    int position = textBuilder.indexOf(balise);

                        // Vérifier si la balise a été trouvée
                         if (position != -1) {

                             // Insérer le texte juste avant la balise </font>
                            textBuilder.insert(position, nextChar);

                            // Afficher le résultat
                        } else {
                            throw new IllegalStateException("Balise </font> non trouvée dans la chaîne !");
                        }
                    editorPane.setText(textBuilder.toString());
                    index++;
                }
            
            } else {
                ((Timer) e.getSource()).stop(); // Handle line breaks using HTML tag
            }
            
        }
        
        
    });
    timer.start();
    if(node instanceof FightNode){
        playFightNode(node);
    } else InnerNodeButton(node);


}

    /**
    * Configures the interface to display buttons for a ChooseNode and handles the button actions.
    *
    * @param node The current ChooseNode to display options for.
    */

    public void InnerNodeButton(Node node){
        configPanel();
        InnerNode chooseNode;// Cast the node to a ChooseNode
        
        chooseNode=(InnerNode)node;

        JPanel panelChoose= new JPanel(); // Create a panel to hold the ChooseNode buttons
        getFenetre().add(layeredPane);
        panelChoose.setBounds(710, 350, 200, 225);
        layeredPane.add(panelChoose, JLayeredPane.POPUP_LAYER);
	    panelChoose.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));

        panelChoose.setBackground(Color.RED); 
        panelChoose.setOpaque(false);
        

        // Create buttons for each option in the ChooseNode
        for (int i = 0; i < chooseNode.getOptions().size(); i++) {
            final int currentIndex = i;
            String nomBouton = "";
            if (node instanceof ChooseNode){
                nomBouton=chooseNode.getOptions().get(i).getNom();
            } else nomBouton = "Suivant";
            JButton btn1 = new JButton(nomBouton);
            Font maFont = new Font("Courier new", Font.PLAIN, 13);
            
            btn1.setFont(maFont);
            btn1.setBackground(Color.WHITE);
		    btn1.setForeground(Color.BLACK);
            panelChoose.add(btn1);
            if (node instanceof ChooseNode){
            // Add an ActionListener to handle button clicks
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    chooseNode.getOptions().get(currentIndex).display(); // clique du bouton provoque affichage du prochain bode
                    ImageNode imageNode= new ImageNode(chooseNode.getOptions().get(currentIndex), node.getImageName());
                    imageNode.display();
                }
            });
        } else boutonGoNext(btn1, chooseNode);
        getFenetre().revalidate();
        }
    }

    public void boutonGoNext(JButton btn1, Node node){
        btn1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                        	node.goNext() ; // Code to execute when the button is clicked
                            if(node instanceof TextNode){
                                TextNode j= (TextNode) node;
                                ImageNode imageNode= new ImageNode(j.getOptions().get(0), node.getImageName());
                                imageNode.display();
                            }
                            if(node instanceof ChanceNode){
                                ChanceNode x = (ChanceNode) node;
                                x.goNext();
                               
                            }
                            if (node instanceof TestNode){
                                TestNode x = (TestNode) node;
                                x.goNext();
                              
                            }
                            
                        }
            });
        getFenetre().revalidate();
    }

    
    /**
     * La fonction pour lancer le fight node 
     * @param node
     */
    public static void playFightNode(Node node){
        FightNode node1 = (FightNode) node ;
        configPanel();
      
        // Create a panel for the "Next" button
        JPanel panelInner = new JPanel();
        getFenetre().add(layeredPane);
		panelInner.setBounds(710, 494, 144, 62);

        afficherPersoFight((FightNode)node);

        
        // Add the "Next" panel to the layered pane
		layeredPane.add(panelInner, JLayeredPane.POPUP_LAYER);
        panelInner.setBackground(Color.yellow);
        panelInner.setOpaque(false);
        
        
        JButton suivant = new JButton("C'est Parti !"); // Create a "Next" button
        suivant.setFont(new Font("Courier New", Font.PLAIN, 11));
        suivant.setBackground(Color.WHITE);
		suivant.setForeground(Color.BLACK);
        panelInner.add(suivant);
        getFenetre().revalidate() ;
        suivant.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                        playTourFightNode(node1) ; // une fois le bouton cliqué on lance le premier tour du fightNode 
                          
                    	
                        }
            });

    }

    
    /**
     * La fonction qui se joue à chaque nouveau tour du combat
     * @param node
     */
    public static void playTourFightNode(FightNode node) {
        configPanel();
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        //afficherImageDansInterface(node.getImageName());
	    getFenetre().getContentPane().setLayout(null);
	    cleanFenetre() ;        
        JPanel panelText= new JPanel();// Create a panel for the text content of the node
        JEditorPane editorPane = new JEditorPane();
 
        panelText.setBounds(60, 50, 850, 100);
        editorPane.setPreferredSize(new Dimension(850, 100));
        layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
        getFenetre().add(layeredPane);
         

        JLabel label = new JLabel("", JLabel.CENTER);// Create a label for displaying the description of the node
        
        panelText.add(label);

        
        label.setOpaque(false);
        panelText.setOpaque(false);
        label.setFont(new Font("Courier new", Font.PLAIN, 20));
        label.setForeground(Color.BLACK);
        editorPane.setOpaque(false);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));

        editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">Sélectionnez les compétences et les cibles de vos personnages !</div>");

        getFenetre().revalidate();
        getFenetre().repaint();
        
        panelText.add(editorPane);
        
        node.videActions(); //On vide la variable actions du FightNode
        selectionAction(node ,0); // on lance la sélection des actions

        
    }

/**
 * La fonction pour sélectionner la compétence du personnage 
 * @param node
 * @param perso // le personnage auquel on est dans le groupe
 */

 public static void afficherPersoFight(FightNode node){
    
    ArrayList<String> imagePathGroupList = new ArrayList<String>();
    for (int i =0; i<Game.getGame().getGroupeJoueurVivant().size();i++){
        imagePathGroupList.add(Game.getGame().getGroupeJoueurVivant().get(i).getImageLien());
    }
    
    ArrayList<String> imagePathAdversaireList = new ArrayList<String>();
    for (int i =0; i<node.getOpponentsVivant().size();i++){
        imagePathAdversaireList.add(node.getOpponentsVivant().get(i).getImageLien());
    }

        if (imagePathGroupList!=null){
            JPanel panelGroupe= new JPanel(new FlowLayout());
            panelGroupe.setBounds(60, 475, 650, 150);
            panelGroupe.setOpaque(false);
            for (String  element : imagePathGroupList) {
                ImageIcon imageIcon= new ImageIcon(element);
                // On redimentionne en width 130 pour pouvoir faire rentrer 5 personnages
                java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
                JLabel label = new JLabel(imageRedimensionneeIcon);
                panelGroupe.add(label);
            }

            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
            layeredPane.add(panelGroupe, JLayeredPane.POPUP_LAYER);
            
            getFenetre().revalidate();
            getFenetre().repaint();
        }

        if (imagePathAdversaireList!=null){
            JPanel panelAdversaire= new JPanel(new FlowLayout());
            panelAdversaire.setBounds(60, 300, 650, 150);
            panelAdversaire.setOpaque(false);
            for (String  element : imagePathAdversaireList) {
                ImageIcon imageIcon= new ImageIcon(element);
                // On redimentionne en width 130 pour pouvoir faire rentrer 5 personnages
                java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
                JLabel label = new JLabel(imageRedimensionneeIcon);
                panelAdversaire.add(label);
            }


            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
            layeredPane.add(panelAdversaire, JLayeredPane.POPUP_LAYER);
            
            getFenetre().revalidate();
            getFenetre().repaint();
        } 
    
 }

 public static void afficherPersoFight(FightNode node, ArrayList<String> imagePathGroupList, ArrayList<String> imagePathAdversaireList){
    
        if (imagePathGroupList!=null){
            JPanel panelGroupe= new JPanel(new FlowLayout());
            panelGroupe.setBounds(60, 475, 650, 150);
            panelGroupe.setOpaque(false);
            for (String  element : imagePathGroupList) {
                ImageIcon imageIcon= new ImageIcon(element);
                // On redimentionne en width 130 pour pouvoir faire rentrer 5 personnages
                java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
                JLabel label = new JLabel(imageRedimensionneeIcon);
                panelGroupe.add(label);
            }

            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
            layeredPane.add(panelGroupe, JLayeredPane.POPUP_LAYER);
            
            getFenetre().revalidate();
            getFenetre().repaint();
        }

        if (imagePathAdversaireList!=null){
            JPanel panelAdversaire= new JPanel(new FlowLayout());
            panelAdversaire.setBounds(60, 300, 650, 150);
            panelAdversaire.setOpaque(false);
            for (String  element : imagePathAdversaireList) {
                ImageIcon imageIcon= new ImageIcon(element);
                // On redimentionne en width 130 pour pouvoir faire rentrer 5 personnages
                java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
                JLabel label = new JLabel(imageRedimensionneeIcon);
                panelAdversaire.add(label);
            }


            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
            layeredPane.add(panelAdversaire, JLayeredPane.POPUP_LAYER);
            
            getFenetre().revalidate();
            getFenetre().repaint();
        } 
    
 }


    public static void selectionAction(FightNode node, int perso) {
        
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        afficherImageDansInterface(node.getImageName());
	    getFenetre().getContentPane().setLayout(null);
	    cleanFenetre() ;

        afficherPersoFight(node); 

        JPanel panelText= new JPanel();// Create a panel for the text content of the node
        JEditorPane editorPane = new JEditorPane();
        panelText.setBounds(60, 50, 850, 100);
        editorPane.setPreferredSize(new Dimension(850, 100));
        layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
        getFenetre().add(layeredPane);
        JLabel label = new JLabel("", JLabel.CENTER);// Create a label for displaying the description of the node
        panelText.add(label);
        label.setOpaque(false);
        panelText.setOpaque(false);
        label.setFont(new Font("Courier new", Font.PLAIN, 20));
        label.setForeground(Color.BLACK);
        editorPane.setOpaque(false);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));
        editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">Sélectionnez la compétence et la cible de "+Game.getGame().getGroupeJoueurVivant().get(perso).getName()+"</div>");
        getFenetre().revalidate();
        getFenetre().repaint();
        
        panelText.add(editorPane);



        JScrollPane panelFight = new JScrollPane();
        panelFight.setBounds(700, 200, 250, 300);
        
        JPanel contentPanel = new JPanel();
        int numberOfColumns = 1; 
        contentPanel.setLayout(new GridLayout(0, numberOfColumns)); 
        panelFight.setViewportView(contentPanel);
        contentPanel.setBackground(Color.BLACK);

        contentPanel.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                JScrollBar verticalScrollBar = panelFight.getVerticalScrollBar();
                verticalScrollBar.setValue(verticalScrollBar.getValue() - e.getUnitsToScroll());
            }
        });
        
        layeredPane.add(panelFight, JLayeredPane.POPUP_LAYER);

    
        ButtonGroup buttonGroup = new ButtonGroup();
        JLabel cmp = new JLabel(Game.getGame().getGroupeJoueurVivant().get(perso).getName(), JLabel.CENTER);
        cmp.setFont(new Font("Courier New", Font.PLAIN, 15));
        cmp.setForeground(Color.WHITE);
        contentPanel.add(cmp);
        for (int j = 0; j < Game.getGame().getGroupeJoueurVivant().get(perso).getCompetences().size(); j++) {
            JRadioButton radioButton = new JRadioButton("<html>"+Game.getGame().getGroupeJoueurVivant().get(perso).getCompetences().get(j).getName()+Game.getGame().getGroupeJoueurVivant().get(perso).getCompetences().get(j).affichageCoutMana());
            radioButton.setActionCommand(Game.getGame().getGroupeJoueurVivant().get(perso).getCompetences().get(j).getName());
            radioButton.setFont(new Font("Courier New", Font.PLAIN, 15));
            radioButton.setForeground(Color.WHITE);
            buttonGroup.add(radioButton);
            contentPanel.add(radioButton); // on crée un radio button pour chacune des compétences du personnage
        }
    
        JButton validateButton = new JButton("Valider");
        contentPanel.add(validateButton);
        validateButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) { 
                       CompetencesActives competence = null ;
                        String n = buttonGroup.getSelection().getActionCommand() ;
                        for (int i = 0 ; i<Game.getGame().getGroupeJoueurVivant().get(perso).getCompetences().size();i++) {
                            if (Game.getGame().getGroupeJoueurVivant().get(perso).getCompetences().get(i).getName().equals(n)) {
                                competence = Game.getGame().getGroupeJoueurVivant().get(perso).getCompetences().get(i) ;
                            } // on récupère la compétence (un radio button ne peut renvoyer qu'un String)
                        }
                        if (competence.isGroup()) { // si la compétence est une de groupe on apsse directement à la sélection suivante
                            Object[] cibleComp = {competence,null} ;
                            node.putAction(Game.getGame().getGroupeJoueurVivant().get(perso), cibleComp);
                            if (perso + 1 == Game.getGame().getGroupeJoueurVivant().size()) { // on s'arrête si on a fini tous les persos
                                selectionAdverse(node) ;
                            } else {
                                selectionAction(node, perso+1);
                            }
                        } else {
                            Object[] cibleCompetence = {competence, null};   
                            selectionCible(node, perso, cibleCompetence) ; // on va sélectionner la cible de la compétence                             
                        }
                        layeredPane.remove(panelFight);
                        layeredPane.revalidate();
                        layeredPane.repaint();
                    }
                    
                });        
         getFenetre().add(layeredPane);
         getFenetre().setVisible(true); 
    }

    /**
     * La fonction pour sélectionner la cible d'une compétence 
     * @param node
     * @param perso
     * @param cibleCompetence
     */
    public static void selectionCible(FightNode node, int perso, Object [] cibleCompetence) {
        
        
        //*******************PANEL DE SELECTION************** */
        JScrollPane panelFight = new JScrollPane();
        panelFight.setBounds(700, 200, 250, 300);
        getFenetre().add(panelFight);        
        JPanel contentPanel = new JPanel();
   
        int numberOfColumns = 1; 
        contentPanel.setLayout(new GridLayout(0, numberOfColumns)); // 0 pour un nombre de lignes dynamique
        panelFight.setViewportView(contentPanel);
        contentPanel.setBackground(Color.BLACK);

        // Ajoute un écouteur pour gérer la molette de la souris au premier JScrollPane
        contentPanel.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                // Défilement vertical en fonction de l'événement de la molette
                JScrollBar verticalScrollBar = panelFight.getVerticalScrollBar();
                verticalScrollBar.setValue(verticalScrollBar.getValue() - e.getUnitsToScroll());
            }
        });
        
        ButtonGroup buttonGroup = new ButtonGroup();
        JLabel cmp = new JLabel("Cible du " + Game.getGame().getGroupeJoueurVivant().get(perso).getName(), JLabel.CENTER);
        cmp.setFont(maFont);
        cmp.setForeground(Color.WHITE);
        contentPanel.add(cmp);
        
        if (cibleCompetence[0] instanceof CompetenceDammage) {
            for (int j = 0; j < node.getOpponentsVivant().size(); j++) {
                JRadioButton radioButton = new JRadioButton(node.getOpponentsVivant().get(j).getName());
                radioButton.setActionCommand(node.getOpponentsVivant().get(j).getName());
                radioButton.setFont(maFont);
                radioButton.setForeground(Color.WHITE);
                buttonGroup.add(radioButton);
                contentPanel.add(radioButton);
            }
        } else {
            for (int j = 0; j < Game.getGame().getGroupeJoueurVivant().size(); j++) {
                JRadioButton radioButton = new JRadioButton(Game.getGame().getGroupeJoueurVivant().get(j).getName());
                radioButton.setActionCommand(Game.getGame().getGroupeJoueurVivant().get(j).getName());
                radioButton.setFont(maFont);
                radioButton.setForeground(Color.WHITE);
                buttonGroup.add(radioButton);
                contentPanel.add(radioButton);
            }
        }
        JButton validateButton = new JButton("Valider");
        validateButton.setFont(maFont);
        contentPanel.add(validateButton);

        
        getFenetre().revalidate();
        getFenetre().repaint();

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonnageCombattant cible = null;
                String n = buttonGroup.getSelection().getActionCommand();
                
                if (cibleCompetence[0] instanceof CompetenceDammage) {
                    for (int i = 0; i < node.getOpponentsVivant().size(); i++) {
                        if (node.getOpponentsVivant().get(i).getName().equals(n)) {
                            cible = node.getOpponentsVivant().get(i);
                        }
                    }
                } else {
                    for (int i = 0; i < Game.getGame().getGroupeJoueur().size(); i++) {
                        if (Game.getGame().getGroupeJoueur().get(i).getName().equals(n)) {
                            cible = Game.getGame().getGroupeJoueur().get(i) ;
                        }
                    }
                }

                cibleCompetence[1] = cible ;
                node.putAction(Game.getGame().getGroupeJoueurVivant().get(perso), cibleCompetence) ;
                if (perso + 1 < Game.getGame().getGroupeJoueurVivant().size()) {
                    // i use getFenetre() and note layeredpane because it doesn't delet panelfight
                        getFenetre().remove(panelFight);
                        layeredPane.revalidate();
                        layeredPane.repaint();
                    selectionAction(node, perso +1 );
                } else {
                    // i use getFenetre() and note layeredpane because it doesn't delet panelfight
                        getFenetre().remove(panelFight);
                        layeredPane.revalidate();
                        layeredPane.repaint();
                    selectionAdverse(node);      
                } 
            }  
        });

        layeredPane.add(panelFight, JLayeredPane.DRAG_LAYER);

        getFenetre().setVisible(true);

    }

    /**
     * La fonction pour sélection des capacités ennemies 
     * @param node
     */
    public static void selectionAdverse(FightNode node) {
        // pour chaque opponent on lui attribue une action
        for (int i = 0; i<node.getOpponentsVivant().size();i++) {
            CompetencesActives competence = ((PersonnageAdversaire)node.getOpponentsVivant().get(i)).selectionAttaque() ;
            Object[] competenceCible = {competence, ((PersonnageAdversaire)node.getOpponentsVivant().get(i)).selectionCible(competence)} ;
            node.putAction(node.getOpponentsVivant().get(i), competenceCible);
        }
        faireActions(node);
    }
    
    /**
     * la fonction pour exécuter les compétences et récupérer leur texte
     * @param node
     */
    public void faireActions(FightNode node) {
        
        // on transforme la map d'action en une arraylist
        Set<PersonnageCombattant> a = node.getAction().keySet();
        ArrayList<PersonnageCombattant> ordreDAction = new ArrayList<PersonnageCombattant>(a);
    // on trie la liste en fonction de la vitesse des personnages 
        Collections.sort(ordreDAction, Comparator.comparingInt(PersonnageCombattant::getSpeed));

        String txt = "" ;
        String texteAction ="" ;
        // le nombre d'action du tour 
        int nombreAction = ordreDAction.size() ;

        ArrayList<String> imagePathGroupList = new ArrayList<String>();
        for (int i =0; i<Game.getGame().getGroupeJoueurVivant().size();i++){
            imagePathGroupList.add(Game.getGame().getGroupeJoueurVivant().get(i).getImageLien());
        }
    
        ArrayList<String> imagePathAdversaireList = new ArrayList<String>();
        for (int i =0; i<node.getOpponentsVivant().size();i++){
            imagePathAdversaireList.add(node.getOpponentsVivant().get(i).getImageLien());
        }


        // boucle pou créer le texte avec toutes les actions 
        for (int i = 0; i < ordreDAction.size() ;i++) {
            PersonnageCombattant utilisateur = ordreDAction.get(i) ;
            if(utilisateur.enVie() == false){
                texteAction += "$" ;
                continue ;
            }
            PersonnageCombattant cible = (PersonnageCombattant)node.getAction().get(ordreDAction.get(i))[1] ;
            CompetencesActives competence = (CompetencesActives)node.getAction().get(ordreDAction.get(i))[0] ;
        
            txt = (competence.utilisation(utilisateur, cible));
            
            if (txt == "nope"){ // la fonction competence d'utilisation renvoie "nope" si rien ne se passe 
                texteAction += "$" ;
                continue ;
            }

            texteAction += txt + "$"; // on va se servir du charactère dollar un peu de la même manière dont on s'est servi du charactère "/" 
            
        }

        // puis on lance la fonction afficher action qui permet d'afficher les actions 
        //System.out.println(texteAction);
        afficherAction(node, texteAction, nombreAction, 0, 0, imagePathGroupList, imagePathAdversaireList);
    }

    /**
     * La fonction pour afficher le résultat du tour
     * Les actions sont affichées 12 lignes par 12
     * @param node
     * @param texteAction
     * @param nombreAction
     * @param ligneAffichee
     * @param actionAffichee
     */
    
    
    
     public static void afficherAction(FightNode node, String texteAction, int nombreAction, int actionAffichee, int ligneAffichee, ArrayList<String> imagePathGroupList, ArrayList<String> imagePathAdversaireList){  
        configPanel();
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();

        if (nombreAction-actionAffichee> 0) {
            afficherImageDansInterface(node.getImageName());
	        getFenetre().getContentPane().setLayout(null);

            this.afficherPersoFight(node, imagePathGroupList, imagePathAdversaireList);
        
            JPanel panelText= new JPanel();// Create a panel for the text content of the node
            JEditorPane editorPane = new JEditorPane();
 
            panelText.setBounds(60, 50, 850, 230);
            editorPane.setPreferredSize(new Dimension(850, 300));
            layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
            getFenetre().add(layeredPane);
         

            JLabel label = new JLabel("", JLabel.CENTER);// Create a label for displaying the description of the node
        
            panelText.add(label);

        
            label.setOpaque(false);
            panelText.setOpaque(false);
            label.setFont(new Font("Courier new", Font.PLAIN, 20));
            label.setForeground(Color.BLACK);
            editorPane.setOpaque(false);
            editorPane.setEditable(false);
            editorPane.setContentType("text/html");
            editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));

            getFenetre().revalidate();
            getFenetre().repaint();


            editorPane.setOpaque(false);
            editorPane.setEditable(false);
            editorPane.setContentType("text/html");
            editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));
        
            panelText.add(editorPane);
            int action = 0 ;
            int debut = 0; 
            int ligne = 0 ;
            char[] texts = texteAction.toCharArray(); 

            if (ligneAffichee != 0) {
                    do {
                        if (texts[debut]=='/'){
                            ligne++ ; // on compte le nombre de lignes déjà affichées pour ajuster l'index de début
                        }
                        if (texts[debut]=='$'){
                            action++; // on compte le nombre d'actions déjà affichées pour savoir quand s'arrêter 
                        }
                        debut++ ;
                     } while(ligne < ligneAffichee) ;
                }
            
            final int debut2 = debut ;
            final int action2 = action ;
            
            Timer timer = new Timer(10, new ActionListener(){ // Create a timer to display the description character by character
            int index = debut2 ;
            int action3 = action2 ;
            int nbAction = 0 ;
            int nbLigne = 0 ;
            StringBuilder textBuilder = new StringBuilder("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\"></div>");
                @Override
                    public void actionPerformed(ActionEvent e){
                        if (index < texts.length) { 
                            if (nbLigne<10){
                                char nextChar = texts[index];
                                if ((nextChar == '/') && !(texts[index - 1] == '<')) {
                                    String balise = "</div>";
                                    int position = textBuilder.indexOf(balise);
                                    // Vérifier si la balise a été trouvée
                                    if (position != -1) {
                                        // Insérer le texte juste avant la balise </font>
                                        textBuilder.insert(position, "<br>");

                                        // Afficher le résultat
                                    } else {
                                        throw new IllegalStateException("Balise </font> non trouvée dans la chaîne !");
                                    }
                                editorPane.setText(textBuilder.toString());
                                index++;
                                nbLigne++ ;

                                }  else if(nextChar == '$') {
                                    index++ ;
                                    nbAction++ ;
                                } else {
                                    String balise = "</div>";
                                    int position = textBuilder.indexOf(balise);
                                    // Vérifier si la balise a été trouvée
                                    if (position != -1) {
                                        // Insérer le texte juste avant la balise </font>
                                        textBuilder.insert(position, nextChar);
                                    } else {
                                        throw new IllegalStateException("Balise </font> non trouvée dans la chaîne !");
                                    }
                                    editorPane.setText(textBuilder.toString());
                                    index++;
                                }
                            } else {
                                index = texts.length ;
                            }
                        } else {
                            ((Timer) e.getSource()).stop(); 
                            ButtonSuivant(node, texteAction, nombreAction, action3 + nbAction, ligneAffichee+10, imagePathGroupList,imagePathAdversaireList);

                        }

                    }
                });
            timer.start();  
        } else {
            FightOver(node) ;
        }
    }

    public static void ButtonSuivant(FightNode node, String texteAction, int nombreAction, int actionAffichee, int ligneAffichee, ArrayList<String> imagePathGroupList, ArrayList<String> imagePathAdversaireList){
        configPanel();
      
            // Create a panel for the "Next" button
            JPanel panelInner = new JPanel();
            getFenetre().add(layeredPane);
		    panelInner.setBounds(711, 494, 144, 62);
            panelInner.setOpaque(false);
            
        
            // Add the "Next" panel to the layered pane
		    layeredPane.add(panelInner, JLayeredPane.POPUP_LAYER);
            panelInner.setBackground(Color.yellow);
        
        
            JButton suivant = new JButton("Suivant"); // Create a "Next" button
            suivant.setFont(new Font("Courier New", Font.PLAIN, 15));
            suivant.setBackground(Color.WHITE);
		    suivant.setForeground(Color.BLACK);
            panelInner.add(suivant);
            getFenetre().revalidate() ;
            suivant.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                            afficherAction(node, texteAction, nombreAction, actionAffichee, ligneAffichee, imagePathGroupList, imagePathAdversaireList);
                        }
            });
    } 

    /**
     * on vérifie si le combat est terminé 
     * @param node
     */
    public static void FightOver(FightNode node){
        if (node.isOver()){  // si le combat est terminé on passe au node suivant 
            node.goNext();
        } else {
       
        playTourFightNode(node);
        }
    }

    /**
     * la fonction qui selon la valeur renvoyée par le fightNode va lancer le node suivant 
     * @param node
     */
    public static void Victoire(FightNode node) {
        configPanel();
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        afficherImageDansInterface(node.getImageName());
	    getFenetre().getContentPane().setLayout(null);

        this.afficherperso(node) ;
        
        JPanel panelText= new JPanel();// Create a panel for the text content of the node
        JEditorPane editorPane = new JEditorPane();
 
        panelText.setBounds(60, 50, 850, 300);
        editorPane.setPreferredSize(new Dimension(850, 300));
        layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
        getFenetre().add(layeredPane);
         

        JLabel label = new JLabel("", JLabel.CENTER);// Create a label for displaying the description of the node
        
        panelText.add(label);
        afficherPersoVictoire();

        
        label.setOpaque(false);
        panelText.setOpaque(false);
        label.setFont(new Font("Courier new", Font.PLAIN, 20));
        label.setForeground(Color.BLACK);
        editorPane.setOpaque(false);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));

        getFenetre().revalidate();
        getFenetre().repaint();


        editorPane.setOpaque(false);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));
        
        panelText.add(editorPane);
        String q = "Le groupe remporte la victoire !!/" ;
        Node nodeNext = node.getOptions().get(0) ;
        q+= node.gainXP() ;
        q += node.gainButin() ;
        String u = "" ;

        Map<PersoGroupe, String> gainNiveau = new HashMap<>();
        for (int i = 0;i<Game.getGame().getGroupeJoueur().size();i++){
            u = ((PersoGroupe)Game.getGame().getGroupeJoueur().get(i)).gainExperience(node.getXp()) ;
            if (u!="nope"){
                gainNiveau.put((PersoGroupe)Game.getGame().getGroupeJoueur().get(i),u) ;
            }
        }
	
        
        final Node nodeNext2 = nodeNext ;

        char[] texts = q.toCharArray(); 

        Timer timer = new Timer(10, new ActionListener() { // Create a timer to display the description character by character
        int index = 0; // Index to retrieve each character from the description
        StringBuilder textBuilder = new StringBuilder("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\"></div>");
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (index < texts.length) { 
                char nextChar = texts[index];
                    if ((nextChar == '/') && !(texts[index - 1] == '<')) {
                        String balise = "</div>";
                        int position = textBuilder.indexOf(balise);

                        // Vérifier si la balise a été trouvée
                        if (position != -1) {
                             // Insérer le texte juste avant la balise </font>
                            textBuilder.insert(position, "<br>");

                            // Afficher le résultat
                        } else {
                            throw new IllegalStateException("Balise </font> non trouvée dans la chaîne !");
                        }
                        
                        
                        editorPane.setText(textBuilder.toString());
                        index++;
                
                }
                else{
                    String balise = "</div>";
                    int position = textBuilder.indexOf(balise);

                        // Vérifier si la balise a été trouvée
                         if (position != -1) {

                             // Insérer le texte juste avant la balise </font>
                            textBuilder.insert(position, nextChar);

                            // Afficher le résultat
                        } else {
                            throw new IllegalStateException("Balise </font> non trouvée dans la chaîne !");
                        }
                    editorPane.setText(textBuilder.toString());
                    index++;
                }
            
            } else {
                ((Timer) e.getSource()).stop(); 
                if (gainNiveau.size()!=0){
                    gainDeNiveauButton(node,gainNiveau) ;
                } else {
                    nextNodeButton(nodeNext2) ;
                }
            }
            
        }
        
        
    });
    timer.start();
        
    }
    public static void afficherPersoVictoire(){
        ArrayList<String> imagePathGroupList = new ArrayList<String>();
    for (int i =0; i<Game.getGame().getGroupeJoueurVivant().size();i++){
        imagePathGroupList.add(Game.getGame().getGroupeJoueurVivant().get(i).getImageLien());
    }

        if (imagePathGroupList!=null){
            JPanel panelGroupe= new JPanel(new FlowLayout());
            panelGroupe.setBounds(60, 475, 650, 150);
            panelGroupe.setOpaque(false);
            for (String  element : imagePathGroupList) {
                ImageIcon imageIcon= new ImageIcon(element);
                // On redimentionne en width 130 pour pouvoir faire rentrer 5 personnages
                java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
                JLabel label = new JLabel(imageRedimensionneeIcon);
                panelGroupe.add(label);
            }

            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
            layeredPane.add(panelGroupe, JLayeredPane.POPUP_LAYER);
            
            getFenetre().revalidate();
            getFenetre().repaint();

        }

    }

    public static void afficherPersoGainNiveau(String imagePerso){
        if (imagePerso!=null){
            JPanel panel= new JPanel(new FlowLayout());
            panel.setBounds(100, 300, 650, 310);
            panel.setOpaque(false);
            ImageIcon imageIcon= new ImageIcon(imagePerso);
            // Redimensionnement de l'image
            // On redimentionne en width 130 pour pouvoir faire rentrer 5 personnages
            java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
            ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
            JLabel label = new JLabel(imageRedimensionneeIcon);
            panel.add(label);
            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
            layeredPane.add(panel, JLayeredPane.POPUP_LAYER);
            
            getFenetre().revalidate();
            getFenetre().repaint();
        }
    }

    
    public static void ecranGainNiveau(FightNode node, Map<PersoGroupe, String> gainNiveau){
        configPanel();
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        afficherImageDansInterface(node.getImageName());
	    getFenetre().getContentPane().setLayout(null);
        
        JPanel panelText= new JPanel();// Create a panel for the text content of the node
        JEditorPane editorPane = new JEditorPane();
 
        panelText.setBounds(60, 50, 850, 300);
        editorPane.setPreferredSize(new Dimension(850, 300));
        layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
        getFenetre().add(layeredPane);
         

        JLabel label = new JLabel("", JLabel.CENTER);// Create a label for displaying the description of the node
        
        panelText.add(label);

        
        label.setOpaque(false);
        panelText.setOpaque(false);
        label.setFont(new Font("Courier new", Font.PLAIN, 20));
        label.setForeground(Color.BLACK);
        editorPane.setOpaque(false);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));

        getFenetre().revalidate();
        getFenetre().repaint();


        editorPane.setOpaque(false);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));
        String q = "PROBLÈME";
        
        panelText.add(editorPane);
        for(PersonnageCombattant perso : Game.getGame().getGroupeJoueur()){
            if (gainNiveau.containsKey(perso)){
                q = gainNiveau.remove(perso) ;
                this.afficherPersoGainNiveau(perso.getImageLien());
                break;
            }
        }

        Node nodeNext = node.getOptions().get(0) ;
        
        char[] texts = q.toCharArray(); 
        Timer timer = new Timer(10, new ActionListener() { 
        int index = 0; 

        StringBuilder textBuilder = new StringBuilder("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\"></div>");


        @Override
        public void actionPerformed(ActionEvent e) {
            if (index < texts.length) { 
                char nextChar = texts[index];
                    if ((nextChar == '/') && !(texts[index - 1] == '<')) {
                        String balise = "</div>";
                        int position = textBuilder.indexOf(balise);

                        // Vérifier si la balise a été trouvée
                        if (position != -1) {
                             // Insérer le texte juste avant la balise </font>
                            textBuilder.insert(position, "<br>");

                            // Afficher le résultat
                        } else {
                            throw new IllegalStateException("Balise </font> non trouvée dans la chaîne !");
                        }
                        
                        
                        editorPane.setText(textBuilder.toString());
                        index++;
                
                }
                else{   
                    String balise = "</div>";
                    int position = textBuilder.indexOf(balise);

                        // Vérifier si la balise a été trouvée
                         if (position != -1) {

                             // Insérer le texte juste avant la balise </font>
                            textBuilder.insert(position, nextChar);

                            // Afficher le résultat
                        } else {
                            throw new IllegalStateException("Balise </font> non trouvée dans la chaîne !");
                        }
                    editorPane.setText(textBuilder.toString());
                    index++;
                }
            
            } else {
                ((Timer) e.getSource()).stop(); 
                
            }
            
        }
        
        
    });
    timer.start();
    if (gainNiveau.size()!=0){
                    gainDeNiveauButton(node,gainNiveau) ;
                } else {
                    nextNodeButton(nodeNext) ;
                }


        
    }

    public static void Defaite(FightNode node) {
        configPanel();
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        afficherImageDansInterface(node.getImageName());
	    getFenetre().getContentPane().setLayout(null);

        this.afficherperso(node) ;
        
        JPanel panelText= new JPanel();// Create a panel for the text content of the node
        JEditorPane editorPane = new JEditorPane();
 
        panelText.setBounds(60, 50, 850, 300);
        editorPane.setPreferredSize(new Dimension(850, 300));
        layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
        getFenetre().add(layeredPane);
         

        JLabel label = new JLabel("", JLabel.CENTER);// Create a label for displaying the description of the node
        
        panelText.add(label);

        
        label.setOpaque(false);
        panelText.setOpaque(false);
        label.setFont(new Font("Courier new", Font.PLAIN, 20));
        label.setForeground(Color.BLACK);
        editorPane.setOpaque(false);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));

        getFenetre().revalidate();
        getFenetre().repaint();


        editorPane.setOpaque(false);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));
        
        panelText.add(editorPane);
        
        String q = "Le groupe a perdu ..." ;
        char[] texts = q.toCharArray(); 
        Timer timer = new Timer(10, new ActionListener() { 
        int index = 0; 
        Node nodeNext = node.getOptions().get(1) ;
        final Node nodeNext2 = nodeNext ;
        StringBuilder textBuilder = new StringBuilder("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\"></div>");


        @Override
        public void actionPerformed(ActionEvent e) {
            if (index < texts.length) { 
                char nextChar = texts[index];
                    if ((nextChar == '/') && !(texts[index - 1] == '<')) {
                        String balise = "</div>";
                        int position = textBuilder.indexOf(balise);

                        // Vérifier si la balise a été trouvée
                        if (position != -1) {
                             // Insérer le texte juste avant la balise </font>
                            textBuilder.insert(position, "<br>");

                            // Afficher le résultat
                        } else {
                            throw new IllegalStateException("Balise </font> non trouvée dans la chaîne !");
                        }
                        
                        
                        editorPane.setText(textBuilder.toString());
                        index++;
                
                }
                else{   
                    String balise = "</div>";
                    int position = textBuilder.indexOf(balise);

                        // Vérifier si la balise a été trouvée
                         if (position != -1) {

                             // Insérer le texte juste avant la balise </font>
                            textBuilder.insert(position, nextChar);

                            // Afficher le résultat
                        } else {
                            throw new IllegalStateException("Balise </font> non trouvée dans la chaîne !");
                        }
                    editorPane.setText(textBuilder.toString());
                    index++;
                }
            
            } else {
                ((Timer) e.getSource()).stop(); 
                    nextNodeButton(nodeNext2) ;
                }
            }    
        });
        timer.start();
    }

    public static void gainDeNiveauButton(FightNode node, Map<PersoGroupe, String> gainNiveau){
        configPanel();
        JPanel panelInner = new JPanel();
            getFenetre().add(layeredPane);
		    panelInner.setBounds(711, 494, 144, 62);
            panelInner.setOpaque(false);
            
        
            // Add the "Next" panel to the layered pane
		    layeredPane.add(panelInner, JLayeredPane.POPUP_LAYER);
            panelInner.setBackground(Color.yellow);
        
        
            JButton suivant = new JButton("Suivant"); // Create a "Next" button
            suivant.setFont(new Font("Courier New", Font.PLAIN, 15));
            suivant.setBackground(Color.WHITE);
		    suivant.setForeground(Color.BLACK);
            panelInner.add(suivant);
            getFenetre().revalidate() ;
            suivant.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                        ecranGainNiveau(node,gainNiveau) ;
                        }
            });
    }

    public static void nextNodeButton(Node nodeNext){
        JPanel panelInner = new JPanel();
            getFenetre().add(layeredPane);
		    panelInner.setBounds(711, 494, 144, 62);
            panelInner.setOpaque(false);
            
        
            // Add the "Next" panel to the layered pane
		    layeredPane.add(panelInner, JLayeredPane.POPUP_LAYER);
            panelInner.setBackground(Color.yellow);
        
        
            JButton suivant = new JButton("Suivant"); // Create a "Next" button
            suivant.setFont(new Font("Courier New", Font.PLAIN, 15));
            suivant.setBackground(Color.WHITE);
		    suivant.setForeground(Color.BLACK);
            panelInner.add(suivant);
            getFenetre().revalidate() ;
            suivant.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                    nodeNext.display();
                        }
            });
    }

    
    
    public static void CloseFrame(){
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFenetre().dispose(); // Fermer la fenêtre
            }
        });
        
        timer.setRepeats(false); // Pour ne déclencher l'événement qu'une seule fois
        timer.start(); // Démarrer le timer
    
    }

     public static void TerminalNodeButton(Node node) {
        configPanel();
        JPanel panelTerminal = new JPanel();
        getFenetre().add(layeredPane);
        panelTerminal.setBounds(711, 494, 144, 62);
        layeredPane.add(panelTerminal, JLayeredPane.POPUP_LAYER);
        panelTerminal.setBackground(Color.YELLOW);
        this.CloseFrame();
    }

    

    public static void afficherImageDansInterface(String imageName) {
        if (imageName != null) {
            configPanel();
            ImageIcon imageIcon= new ImageIcon(imageName);
            JLabel label = new JLabel(imageIcon);
            JPanel panel = new JPanel();
            panel.add(label);
            panel.setOpaque(false);
            panel.setBounds(0, 0, 1000, 1000);
            layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);
            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
            
        }
    }

    public static Clip afficherSoundDansInterface(String soundName) {
       
        if (soundName != null) {
            configPanel();
            try {
                File file = new File(soundName);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.addLineListener(new LineListener() {
                    @Override
                    public void update(LineEvent event) {
                        if (event.getType() == LineEvent.Type.STOP) {
                            clip.close();
                            System.out.println("Lecture terminée !");
                        }
                    }
                });
                clip.open(audioInputStream);
                clip.start();
                getFenetre().add(layeredPane);
                getFenetre().setVisible(true);

                return clip; 

            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                e.printStackTrace();
            }
        }

        return null; 
    }

    
    


}


    /**
    * Configures the interface to display the "Next" button for an inner node (InnerNode).
    *
    * @param node The current inner node.
    */

    // public void InnerNodeButton(Node node){
    //     configPanel();
      
    //     // Create a panel for the "Next" button
    //     JPanel panelInner = new JPanel();
    //     getFenetre().add(layeredPane);
	// 	panelInner.setBounds(710, 494, 144, 62);
        
    //     // Add the "Next" panel to the layered pane
	// 	layeredPane.add(panelInner, JLayeredPane.POPUP_LAYER);
    //     panelInner.setBackground(Color.yellow);
        
        
    //     JButton suivant = new JButton("Suivant"); // Create a "Next" button
    //     suivant.setFont(new Font("Courier New", Font.PLAIN, 11));
    //     suivant.setBackground(new Color(240, 240,240));
	// 	suivant.setForeground(new Color(128, 64, 0));
    //     panelInner.add(suivant);
    //     getFenetre().revalidate() ;
    //     getFenetre().repaint() ;
        
	// 	boutonGoNext(suivant, node);
        
    // }   
// ANCIENNN****************************************************************************

                        // if (index < texts.length) { 
                        //     if (nbLigne<12){
                        //         char nextChar = texteAction.charAt(index); 
                        //         if(nextChar =='/'){  
                        //             label.setText(label.getText() + "<br>");
                        //             index++;
                        //             nbLigne++ ;
                        //         } else if(nextChar == '$') {
                        //             index++ ;
                        //             nbAction++ ;
                        //         } else {
                        //             label.setText(label.getText() + nextChar); 
                        //             index++; //on passe au caractere suivant de la chaine de description
                        //         }
                        //     } else {
                        //         index = texts.length ;
                        //     }
                        // } else {
                        //     ((Timer) e.getSource()).stop(); 
                        //     ButtonSuivant(node, texteAction, nombreAction, action3 + nbAction, ligneAffichee+12);
                        // }
        
    

    
