package Representation;

import java.util.ArrayList;

/**
 * Une classe pour les Nodes les plus simples avec une seule option
 */
public class TextNode extends InnerNode {

    /**
     * Un constructeur 
     *
     * @param nom          Le nom du textNode 
     * @param description  La description du textNode 
     * @param imageName    Le nom de l'image associé 
     * @param options      La liste des options du node 
     */
    public TextNode(String nom, String description, String imageName, ArrayList<Node> options){
        super(nom, description, imageName, options);
    }

    

     /**
     * Un constructeur 
     *
     * @param nom          Le nom du textNode 
     * @param description  La description du textNode 
     * @param imageName    Le nom de l'image associé 
     */
    public TextNode(String nom, String description, String imageName) {
        super(nom, description, imageName);
    }

  


    /**
     * La méthode pour aller au node suivant 
     * @return le node siuvant 
     */
    @Override
    public Node goNext() {
		this.getOptions().get(0).setFormerNode(this);
		return this.getOptions().get(0) ;
	}

    /**
     * renvoie une représentation en string du node 
     *
     * @return le string du node 
     */
    @Override
    public String toString() {
        return "TextNode:" + super.toString();
    }

    /**
     * Indique si le node est égal à un objet 
     *
     * @param obj l'objet à comparer .
     * @return si le node et l'objet sont equals 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        TextNode textNode = (TextNode) obj;

        return super.equals(obj) && getOptions().equals(textNode.getOptions());
    }
}
