package Representation;

import java.util.ArrayList;

public class SoinNode extends TextNode{
    
    public SoinNode(String nom, String description, boolean checkPoint, ArrayList<Node> option) {
		super(nom, description, checkPoint, option);
	}

    @Override
    public void display(){
        for (int i=0; i< Game.getGame().getGroupeJoueur().size();i++){
            Game.getGame().getGroupeJoueur().get(i).setLifePoints(Game.getGame().getGroupeJoueur().get(i).getMaxLifePoints());
            Game.getGame().getGroupeJoueur().get(i).setMana(Game.getGame().getGroupeJoueur().get(i).getMaxMana());
            Game.getGame().getGroupeJoueur().get(i).setAlive(true);
        }
        super.display();
    }

}
