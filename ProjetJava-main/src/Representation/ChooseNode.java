/**
 * The ChooseNode class represents a node for making a choice among different options.
 * It extends the Node class.
 */


 package Representation;

 import java.util.ArrayList;
import java.util.Objects;
public class ChooseNode extends InnerNode {


	/**
     * Constructor for the ChooseNode class.
     * @param name The name of the choice node.
     * @param description The description of the choice node.
     * @param options The available options for the choice.
     */

	public ChooseNode(String nom, String description,String imageName, ArrayList <Node> options){
		super(nom, description,imageName, options) ; // Call to the superclass constructor
	}

	public ChooseNode(String description, String imageNode){
		super("Node" + Node.getTotalNode()+1, description,imageNode, false) ;
	}
    public ChooseNode(String nom,String description, String imageNode){
		super(nom, description,imageNode, false) ;
	}
	
	// @Override
	// public String toString() {
	// 	return "Choose Node:"+ super.toString();
	// }

	// @Override
    // public boolean equals(Object obj) {
    //     if (this == obj) {
    //         return true;
    //     }

    //     if (obj == null || getClass() != obj.getClass()) {
    //         return false;
    //     }
    //     return super.equals(obj);
    // }
	
	@Override 
	public void display() {
		super.display();
        //System.out.println("Displaying Choose Node");

	}
    // Pour la classe CHooseNode, l'équivalent de la méthode goNext se fait au niveau de l'interface graphique 
	public void goNext() {
        
	}

	@Override
	public String toString() {
		return "Choose Node:"+super.toString();
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
}


