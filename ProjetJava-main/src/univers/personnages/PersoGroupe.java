package univers.personnages;

import java.util.Random;
import univers.competences.*;
import univers.Eleme;
import univers.armes.*;
import java.util.* ;

public abstract class PersoGroupe extends PersonnageCombattant {
	private int experience ;
	private Weapon weapon ;
	private ArrayList<Competences> competences ;
	private ArrayList<PersonnageCombattant> groupe ;
	private ArrayList<WeaponType> armePossible ;
	
	
	public PersoGroupe(String nom, String description, int dexterite, int strengh, int intelligence, int endurance, int speed, int maxMana, int maxLifePoints, ArrayList<Competences> competences, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances, ArrayList<WeaponType> armePossible) {
		super(nom, description, dexterite, strengh, intelligence, endurance, speed, maxMana, maxLifePoints, faiblesses, resistances) ;
		this.experience = 0 ;
		this.armePossible = armePossible ;
		this.competences = competences ;
	}
	
	
	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Weapon getWeapon() {
		return weapon;
	}


	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	
	public ArrayList<Competences> getCompetences() {
		return competences;
	}


	public void setCompetences(ArrayList<Competences> competences) {
		this.competences = competences;
	}


	// les getters qui intègrent le bonus procuré par l'arme 
	@Override 
	public int getIntelligence() {
		if (weapon != null) {
			return (this.getWeapon().getBonusIntelligence() + super.getIntelligence()) ;
		} else {
			return super.getIntelligence() ;
		}
	}
	
	// les getter pour les statistiques comprenant les bonus 
	@Override 
	public int getStrength() {
		if (weapon != null) {
			return (this.getWeapon().getBonusStrength() + super.getStrength()) ;
		} else {
			return super.getStrength() ;
		}
	}

	@Override 
	public int getDexterity() {
		if (weapon != null) {
			return (this.getWeapon().getBonusDexterity() + super.getDexterity()) ;
		} else {
			return super.getDexterity() ;
		}
	}
	
	@Override 
	public int getEndurance() {
		if (weapon != null) {
			return (this.getWeapon().getBonusIntelligence() + super.getIntelligence()) ;
		} else {
			return super.getIntelligence() ;
		}
	}
	
	// des getter pour les statistiques de base 
	public int getBaseStrength() {
		return super.getStrength() ;
	}
	
	public int getBaseIntelligence() {
		return super.getIntelligence() ;
	}
	
	public int getBaseDexterity() {
		return super.getDexterity() ;
	}
	
	public ArrayList<PersonnageCombattant> getGroupe() {
		return groupe;
	}


	public void setGroupe(ArrayList<PersonnageCombattant> groupe) {
		this.groupe = groupe;
	}


	public ArrayList<WeaponType> getArmePossible() {
		return armePossible;
	}


	public void setArmePossible(ArrayList<WeaponType> armePossible) {
		this.armePossible = armePossible;
	}


	// des méthodes pour réaliser des tests de force, d'agilité et de dextérité (pour des actions en combat ou 
	public boolean testStrengh(int valeurTest) {
		Random random = new Random() ;
		if (valeurTest <= this.getStrength() + random.nextInt(19) + 1) {
			return true ;
		} else {
			return false ;
		}
	}
	
	public boolean testIntelligence(int valeurTest) {
		Random random = new Random() ;
		if (valeurTest <= this.getIntelligence() + random.nextInt(19) + 1) {
			return true ;
		} else {
			return false ;
		}
	}
	
	public boolean testDexterity(int valeurTest) {
		Random random = new Random() ;
		if (valeurTest <= this.getDexterity() + random.nextInt(19) + 1) {
			return true ;
		} else {
			return false ;
		}
	}
	
	
	
	
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
	
	public abstract String gainNiveau() ;
	
	
	
	
	
}
