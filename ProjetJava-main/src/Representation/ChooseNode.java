/**
 * The ChooseNode class represents a node for making a choice among different options.
 * It extends the Node class.
 */


 package Representation;

 import java.util.ArrayList;

public class ChooseNode extends Node {
	
	private  ArrayList <Node> options; // An array containing the different available options for the choice


	/**
     * Constructor for the ChooseNode class.
     * @param name The name of the choice node.
     * @param description The description of the choice node.
     * @param options The available options for the choice.
     */

	public ChooseNode(String nom, String description, ArrayList <Node> options){
		super(nom, description) ; // Call to the superclass constructor
		this.options = options ; 
	}
	
	
	 /**
     * Get the list of available options for the choice.
     * @return The list of options.
     */

	public ArrayList <Node> getOptions() {
		return options ;
	}

	 /**
     * Add an option to the list of available options.
     * @param additionalOption The option to add.
     */

	public void addOption(Node optionSupp) {
		getOptions().add(optionSupp);
	}

	/**
     * Remove an option from the list of available options.
     * @param removedOption The option to remove.
     */

	public void suppOption(Node suppOption) {
		int index=getOptions().indexOf(suppOption);
		options.remove(index);
	}
	
	 /**
     * Overrides the display method to display the information of the choice node.
     */
    
	@Override 
	public void display() {
		super.display() ;

    }


	/**
     * Main method for testing the ChooseNode class.
     */
	 public static void main(String[] args) {
		// Creating some nodes for options
 		InnerNode test = new InnerNode("Node test", "<html> vous êtes un jeune prince/ BLABLABLA Vous avez assassiné le roi etc... ", true) ; // balise html a revoir            		
     	
		TerminalNode gameOver = new TerminalNode("Game Over" , "<html> Tu viens de mourir grosse merde, veux tu reprendre au check point ou rage quit ?") ;
		
		InnerNode test2 = new InnerNode("Node next", "<html> vous devez prouver votre innocence et vous battre pour vous") ;

		FightNode test3 = new FightNode("Combat", "C'est la guerre");
 		
		// Configuring next nodes
		test2.setNextNode(gameOver) ;
		test.setNextNode(test2) ;
		// test3.setNextNode(test3);
 		
		// Creating a list of options
		ArrayList <Node> options= new ArrayList<>();
		options.add(test);
		options.add(test2);
		options.add(gameOver);
		options.add(test3);
 		
		// Creating a choice node
		ChooseNode testChoix = new ChooseNode("test", "<html> tu dois choisir entre les choix suivants : ", options) ;
 		
		// Displaying the choice node
		testChoix.display() ;
     }

    
}

