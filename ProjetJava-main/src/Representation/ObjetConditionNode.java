package Representation;

import univers.Collectibles;
import univers.Objets.Objets;

public class ObjetConditionNode extends InnerNode{

    private Collectibles objetNecessaire ;    
    
    
    public ObjetConditionNode(String nom, String description, Collectibles objetNecessaire) {
        super(nom, description);
        if (objetNecessaire==null){
            throw new IllegalArgumentException("L'Objet nécessaire ne peut être nul !");
        }
        this.objetNecessaire=objetNecessaire;
    }

    public Collectibles getObjetNecessaire(){
        return this.objetNecessaire;
    }
    public void setObjetNecessaire(Collectibles objetNecessaire){
        if (objetNecessaire==null){
            throw new IllegalArgumentException("L'Objet nécessaire ne peut être nul !");
        }
        this.objetNecessaire=objetNecessaire;
    }

    @Override
    public Node goNext() {
        if (Game.getGame().getInventaire().containsKey(objetNecessaire)){
            return this.getOptions().get(0);
        } else return this.getOptions().get(1);
    }
    
}
