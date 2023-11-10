/**
 * The FightNode class represents a node for a combat sequence in a scenario.
 * It extends the Node class.
 */

package Representation;

import java.util.ArrayList;

import univers.Collectibles;
import univers.personnages.* ;

public class FightNode extends InnerNode {
	
	private ArrayList<PersonnageCombattant> opponents ; //The opponents field represents a collection of combatant characters that the player may face in a combat scenario.
	private int xp ;
	private ArrayList<Collectibles> butin ;


    /**
     * Constructor for the FightNode class.
     * @param name The name of the fight node.
     * @param description The description of the fight node.
     */

	public FightNode(String nom, String description, ArrayList<Node> options) {
				super(nom, description, options) ;
	}
	
	public ArrayList<PersonnageCombattant> getOpponents() {
		return opponents;
	}

	public void setOpponents(ArrayList<PersonnageCombattant> opponents) {
		this.opponents = opponents;
	}
	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public ArrayList<Collectibles> getButin() {
		return butin;
	}

	public void setButin(ArrayList<Collectibles> butin) {
		this.butin = butin;
	}

	/**
     * Method to display the information of the fight node.
     */

	public void display() {
		
		
	}

	@Override
	public void goNext() {
		// TODO Auto-generated method stub
		
	}
	
}