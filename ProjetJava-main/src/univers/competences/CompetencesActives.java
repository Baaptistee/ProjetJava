package univers.competences;

import java.util.Objects;

import Representation.FightNode;
import univers.personnages.PersonnageCombattant;
/** A class for all the cative competences (the ones that can be chose during a fightNode)
 * 
 */
public abstract class CompetencesActives extends Competences {
	
	@Override
	public String toString() {
		return super.toString() + "[coutMana=" + coutMana + "] " ;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompetencesActives other = (CompetencesActives) obj;
		return this.getCoutMana() == other.getCoutMana() && 
			Objects.equals(this.getDescription(), other.getDescription()) && Objects.equals(this.getName(), other.getName());

	}


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
		try{
			if (coutMana < 0){
				throw new IllegalArgumentException("cout mana ne peut être négatif "+nom);
			}
			this.coutMana = coutMana ;
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}
	
	public CompetencesActives(String nom) {
		super(nom);
}


	/** a getter for coutMana
	 * 
	 * @return
	 */
	public int getCoutMana() {
		return coutMana;
	}

	public String affichageCoutMana(){
		if (this.coutMana==0){
			return "" ;
		} else{	
		return " <strong>"+this.coutMana+"PM</strong>";
		}
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
	public abstract String utilisation(PersonnageCombattant utilisateur, PersonnageCombattant cible, FightNode node) ;
	public abstract boolean isGroup() ;


	public abstract void setGroup(boolean b);
}