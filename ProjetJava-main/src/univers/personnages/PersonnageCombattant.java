package univers.personnages;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import univers.Eleme;
import univers.Statistiques;
//import univers.competences.Competences;
import univers.competences.CompetencesActives;
//import univers.personnages.personnagesGroupe.*;
/** an abstract class to represent all of our fighting characters (allies or ennemies)
 * 
 */
public abstract class PersonnageCombattant extends Personnage {
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

	//private static ArrayList<PersonnageCombattant> groupeJoueur ;

	
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
	public PersonnageCombattant(String nom, String description, Integer dexterite, Integer force, Integer intelligence, Integer endurance, Integer speed, Integer maxMana, Integer maxLifePoints, ArrayList<Eleme> faiblesse, ArrayList<Eleme> resistances) {
		super(nom, description) ;
		if (dexterite == null || dexterite<=0){
			throw new IllegalArgumentException("La dexterité ne peut pas être null ou négatif!");

		}
		this.dexterity = dexterite ;
		if (force==null || force <= 0){
                throw new IllegalArgumentException("La force  ne peut pas être null ou négatif !");
            }
		this.intelligence = intelligence ; 
		if (intelligence==null || intelligence <= 0){
			throw new IllegalArgumentException("La intelligence  ne peut pas être null ou négatif !");
		}
		this.strength = force ;
		
		this.level = 1 ;
		if (maxLifePoints==null || maxLifePoints <= 0){
			throw new IllegalArgumentException("Les Lifepoints max  ne peut pas être null ou négatif!");
		}
		this.maxLifePoints = maxLifePoints ;

		this.lifePoints = maxLifePoints ;
		if (endurance==null||endurance <= 0){
			throw new IllegalArgumentException("La endurance  ne peut pas être null ou négative!");
		}
		this.endurance = endurance ; 
		this.alive = true ;
		if (speed==null || speed <= 0){
			throw new IllegalArgumentException("La speed  ne peut pas être null ou négative !");
		}
		this.speed = speed ;
		if (maxMana==null || maxMana<=0){
			throw new IllegalArgumentException("La max Mana  ne peut pas être null ou négatif !");
		}
		this.maxMana = maxMana ;
		this.mana = maxMana ;
		if (faiblesses==null){
			this.faiblesses = new ArrayList<Eleme>();
		} this.faiblesses=faiblesse ;
		if (resistances==null){
			this.resistances = new ArrayList<Eleme>();
		} else this.resistances = resistances ;
	}

	public PersonnageCombattant(String nom, String description, String imagePath, Integer dexterite, Integer force, Integer intelligence, Integer endurance, Integer speed, Integer maxMana, Integer maxLifePoints, ArrayList<Eleme> faiblesse, ArrayList<Eleme> resistances) {
		super(nom, description, imagePath) ;
		if (dexterite == null || dexterite<=0){
			throw new IllegalArgumentException("La dexterité ne peut pas être null ou négatif!");

		}
		this.dexterity = dexterite ;
		if (force==null || force <= 0){
                throw new IllegalArgumentException("La force  ne peut pas être null ou négatif !");
            }
		this.intelligence = intelligence ; 
		if (intelligence==null || intelligence <= 0){
			throw new IllegalArgumentException("La intelligence  ne peut pas être null ou négatif !");
		}
		this.strength = force ;
		
		this.level = 1 ;
		if (maxLifePoints==null || maxLifePoints <= 0){
			throw new IllegalArgumentException("Les Lifepoints max  ne peut pas être null ou négatif!");
		}
		this.maxLifePoints = maxLifePoints ;

		this.lifePoints = maxLifePoints ;
		if (endurance==null||endurance <= 0){
			throw new IllegalArgumentException("La endurance  ne peut pas être null ou négative!");
		}
		this.endurance = endurance ; 
		this.alive = true ;
		if (speed==null || speed <= 0){
			throw new IllegalArgumentException("La speed  ne peut pas être null ou négative !");
		}
		this.speed = speed ;
		if (maxMana==null || maxMana<=0){
			throw new IllegalArgumentException("La max Mana  ne peut pas être null ou négatif !");
		}
		this.maxMana = maxMana ;
		this.mana = maxMana ;
		if (faiblesses==null){
			this.faiblesses = new ArrayList<Eleme>();
		} this.faiblesses=faiblesse ;
		if (resistances==null){
			this.resistances = new ArrayList<Eleme>();
		} else this.resistances = resistances ;
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
		if (speed < 0) {
			throw new IllegalArgumentException("La vitesse ne peut pas être négative");
		}
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
		if (level <= 0) {
			throw new IllegalArgumentException("Level ne peut être négatif ou 0");
		}
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
	
			if(strengh<=0){
				throw new IllegalArgumentException("Strengh ne peut être négatif ou 0");
			}
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
			if(intelligence<=0){
				throw new IllegalArgumentException("Intelligence ne peut être négatif ou 0");
			}
			this.intelligence = intelligence;
		
	}
	/** a getter for dexterity
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
			if(dexterity<=0){
				throw new IllegalArgumentException("Dexterity ne peut être négatif ou 0");
			}
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

			if(endurance<=0){
				throw new IllegalArgumentException("Endurance ne peut être négatif ou 0");
			}
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
			if(maxLifePoints<=0){
				throw new IllegalArgumentException("MaxLifepoints ne peut être négatif ou 0");
			}
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
		
			if (mana < 0){
				throw new IllegalArgumentException("mana ne peut être négatif ! ");
			}
			if (mana > maxMana){
				this.mana = maxMana ;
			} else this.mana = mana;
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

			if(maxMana<=0){
				throw new IllegalArgumentException("MaxMana ne peut être négatif ou 0");
			}
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
		if (resistances==null){
			resistances = new ArrayList<Eleme>() ;
		} else this.resistances = resistances;
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
	public void setFaiblesse(ArrayList<Eleme> faiblesses) {
		if (faiblesses==null){
			this.faiblesses = new ArrayList<Eleme>() ;
		} else this.faiblesses = faiblesses;	}
	/* 
	public static void setGroupeJoueur(ArrayList<PersonnageCombattant> groupeJoueur) {
		PersonnageCombattant.groupeJoueur = groupeJoueur;
	}*/
	
