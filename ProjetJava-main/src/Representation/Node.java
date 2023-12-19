package Representation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.* ;
import Event.Event;
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
	private ArrayList <String> imagepersoPath;


	 /**
     * Constructor for the Node.
     * @param name The name of the Node.
     * @param description The description of the Node.
     */

	 public Node(String nom, String description, String imageName) throws IllegalArgumentException {
		try {
			if (nom == null) {
				throw new IllegalArgumentException("Le nom ne peut pas être null");
			}
			this.nom = nom;
	
			if (description == null) {
				throw new IllegalArgumentException("La description ne peut pas être null");
			}
			this.description = description;
	
			if (imageName == null) {
				throw new IllegalArgumentException("Le nom de l'image ne peut pas être null");
			}
			this.imageName = imageName;
	
		} catch (IllegalArgumentException e) {
			System.err.println("Erreur : " + e.getMessage());
		}
	}
	

	public Node(String nom, String description) throws IllegalArgumentException {
		if (nom == null) {
			throw new IllegalArgumentException("Le nom ne peut pas être null");
		}
		if (description == null) {
			throw new IllegalArgumentException("La description ne peut pas être null");
		}
		this.idNode = totalNode++ ; // Incrementing for a unique ID with each Node creation
		this.description = description ;
		this.nom = nom ;
	}

	public Node(String nom, String description, String imageName,ArrayList<String> imagepersoPath) throws IllegalArgumentException {
		if (nom == null) {
			throw new IllegalArgumentException("Le nom ne peut pas être null");
		}
		if (description == null) {
			throw new IllegalArgumentException("La description ne peut pas être null");
		}
		if (imageName == null) {
			throw new IllegalArgumentException("Le nom de l'image ne peut pas être null");
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
     * @param isCheckpoint Indicates whether the Node is a checkpoint.
     */

	public Node(String nom, String description,String imageName, boolean checkPoint) throws IllegalArgumentException {

		if (nom == null) {
			throw new IllegalArgumentException("Le nom ne peut pas être null");
		}
		if (description == null) {
			throw new IllegalArgumentException("La description ne peut pas être null");
		}
		if (imageName == null) {
			throw new IllegalArgumentException("Le nom de l'image ne peut pas être null");
		}
		
		this.idNode = totalNode++ ;
		this.description = description ;
		this.nom = nom ;
		this.checkPoint = checkPoint ;
		this.imageName=imageName; 
	}
	

	public Node(String nom, String description, boolean checkPoint) throws IllegalArgumentException {

		if (nom == null) {
			throw new IllegalArgumentException("Le nom ne peut pas être null");
		}
		if (description == null) {
			throw new IllegalArgumentException("La description ne peut pas être null");
		}
		this.idNode = totalNode++ ;
		this.description = description ;
		this.nom = nom ;
		this.checkPoint = checkPoint ;
	}
	//public abstract ArrayList<ImageIcon> ImagePersoList();


	public ArrayList<String> getImagePersoList() {
        return this.imagepersoPath;
    }


	public String getImageName(){
		return imageName;
	}

	/**
     * Set the description of the Node.
     * @param newDescription The new description to set.
     */

	public void setDescription(String newDescription) {
		
		this.description = newDescription ;
		
	}

	public static int getTotalNode(){
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

	public abstract void goNext() ;

	 /**
     * Check if the Node is a checkpoint and update the last checkpoint if needed.
     */

	public void isCheckPoint() {
		if (this.getCheckPoint()) { 
        	setLastCheckpoint(this) ;
        }
	}
	
	@Override
	public String toString() {
		return "Nom:"+this.getNom()+"Description:"+ this.getDescription();
	}

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
     * Display the Node in the user interface.
     */

	public void display() {
		this.isCheckPoint() ;
		ImageIcon imageIcon = new ImageIcon(imageName);
		Game.getGame().setCurrentNode(this);
		getInterface().afficherNodeBase(this, imageIcon, getImagePersoList());
	}
	

	@Override
	public Event chooseNext() {
		goNext();
		return this;
	}
	
}