
package Representation;

import java.util.ArrayList;


/**
 * La classe chooseNode est pour les Nodes ou le choix du node suivant est laissé au joueur 
 */
public class ChooseNode extends InnerNode {

    /**
     * un constructeur pour la classe choosenode
     *
     * @param nom le nom du chooseNode
     * @param description La description du chooseNode
     * @param imageName le path de l'image 
     * @param options les choix possibles 
     */
    public ChooseNode(String nom, String description, String imageName, ArrayList<Node> options) {
        super(nom, description, imageName, options);
    }

    /**
     * un constructeur pour la classe choosenode
     *
     * @param description la description du node 
     * @param imageNode l'image path du node 
     */
    public ChooseNode(String description, String imageName) {
        super("Node" + Node.getTotalNode() + 1, description, imageName);
    }

    /**
     * un constructeur pour la classe choosenode
     *
     * @param nom The name of the choice node.
     * @param description la description du node 
     * @param imageNode l'image path du node 
     */
    public ChooseNode(String nom, String description, String imageName) {
        super(nom, description, imageName);
    }

   
    /**
     * un constructeur pour la classe choosenode
     *
     * @param description la description du node 
     * @param imageNode l'image path du node 
     * @param imagepersoPath La liste des images 
     */
    public ChooseNode(String description, String imageNode, ArrayList<String> imagepersoPath) {
        super(description, imageNode, imagepersoPath);
    }


    /**
     * Override de la méthode goNext 
     * Cette méthode n'est censée jamais être appelée, l'action de sélection du node suivant se faisant directement sur l'interface 
     */
    @Override
    public Node goNext() {
        return null ;
    }

    /**
     * Override de la méthode to String 
     *
     * @return La représentation string du chooseNode
     */
    @Override
    public String toString() {
        return "Choose Node: " + super.toString();
    }

    /**
     * L'override de la méthode equals 
     *
     * @param obj l'objet auquel s'est comparé
     * @return true si les deux objets sont similaires 
     */
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