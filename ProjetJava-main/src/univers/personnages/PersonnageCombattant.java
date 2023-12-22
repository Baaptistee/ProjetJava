package univers.personnages;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import univers.Eleme;
import univers.Statistiques;
import univers.competences.CompetencesActives;

/**
 * Une classe pour les Personnages combattants (qui apparaissent dans le FighTNode )
 */
public abstract class PersonnageCombattant extends Personnage {
	
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
	
	/**
	 * le constructeur de la classe
	 * @param nom le nom du perso 
	 * @param description sa description
	 * @param dexterite la dexterite 
	 * @param force sa force 
	 * @param intelligence son intelligence 
	 * @param endurancen son endurance 
	 * @param speed sa vitesse 
	 * @param maxLifePoints son MAximum de points de vie 
	 * @param maxMana son maximum de mana 
	 * @param faiblesses ses faiblesses 
	 * @param resistances ses résistances 
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

	/**
	 * le constructeur de la classe
	 * @param nom le nom du perso 
	 * @param description sa description
	 * @param imagePath l'image path de l'image du perso 
	 * @param dexterite la dexterite 
	 * @param force sa force 
	 * @param intelligence son intelligence 
	 * @param endurancen son endurance 
	 * @param speed sa vitesse 
	 * @param maxLifePoints son MAximum de points de vie 
	 * @param maxMana son maximum de mana 
	 * @param faiblesses ses faiblesses 
	 * @param resistances ses résistances 
	 */
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
	
	/**
	 * Un getter pour la vitesse 
	 * @return la vitesse 
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Un setter pour la vitesse 
	 * @return la vitesse 
	 */
	public void setSpeed(int speed) {
		if (speed < 0) {
			throw new IllegalArgumentException("La vitesse ne peut pas être négative");
		}
		this.speed = speed;
	}
	
