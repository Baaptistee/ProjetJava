package Representation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import Event.Event;
import Event.ImageNode;
import Event.SoundNode;
import Interface.* ;

public abstract class Node extends Object implements Event, Serializable {
	
	private static int totalNode = 0; 
	private static Node lastCheckPoint;
	private static InterfaceJeu interfac = new InterfaceJeu() ; 
	private String description ; 
	private int idNode ; 
	private String nom ; 
	private Node formerNode ; 
	private boolean checkPoint = false ;
	private String imageName;
	private String soundName;
	private ArrayList <String> imagepersoPath = new ArrayList<String>();


	/**
     * Constructor for the Node with essential attributes.
     * @param nom The name of the Node.
     * @param description The description of the Node.
     * @param imageName The name of the associated image.
     */

	 public Node(String nom, String description, String imageName){
			if (nom == null) {
				throw new IllegalArgumentException("Le nom du node ne peut pas être null");
			}
			this.nom = nom;
	
			if (description == null) {
				throw new IllegalArgumentException("La description du node ne peut pas être null");
			}
			this.description = description;
	
			if (imageName == null) {
				throw new IllegalArgumentException("Le nom de l'image du node ne peut pas être null");
			}
			this.imageName = imageName;
			
	}


	/**
	* Constructor for the Node with essential attributes.
     * @param nom The name of the Node.
     * @param description The description of the Node.
     */

	public Node(String nom, String description){
		if (nom == null) {
			throw new IllegalArgumentException("Le nom du node ne peut pas être null");
		}
		if (description == null) {
			throw new IllegalArgumentException("La description du node ne peut pas être null");
		}
		this.idNode = totalNode++ ; // Incrementing for a unique ID with each Node creation
		this.description = description ;
		this.nom = nom ;
	}

	/**
     * Constructor for the Node with essential attributes.
     * @param nom The name of the Node.
     * @param description The description of the Node.
     * @param imageName The name of the associated image.
	 * @param imagepersoPath The name of the associated image.
     */

	public Node(String nom, String description, String imageName,ArrayList<String> imagepersoPath) {
		if (nom == null) {
			throw new IllegalArgumentException("Le nom du node ne peut pas être null");
		}
		if (description == null) {
			throw new IllegalArgumentException("La description du node ne peut pas être null");
		}
		if (imageName == null) {
			throw new IllegalArgumentException("Le nom de l'image du node ne peut pas être null");
		} 
		if (nom.length()>25){
			throw new IllegalArgumentException("Le nom ne peut pas être de plus de 25 caractères");
		}
		
		this.idNode = totalNode++ ; // Incrementing for a unique ID with each Node creation
		this.description = description ;
		this.nom = nom ;
		this.imageName= imageName;
		this.imagepersoPath=imagepersoPath;
	}


	
	/**
     * Constructor for the Node with an optional checkpoint.
     * @param name The name of the Node.
     * @param description The description of the Node.
	 * @param imageName The name of the associated image.
     * @param isCheckpoint Indicates whether the Node is a checkpoint.
     */

	public Node(String nom, String description,String imageName, boolean checkPoint){

		if (nom == null) {
			throw new IllegalArgumentException("Le nom du node ne peut pas être null");
		}
		if (description == null) {
			throw new IllegalArgumentException("La description du node ne peut pas être null");
		}
		if (imageName == null) {
			throw new IllegalArgumentException("Le nom de l'image du node ne peut pas être null");
		}
		if (nom.length()>25){
			throw new IllegalArgumentException("Le nom ne peut pas être de plus de 25 caractères");
		}
		
		this.idNode = totalNode++ ;
		this.description = description ;
		this.nom = nom ;
		this.checkPoint = checkPoint ;
		this.imageName=imageName; 
	}

	/**
     * Constructor for the Node with an optional checkpoint.
     * @param name The name of the Node.
     * @param description The description of the Node.
     * @param isCheckpoint Indicates whether the Node is a checkpoint.
     */
	

	public Node(String nom, String description, boolean checkPoint){

		if (nom == null) {
			throw new IllegalArgumentException("Le nom du node ne peut pas être null");
		}
		if (description == null) {
			throw new IllegalArgumentException("La description du node ne peut pas être null");
		}
		if (nom.length()>25){
			throw new IllegalArgumentException("Le nom ne peut pas être de plus de 25 caractères");
		}
		this.idNode = totalNode++ ;
		this.description = description ;
		this.nom = nom ;
		this.checkPoint = checkPoint ;
	}


