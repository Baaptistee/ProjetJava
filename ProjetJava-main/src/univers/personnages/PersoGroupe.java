package univers.personnages;

//import java.util.Random;
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
		return this.competences;
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
	
	/**
	 * a getter for the speed with the bonus 
	 */
	@Override
	public int getSpeed() {
		if (weapon != null) {
			return (this.getWeapon().getBonusSpeed() + super.getIntelligence()) ;
		} else {
			return super.getIntelligence() ;
		}
	}
	/**
	 * a getter for base speed
	 * @return
	 */
	public int getBaseSpeed() {
		return super.getSpeed() ;
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
	
	/** a getter for base Endurance 
	 * 
	 */
	
	public int getBaseEndurance() {
		return super.getEndurance() ;
	}
	/** a getter for the group
	 * 
	 */
	public ArrayList<PersonnageCombattant> getGroupe() {
		return PersonnageCombattant.getGroupeJoueur();
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

	
	/** a method to make our characters gain xp
	 * 
	 * @param xp
	 */
	// une fonction qui gère le gain d'XP
	public void gainExperience(int xp) {
		
		experience += xp ; 
		// si il y a assez d'expérience 
		if (this.getExperience() >= this.getLevel()*10 + 90) {
			// on réinitialise l'expérience enlevant celle qui a servi au gain de niveau 
			this.setExperience(getExperience() - (getLevel()*10 + 90)) ;
			//On appelle la fonction gain de niveau 
			this.gainNiveau() ;
			
		}
	}
	
	/** a abstract method to make our character win levels
	 * 
	 * @return
	 */
	public abstract String gainNiveau() ;
	
	
	
	
	
}
