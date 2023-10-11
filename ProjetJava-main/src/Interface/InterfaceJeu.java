package Interface;
import Representation.* ;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.* ;
import javax.swing.border.MatteBorder;


public class InterfaceJeu {
	
	private static JFrame fenetre = new JFrame();
	private static JMenuBar barreMenu = new JMenuBar() ;


	
	public InterfaceJeu() {
		
		configFenetre();
	}
public static JFrame getFenetre() {
	return fenetre;
}


public static void setFenetre(JFrame fenetre) {
	InterfaceJeu.fenetre = fenetre;
}


public static JMenuBar getBarreMenu() {
	return barreMenu;
}


public static void setBarreMenu(JMenuBar barreMenu) {
	InterfaceJeu.barreMenu = barreMenu;
}


public static void cleanFenetre() {
	getFenetre().getContentPane().removeAll();
	getFenetre().revalidate() ;
	getFenetre().repaint();
}


public static void configMenu() {
	
	JMenu inventaire = new JMenu("Inventaire") ;
	JMenu histoire = new JMenu ("Histoire") ;
	JMenu statut = new JMenu ("Statut") ;
	
	JMenuItem precedent = new JMenuItem("Voir précédent") ;
	JMenuItem resumeH = new JMenuItem("Résumé de l'histoire") ;
   JMenuItem stats = new JMenuItem("Statistiques") ;
	
	histoire.add(precedent) ;
	histoire.add(resumeH) ;
    statut.add(stats);
	
	getBarreMenu().add(histoire) ;
	getBarreMenu().add(inventaire) ;
	getBarreMenu().add(statut) ;
	
	
	getFenetre().setJMenuBar(getBarreMenu());

}

public static void configFenetre() {

getFenetre().setSize(1000, 1000); //taille fenetre
getFenetre().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; //sortir correctement de la fenetre
getFenetre().setLocationRelativeTo(null); // centrer la fenetre sur l'ecran
configMenu() ;
getFenetre().setVisible(true); // rendre la fenetre visible



}

/*
public static void popUp(String description) {
	JLayeredPane popUP = new JLayeredPane() ;
	JLabel label = new JLabel("", JLabel.CENTER) ;
	GridBagConstraints constraints = new GridBagConstraints(); // Utilisation d'un gestionnaire de mise en page FlowLayout
	popUP.add(label) ;
	
	char[] texts = description.toCharArray(); // transformation de la chaine descrition en tableau de char
    Timer timer = new Timer(20, new ActionListener() { // timer apparition d'un char composant le tableau ci-dessus toutes les 20milisec
    int index = 0 ; // index pour recuperer chaque char par l'intermediaire du tableau
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (index < texts.length) { //Parcours de la chaine Descrition caractère par caractère grace au tableau texts
            char nextChar = description.charAt(index); // recuperation dans la chaine de caractere du caractere associé a l'index
            if(nextChar =='/'){ //creation d'une condition de passage a la ligne : utilisation de balise web (retour chariot ne marchant pas) MAIS A REVOIR 
                label.setText(label.getText() + "<br>");
                index++;
            }
            else{
                label.setText(label.getText() + nextChar); // label.getText() récupère le texte actuellement affiche dans la frame. On ajoute le caractere suivant qui compose la chaine Descrition. ATTENTION setText() ne prend que des String(!=char)
                index++; //on passe au caractere suivant de la chaine de description
            }
            
        } else {
            ((Timer) e.getSource()).stop(); // Arrête le timer après l'affichage de tous les textes
            
            
			CreateCloseButton(constraints, popUP);
        }
        
    }
});


timer.start();
	
}




public static void CreateCloseButton(GridBagConstraints constraints, JLayeredPane pane) {
	JButton fermer = new JButton("Fermer"); // création button
    constraints.gridx = 0;
    constraints.gridy = 1;
    getFenetre().add(fermer,constraints); // ajout du bouton a la fenetre
	constraints.gridx = 1;
    constraints.gridy = 1;
    getFenetre().revalidate() ;
	boutonClosePane(fermer, pane);
	
}

public static void retirer (Component component) {
	
	getFenetre().remove(component);
}

public static void boutonClosePane(JButton btn, JLayeredPane pane) {
	
	btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				retirer(pane) ;
			}
			});
}

*/



public void afficherNodeBase(Node node) {
	fenetre.getContentPane().setLayout(null);
	cleanFenetre() ;
    JPanel p= new JPanel();
    p.setBounds(60, 110, 600, 100);
    fenetre.getContentPane().add(p);
    JLabel label = new JLabel("", JLabel.CENTER);// affichage description Node 
    p.add(label); //ajout du label a la fenetre
    p.setBackground(Color.CYAN); 
    label.setFont(new Font("Times New Roman", Font.PLAIN, 17));
    getFenetre().revalidate();
    getFenetre().repaint();

	
    char[] texts = node.getDescription().toCharArray(); // transformation de la chaine descrition en tableau de char
    Timer timer = new Timer(20, new ActionListener() { // timer apparition d'un char composant le tableau ci-dessus toutes les 20milisec
    int index = 0; // index pour recuperer chaque char par l'intermediaire du tableau

    @Override
    public void actionPerformed(ActionEvent e) {
        if (index < texts.length) { //Parcours de la chaine Descrition caractère par caractère grace au tableau texts
            char nextChar = node.getDescription().charAt(index); // recuperation dans la chaine de caractere du caractere associé a l'index
            if(nextChar =='/'){ //creation d'une condition de passage a la ligne : utilisation de balise web (retour chariot ne marchant pas) MAIS A REVOIR 
                label.setText(label.getText() + "<br>");
                index++;
                
            }
            else{
                label.setText(label.getText() + nextChar); // label.getText() récupère le texte actuellement affiche dans la frame. On ajoute le caractere suivant qui compose la chaine Descrition. ATTENTION setText() ne prend que des String(!=char)
                index++; //on passe au caractere suivant de la chaine de description
            }
            
        } else {
            ((Timer) e.getSource()).stop(); // Arrête le timer après l'affichage de tous les textes

            if (node.getClass()== ChooseNode.class){ //Si le node en question est un chooseNode: affichage boutons choix
                ChooseNodeButton(node);
            }
            if(node.getClass()== InnerNode.class){ // Si le node est un innerNode affichage boutonSuivant
                InnerNodeButton(node);
            }
            //ChooseNodeButton();
			//
        }
        
    }
});


timer.start(); 

}

/*public void ChooseNextButton(ArrayList options){
     for (int i = 0; i < getOptions().size(); i++) {
            final int currentIndex = i; // On récupère l'index actuel en final pour pouvoir l'utiliser ensuite dans l'action listener 
            constraints.gridx++;
            JButton btn1 = new JButton(getOptions().get(i).getNom()); // création button
            getW().add(btn1, constraints); // ajout du bouton a la fenetre
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Code à exécuter lorsque le bouton est cliqué
                    getOptions().get(currentIndex).display();
                }
            });
        }
}*/

public void ChooseNodeButton(Node node){
    ChooseNode chooseNode;
    chooseNode=(ChooseNode)node;
    JPanel j= new JPanel();
     j.setBounds(661, 109, 194, 323);
     fenetre.getContentPane().add(j);
	 j.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
     j.setBackground(Color.RED); 
    
    for (int i = 0; i < chooseNode.getOptions().size(); i++) {
        final int currentIndex = i;
        JButton btn1 = new JButton(chooseNode.getOptions().get(i).getNom());
        btn1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        btn1.setBackground(new Color(240, 240,240));
		btn1.setForeground(new Color(128, 64, 0));
        j.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //chooseNode.getOptions().get(currentIndex).display();
                JPanel panel_3 = new JPanel();
		        panel_3.setBounds(56, 212, 552, 344);
		        fenetre.getContentPane().add(panel_3);
		        panel_3.setLayout(null);
		
                
		
		        JLayeredPane layeredPane_1 = new JLayeredPane();
		        layeredPane_1.setBounds(89, 34, 320, 239);
		        layeredPane_1.setForeground(new Color(0, 255, 64));
		        layeredPane_1.setBorder(new MatteBorder(4, 3, 1, 6, (Color) new Color(0, 0, 0)));
                layeredPane_1.setBackground(Color.BLUE);
                j.setOpaque(false);
		        panel_3.add(layeredPane_1);
		        layeredPane_1.setLayout(null);
		
		        JPanel panel_5 = new JPanel();
		        panel_5.setBounds(89, 36, 117, 168);
		        layeredPane_1.add(panel_5,JLayeredPane.DEFAULT_LAYER);
		        panel_5.setLayout(null);
		
		        JLabel lblNewLabel_1 = new JLabel("bienvenidos");
		        lblNewLabel_1.setBounds(10, 30, 73, 14);
		        panel_5.add(lblNewLabel_1);
		
		        JButton btnNewButton_4 = new JButton("ok");
		        btnNewButton_4.setBounds(10, 110, 89, 23);
		        panel_5.add(btnNewButton_4);
                btnNewButton_4.addActionListener(new ActionListener() {
                    @Override
                public void actionPerformed(ActionEvent e) {
                layeredPane_1.setVisible(false);

                }
                });
            }
        });
        getFenetre().revalidate();
    }
}


