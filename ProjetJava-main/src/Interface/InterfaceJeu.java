/**
* Represents the Game.getGame() interface that displays nodes and allows interactions.
*/

package Interface;
import Representation.* ;
import univers.competences.CompetencesActives;
import univers.personnages.PersoGroupe;
import univers.personnages.PersonnageAdversaire;
import univers.personnages.PersonnageCombattant;
import univers.Collectibles;
import univers.Utilisable;
import univers.competences.CompetenceDammage;
import univers.competences.CompetenceSoin;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
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
import javax.swing.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * La classe dédiée à tout ce qui concerne l'affichage dans l'interface de jeu 
 */
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

    
    /**
     * Une fonction pour afficher le menu
     */
    public static void showMenu(){
        getBarreMenu().setVisible(true);
    }
    /**
     * Une fonction pour cacher le menu
     */
    public static void hideMenu(){
        getBarreMenu().setVisible(false);
    }

    /**
     * Une fonction pour configurer le menu
     */
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

        quitter.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                            getFenetre().dispose(); // Fermer la fenêtre

                        }
            });

        sauvegarder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getGame().sauvegarde() ;
            }
        });

        sauvegarderEtQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.getGame().sauvegarde() ;
                if (!(Game.getGame().getCurrentNode() instanceof FightNode)){
                getFenetre().dispose(); // Fermer la fenêtre
                }

            }
        });

        ecranTitre.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                            ecranTitre() ;      
                        }
            });
        stats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(Game.getGame().getCurrentNode() instanceof FightNode)){
                    ecranStatut();             
                } else {
                    JOptionPane.showMessageDialog(null, "Désolé, impossible d'y accéder lors d'un combat !", "Désolé ...", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
       
        inventairessmenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(Game.getGame().getCurrentNode() instanceof FightNode)){
                    ecranInventaire();
                }else {
                    JOptionPane.showMessageDialog(null, "Désolé, impossible d'y accéder lors d'un combat !", "Désolé ...", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
    
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

    /**
     * La fonction pour afficher l'inventaire 
     */
    public static void ecranInventaire(){
            System.out.println("test");
            configPanel();
            layeredPane.removeAll();
            layeredPane.revalidate();
            layeredPane.repaint();
    
            afficherImageDansInterface("image/ForetJolie.png");

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
            panelText.setBounds(450, 50, 400, 70);
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

    if (Game.getGame().getInventaire().size()!=0){
    ButtonGroup buttonGroup = new ButtonGroup();
    Map<Collectibles, Integer> inventaire = Game.getGame().getInventaire();
    
    for (Collectibles objet : inventaire.keySet()) {
        JRadioButton radioButton = new JRadioButton("<html>"+objet.getName()+" x"+inventaire.get(objet));
        radioButton.setActionCommand(objet.getName());
        radioButton.setFont(new Font("Courier New", Font.PLAIN, 15));
        radioButton.setForeground(Color.WHITE);
        radioButton.setBackground(Color.BLACK);
        buttonGroup.add(radioButton);
        contentPanel.add(radioButton); // on crée un radio button pour chacune des compétences du personnage
    }
    JPanel panelText2 = new JPanel();

    JButton validateButton = new JButton("Obtenir plus d'info");
    validateButton.setFont(maFont);
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
                        
                    }
                }
            });
    JButton utiliser = new JButton("Utiliser/Équiper");
    utiliser.setFont(maFont);
    contentPanel.add(utiliser);
    utiliser.addActionListener(new ActionListener() {
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
                        if (objet instanceof Utilisable){
                            utiliserObjet((Utilisable)objet);
                        } else {
                            ecranInventaire();
                            utilisation("Utilisation impossible pour cet objet !");
                        }
                        
                    }
                }
            });
        } else {
            JLabel cmp = new JLabel("Désolé l'inventaire est vide !", JLabel.CENTER);
            cmp.setFont(new Font("Courier New", Font.PLAIN, 15));
            cmp.setForeground(Color.WHITE);
            contentPanel.add(cmp);
        }
        
    ButtonFermer();
    panelText.add(editorPane);
    layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);


    }

    /**
     * le bouton pour revenir à l'inventaire
     */
    public static void ButtonRetourInventaire(){
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
                            ecranInventaire();
                        }
            });
    }

    /**
     * La fonction pour sélectionner la cible d'un objet
     * @param objet
     */
    public static void utiliserObjet(Utilisable objet){
        configPanel();
            layeredPane.removeAll();
            layeredPane.revalidate();
            layeredPane.repaint();
    
            getFenetre().getContentPane().setLayout(null);
            getFenetre().revalidate();
            getFenetre().repaint();
    
                    afficherImageDansInterface("image/ForetJolie.png");


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
            panelText.setBounds(450, 50, 400, 70);
            panelText.setOpaque(false);
            panelText.setBackground(Color.CYAN);

            JEditorPane editorPane = new JEditorPane();
            editorPane.setPreferredSize(new Dimension(400, 100));
            editorPane.setOpaque(false);
            editorPane.setEditable(false);
            editorPane.setContentType("text/html");
            editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));
            editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">"
            + "Sélectionnez le membre du groupe sur lequel équiper/utiliser l'objet : "
            + "</div>");
    panelText.add(editorPane);
    layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
    
    JPanel panelText2 = new JPanel();
    afficherDetailObjet(panelText2, objet);   
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
    
    for (PersonnageCombattant perso : Game.getGame().getGroupeJoueur()) {
        JRadioButton radioButton = new JRadioButton("<html>"+"<strong>"+perso.getName()+"</strong>"+ " PV : "+perso.getLifePoints()+"/"+perso.getMaxLifePoints()+ " PM : "+perso.getMana()+"/"+perso.getMaxMana());
        radioButton.setActionCommand(perso.getName());
        radioButton.setFont(new Font("Courier New", Font.PLAIN, 15));
        radioButton.setForeground(Color.WHITE);
        radioButton.setBackground(Color.BLACK);

        buttonGroup.add(radioButton);
        contentPanel.add(radioButton); // on crée un radio button pour chacune des compétences du personnage
    }

    JButton validateButton = new JButton("Utiliser/Équiper");
    validateButton.setFont(maFont);
    contentPanel.add(validateButton);
    validateButton.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) { 
                   PersonnageCombattant perso = null ;
                    String n = buttonGroup.getSelection().getActionCommand() ;
                    for (PersonnageCombattant perso2 : Game.getGame().getGroupeJoueur()) {
                        if (perso2.getName().equals(n)) {
                            perso = perso2 ;
                        } 
                    }
                    if (objet!=null){
                        if (Game.getGame().getInventaire().get(objet)==1){
                            String d = (objet).utilisation(perso);
                            ecranInventaire();
                            utilisation(d);
                        } else {
                            String d = (objet).utilisation(perso);
                            utiliserObjet(objet);
                            utilisation(d);
                        }
                    }
                }
            });
        ButtonFermer();
        ButtonRetourInventaire();
    }

    /**
     * La fonction qui utilise l'objet
     * @param text
     */
    public static void utilisation(String text){
        JPanel panel = new JPanel();
        panel.setBounds(50, 450, 400, 250);
        panel.setOpaque(false);
        panel.setBackground(Color.CYAN);
        panel.setVisible(true);
                        
        JEditorPane editorPane = new JEditorPane();
        editorPane.setPreferredSize(new Dimension(400, 250));
        editorPane.setOpaque(false);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setFont(new Font("Courier new", Font.PLAIN, 20));
        
    
        // editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">"
        // + "</div>");
        panel.add(editorPane);
        layeredPane.add(panel, JLayeredPane.POPUP_LAYER);
        
        editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">"
        + text
        + "</div>");
        
    }

    /**
     * pour afficher plus d'info sur un objet en particulier 
     * @param panel
     * @param objet
     */
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
        + "Nom : " + objet.getName() + "<br>"
        + "Description : "+ objet.getName()+"<br>"
        + "</div>");
    
        // editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">"
        // + "</div>");
        panel.add(editorPane);
        layeredPane.add(panel, JLayeredPane.POPUP_LAYER);
    }

    
    
    /**
     * pour afficher l'écran statut du menu 
     */
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
    
        afficherImageDansInterface("image/ForetJolie.png");
    
            addPanelWithImage(imagePathGroupList.get(0), 50, 100);
            addTextPanel(Game.getGame().getGroupeJoueur().get(0), 250, 100);
            addTextPanel(Game.getGame().getGroupeJoueur().get(1), 700, 400);
            addTextPanel(Game.getGame().getGroupeJoueur().get(2), 700, 100);
            addTextPanel(Game.getGame().getGroupeJoueur().get(3), 250, 400);

    
            addPanelWithImage(imagePathGroupList.get(1), 500, 400);
            addPanelWithImage(imagePathGroupList.get(2), 500, 100);
            addPanelWithImage(imagePathGroupList.get(2), 50, 400);
            ButtonFermer();
    
            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
        }
    }
    /**
     * Bouton pour fermer l'écran et revenir au jeu 
     */
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
                            configPanel();
                            layeredPane.removeAll();
                            layeredPane.revalidate();
                            layeredPane.repaint();
                            Game.getGame().getCurrentNode().display();
                            System.out.println("test");	
                        }
            });

    }

    /**
     * Bouton pour revenir en arrière dans le menu statut
     */
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
    /**
     * Pour afficher les détails d'un personnage en particulier 
     * @param personnage
     */
    public static void ecranDetail(PersoGroupe personnage){
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();

    afficherImageDansInterface("image/ForetJolie.png");


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
    if (personnage.getWeapon()==null){
        editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">"
            + personnage.getName() + "<br>"
            + "Niveau : " + personnage.getLevel() + "<br>"
            + "PV : " + personnage.getLifePoints() + "/" + personnage.getMaxLifePoints() + "<br>"
            + "PM : " + personnage.getMana() + "/" + personnage.getMaxMana() + "<br>"
            + "Force : "+ personnage.getBaseStrength()+ "<br>"
            + "Intelligence : " + personnage.getBaseIntelligence()+ "<br>"
            + "Vitesse : " + personnage.getBaseSpeed()+ "<br>"
            + "Endurance : " + personnage.getBaseEndurance() +  "<br>"
            + "Dextérité : "+ personnage.getBaseDexterity()
            + "</div>");
    } else {
        editorPane.setText("<div style=\"background-color: #000000; padding: 10px; display: inline-block; color: #ffffff; font-size: 13px; font-family: Courier New; letter-spacing: -1px;\">"
            + personnage.getName() + "<br>"
            + "Niveau : " + personnage.getLevel() + "<br>"
            + "Arme équipée : "+personnage.getWeapon().getName() + "<br>"
            + "PV : " + personnage.getLifePoints() + "/" + personnage.getMaxLifePoints() + "<br>"
            + "PM : " + personnage.getMana() + "/" + personnage.getMaxMana() + "<br>"
            + "Force : "+ personnage.getBaseStrength()+ "(+"+personnage.getWeapon().getBonusStrength()+")"+ "<br>"
            + "Intelligence : " + personnage.getBaseIntelligence()+ "(+"+personnage.getWeapon().getBonusIntelligence()+")"+ "<br>"
            + "Vitesse : " + personnage.getBaseSpeed()+ "(+"+personnage.getWeapon().getBonusSpeed()+")"+ "<br>"
            + "Endurance : " + personnage.getBaseEndurance() + "(+"+personnage.getWeapon().getBonusEndurance()+")"+  "<br>"
            + "Dextérité : "+ personnage.getBaseDexterity()+ "(+"+personnage.getWeapon().getBonusDexterity()+")"
            + "</div>");
    }
    

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
        radioButton.setBackground(Color.BLACK);
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

