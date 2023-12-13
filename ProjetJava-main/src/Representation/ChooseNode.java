/**
 * The ChooseNode class represents a node for making a choice among different options.
 * It extends the Node class.
 */


 package Representation;

 import java.util.ArrayList;

public class ChooseNode extends InnerNode {
	
	private  ArrayList <Node> options; // An array containing the different available options for the choice

	/**
     * Constructor for the ChooseNode class.
     * @param name The name of the choice node.
     * @param description The description of the choice node.
     * @param options The available options for the choice.
     */

	public ChooseNode(String nom, String description, ArrayList <Node> options){
		super(nom, description, options) ; // Call to the superclass constructor
	}

	public ChooseNode(String nom, String description){
		super(nom, description, false) ;
	}
	
	@Override
	public String toString() {
		return "Choose Node:"+ super.toString();
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return super.equals(obj);
    }
	
	@Override 
	public void display() {
		super.display();

	}
    // Pour la classe CHooseNode, l'équivalent de la méthode goNext se fait au niveau de l'interface graphique 
	public void goNext() {
	}
}

