package univers.personnages;

import java.util.ArrayList;
import java.util.Random;

import univers.Eleme;
import univers.competences.Competences;
/** an abstract class to represent all of our fighting characters (allies or ennemies)
 * 
 */
public abstract class PersonnageCombattant extends Personnage{
	/** the level of the character
	 * used for progression in the specific class "PersoGroupe" and mainly for tension when it comes to ennemies
	 */
	private int level ; 
	/** the strangth of the character 
	 * 
	 */
	private int strength ;
	/** the intelligence of the character 
	 * 
	 */
	private int intelligence ;
	/** the dexterity of the character 
	 * 
	 */
	private int dexterity ;
	/** the speed of the character 
	 * 
	 */
	private int speed ; 
	/** the lifePoints of the character 
	 * 
	 */
	private int lifePoints ;
	/** the maxLifePOints of the character 
	 * 
	 */
	private int maxLifePoints ;
	/** is the character alive 
	 * 
	 */
	private boolean alive ;
	/** the endurance of the character 
	 * 
	 */
	private int endurance ;
	/** the current mana of the character 
	 * 
	 */
	private int mana ;
	/** the maximum mana of the character 
	 * 
	 */
	private int maxMana ;
	/** the weaknesses of the character 
	 * 
	 */
	private ArrayList<Eleme> faiblesses ; 
	/** the resistances of the character 
	 * 
	 */
	private ArrayList<Eleme> resistances ;

	
	
	/** the constructor for the class 
	 * 
	 * @param nom
	 * @param description
	 * @param dexterite
	 * @param force
	 * @param intelligence
	 * @param endurance
	 * @param speed
	 * @param maxMana
	 * @param maxLifePoints
	 * @param faiblesse
	 * @param resistances
	 */
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
	/** a getter for the speed
	 * 
	 * @return
	 */
	public int getSpeed() {
		return speed;
	}
	/** a setter for speed
	 * 
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/** a getter for level 
	 * 
	 * @return
	 */
	public int getLevel() {
		return level;
	}
	/** a setter for level 
	 * 
	 * @param level
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/** a getter for strength
	 * 
	 * @return
	 */
	public int getStrength() {
		return strength;
	}
	/** a setter for strength
	 * 
	 * @param strengh
	 */
	public void setStrength(int strengh) {
		this.strength = strengh;
	}
	/** a getter for intelligence
	 * 
	 * @return
	 */
	public int getIntelligence() {
		return intelligence;
	}
	/** a setter for intelligence
	 * 
	 * @param intelligence
	 */
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	/** a gette for dexterity
	 * 
	 * @return
	 */
	public int getDexterity() {
		return dexterity;
	}
	/* a setter for dexterity
	 * 
	 */
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	/** a getter for endurance
	 * 
	 * @return
	 */
	public int getEndurance() {
		return endurance;
	}
	/** a setter for endurance
	 * 
	 * @param endurance
	 */
	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	/** a getter for Lifepoints
	 * 
	 * @return
	 */
	public int getLifePoints() {
		return lifePoints;
	}
	/** a setter for lifepoints
	 * 
	 * @param lifePoints
	 */
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	/** a getter for max lifePOints
	 * 
	 * @return
	 */
	public int getMaxLifePoints() {
		return maxLifePoints;
	}
	/** a setter for maxlifepoints
	 * 
	 * @param maxLifePoints
	 */
	public void setMaxLifePoints(int maxLifePoints) {
		this.maxLifePoints = maxLifePoints;
	}
	/** a getter for the current mana
	 * 
	 * @return
	 */
	public int getMana() {
		return mana;
	}
	/** a setter for the current mana
	 * 
	 * @param mana
	 */
	public void setMana(int mana) {
		this.mana = mana;
	}
	/** a getter for the maximum mana
	 * 
	 * @return
	 */
	public int getMaxMana() {
		return maxMana;
	}
	/** a setter for the maximum mana
	 * 
	 * @param maxMana
	 */
	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}
	/** a getter for alive
	 * 
	 * @return
	 */
	public boolean isAlive() {
		return alive;
	}
	/** a setter for alive
	 * 
	 * @param alive
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	/** a getter for resistances 
	 * 
	 * @return
	 */
	public ArrayList<Eleme> getResistances() {
		return resistances;
	}
	/** a setter for resistances
	 * 
	 * @param resistances
	 */
	public void setResistances(ArrayList<Eleme> resistances) {
		this.resistances = resistances;
	}
	/** a getter for weaknesses
	 * 
	 * @return
	 */
	public ArrayList<Eleme> getFaiblesses(){
		return this.faiblesses ;
	}
	/** a setter for weaknesses
	 * 
	 * @param faiblesse
	 */
	public void setFaiblesse(ArrayList<Eleme> faiblesse) {
		this.faiblesses = faiblesse;
	}
	/** a function meant to check if the character is alive or no
	 * 
	 * @return
	 */
	// une fonction qui vérifie que le personnage est toujours en vie 
	public boolean enVie() {
		if (this.getLifePoints() <= 0) {
			this.setAlive(false);
		}
		return this.isAlive() ;
	}
	/** a method to prevent the character to overheal
	 * 
	 */
	// une méthode pour s'assurer que le personnage n'overheal pas 
	public void noOverHeal() {
		if (this.getLifePoints() >= this.getMaxLifePoints()) {
			this.setLifePoints(this.getMaxLifePoints()) ;
		}
	}
	/** a function to measure if the character successfully avoided the attack 
	 * 
	 * @param competenceAccuracy
	 * @param lanceur
	 * @return
	 */
	public boolean esquive (int competenceAccuracy, PersonnageCombattant lanceur) {
		boolean t = false ;
		Random random = new Random() ;
		int a = competenceAccuracy + lanceur.getDexterity()/3 - this.getSpeed()/3 ;
		if (random.nextInt(100) < a) {
			t = true ;
		}
		return t ;
	}
	/** a method to deal dammage to characters
	 * 
	 * @param dammage
	 */
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
	/** a method to heal characters 
	 * 
	 * @param heal
	 */
	// une méthode pour soigner les personnages
	public void heal(int heal) {
		this.setLifePoints(this.getLifePoints() + heal) ;
		this.noOverHeal(); 	
	}
	/** a function used to get the group of the characters
	 * 
	 * @return
	 */
	public abstract ArrayList<PersonnageCombattant> getGroupe() ; 
	/** a setter for the group 
	 * 
	 * @param groupe
	 */
	public abstract void setGroupe(ArrayList<PersonnageCombattant> groupe) ;

}