	/**
 * Get the list of image paths for associated characters.
 *
 * @return The list of image paths.
 */
public ArrayList<String> getImagePersoList() {
    return this.imagepersoPath;
}

public String getSoundName(){
	return soundName;
}

public void setImageName(String imageName){
	this.imageName=imageName;
}

public void setImagePersoList(ArrayList<String> im){
	if (im.size()>5){
		throw new IllegalArgumentException("Le jeu ne peut afficher que 5 persos à la fois ! Node concerné : "+this.nom);
	}
	this.imagepersoPath=im ;
}

/**
 * Get the name of the associated image.
 *
 * @return The name of the image.
 */
public String getImageName() {
    return imageName;
}

	/**
     * Set the description of the Node.
     * @param newDescription The new description to set.
     */

	public void setDescription(String newDescription) {
		if( newDescription==null){
			throw new IllegalArgumentException("La description est null");
		}
		this.description = newDescription ;
		
	}
	/**
	 * Get the total number of nodes created.
	 *
	 * @return The total number of nodes.
	 */
	public static int getTotalNode() {
		return totalNode;
	}
	 /**
     * Get the description of the Node.
     * @return The description of the Node.
     */

	public String getDescription() {
		return this.description ;
	}

	/**
     * Set the name of the Node.
     * @param newNom The new name to set.
     */

	public void setNom(String newNom) {
		if( newNom==null){
			throw new IllegalArgumentException("Le nom est null");
		}
		if (nom.length()>25){
			throw new IllegalArgumentException("Le nom ne peut pas être de plus de 25 caractères");
		}
		this.nom = newNom ; 
	}
	
	  /**
     * Get the name of the Node.
     * @return The name or title of the Node.
     */ 

	public String getNom() {
		
		return this.nom ;
	}


	/**
     * Get the unique identifier (ID) of the Node.
     * @return The ID of the Node.
     */

	public int getID() {
		
		return this.idNode;
	}

	 /**
     * Get the former Node, which is the Node that precedes this one.
     * @return The former Node.
     */

	public Node getFormerNode() {
		
		return this.formerNode ;
		}
	
	 /**
     * Set the former Node, which is the Node that precedes this one.
     * @param formerNode The former Node to set.
     */

	public void setFormerNode (Node formerNode) {
		
		this.formerNode = formerNode ;
	}


	/**
     * Get the checkpoint status of the Node.
     * @return `true` if the Node is a checkpoint, `false` otherwise.
     */

	public boolean getCheckPoint() {
		return this.checkPoint ;
	}
	
	 /**
     * Set the checkpoint status of the Node.
     * @param x `true` to mark the Node as a checkpoint, `false` otherwise.
     */

	public void setCheckPoint(boolean x) {
		this.checkPoint = x ;
	}
	
	/**
     * Mark the Node as a checkpoint.
     */

	public void checkPointTrue() {
		this.checkPoint = true ;
	}

	/**
     * Set the last checkpoint Node.
     * @param x The last checkpoint Node to set.
     */

	public static void setLastCheckpoint(Node x) {
		lastCheckPoint = x ;
	}

	/**
     * Get the last checkpoint Node.
     * @return The last checkpoint Node.
     */

	public static Node getLastCheckPoint() {
		return lastCheckPoint ;
	}
	
	/**
     * Get the Game.getGame() interface instance.
     * @return The Game.getGame() interface.
     */

	public static InterfaceJeu getInterface() {
		return interfac ;
	}
	
	/**
     * Move to the next Node while updating the formerNode reference.
     */

	public abstract Node goNext() ;

	 /**
     * Check if the Node is a checkpoint and update the last checkpoint if needed.
     */

	public void isCheckPoint() {
		if (this.getCheckPoint()) { 
        	setLastCheckpoint(this) ;
        }
	}
	
		/**
	 * Returns a string representation of the Node, including its name and description.
	 *
	 * @return A string representation of the Node.
	 */
	@Override
	public String toString() {
		return "Nom:" + this.getNom() + "Description:" + this.getDescription();
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 *
	 * @param obj The reference object with which to compare.
	 * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null || getClass() != obj.getClass()) {
			return false;
		} else {
			Node node = (Node) obj;
			return Objects.equals(this.getDescription(), node.getDescription()) &&
					Objects.equals(this.getNom(), node.getNom()) &&
					Objects.equals(this.getID(), node.getID()) &&
					Objects.equals(this.getFormerNode(), node.getFormerNode()) &&
					Objects.equals(this.getCheckPoint(), node.getCheckPoint());
		}
	}

	/**
 * Displays the Node in the user interface, sets it as the current Node in the game, and
 * checks if it is a checkpoint to update the last checkpoint if needed.
 */
public void display() {
    this.isCheckPoint();
    Game.getGame().setCurrentNode(this);
	ImageNode imageNode= new ImageNode(this, this.getImageName());
    imageNode.display();
	SoundNode soundNode = new SoundNode(this, "sound/success-1-6297.wav");
    soundNode.display();
}

/**
 * @return The current Node as the next event.
 */
@Override
public Event chooseNext() {
    goNext();
    return this;
}
	
}