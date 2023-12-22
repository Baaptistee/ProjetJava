package Representation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import Event.Event;
import Event.ImageNode;
import Event.SoundNode;
import Interface.* ;


/**
 * La classe Node pour représenter les noeuds de notre jeu
 */
public abstract class Node extends Object implements Event, Serializable {
	
	private static int totalNode = 0; 
	private static InterfaceJeu interfac = new InterfaceJeu() ; 
	private String description ; 
	private int idNode ; 
	private String nom ; 
	private Node formerNode ; 
	private String imageName;
	private String soundName;
	private ArrayList <String> imagepersoPath = new ArrayList<String>();
	private static Node firstNode;


	/**
	 * un constructeur pour la classe Node 
	 * @param nom le nom du Node
	 * @param description La desciption du node
	 * @param imageName le path de l'image de fond 
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
	 * un constructeur pour la classe Node 
	 * @param nom le nom du Node
	 * @param description La desciption du node
	 */
	public Node(String nom, String description){
		if (nom == null) {
			throw new IllegalArgumentException("Le nom du node ne peut pas être null");
		}
		if (description == null) {
			throw new IllegalArgumentException("La description du node ne peut pas être null");
		}
		if (nom.length()>25){
			System.out.println("Attention il y a plus de 25 caractères !! "+nom);

         	nom = nom.substring(0, Math.min(nom.length(), 25));
		}
		this.idNode = totalNode++ ; // Incrementing for a unique ID with each Node creation
		this.description = description ;
		this.nom = nom ;
	}

	/**
	 * un constructeur pour la classe Node 
	 * @param nom le nom du Node
	 * @param description La desciption du node
	 * @param imageName le path de l'image de fond 
	 * @param imagepersoPath La liste des path des persos à afficher dans le node 
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
			System.out.println("Attention il y a plus de 25 caractères !! "+nom);

         	nom = nom.substring(0, Math.min(nom.length(), 25));
		}
		
		this.idNode = totalNode++ ; // Incrementing for a unique ID with each Node creation
		this.description = description ;
		this.nom = nom ;
		this.imageName= imageName;
		this.imagepersoPath=imagepersoPath;
	}



/**
 * Un getter pour les path des persos à afficher 
 * @return les path des persos
 */
public ArrayList<String> getImagePersoList() {
    return this.imagepersoPath;
}

/**
 * un getter pour le soundName
 * @return le soundName
 */
public String getSoundName(){
	return soundName;
}

/**
 * un setter pour le path de l'image de fond
 * @param imageName la nouvelle image de fond
 */
public void setImageName(String imageName){
	this.imageName=imageName;
}

/**
 * Un setter pour les path des personnages à afficher 
 * @param im la liste des path des persos à afficher
 */
public void setImagePersoList(ArrayList<String> im){
	if (im.size()>5){
		throw new IllegalArgumentException("Le jeu ne peut afficher que 5 persos à la fois ! Node concerné : "+this.nom);
	}
	this.imagepersoPath=im ;
}

/**
 * un getter pour le path de l'image de fond
 * @return le path de l'image de fond
 */
public String getImageName() {
    return imageName;
}

	/**
	 * Un setter pour la description du jeu
	 * @param newDescription la nouvelle descrption
	 */
	public void setDescription(String newDescription) {
		if( newDescription==null){
			throw new IllegalArgumentException("La description est null");
		}
		this.description = newDescription ;
		
	}
	/**
	 * un getter pour le nombre de node créés
	 * @return le nombre total de node
	 */
	public static int getTotalNode() {
		return totalNode;
	}
	/**
	 * un getter pour la desciption 
	 * @return la description
	 */
	public String getDescription() {
		return this.description ;
	}
	
	/**
	 * Un getter pour le firstNode
	 * @return le first Node 
	 */
	public static Node getFirstNode() {
		return firstNode;
	}

	/**
	 * Un setter pour le firstNode
	 * @param newFirstNode le nouveau FirstNode 
	 */
	public static void setFirstNode(Node newFirstNode){
		firstNode= newFirstNode ;
	}

	/**
     * Setter pour le nom du node
     * @param newNom le nouveau nom set
     */

	public void setNom(String newNom) {
		if( newNom==null){
			throw new IllegalArgumentException("Le nom est null");
		}
		if (newNom.length()>25){
			System.out.println("Attention il y a plus de 25 caractères !! "+nom);

         	newNom = newNom.substring(0, Math.min(nom.length(), 25));
		}
		this.nom = newNom ; 
	}
	
	/**
	 * un getter pour le nom
	 * @return le nom
	 */
	public String getNom() {
		
		return this.nom ;
	}


	/**
	 * un getter pour l'id Unique du Node
	 * @return l'id unique du node 
	 */
	public int getID() {
		
		return this.idNode;
	}

	/**
	 * un getter pour le Node précédent
	 * @return le node Précedent
	 */
	public Node getFormerNode() {
		return this.formerNode ;
		}
	
	/**
	 * Un setter pour le node précédent
	 * @param formerNode le node précédent
	 */
	public void setFormerNode (Node formerNode) {
		
		this.formerNode = formerNode ;
	}

	
	/**
	 * un getter pour l'interface de jeu
	 * @return l'interface de jeu
	 */
	public static InterfaceJeu getInterface() {
		return interfac ;
	}
	
	/**
	 * une méthode abstract pour avancer au prochain node
	 * @return le prochain node 
	 */
	public abstract Node goNext() ;

	
	
	/**
	 * une méthode pour obtenir un String représentant le node
	 */
	@Override
	public String toString() {
		return "Nom:" + this.getNom() + "Description:" + this.getDescription();
	}

	/**
	 * Une méthode pour savoir si le npde est égal à un autre 
	 * @param l'objet à comparer 
	 * @return si le node est égal
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
					Objects.equals(this.getFormerNode(), node.getFormerNode()) ;
		}
	}

	/**
 * Displays the Node in the user interface, sets it as the current Node in the game, and
 * checks if it is a checkpoint to update the last checkpoint if needed.
 */
public void display() {
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