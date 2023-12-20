package univers.competences ;

import java.util.Objects;
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
		try{ if (powerHeal<=0){
			throw new IllegalArgumentException("Power heal égal à zéro attention !");
		}
		this.powerHeal = powerHeal ;
		
		this.groupHeal = groupHeal ;
	} catch (IllegalArgumentException e){
		System.out.println(e.getMessage()) ;
	}
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
		try {
			if (powerHeal<0){
				throw new IllegalArgumentException("impossible pour powerHeal d'être à zéro");
			}
			this.powerHeal = powerHeal;
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}
	/** a getter for groupHeal
	 * 
	 * @return
	 */
	public boolean isGroup() {
		return groupHeal;
	}
	/** a getter for groupHeal
	 * 
	 * @param groupHeal
	 */
	public void setGroup(boolean groupHeal) {
		this.groupHeal = groupHeal;
	}
	
	@Override
	public String toString() {
		return "CompetenceSoin " + super.toString() + "[powerHeal=" + powerHeal + ", groupHeal=" + groupHeal + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompetenceSoin other = (CompetenceSoin) obj;
		return this.isGroup() == other.isGroup() && this.getPowerHeal() == other.getPowerHeal() && this.getCoutMana() == other.getCoutMana() && 
				Objects.equals(this.getDescription(), other.getDescription()) && Objects.equals(this.getName(), other.getName());
	}
	
	@Override
	/** the fonction utilisation is the one used to call the competence 
	 * @param the user of the competence 
	 * @param the target of the competence 
	 */
	public String utilisation(PersonnageCombattant utilisateur, PersonnageCombattant cible) {
		try {
		if (utilisateur==null){
			throw new IllegalArgumentException("utilisateur null !!");
		}
		Random random = new Random() ;
		String d ;
		if (utilisateur.getMana()<this.getCoutMana()) {
			d = "Pas assez de mana, rien ne se passe" ;
		} else {
			d = utilisateur.getName() + " utilise " + this.getName() + ".";
			int a = this.getPowerHeal() + random.nextInt(getPowerHeal()/2) + utilisateur.getIntelligence() - 10 ;
			if (this.isGroup()) {
				for (int i = 0 ; i<utilisateur.getGroupe().size() ; i++) {
					utilisateur.getGroupe().get(i).heal(a) ;
					d += "/Tous les membres du groupe récupère " + a + " points de vie." ;
				}
			} else {
				cible.heal(a) ;
				d += "/" + cible.getName() + " récupère " + a + " points de vie." ;
			}
		}
		return d ;
	} catch (IllegalArgumentException e){
		System.out.println(e.getMessage()) ;
		return "";
	}
	}
	
}