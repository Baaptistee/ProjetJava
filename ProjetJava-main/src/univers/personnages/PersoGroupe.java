package univers.personnages;

import java.util.Random;
import univers.competences.*;
import univers.Eleme;
import univers.armes.*;
import java.util.* ;
/** a class for the personnage of our group
 * 
 */
public abstract class PersoGroupe extends PersonnageCombattant {
	/** the current exp of the character 
	 * 
	 */
	private int experience ;
	/** the weapon the character is holding 
	 * 
	 */
	private Weapon weapon ;
	/** the competences of the character
	 * 
	 */
	private ArrayList<Competences> competences ;
	/** the group of the character 
	 * 
	 */
	private ArrayList<PersonnageCombattant> groupe ;
	/** an arrayList with the type of weapons the character can carry
	 * 
	 */
	private ArrayList<WeaponType> armePossible ;
	
	/** the constructor of the class
	 * 
	 * @param nom
	 * @param description
	 * @param dexterite
	 * @param strengh
	 * @param intelligence
	 * @param endurance
	 * @param speed
	 * @param maxMana
	 * @param maxLifePoints
	 * @param competences
	 * @param faiblesses
	 * @param resistances
	 * @param armePossible
	 */
	public PersoGroupe(String nom, String description, int dexterite, int strengh, int intelligence, int endurance, int speed, int maxMana, int maxLifePoints, ArrayList<Competences> competences, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances, ArrayList<WeaponType> armePossible) {
		super(nom, description, dexterite, strengh, intelligence, endurance, speed, maxMana, maxLifePoints, faiblesses, resistances) ;
		this.experience = 0 ;
		this.armePossible = armePossible ;
		this.competences = competences ;
	}
	
	/** a getter for the experience 
	 * 
	 * @return
	 */
	public int getExperience() {
		return experience;
	}

	/** a setter for the experience 
	 * 
	 * @param experience
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}
	/** a getter for the weapon
	 * 
	 * @return
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/** a setter for the weapon 
	 * 
	 * @param weapon
	 */
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	/** a getter for the competences 
	 * 
	 * @return
	 */
	public ArrayList<Competences> getCompetences() {
		return competences;
	}

	/** a setter for the competences 
	 * 
	 * @param competences
	 */
	public void setCompetences(ArrayList<Competences> competences) {
		this.competences = competences;
	}

	/** a getter for Intelligence with the bonus of the weapon
	 * 
	 */
	// les getters qui intègrent le bonus procuré par l'arme 
	@Override 
	public int getIntelligence() {
		if (weapon != null) {
			return (this.getWeapon().getBonusIntelligence() + super.getIntelligence()) ;
		} else {
			return super.getIntelligence() ;
		}
	}
	/** a getter for Strength with the bonus of ythe weapon
	 * 
	 */
	// les getter pour les statistiques comprenant les bonus 
	@Override 
	public int getStrength() {
		if (weapon != null) {
			return (this.getWeapon().getBonusStrength() + super.getStrength()) ;
		} else {
			return super.getStrength() ;
		}
	}
	/** a getter for dexterity with the bonus of the weapon
	 * 
	 */
	@Override 
	public int getDexterity() {
		if (weapon != null) {
			return (this.getWeapon().getBonusDexterity() + super.getDexterity()) ;
		} else {
			return super.getDexterity() ;
		}
	}
	/** a getter for the endurance with the weapon's bonus 
	 * 
	 */
	@Override 
	public int getEndurance() {
		if (weapon != null) {
			return (this.getWeapon().getBonusIntelligence() + super.getIntelligence()) ;
		} else {
			return super.getIntelligence() ;
		}
	}
	/** a getter for base Strength
	 * 
	 * @return
	 */
	// des getter pour les statistiques de base 
	public int getBaseStrength() {
		return super.getStrength() ;
	}
	/** a getter for base INtelligence 
	 * 
	 * @return
	 */
	public int getBaseIntelligence() {
		return super.getIntelligence() ;
	}
	/** a getter for base Dexterity
	 * 
	 * @return
	 */
	public int getBaseDexterity() {
		return super.getDexterity() ;
	}
	/** a getter for the group
	 * 
	 */
	public ArrayList<PersonnageCombattant> getGroupe() {
		return groupe;
	}

	/** a setter for the group
	 * 
	 */
	public void setGroupe(ArrayList<PersonnageCombattant> groupe) {
		this.groupe = groupe;
	}

	/** a getter for the possible weapons
	 * 
	 * @return
	 */
	public ArrayList<WeaponType> getArmePossible() {
		return armePossible;
	}

	/** a setter for the possible weapons 
	 * 
	 * @param armePossible
	 */
	public void setArmePossible(ArrayList<WeaponType> armePossible) {
		this.armePossible = armePossible;
	}

	/** a methode to do Strength test
	 * 
	 * @param valeurTest
	 * @return
	 */
	// des méthodes pour réaliser des tests de force, d'agilité et de dextérité (pour des actions en combat ou 
	public boolean testStrengh(int valeurTest) {
		Random random = new Random() ;
		if (valeurTest <= this.getStrength() + random.nextInt(19) + 1) {
			return true ;
		} else {
			return false ;
		}
	}
	/** a methd to do a intelligence test
	 * 
	 * @param valeurTest
	 * @return
	 */
	public boolean testIntelligence(int valeurTest) {
		Random random = new Random() ;
		if (valeurTest <= this.getIntelligence() + random.nextInt(19) + 1) {
			return true ;
		} else {
			return false ;
		}
	}
	/** a method to do a dexterity test
	 * 
	 * @param valeurTest
	 * @return
	 */
	public boolean testDexterity(int valeurTest) {
		Random random = new Random() ;
		if (valeurTest <= this.getDexterity() + random.nextInt(19) + 1) {
			return true ;
		} else {
			return false ;
		}
	}
	
	
	
	/** a method to make our characters gain xp
	 * 
	 * @param xp
	 */
	// une fonction qui gère le gain d'XP
	public void gainExperience(int xp) {
		
		experience += xp ; 
		// si il y a assez d'expérience 
		if (this.getExperience() >= this.getLevel()*10 + 90) {
			//On appelle la fonction gain de niveau 
			this.gainNiveau() ;
			// on réinitialise l'expérience enlevant celle qui a servi au gain de niveau 
			this.setExperience(getExperience() - (getLevel()*10 + 90)) ;
		}
	}
	/** a abstract method to make our character win levels
	 * 
	 * @return
	 */
	public abstract String gainNiveau() ;
	
	
	
	
	
}