/**
 * Pour afficher les détails d'une compétence 
 * @param competence
 * @param panel
 * @param personnage
 */
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

/**
 * pour ajouter au panel une image 
 * @param imagePath
 * @param x
 * @param y
 */
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
    
    /**
     * ajouter un texte au panel
     * @param personnage
     * @param x
     * @param y
     */
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

   
    /**
     * Pour afficher l'écrant titre du jeu 
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

        afficherImageDansInterface("image/ForetJolie.png");
            
    
        JPanel panelText= new JPanel();
        
        panelText.setBounds(80, 200, 850, 300);
        layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
        getFenetre().add(layeredPane);
        JLabel label = new JLabel("<html> <strong>Enquêtes et Trahisons</strong>", JLabel.CENTER);// Create a label for displaying the description of the node
        panelText.add(label);
        panelText.setBackground(Color.CYAN); 
        panelText.setOpaque(false);
        label.setFont(new Font("Courier New", Font.PLAIN, 65));
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

        JPanel panelChoose= new JPanel(); 
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
                    configPanel();
                    layeredPane.removeAll();
                    layeredPane.revalidate();
                    layeredPane.repaint();
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

    /**
     * pour afficher l'écran de sélection des sauvegardes
     */
    public static void ecranSauvegarde(){
        
        SwingUtilities.invokeLater(()-> {
        configPanel();
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        
	    getFenetre().getContentPane().setLayout(null);
        getFenetre().revalidate();
        getFenetre().repaint();

        afficherImageDansInterface("image/ForetJolie.png");
    
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
                    radioButton.setBackground(Color.BLACK);

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
                    if (buttonGroup.getSelection()!=null){
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
                                            configPanel();
                                            layeredPane.removeAll();
                                            layeredPane.revalidate();
                                            layeredPane.repaint();                                           
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
                    }
                    
                });        
        getFenetre().revalidate();
        getFenetre().repaint();
        getFenetre().add(layeredPane);

        });

        
    }
    
    /**
     * pour configurer la fenêtre (appelé une fois au début du jeu)
     */
    public static void configFenetre() {

        getFenetre().setSize(1000, 1000); //taille fenetre
        getFenetre().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; //sortir correctement de la fenetre
        getFenetre().setLocationRelativeTo(null); // centrer la fenetre sur l'ecran
        configMenu() ;
        getFenetre().setVisible(true); // rendre la fenetre visible

    
    }
    /**
     * configurer le panel
     * 
     */
    public static void configPanel(){
        layeredPane.setBounds(0, 0, 1000, 1000);
    }


     /**
      * Pour afficher les persos d'un node 
      * @param node
      */
    public static void afficherperso(Node node){
        if (node==null){
            throw new IllegalArgumentException("Node ne peut être null");
        }
        if (node.getImagePersoList().size()>5){
            throw new IllegalArgumentException("Le jeu ne peut afficher que 5 persos à la fois ! Node concerné : "+node.getNom());
        }
        ArrayList<String> imageperso = node.getImagePersoList();
        if (imageperso!=null){
            
            JPanel panel= new JPanel(new FlowLayout());
            panel.setBounds(60, 350, 650, 270);
            panel.setOpaque(false);
            for (String  element : imageperso) {
                try {
                configPanel();
                ImageIcon imageIcon = new ImageIcon(element);
                
                // Vérifier le statut du chargement de l'image
                int loadStatus = imageIcon.getImageLoadStatus();
                if (loadStatus == MediaTracker.COMPLETE) {
                    // Redimensionnement de l'image
                    // On redimentionne en width 130 pour pouvoir faire rentrer 5 personnages
                    java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                    ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
                    JLabel label = new JLabel(imageRedimensionneeIcon);
                    panel.add(label);
                } else {
                    throw new Exception("Échec du chargement de l'image "+element);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erreur lors du chargement de l'image : " + e.getMessage());
            }
                
            }
            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
            layeredPane.add(panel, JLayeredPane.POPUP_LAYER);
            
            getFenetre().revalidate();
            getFenetre().repaint();
        }
    }

/**
 * Pour afficher nos nodes
 * @param node
 */
 public static void afficherNodeBase(Node node) {
        if (node == null){
            throw new IllegalArgumentException("Node ne peut être null (afficherNodeBase)");
        }
        Clip clip =afficherSoundDansInterface(node.getSoundName());

	    getFenetre().getContentPane().setLayout(null);

        afficherperso(node) ;
        
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
    } else InnerNodeButton(node, clip);


}

    /**
    * La fonction pour afficher les boutons correspondant au type de node
    * @param node The current ChooseNode to display options for.
    */

    public static void InnerNodeButton(Node node, Clip clip){
        configPanel();
        InnerNode chooseNode;// Cast the node to a ChooseNode
        
        chooseNode=(InnerNode)node;

        JPanel panelChoose= new JPanel(); // Create a panel to hold the ChooseNode buttons
        getFenetre().add(layeredPane);
        panelChoose.setBounds(710, 350, 250, 260);
        layeredPane.add(panelChoose, JLayeredPane.POPUP_LAYER);
	    panelChoose.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        panelChoose.setBackground(Color.RED); 
        panelChoose.setOpaque(false);
        
        if (chooseNode instanceof ChooseNode){
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
                    configPanel();
                    layeredPane.removeAll();
                    layeredPane.revalidate();
                    layeredPane.repaint();
                    chooseNode.getOptions().get(currentIndex).display(); // clique du bouton provoque affichage du prochain bode
                    
                }
            });
        } else boutonGoNext(btn1, chooseNode, clip);
        getFenetre().revalidate();
        }
        } else {
            String nomBouton = "Suivant";
            JButton btn1 = new JButton(nomBouton);
            Font maFont = new Font("Courier new", Font.PLAIN, 13);
            
            btn1.setFont(maFont);
            btn1.setBackground(Color.WHITE);
		    btn1.setForeground(Color.BLACK);
            panelChoose.add(btn1);
            
            boutonGoNext(btn1, chooseNode, clip);
            getFenetre().revalidate();
        }
    }

    /**
     * pour ajouter action goNext à un bouton
     * @param btn1
     * @param node
     * @param clip
     */
    public static void boutonGoNext(JButton btn1, InnerNode node, Clip clip){
        btn1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                configPanel();
                                layeredPane.removeAll();
                                layeredPane.revalidate();
                                layeredPane.repaint();
                                node.goNext().display();;      
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
 * La fonction pour afficher les persos du FightNode
 * @param node
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
                try {
                ImageIcon imageIcon= new ImageIcon(element);
                int loadStatus = imageIcon.getImageLoadStatus();
                if (loadStatus == MediaTracker.COMPLETE) {
                // On redimentionne en width 130 pour pouvoir faire rentrer 5 personnages
                java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
                JLabel label = new JLabel(imageRedimensionneeIcon);
                panelGroupe.add(label);
                } else {
                    throw new Exception("Échec du chargement de l'image "+element);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erreur lors du chargement de l'image : " + e.getMessage());
            }
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
                try {

                ImageIcon imageIcon= new ImageIcon(element);
                int loadStatus = imageIcon.getImageLoadStatus();
                if (loadStatus == MediaTracker.COMPLETE) {
                // On redimentionne en width 130 pour pouvoir faire rentrer 5 personnages
                java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
                JLabel label = new JLabel(imageRedimensionneeIcon);
                panelAdversaire.add(label);
                } else {
                    throw new Exception("Échec du chargement de l'image "+element);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erreur lors du chargement de l'image : " + e.getMessage());
            }
            }


            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
            layeredPane.add(panelAdversaire, JLayeredPane.POPUP_LAYER);
            
            getFenetre().revalidate();
            getFenetre().repaint();
        } 
    
 }

 /**
  * Fonction pour afficher les persos du fightNode
  * @param node
  * @param imagePathGroupList
  * @param imagePathAdversaireList
  */
 public static void afficherPersoFight(FightNode node, ArrayList<String> imagePathGroupList, ArrayList<String> imagePathAdversaireList){
    
        if (imagePathGroupList!=null){
            JPanel panelGroupe= new JPanel(new FlowLayout());
            panelGroupe.setBounds(60, 475, 650, 150);
            panelGroupe.setOpaque(false);
            for (String  element : imagePathGroupList) {
                try{
                ImageIcon imageIcon= new ImageIcon(element);
                int loadStatus = imageIcon.getImageLoadStatus();
                if (loadStatus == MediaTracker.COMPLETE) {
                // On redimentionne en width 130 pour pouvoir faire rentrer 5 personnages
                java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
                JLabel label = new JLabel(imageRedimensionneeIcon);
                panelGroupe.add(label);
                } else {
                    throw new Exception("Échec du chargement de l'image "+element);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erreur lors du chargement de l'image : " + e.getMessage());
            }
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

/**
 * La fonction pour sélectionner la compétence du personnage 
 * @param node
 * @param perso // le personnage auquel on est dans le groupe
 */
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
        JLabel cmp = new JLabel(Game.getGame().getGroupeJoueurVivant().get(perso).getName() + " PM : "+Game.getGame().getGroupeJoueurVivant().get(perso).getMana()+"/"+Game.getGame().getGroupeJoueurVivant().get(perso).getMaxMana(), JLabel.CENTER);
        cmp.setFont(new Font("Courier New", Font.PLAIN, 15));
        cmp.setForeground(Color.WHITE);
        contentPanel.add(cmp);
        for (int j = 0; j < Game.getGame().getGroupeJoueurVivant().get(perso).getCompetences().size(); j++) {
            JRadioButton radioButton = new JRadioButton("<html>"+Game.getGame().getGroupeJoueurVivant().get(perso).getCompetences().get(j).getName()+Game.getGame().getGroupeJoueurVivant().get(perso).getCompetences().get(j).affichageCoutMana());
            radioButton.setActionCommand(Game.getGame().getGroupeJoueurVivant().get(perso).getCompetences().get(j).getName());
            radioButton.setFont(new Font("Courier New", Font.PLAIN, 15));
            radioButton.setForeground(Color.WHITE);
            radioButton.setBackground(Color.BLACK);
            buttonGroup.add(radioButton);
            contentPanel.add(radioButton); // on crée un radio button pour chacune des compétences du personnage
        }
    
        JButton validateButton = new JButton("Valider");
        contentPanel.add(validateButton);
        validateButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) { 
                    if(buttonGroup.getSelection()!=null){   
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
                            if (perso + 1 < Game.getGame().getGroupeJoueurVivant().size()) {
                                // i use getFenetre() and note layeredpane because it doesn't delet panelfight
                                
                                selectionAction(node, perso +1 );
                             } else {
                                // i use getFenetre() and note layeredpane because it doesn't delet panelfight
                                
                                selectionAdverse(node);   
                            }
                        } else {
                            
                            Object[] cibleCompetence = {competence, null};   
                            selectionCible(node, perso, cibleCompetence) ; // on va sélectionner la cible de la compétence                             
                        }
                        layeredPane.remove(panelFight);
                        layeredPane.revalidate();
                        layeredPane.repaint();
                    }
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
                JRadioButton radioButton = new JRadioButton("<html> <strong> "+node.getOpponentsVivant().get(j).getName()+ "</strong> PV : "+node.getOpponentsVivant().get(j).getLifePoints()+"/"+node.getOpponentsVivant().get(j).getMaxLifePoints());
                radioButton.setActionCommand(node.getOpponentsVivant().get(j).getName());
                radioButton.setFont(maFont);
                radioButton.setForeground(Color.WHITE);
                radioButton.setBackground(Color.BLACK);
                buttonGroup.add(radioButton);
                contentPanel.add(radioButton);
            }
        } else {
            for (int j = 0; j < Game.getGame().getGroupeJoueurVivant().size(); j++) {
                JRadioButton radioButton = new JRadioButton("<html> <strong> "+ Game.getGame().getGroupeJoueurVivant().get(j).getName()+" </strong>PV : "+Game.getGame().getGroupeJoueurVivant().get(j).getLifePoints()+"/"+Game.getGame().getGroupeJoueurVivant().get(j).getMaxLifePoints());
                radioButton.setActionCommand(Game.getGame().getGroupeJoueurVivant().get(j).getName());
                radioButton.setFont(maFont);
                radioButton.setForeground(Color.WHITE);
                radioButton.setBackground(Color.BLACK);
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
                if (buttonGroup.getSelection()!=null){
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
                        selectionAction(node, perso +1 );
                } else {
                    // i use getFenetre() and note layeredpane because it doesn't delet panelfight
                        selectionAdverse(node);      
                } 
            }  }
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
        if (node.getOpponentsVivant().size()==0){
            throw new IllegalStateException("Si il n'y a plus d'opponents vivant cette fonction n'aurait pas du être lancée");
        }
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
    public static void faireActions(FightNode node) {
        if (node.getAction().size()==0){
            throw new IllegalStateException("impossible que actions soit vide si cette fonction est appelée") ;
        }
        // on transforme la map d'action en une arraylist
        Set<PersonnageCombattant> a = node.getAction().keySet();
        ArrayList<PersonnageCombattant> ordreDAction = new ArrayList<PersonnageCombattant>(a);
    // on trie la liste en fonction de la vitesse des personnages 
        Collections.sort(ordreDAction, Comparator.comparingInt(PersonnageCombattant::getSpeed).reversed());

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
        
            txt = (competence.utilisation(utilisateur, cible, node));
            
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
     * Les actions sont affichées 10 lignes par 10
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

            afficherPersoFight(node, imagePathGroupList, imagePathAdversaireList);
        
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

    /**
     * fonction pour affcher prochaine action 
     * @param node
     * @param texteAction
     * @param nombreAction
     * @param actionAffichee
     * @param ligneAffichee
     * @param imagePathGroupList
     * @param imagePathAdversaireList
     */
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
     * la fonction pour l'écran de victoire
     * @param node
     */
    public static void Victoire(FightNode node) {
        configPanel();
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        afficherImageDansInterface(node.getImageName());
	    getFenetre().getContentPane().setLayout(null);

        afficherperso(node) ;
        
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
        for(PersonnageCombattant persogroupe : Game.getGame().getGroupeJoueur()){
            if (!persogroupe.isAlive()){
                persogroupe.setAlive(false);
                persogroupe.setLifePoints(1);
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
    /**
     * Pour afficher le groupe en cas de victoire 
     */
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
                try{
                ImageIcon imageIcon= new ImageIcon(element);
                int loadStatus = imageIcon.getImageLoadStatus();
                if (loadStatus == MediaTracker.COMPLETE) {// On redimentionne en width 130 pour pouvoir faire rentrer 5 personnages
                java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
                ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
                JLabel label = new JLabel(imageRedimensionneeIcon);
                panelGroupe.add(label);
                } else {
                    throw new Exception("Échec du chargement de l'image "+element);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erreur lors du chargement de l'image : " + e.getMessage());
            }
            }

            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
            layeredPane.add(panelGroupe, JLayeredPane.POPUP_LAYER);
            
            getFenetre().revalidate();
            getFenetre().repaint();

        }

    }

    /**
     * afficher un perso en grand pour sa montée de niveau
     * @param imagePerso
     */
    public static void afficherPersoGainNiveau(String imagePerso){
        if (imagePerso!=null){
            JPanel panel= new JPanel(new FlowLayout());
            panel.setBounds(100, 300, 650, 310);
            panel.setOpaque(false);
            try{
                ImageIcon imageIcon= new ImageIcon(imagePerso);
                int loadStatus = imageIcon.getImageLoadStatus();
                if (loadStatus == MediaTracker.COMPLETE) {           // Redimensionnement de l'image
            // On redimentionne en width 130 pour pouvoir faire rentrer 5 personnages
            java.awt.Image imageRedimensionnee = imageIcon.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
            ImageIcon imageRedimensionneeIcon = new ImageIcon(imageRedimensionnee);
            JLabel label = new JLabel(imageRedimensionneeIcon);
            panel.add(label);
            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
            layeredPane.add(panel, JLayeredPane.POPUP_LAYER);

            } else {
                    throw new Exception("Échec du chargement de l'image "+imagePerso);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erreur lors du chargement de l'image : " + e.getMessage());
            }
            
            getFenetre().revalidate();
            getFenetre().repaint();
        }
    }

    /**
     * POur afficher l'écran de gain de niveau
     * @param node
     * @param gainNiveau
     */
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
                afficherPersoGainNiveau(perso.getImageLien());
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

    /** Écran de défaite
     * 
     */
    public static void Defaite(FightNode node) {
        configPanel();
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        afficherImageDansInterface(node.getImageName());
	    getFenetre().getContentPane().setLayout(null);
        
        ArrayList<String> imagePathAdversaireList = new ArrayList<String>();
    for (int i =0; i<node.getOpponentsVivant().size();i++){
        imagePathAdversaireList.add(node.getOpponentsVivant().get(i).getImageLien());
    }
        afficherPersoFight(node, null, imagePathAdversaireList);

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
    /**
     * Bouton pour écran passage de niveau 
     * @param node
     * @param gainNiveau
     */
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
    /**
     * Bouton pour aller au node nodeNext
     */
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
                        configPanel();
                        layeredPane.removeAll();
                        layeredPane.revalidate();
                        layeredPane.repaint();
                        nodeNext.display();
                        }
            });
    }

    
    /**
     * Fonction pour fermer la fenêtre au bout d'un certain timer
     */
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

    /**
     * Bouton pour TerminalNode 
     * @param node
     */
    public static void TerminalNodeButton(Node node) {
        configPanel();
        JPanel panelTerminal = new JPanel();
        getFenetre().add(layeredPane);
        panelTerminal.setBounds(711, 494, 144, 62);
        layeredPane.add(panelTerminal, JLayeredPane.POPUP_LAYER);
        panelTerminal.setBackground(Color.YELLOW);
        CloseFrame();
    }

    /**
     * 
     * @param imageName
     */
    public static void afficherImageDansInterface(String imageName) {
            try {
                configPanel();
                ImageIcon imageIcon = new ImageIcon(imageName);
                
                // Vérifier le statut du chargement de l'image
                int loadStatus = imageIcon.getImageLoadStatus();
                if (loadStatus == MediaTracker.COMPLETE) {
                    
                    JLabel label = new JLabel(imageIcon);
                    JPanel panel = new JPanel();
                    panel.add(label);
                    panel.setOpaque(false);
                    panel.setBounds(0, 0, 1000, 1000);
                    layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);
                    getFenetre().add(layeredPane);
                    getFenetre().setVisible(true);
                } else {
                    throw new Exception("Échec du chargement de l'image "+imageName);
                }
            } catch (Exception e) {
                System.out.println("Erreur lors du chargement de l'image : " + e.getMessage());
            }
        
    }
    /**
     * Fonction pour lancer les sons dans l'interface
     * @param soundName
     * @return
     */
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