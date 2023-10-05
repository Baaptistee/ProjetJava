package Representation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.* ;
import java.awt.*;

public class TerminalNode extends Node {
	

	
	public TerminalNode(String nom, String description) {
		
		super(nom, description) ;
		
	}
		
	/*
	@Override 
	public void display() {
		
		getW().getContentPane().removeAll() ; // on clean le frame 
		getW().revalidate(); // on actualise l'affichage
		getW().repaint();
		getW().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints(); // Utilisation d'un gestionnaire de mise en page FlowLayout
        
        JLabel label = new JLabel("", JLabel.CENTER);// affichage description Node
        constraints.gridx = 0;
        constraints.gridy = 1;
        getW().add(label, constraints); //ajout du label a la fenetre

        
        char[] texts = getDescription().toCharArray(); // transformation de la chaine descrition en tableau de char
        Timer timer = new Timer(20, new ActionListener() { // timer apparition d'un char composant le tableau ci-dessus toutes les 20milisec
            int index = 0; // index pour recuperer chaque char par l'intermediaire du tableau
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < texts.length) { //Parcours de la chaine Descrition caractère par caractère grace au tableau texts
                    char nextChar = getDescription().charAt(index); // recuperation dans la chaine de caractere du caractere associé a l'index
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
                    JButton btn1 = new JButton("Quitter le jeu"); // création button
                    JButton btn2 = new JButton("Reprendre") ;
                    constraints.gridx = 1;
                    constraints.gridy = 1;
                    getW().add(btn1,constraints); // ajout du bouton a la fenetre
                    constraints.gridx = 2;
                    getW().add(btn2,constraints); // ajout du bouton a la fenetre
               
                    getW().revalidate() ;
                    
                    btn1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Code à exécuter lorsque le bouton est cliqué
                        	getW().dispose() ; 
                        }
                    });
                    
                    btn2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Code à exécuter lorsque le bouton est cliqué
                        	getLastCheckPoint().display() ; 
                        }
                    });
                    
  
                }
            }
        });
        timer.start();
	}
	
	/*
                public static void main(String[] args) {
            		Node test = new Node("Node test", "<html> vous êtes un jeune prince/ BLABLABLA Vous avez assassiné le roi etc... ", true) ; // balise html a revoir            		
                	TerminalNode gameOver = new TerminalNode("rip" , "<html> Tu viens de mourir grosse merde, veux tu reprendre au check point ou rage quit ?") ;
            		test.setNextNode(gameOver) ;
            		gameWindow() ;
            		test.display() ;
                }*/
	
} 
