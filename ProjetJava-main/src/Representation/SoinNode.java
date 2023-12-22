package Representation;

/**
 * La classe SoinNode représente un Node dans lequel le groupe va être entièrement soigné
 */
public class SoinNode extends TextNode {

    /**
     * Un constructeur pour la classe 
     * @param nom le nom du node
     * @param description la description du node 
     * @param imageName le path de l'image 
     */
    public SoinNode(String nom, String description, String imageName){
        super(nom, description, imageName);
    }

    /**
     * Un override de la méthode display pour lancer le node 
     */
    @Override
    public void display() {
        if (Game.getGame().getGroupeJoueur().isEmpty()) {
            throw new IllegalStateException("Le groupe de joueur est vide");
        }
            for (int i = 0; i < Game.getGame().getGroupeJoueur().size(); i++) {
                Game.getGame().getGroupeJoueur().get(i).setLifePoints(Game.getGame().getGroupeJoueur().get(i).getMaxLifePoints());
                Game.getGame().getGroupeJoueur().get(i).setMana(Game.getGame().getGroupeJoueur().get(i).getMaxMana());
                Game.getGame().getGroupeJoueur().get(i).setAlive(true);
            }
            super.display();
       
    }
}