	/**
	 * Un getter pour le niveau 
	 * @return le niveau 
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * Un setter pour le niveau 
	 * @return le niveau 
	 */
	public void setLevel(int level) {
		if (level <= 0) {
			throw new IllegalArgumentException("Level ne peut être négatif ou 0");
		}
		this.level = level;
	}
	/**
	 * Un getter pour la force 
	 * @return la force 
	 */
	public int getStrength() {
		return strength;
	}
	/**
	 * Un setter pour la force 
	 * @return la force 
	 */
	public void setStrength(int strengh) {
	
			if(strengh<=0){
				throw new IllegalArgumentException("Strengh ne peut être négatif ou 0");
			}
			this.strength = strengh;
		
	}
	/**
	 * Un getter pour l'intelligence 
	 * @return l'intelligence 
	 */
	public int getIntelligence() {
		return intelligence;
	}
	/**
	 * Un setter pour l'intelligence 
	 * @return l'intelligence 
	 */
	public void setIntelligence(int intelligence) {
			if(intelligence<=0){
				throw new IllegalArgumentException("Intelligence ne peut être négatif ou 0");
			}
			this.intelligence = intelligence;
		
	}
	/**
	 * Un getter pour la dextérité 
	 * @return la dextérité 
	 */
	public int getDexterity() {
		return dexterity;
	}
	/**
	 * Un setter pour la dextérité 
	 * @return la dextérité 
	 */
	public void setDexterity(int dexterity) {
			if(dexterity<=0){
				throw new IllegalArgumentException("Dexterity ne peut être négatif ou 0");
			}
			this.dexterity = dexterity;
			}
	/**
	 * Un getter pour l'endurance 
	 * @return l'endurance 
	 */
	public int getEndurance() {
		return endurance;
	}
	/**
	 * Un setter pour l'endurance 
	 * @return l'endurance 
	 */
	public void setEndurance(int endurance) {

			if(endurance<=0){
				throw new IllegalArgumentException("Endurance ne peut être négatif ou 0");
			}
			this.endurance = endurance;
				}
	/**
	 * Un getter pour les points de vie 
	 * @return les points de vie 
	 */
	public int getLifePoints() {
		return lifePoints;
	}
	/**
	 * Un setter pour les points de vie  
	 * @return les points de vie  
	 */
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
		if (this.lifePoints>this.maxLifePoints){
			this.lifePoints=this.maxLifePoints;
		}
	}
	/**
	 * Un getter pour les points de vie MAX  
	 * @return les points de vie MAX 
	 */
	public int getMaxLifePoints() {
		return maxLifePoints;
	}
	/**
	 * Un setter pour les points de vie MAX 
	 * @return les points de vie MAX 
	 */
	public void setMaxLifePoints(int maxLifePoints) {
			if(maxLifePoints<=0){
				throw new IllegalArgumentException("MaxLifepoints ne peut être négatif ou 0");
			}
			this.maxLifePoints = maxLifePoints;
				}
	/**
	 * Un getter pour les points de Mana 
	 * @return les points de mana  
	 */
	public int getMana() {
		return mana;
	}
	/**
	 * Un setter pour les points de mana  
	 * @return les points de mana  
	 */
	public void setMana(int mana) {
		
			if (mana < 0){
				throw new IllegalArgumentException("mana ne peut être négatif ! ");
			}
			if (mana > maxMana){
				this.mana = maxMana ;
			} else this.mana = mana;
	}
	/**
	 * Un getter pour les points de mana MAX  
	 * @return les points de mana MAX  
	 */
	public int getMaxMana() {
		return maxMana;
	}
	/**
	 * Un setter pour les points de mana MAX 
	 * @return les points de mana MAX
	 */
	public void setMaxMana(int maxMana) {

			if(maxMana<=0){
				throw new IllegalArgumentException("MaxMana ne peut être négatif ou 0");
			}
			this.maxMana = maxMana;
			}
	/**
	 * Un getter pour si le personnage est en vie  
	 * @return si le personnage est en vie  
	 */
	public boolean isAlive() {
		return alive;
	}
	/**
	 * Un setter pour si le personnage est en vie  
	 * @return si le personnage est en vie  
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	/**
	 * Un getter pour si les résistances 
	 * @return si les résistances 
	 */
	public ArrayList<Eleme> getResistances() {
		return resistances;
	}
	/**
	 * Un setter pour si les résistances 
	 * @return si les résistances 
	 */
	public void setResistances(ArrayList<Eleme> resistances) {
		if (resistances==null){
			resistances = new ArrayList<Eleme>() ;
		} else this.resistances = resistances;
	}
	/**
	 * Un getter pour si les faiblesses 
	 * @return si les faiblesses 
	 */
	public ArrayList<Eleme> getFaiblesses(){
		return this.faiblesses ;
	}
	/**
	 * Un setter pour si les faiblesses 
	 * @return si les faiblesses 
	 */
	public void setFaiblesse(ArrayList<Eleme> faiblesses) {
		if (faiblesses==null){
			this.faiblesses = new ArrayList<Eleme>() ;
		} else this.faiblesses = faiblesses;	}
	
	/** 
	 * Une méthode pour testes les statistiques d'un personnage 
	 * @param valeurTest valeur pour moduler la difficulté du test 
	 * @param stat la stat qui va se faire test  
	 * @return est ce que le personnage a réussi le test  
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
	
	
	/**
	 * Une fonction pour vérifier si le personnage est en vie 
	 * @return si le personnage est en vie ou pas 
	 */
	public boolean enVie() {
		if (this.getLifePoints() <= 0) {
			this.setAlive(false);
			setLifePoints(0);
		}
		return this.alive ;
	}
	/**
	 * une méthode pour éviter que le personnage ne se soigne trop
	 */
	public void noOverHeal() {
		if (this.getLifePoints() >= this.getMaxLifePoints()) {
			this.setLifePoints(this.getMaxLifePoints()) ;
		}
	}
	/** 
	 * Une fonction pour tester si le personnage a esquivé l'attaque 
	 * 
	 * @param competenceAccuracy la précision de l'attaque 
	 * @param lanceur le lanceur de la compétence 
	 * @return si le personnage a esquivé 
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
	
	/** 
	 * Une méthode pour infliger des dégâts aux personnages 
	 * @param dammage les dégâts infligés 
	 */
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
	/** 
	 * Une méthode pour soigner les personnages 
	 * @param heal le total de soin
	 */
	public void heal(int heal) {
			if (heal<=0){
				throw new IllegalArgumentException("heal doit être supérieur à, zéro");
			}
		this.setLifePoints(this.getLifePoints() + heal) ;
		
	}
	
	/**
	 * Un getter pour le groupe  
	 * @return le groupe  
	 */
	public abstract ArrayList<PersonnageCombattant> getGroupe() ;
	/**
	 * un setter pour le groupe 
	 * @param newgroup le nouveau groupe 
	 */
	public abstract void setGroupe(ArrayList<PersonnageCombattant> newGroup) ;
	/**
	 * Un getter pour le groupe vivant 
	 * @return le groupe Vivant 
	 */
	public abstract ArrayList<PersonnageCombattant> getGroupeVivant() ;
	

	/**
	 * Pour convertir le personnage en String 
	 * @return La conversion en String 
	 */
	@Override
	public String toString() {
		return super.toString() + " [level=" + level + ", strength=" + strength + ", intelligence=" + intelligence
				+ ", dexterity=" + dexterity + ", speed=" + speed + ", lifePoints=" + lifePoints + ", maxLifePoints="
				+ maxLifePoints + ", alive=" + alive + ", endurance=" + endurance + ", mana=" + mana + ", maxMana="
				+ maxMana + ", faiblesses=" + faiblesses + ", resistances=" + resistances + "]";
	}
	/**
	 * La méthode equals pour vérifier si l'objet comparé est égal
	 * @param obj l'objet comparé
	 * @return si l'objet est le même ou pas 
	 */
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