
package Representation;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Une classe abstract qui hérite de la classe Node et qui représente les Nodes qui auront un noeud ensuite
 */
public abstract class InnerNode extends Node {
	
    private ArrayList<Node> options = new ArrayList<>();

    /**
     * Un constructeur pour la classe innerNode
     * @param name Le nom de l'innerNode
     * @param description La description de l'innerNode 
     * @param imageName Le path de l'image
     * @param options la liste des options
     */
    public InnerNode(String name, String description, String imageName, ArrayList<Node> options){
        super(name, description, imageName);
        this.options = options;
    }

    

    /**
     * Un constructeur pour la classe innerNode
     * @param name Le nom de l'innerNode
     * @param description La description de l'innerNode 
     */
    public InnerNode(String nom, String description){
		super(nom, description);
	}

    
    /**
     * Constructor for an `InnerNode` without an explicit checkpoint.
     * @param name Le nom de l'innerNode
     * @param description La description de l'innerNode 
     * @param imageName Le path de l'image
     */
    public InnerNode(String nom, String description, String imageName){
        super(nom, description, imageName);
    }
   
    /**
     * Constructor for an `InnerNode` without an explicit checkpoint.
     * @param description La description de l'innerNode 
     * @param imageName Le path de l'image
     * @param imagepersoPath la liste des paths des personnages à afficher 
     */
    public InnerNode(String description, String imageName, ArrayList<String> imagepersoPath){
        super("Node" + (Node.getTotalNode() + 1), description, imageName, imagepersoPath);
    }

  
    
    /**
     * un getter pour les options associées 
     * @return les options du node 
     */
	public ArrayList <Node> getOptions() {
		return options ;
	}

    /**
     * un setter pour les options
     * @param options
     */
	public void setOptions(ArrayList <Node> options){
		this.options=options;
	}

    /**
     * Pour ajouter une option
     * @param optionSupp l'option à ajouter 
     */
     public void addOption(Node optionSupp){
            if (optionSupp != null) {
                this.getOptions().add(optionSupp);
            } else {
                throw new IllegalArgumentException("Les options qu'on ajoute ne peuvent pas être null");
            }
    }

    /**
     * Méthode pour supprimer une option
     * @param suppOption l'option à supprimer 
     */
     public void suppOption(Node suppOption){
        int index = this.getOptions().indexOf(suppOption);
            if (index >= 0 && index < this.getOptions().size()) {
                this.getOptions().remove(index);
            } else {
                throw new IndexOutOfBoundsException("Index hors limites : " + index);
            }
    }

	/**
     * Override la méthode display
     */
    @Override
    public String toString() {
        return "InnerNode:"+super.toString();
    }

    /**
     * méthode abstract qui renvoie le node suivant
     */
	public abstract Node goNext() ;

	@Override
    /**
     * la méthode pour vérifier si le node est égal à un autre
     * @param l'objet à comparer 
     * @return si le node est égal ou pas 
     */
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