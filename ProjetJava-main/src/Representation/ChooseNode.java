package Representation;
import java.util.ArrayList;

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
		super.display();

    }

	 public static void main(String[] args) {
 		InnerNode test = new InnerNode("Node test", "<html> vous êtes un jeune prince/ BLABLABLA Vous avez assassiné le roi etc... ", true) ; // balise html a revoir            		
     	TerminalNode gameOver = new TerminalNode("Game Over" , "<html> Tu viens de mourir grosse merde, veux tu reprendre au check point ou rage quit ?") ;
		InnerNode test2 = new InnerNode("Node next", "<html> vous devez prouver votre innocence et vous battre pour vous") ;
 		test2.setNextNode(gameOver) ;
 		test.setNextNode(test2) ;
 		ArrayList <Node> options= new ArrayList<>();
		options.add(test);
		options.add(test2);
		options.add(gameOver);
 		ChooseNode testChoix = new ChooseNode("test", "<html> tu dois choisir entre les choix suivants : ", options) ;
 		testChoix.display() ;
     }
    
}

