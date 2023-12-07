/**
 * The FightNode class represents a node for a combat sequence in a scenario.
 * It extends the Node class.
 */

package Representation;

import java.util.ArrayList;
import java.util.Objects;

import univers.Collectibles;
import univers.personnages.* ;
import java.util.HashMap;
import java.util.Map;
//import java.util.Set;

public class FightNode extends InnerNode {
	
	private ArrayList<PersonnageCombattant> opponents ; //The opponents field represents a collection of combatant characters that the player may face in a combat scenario.
	private int xp ;
	private ArrayList<Collectibles> butin ;
	private Map<PersonnageCombattant, Object[]> actions ;


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

	public ArrayList<PersonnageCombattant> getOpponentsVivant() {
		ArrayList<PersonnageCombattant> groupeVivant = new ArrayList<PersonnageCombattant>() ;
		for (int i = 0 ; i < this.getOpponents().size() ; i++){
			if (this.getOpponents().get(i).enVie()){
				groupeVivant.add(this.getOpponents().get(i)) ;
			}
		}
		return groupeVivant ;
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

	@Override
	public String toString() {
		return "FightNode:"+super.toString();
	}
	
	 @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        FightNode fightNode = (FightNode) obj;
        return super.equals(obj) &&
               Objects.equals(this.getOpponents(), fightNode.getOpponents()) &&
               Objects.equals(this.getXp(),fightNode.getXp()) &&
               Objects.equals(this.getButin(), fightNode.getButin());
    }
	
	/**
     * Method to display the information of the fight node.
     */
	public boolean isGroupEnVie(ArrayList<PersonnageCombattant> groupe ){
		boolean retour = false ;
		for (int i = 0 ; i < groupe.size(); i++) {
			if (groupe.get(i).enVie()) {
				retour = true ;
			}
		}
		return retour ;
	}


	public boolean isOver() {
		boolean retour = false ;
		int t = 0 ;
		if (this.isGroupEnVie(this.getOpponents())){
			t++ ;
		}
		
		if(this.isGroupEnVie(Game.getGroupeJoueur())){
			t++;
		}
		if (t==1){
			retour = true ; 
		}
		return retour ;
	}
	
	public void display() {
		for(int i = 0; i<this.getOpponents().size() ; i++){
			this.getOpponents().get(i).setGroupe(opponents);
		}
		super.display();
	}
	
	public Map<PersonnageCombattant,Object[]> getAction() {
		if (this.actions == null){
			this.actions  = new HashMap<>();
				return this.actions ;
		} else {

		return actions ;
		}
	}

	public void putAction(PersonnageCombattant utilisateur, Object[] competenceCible){
		if (this.actions == null){
			this.actions  = new HashMap<>();
		}
		this.actions.put(utilisateur, competenceCible) ;

	}

	public void removeAction(PersonnageCombattant utilisateur) {
		this.actions.remove(utilisateur) ;
	}

	public void videActions() {
		this.actions = null ;
	}

	public String gainButin(){
		String d = "" ;
		if (butin.size()!=0){
			for(int i = 0; i<butin.size();i++){
				d += "Le groupe remporte un(e) " + butin.get(i).getName() + " !/";
			}
		}
		return d ;
	}

	public String gainXP() {

		String d = "L'ensemble du groupe remporte " + this.getXp() + " points d'expériences !/";
		
		
		return d ;
	}
	

	@Override
	public void goNext() {
		if (this.isGroupEnVie(Game.getGroupeJoueur())) {
			getInterface().Victoire(this) ;
		} else {
			getInterface().Defaite(this) ;
		}	
	}
	
}