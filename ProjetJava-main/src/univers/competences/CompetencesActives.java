package univers.competences;

import univers.personnages.PersonnageCombattant;
/** A class for all the cative competences (the ones that can be chose during a fightNode)
 * 
 */
public abstract class CompetencesActives extends Competences {
	/**
	 * The mana cost of the attack
	 */
	private int coutMana ;
	/** the constructor of the class 
	 * 
	 * @param nom
	 * @param description
	 * @param coutMana
	 */
	public CompetencesActives(String nom, String description, int coutMana){
		super(nom, description) ;
		this.coutMana = coutMana ;
	}
	
	/** a getter for coutMana
	 * 
	 * @return
	 */
	public int getCoutMana() {
		return coutMana;
	}

	/*a setter for coutMana
	 * 
	 */
	public void setCoutMana(int coutMana) {
		this.coutMana = coutMana;
	}
	/** The method that will be called to use the competence 
	 * 
	 * @param utilisateur le lanceur
	 * @param cible la cible
	 * @return renvoie un String qui sera ensuite à afficher dans le fightNode 
	 */
	public abstract String utilisation(PersonnageCombattant utilisateur, PersonnageCombattant cible) ;
			
}
