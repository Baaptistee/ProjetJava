package univers.personnages;

//import java.util.Random;
import univers.competences.*;
import univers.Eleme;
import univers.armes.*;

//import java.io.Serializable;
import java.util.* ;

import Representation.Game;
/** a class for the personnage of our group
 * 
 */
public abstract class PersoGroupe extends PersonnageCombattant{
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
	private ArrayList<CompetencesActives> competences ;
	
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
	public PersoGroupe(String nom, String description, int dexterite, int strengh, int intelligence, int endurance, int speed, int maxMana, int maxLifePoints, ArrayList<CompetencesActives> competences, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances, ArrayList<WeaponType> armePossible) {
		super(nom, description, dexterite, strengh, intelligence, endurance, speed, maxMana, maxLifePoints, faiblesses, resistances) ;
		this.experience = 0 ;
		if (armePossible==null){
			this.armePossible = new ArrayList<>() ;
		} else this.armePossible = armePossible ;
		if (competences==null){
			this.competences=new ArrayList<>();
		} else this.competences = competences ;
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
		try {
			if (experience < 0){
				throw new IllegalArgumentException("Experience ne peut être inferieure à zéro") ;
			} else this.experience = experience;
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage()) ;
		}
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
		try {if (!this.armePossible.contains(weapon.getWeaponType())){
			throw new IllegalArgumentException("Impossible pour ce personnage d'équiper cette arme !") ;
		}
		this.weapon = weapon;}
		catch (IllegalArgumentException e){
			System.out.println(e.getMessage()) ;
		}
	}

	/** a getter for the competences 
	 * 
	 * @return
	 */
	public ArrayList<CompetencesActives> getCompetences() {
		return this.competences;
	}

	/** a setter for the competences 
	 * 
	 * @param competences
	 */
	public void setCompetences(ArrayList<CompetencesActives> competences) {
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
		return Game.getGame().getGroupeJoueur();
	}

	//Méthode vide car on en a besoin pour des personnages Adverses quand ils sont considérés comme des persos combattant qui est abstraite
	public void setGroupe(ArrayList<PersonnageCombattant> newGroup) {};


	public ArrayList<PersonnageCombattant> getGroupeVivant() {
		ArrayList<PersonnageCombattant> groupeVivant = new ArrayList<PersonnageCombattant>() ;
		for (int i = 0 ; i < this.getGroupe().size() ; i++){
			if (this.getGroupe().get(i).enVie()){
				groupeVivant.add(this.getGroupe().get(i)) ;
			}
		}
		return groupeVivant;
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
	public String gainExperience(int xp) {
		try {
			if (xp<=0){
				throw new IllegalArgumentException("Expérience peut pas être inférieure à zéro") ;
			}
			String retour = "nope" ;
			//boolean retour = false ;
			experience += xp ; 
			// si il y a assez d'expérience 
			if (this.getExperience() >= this.getLevel()*10 + 90) {
				// on réinitialise l'expérience enlevant celle qui a servi au gain de niveau 
				this.setExperience(getExperience() - (getLevel()*10 + 90)) ;
				//On appelle la fonction gain de niveau 
				retour = this.gainNiveau() ;
			
			}
			return retour ;
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
			return null ;
		}
	}

	public boolean isLevelUp(int xp){
		boolean retour = false ;
		if (this.getExperience() >= this.getLevel()*10 + 90) {
			retour = true ;
		}
		return retour ;
	}
	
	/** a abstract method to make our character win levels
	 * 
	 * @return
	 */
	public abstract String gainNiveau() ;
	
	
	@Override
	public String toString() {
		return super.toString() + " [experience=" + experience + ", weapon=" + weapon + ", competences=" + competences
				+ ", armePossible=" + armePossible + "]";
	}

	@Override
	    public boolean equals(Object obj) {
			if (this == obj) {
				return true ;
			} else if (obj.getClass() != this.getClass()) {
				return false ;
			} else {
				PersoGroupe perso = (PersoGroupe)obj ;
				if (Objects.equals(this.getName(), perso.getName()) && Objects.equals(this.getDescription(), perso.getDescription()) && Objects.equals(this.getImageLien(), perso.getImageLien()) && Objects.equals(this.getPersoId(), perso.getPersoId()) && Objects.equals(this.getDexterity() , perso.getDexterity()) && Objects.equals(this.getStrength() , perso.getStrength()) && Objects.equals(this.getEndurance() , perso.getEndurance()) && Objects.equals(this.getFaiblesses() , perso.getFaiblesses()) && Objects.equals( this.getGroupe() , perso.getGroupe()) && Objects.equals(this.getIntelligence() , perso.getIntelligence()) && Objects.equals(this.getLevel() , perso.getLevel()) && Objects.equals(this.getLifePoints() , perso.getLifePoints()) && Objects.equals(this.getMana() , perso.getMana()) && Objects.equals(this.getMaxLifePoints() , perso.getMaxLifePoints()) && Objects.equals(this.getMaxMana(), perso.getMaxMana()) && Objects.equals(this.getResistances(), perso.getResistances()) && Objects.equals(this.getSpeed(), perso.getSpeed()) && this.getWeapon().equals(perso.getWeapon())) {
					return true ;
				} else {
					return false ;
				}
			}
	    	
	    }
	
	
}