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

	public void setOptions(ArrayList <Node> options){
		this.options=options;
	}

	 /**
     * Add an option to the list of available options.
     * @param additionalOption The option to add.
     */

	public void addOption(Node optionSupp) {
		this.getOptions().add(optionSupp);
	}

	/**
     * Remove an option from the list of available options.
     * @param removedOption The option to remove.
     */

	public void suppOption(Node suppOption) {
		int index= this.getOptions().indexOf(suppOption);
		this.getOptions().remove(index);
	}
	
	 /**
     * Overrides the display method to display the information of the choice node.
     */
    
	@Override 
	public void display() {
		super.display();

	}
    // Pour la classe CHooseNode, l'équivalent de la méthode goNext se fait au niveau de l'interface graphique 
	public void goNext() {
	}
}

