package univers.personnages;

import java.util.ArrayList;
import java.util.Random;

import univers.Eleme;
import univers.competences.Competences;

public abstract class PersonnageCombattant extends Personnage{
	private int level ; 
	private int strength ;
	private int intelligence ;
	private int dexterity ;
	private int speed ; 
	private int lifePoints ;
	private int maxLifePoints ;
	private boolean alive ;
	private int endurance ;
	private int mana ;
	private int maxMana ;
	private ArrayList<Eleme> faiblesses ; 
	private ArrayList<Eleme> resistances ;

	
	
	
	public PersonnageCombattant(String nom, String description, int dexterite, int force, int intelligence, int endurance, int speed, int maxMana, int maxLifePoints, ArrayList<Eleme> faiblesse, ArrayList<Eleme> resistances) {
		super(nom, description) ;
		this.dexterity = dexterite ;
		this.intelligence = intelligence ; 
		this.strength = force ;
		this.level = 1 ;
		this.maxLifePoints = maxLifePoints ;
		this.lifePoints = maxLifePoints ;
		this.endurance = endurance ; 
		this.alive = true ;
		this.speed = speed ;
		this.maxMana = maxMana ;
		this.mana = maxMana ;
		this.faiblesses=faiblesse ;
		this.resistances = resistances ;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strengh) {
		this.strength = strengh;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getEndurance() {
		return endurance;
	}
	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	public int getLifePoints() {
		return lifePoints;
	}
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	public int getMaxLifePoints() {
		return maxLifePoints;
	}
	public void setMaxLifePoints(int maxLifePoints) {
		this.maxLifePoints = maxLifePoints;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getMaxMana() {
		return maxMana;
	}
	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	
	public ArrayList<Eleme> getResistances() {
		return resistances;
	}

	public void setResistances(ArrayList<Eleme> resistances) {
		this.resistances = resistances;
	}
	
	public ArrayList<Eleme> getFaiblesses(){
		return this.faiblesses ;
	}
	
	public void setFaiblesse(ArrayList<Eleme> faiblesse) {
		this.faiblesses = faiblesse;
	}

	// une fonction qui vérifie que le personnage est toujours en vie 
	public boolean enVie() {
		if (this.getLifePoints() <= 0) {
			this.setAlive(false);
		}
		return this.isAlive() ;
	}
	
	// une méthode pour s'assurer que le personnage n'overheal pas 
	public void noOverHeal() {
		if (this.getLifePoints() >= this.getMaxLifePoints()) {
			this.setLifePoints(this.getMaxLifePoints()) ;
		}
	}
	
	public boolean esquive (int competenceAccuracy, PersonnageCombattant lanceur) {
		boolean t = false ;
		Random random = new Random() ;
		int a = competenceAccuracy + lanceur.getDexterity()/3 - this.getSpeed()/3 ;
		if (random.nextInt(100) < a) {
			t = true ;
		}
		return t ;
	}
	
	// une méthode pour faire subir des dégâts à nos personnages 
	public void dammage(int dammage) {
		// les dégats sont réduits par l'endurance 
		int a = dammage - (endurance/2) ;
		// on veut que nos personnages subissent au moins 1 dégât 
		if (a <= 0) {
			a = 1 ;
		}
		this.setLifePoints(this.getLifePoints() - a) ;
		this.setAlive(this.enVie()) ;
	}
	
	// une méthode pour soigner les personnages
	public void heal(int heal) {
		this.setLifePoints(this.getLifePoints() + heal) ;
		this.noOverHeal(); 	
	}
	
	public abstract ArrayList<PersonnageCombattant> getGroupe() ; 
	public abstract void setGroupe(ArrayList<PersonnageCombattant> groupe) ;

}
