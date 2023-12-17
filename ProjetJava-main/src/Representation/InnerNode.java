/**
 * The InnerNode class represents an inner node in a hierarchical structure.
 * It extends the Node class.
 */

package Representation;

import java.util.ArrayList;
import java.util.Objects;
import javax.swing.ImageIcon;


public abstract class InnerNode extends Node {
	
	private ArrayList<Node> options = new ArrayList<>();
	 /**
     * Constructor for an InnerNode without a checkpoint.
     * @param name The name of the inner node.
     * @param description The description of the inner node.
     */

    public InnerNode(String nom, String description,String imageName, ArrayList<Node> options) {
		super(nom,description, imageName);
		this.options = options ;
	}

    public InnerNode(String nom, String description, ArrayList<Node> options, boolean checkPoint) {
		super(nom, description, checkPoint);
        this.options = options ;
	}

    public InnerNode(String nom, String description) {
		super(nom, description);
	}

	/**
     * Constructor for an InnerNode with an optional checkpoint.
     * @param name The name of the inner node.
     * @param description The description of the inner node.
     * @param checkpoint Indicates whether the inner node is a checkpoint.
     */

    public InnerNode(String nom, String description,String imageName, boolean checkPoint, ArrayList<Node>  options) {

        super(nom,description,imageName,checkPoint);
        this.options = options ;
    }
    
    public InnerNode(String nom, String description,String imageName, boolean checkPoint) {
    	super(nom, description,imageName, checkPoint) ;
    }

    public InnerNode(String nom, String description, ArrayList<Node> options) {
		super(nom,description);
		this.options = options ;
	}

	/**
     * Constructor for an InnerNode with an optional checkpoint.
     * @param name The name of the inner node.
     * @param description The description of the inner node.
     * @param checkpoint Indicates whether the inner node is a checkpoint.
     */

    public InnerNode(String nom, String description, boolean checkPoint, ArrayList<Node>  options) {

        super(nom,description,checkPoint);
        this.options = options ;
    }
    
    public InnerNode(String nom, String description, boolean checkPoint) {
    	super(nom, description, checkPoint) ;
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
	
	// @Override
    // public String toString() {
    //     return "InnerNode:"+super.toString();
    // }

   
	// // @Override
    // // public boolean equals(Object obj) {
    // //     if (this == obj) {
    // //         return true;
    // //     }

    //     if (obj == null || getClass() != obj.getClass()) {
    //         return false;
    //     }

    //     InnerNode innerNode = (InnerNode) obj;
    //     return 
    //            Objects.equals(getOptions(), innerNode.getOptions()) && Objects.equals(this.getDescription(), innerNode.getDescription()) &&
    //            Objects.equals(this.getNom(), innerNode.getNom()) &&
    //            Objects.equals(this.getID(), innerNode.getID()) &&
    //            Objects.equals(this.getFormerNode(), innerNode.getFormerNode()) &&
    //            Objects.equals(this.getCheckPoint(), innerNode.getCheckPoint());
    // }
	
	//  /**
    //  * Overrides the display method to display the information of the choice node.
    //  */
    // @Override
    // public String toString() {
    //     return "InnerNode:"+super.toString();
    // }

    
	public abstract void goNext() ;

	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        InnerNode innerNode = (InnerNode) obj;
        return super.equals(obj) &&
               Objects.equals(getOptions(), innerNode.getOptions());
    }

    
}
