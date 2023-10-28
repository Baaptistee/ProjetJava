/**
 * The FightNode class represents a node for a combat sequence in a scenario.
 * It extends the Node class.
 */

package Representation;

import java.util.ArrayList;

import univers.personnages.* ;

public class FightNode extends Node {
	
	private ArrayList<PersonnageCombattant> opponents ; //The opponents field represents a collection of combatant characters that the player may face in a combat scenario.
	


    /**
     * Constructor for the FightNode class.
     * @param name The name of the fight node.
     * @param description The description of the fight node.
     */

	public FightNode(String nom, String description) {
				super(nom, description) ;
	}
	
	/**
     * Method to display the information of the fight node.
     */

	public void display() {
		
		
	}
	
}
