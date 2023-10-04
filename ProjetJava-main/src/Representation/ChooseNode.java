package Representation;
import javax.swing.* ; // importation des librairies necessaires
import java.util.ArrayList;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseNode extends Node {
	
	private  ArrayList <Node> options; // un tableau comportant les differentes options possible du choix 

	// le constructeur de la classe 
	public ChooseNode(String nom, String description, ArrayList <Node> options){
		super(nom, description) ; // appel au constructeur de la classe mère
		this.options = options ; 
		
	}
	//le getter pour options
	public ArrayList <Node> getOptions() {
		return options ;
	}

	// une method pour ajouter 1 option 
	public void addOption(Node optionSupp) {
		getOptions().add(optionSupp);
	}

	// une method pour supprimer une option 
	public void suppOption(Node suppOption) {
		int index=getOptions().indexOf(suppOption);
		options.remove(index);
	}
	
	@Override 
	public void display() {
		
		if (this.getCheckPoint()) {
			setLastCheckpoint(this) ; 
		}
		
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
                    
                    constraints.gridy = -1;
                    constraints.gridx = 0;

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

                    getW().revalidate() ;
                    
                }
            }
        });
        timer.start();
		
	}
	
	
	 public static void main(String[] args) {
 		Node test = new Node("Node test", "<html> vous êtes un jeune prince/ BLABLABLA Vous avez assassiné le roi etc... ", true) ; // balise html a revoir            		
     	TerminalNode gameOver = new TerminalNode("rip" , "<html> Tu viens de mourir grosse merde, veux tu reprendre au check point ou rage quit ?") ;
		Node test2 = new Node("Node next", "<html> vous devez prouver votre innocence et vous battre pour vous") ;
 		test2.setNextNode(gameOver) ;
 		test.setNextNode(test2) ;
 		gameWindow() ;
 		ArrayList <Node> options= new ArrayList<>();
		options.add(test);
		options.add(test2);
		options.add(gameOver);
 		ChooseNode testChoix = new ChooseNode("test", "<html> tu dois choisir entre les choix suivants : ", options) ;
 		testChoix.display() ;
     }
}