public void InnerNodeButton(Node node){
    JPanel k = new JPanel();
		k.setBounds(711, 494, 144, 62);
        
		fenetre.getContentPane().add(k);
        k.setBackground(Color.yellow);
     if(node.getClass()== InnerNode.class){
       JButton suivant = new JButton("Suivant"); // création button
                suivant.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                 suivant.setBackground(new Color(240, 240,240));
		        suivant.setForeground(new Color(128, 64, 0));
                k.add(suivant);
                getFenetre().revalidate() ;
				boutonGoNext(suivant, node);
    }


    /*else{
        getFenetre().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints(); // Utilisation d'un gestionnaire de mise en page FlowLayout
        constraints.gridy = -1;
        constraints.gridx = 0;
        for (int i = 0; i < getOptions().size(); i++) {
            final int currentIndex = i; // On récupère l'index actuel en final pour pouvoir l'utiliser ensuite dans l'action listener 
            constraints.gridx++;
            JButton btn1 = new JButton(getOptions().get(i).getNom()); // création button
            getFenetre().add(btn1, constraints); // ajout du bouton a la fenetre
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Code à exécuter lorsque le bouton est cliqué
                    getOptions().get(currentIndex).display();
                }
            });
        }
    }*/
    /*elseif(node.getClass()==FightNode.class){

    }*/
}


public void boutonGoNext(JButton btn1, Node node){
    btn1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Code à exécuter lorsque le bouton est cliqué
                    	node.goNext().display(); ;
                    	
                    }
                });
}

}


