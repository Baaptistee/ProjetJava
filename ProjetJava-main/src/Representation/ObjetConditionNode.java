package Representation;

import univers.Collectibles;

/**
 * une classe de Node ou le prochain ndoe est déterminé selon la présence d'un objet particulier dans l'inventaire du jeu 
 */
public class ObjetConditionNode extends InnerNode{

    private Collectibles objetNecessaire ;    
    
    /**
     * Un constructeur 
     * @param nom le nom du node
     * @param description la descritpion du node
     * @param objetNecessaire l'objet nécessaire 
     */
    public ObjetConditionNode(String nom, String description, Collectibles objetNecessaire) {
        super(nom, description);
        if (objetNecessaire==null){
            throw new IllegalArgumentException("L'Objet nécessaire ne peut être nul !");
        }
        this.objetNecessaire=objetNecessaire;
    }

    /**
     * un getter pour l'objet nécessaire
     * @return l'objet nécessaire
     */
    public Collectibles getObjetNecessaire(){
        return this.objetNecessaire;
    }
    /**
     * un setter pour l'objet nécessaire 
     * @param objetNecessaire l'objet Nécessaire à set
     */
    public void setObjetNecessaire(Collectibles objetNecessaire){
        if (objetNecessaire==null){
            throw new IllegalArgumentException("L'Objet nécessaire ne peut être nul !");
        }
        this.objetNecessaire=objetNecessaire;
    }

    /**
     * la fonction pour passer au prochain node
     * @return Le prochain Node 
     */
    @Override
    public Node goNext() {
        if (Game.getGame().getInventaire().containsKey(objetNecessaire)){
            return this.getOptions().get(0);
        } else return this.getOptions().get(1);
    }
    
}