	/** 
	 * a method to test a character's statistic
	 * @param valeurTest value to modulate the difficulty of the test
	 * @param stat the stat being tested 
	 * @return weather the character succeeded or not 
	 */
	
	public boolean testStat(int valeurTest, Statistiques stat){
	
			if (valeurTest<0) {
				throw new IllegalArgumentException("La valeur test doit être supérieure à zéro !");
			}
			if (stat == null){
				throw new IllegalArgumentException("Le nom ne peut pas être null !");
			}
			Random random = new Random() ;
			switch(stat) {
			case STRENGTH:
				if (valeurTest <= this.getStrength() + random.nextInt(19) + 1) {
					return true ;
				} else {
					return false ;
				}
			case DEXTERITY:
				if (valeurTest <= this.getDexterity() + random.nextInt(19) + 1) {
					return true ;
				} else {
					return false ;
				}
			case INTELLIGENCE:
				if (valeurTest <= this.getIntelligence() + random.nextInt(19) + 1) {
				return true ;
				} else {
					return false ;
				}
			case SPEED:
				if (valeurTest <= this.getSpeed() + random.nextInt(19) + 1) {
					return true ;
				} else {
					return false ;
				}
			case ENDURANCE:
				if (valeurTest <= this.getEndurance() + random.nextInt(19) + 1) {
					return true ;
				} else {
					return false ;
				}
			default:
				return false ;
			}
		
	}
	
	
	/** a function meant to check if the character is alive or no
	 * 
	 * @return
	 */
	
	// une fonction qui vérifie que le personnage est toujours en vie 
	public boolean enVie() {
		if (this.getLifePoints() <= 0) {
			this.setAlive(false);
			setLifePoints(0);
		}
		return this.alive ;
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
	public boolean esquive(int competenceAccuracy, PersonnageCombattant lanceur) {
		if (lanceur == null) {
			throw new IllegalArgumentException("Lanceur ne peut être null");
		}
	
		if (competenceAccuracy <= 0) {
			throw new IllegalArgumentException("competence Accuracy doit être supérieur à zéro");
		}
	
		boolean t = false;
		Random random = new Random();
		int a = competenceAccuracy + lanceur.getDexterity() / 3 - this.getSpeed() / 3;
		
		if (random.nextInt(100) > a) {
			t = true;
		}
		
		return t;
	}
	
	/** a method to deal dammage to characters
	 * 
	 * @param dammage
	 */
	// une méthode pour faire subir des dégâts à nos personnages 
	public void dammage(int dammage) {
	
			if (dammage<=0){
				throw new IllegalArgumentException("dammage doit être supérieur à zéro") ;
			}
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
			if (heal<=0){
				throw new IllegalArgumentException("heal doit être supérieur à, zéro");
			}
		this.setLifePoints(this.getLifePoints() + heal) ;
		
	}
	/** a function used to get the group of the characters
	 * 
	 * @return
	 */
	public abstract ArrayList<PersonnageCombattant> getGroupe() ;
	public abstract void setGroupe(ArrayList<PersonnageCombattant> newGroup) ;
	public abstract ArrayList<PersonnageCombattant> getGroupeVivant() ;
	
	 @Override
	public String toString() {
		return super.toString() + " [level=" + level + ", strength=" + strength + ", intelligence=" + intelligence
				+ ", dexterity=" + dexterity + ", speed=" + speed + ", lifePoints=" + lifePoints + ", maxLifePoints="
				+ maxLifePoints + ", alive=" + alive + ", endurance=" + endurance + ", mana=" + mana + ", maxMana="
				+ maxMana + ", faiblesses=" + faiblesses + ", resistances=" + resistances + "]";
	}
	@Override
	    public boolean equals(Object obj) {
			if (this == obj) {
				return true ;
			} else if (obj.getClass() != this.getClass()) {
				return false ;
			} else {
				PersonnageCombattant perso = (PersonnageCombattant)obj ;
				if (Objects.equals(this.getName(), perso.getName()) && Objects.equals(this.getDescription(), perso.getDescription()) && Objects.equals(this.getImageLien(), perso.getImageLien()) && Objects.equals(this.getPersoId(), perso.getPersoId()) && Objects.equals(this.getDexterity() , perso.getDexterity()) && Objects.equals(this.getStrength() , perso.getStrength()) && Objects.equals(this.getEndurance() , perso.getEndurance()) && Objects.equals(this.getFaiblesses() , perso.getFaiblesses()) && Objects.equals( this.getGroupe() , perso.getGroupe()) && Objects.equals(this.getIntelligence() , perso.getIntelligence()) && Objects.equals(this.getLevel() , perso.getLevel()) && Objects.equals(this.getLifePoints() , perso.getLifePoints()) && Objects.equals(this.getMana() , perso.getMana()) && Objects.equals(this.getMaxLifePoints() , perso.getMaxLifePoints()) && Objects.equals(this.getMaxMana(), perso.getMaxMana()) && Objects.equals(this.getResistances(), perso.getResistances()) && Objects.equals(this.getSpeed(), perso.getSpeed())) {
					return true ;
				} else {
					return false ;
				}
			}
	    	
	    }

		public abstract ArrayList<CompetencesActives> getCompetences() ;

}