package univers.competences ;

import java.util.Random;

import univers.personnages.PersonnageCombattant;

/** A class for the competences that have a healing effect
 * 
 */
public class CompetenceSoin extends CompetencesActives {
	/**The heal power of the capacity
	 * 
	 */
	private int powerHeal ; 
	/** the variable that represents if the capacity heal the group of just one character 
	 * 
	 */
	private boolean groupHeal ;
	/** the constructor of the class
	 * 
	 * @param nom
	 * @param description
	 * @param coutMana
	 * @param powerHeal
	 * @param groupHeal
	 */
	public CompetenceSoin(String nom, String description, int coutMana, int powerHeal, boolean groupHeal){
		super(nom, description, coutMana) ;
		this.powerHeal = powerHeal ;
		this.groupHeal = groupHeal ;
	}
	/** a getter for powerHeal
	 * 
	 * @return
	 */
	public int getPowerHeal() {
		return powerHeal;
	}
	/** a setter for powerHeal
	 * 
	 * @param powerHeal
	 */
	public void setPowerHeal(int powerHeal) {
		this.powerHeal = powerHeal;
	}
	/** a getter for groupHeal
	 * 
	 * @return
	 */
	public boolean isGroupHeal() {
		return groupHeal;
	}
	/** a getter for groupHeal
	 * 
	 * @param groupHeal
	 */
	public void setGroupHeal(boolean groupHeal) {
		this.groupHeal = groupHeal;
	}
	
	
	@Override
	/** the fonction utilisation is the one used to call the competence 
	 * @param the user of the competence 
	 * @param the target of the competence 
	 */
	public String utilisation(PersonnageCombattant utilisateur, PersonnageCombattant cible) {
		Random random = new Random() ;
		String d ;
		if (utilisateur.getMana()<this.getCoutMana()) {
			d = "Pas assez de mana, rien ne se passe" ;
		} else {
			d = utilisateur.getName() + " utilise " + this.getName() + ".";
			int a = this.getPowerHeal() + random.nextInt(getPowerHeal()/2) + utilisateur.getIntelligence() - 10 ;
			if (this.isGroupHeal()) {
				for (int i = 0 ; i<utilisateur.getGroupe().size() ; i++) {
					cible.getGroupe().get(i).heal(a) ;
					d += "/Tous les membres du groupe récupère " + a + " points de vie." ;
				}
			} else {
				utilisateur.heal(a) ;
				d += "/" + cible.getName() + " récupère " + a + " points de vie." ;
			}
		}
		return d ;
	}
	
}
