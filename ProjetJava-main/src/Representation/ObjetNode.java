package Representation;

import java.util.HashMap;
import java.util.Map;

import univers.Collectibles;

/**
 * Une classe pour représenter un Node dans lequel le groupe obtient de nouveaux objets 
 */
public class ObjetNode extends TextNode{

    private Map<Collectibles, Integer> objets = new HashMap<Collectibles, Integer>();
    /**
     * Un constructeur
     * @param nom Le nom de l'objetNode
     * @param description La description du node 
     * @param option La liste des options disponibles 
     */
    public ObjetNode(String nom, String description, String imageName){
        super(nom, description, imageName);
    }
    /**
     * Un constructeur
     * @param nom Le nom de l'objetNode
     * @param description La description du node 
     * @param option La liste des options disponibles 
     * @param objets Une map avec les objets ajoutés à l'inventaire et leur nombre 
     */
public ObjetNode(String nom, String description, String imageName, Map<Collectibles, Integer> objets){
        super(nom, description, imageName);
        this.objets=objets ;
    }
    
    /**
     * un getter pour les objets à ajouter 
     * @return les objets à ajouter 
     */
    public Map<Collectibles, Integer> getObjets(){
        return this.getObjets();
    }

    /**
     * un setter pour les objets à ajouter 
     * @param objets les nouveaux objets à ajouter 
     */
    public void setObjets(Map<Collectibles, Integer> objets){
        this.objets=objets;
    }

    /**
     * un override de la méthode display
     */
    @Override
    public void display() {
            for (Collectibles objet : this.objets.keySet()) {
                for(int i =0; i<this.objets.get(objet);i++){
                    Game.getGame().ajoutInventaire(objet);
                }
            }
            super.display();
       
    }
}