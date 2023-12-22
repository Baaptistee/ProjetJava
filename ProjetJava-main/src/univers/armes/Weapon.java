package univers.armes;

import java.util.Objects;
import Representation.Game;
import univers.Utilisable;
import univers.personnages.PersoGroupe;
import univers.personnages.PersonnageCombattant;

import java.io.Serializable;

/**
 * Une classe pour les armes du jeu 
 */
public class Weapon implements Utilisable, Serializable{
	
	private int dammage ;
	private int accuracy ;
	private String name ; 
	private String description ; 
	private int bonusStrength ;
	private int bonusIntelligence ;
	private int bonusDexterity ;
	private int bonusEndurance ;
	private int bonusSpeed ;	
	
	
	/** 
	 * Le constrcuteur de la classe 
	 * @param dammage Les dommages de l'arme 
	 * @param accuracy la précision de l'arme 
	 * @param name le nom de l'arme 
	 * @param description la description de l'arme, 
	 * @param bonusStrength le bonus de force 
	 * @param bonusIntelligence le bonus d'intelligence 
	 * @param bonusDexterity le bonus de dextérité 
	 * @param bonusEndurance le bonus d'endurance
	 * @param bonusSpeed le bonus de vitesse 
	 */
	public Weapon(int dammage, int accuracy, /*int durability, */ String name, String description, int bonusStrength, int bonusIntelligence, int bonusDexterity, int bonusEndurance, int bonusSpeed){
		this.dammage = dammage ;
		this.accuracy = accuracy  ;
		this.name = name ;
		this.description = description ;
		this.bonusStrength = bonusStrength ;
		this.bonusDexterity = bonusDexterity ;
		this.bonusEndurance = bonusEndurance ;
		this.bonusIntelligence = bonusIntelligence ;
		this.bonusSpeed = bonusSpeed ;
	}
	
	public void setDammage(int dammage) {
		this.dammage = dammage;
	}	
	
	/**
	 * Un getter pour le nom
	 * @return le nom 
	 */
	@Override
	public String getName() {
		return name;
	}
	/** 
	 * setter pour le nom 
	 * @param name le nouveau nom de l'arme 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * un getter pour la description
	 * @return la description
	 */
	@Override
	public String getDescription() {
		return description;
	}
	/**
	 * un setter pour la descirption 
	 * @param description la nouvelle description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Un getter pour les dammages 
	 * @return les dammages 
	 */
	public int getDammage() {
		return dammage;
	}
	
	/**
	 * Un getter pour la précision 
	 * @return la précision de l'arme 
	 */
	public int getAccuracy() {
		return accuracy;
	}
	
	/**
	 * un setter pour la précision de l'arme 
	 * @param accuracy la nouvelle préicison 
	 */
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	/**
	 * Un getter pour le bonus de force 
	 * @return le bonus de force 
	 */
	public int getBonusStrength() {
		return bonusStrength;
	}
	
	/**
	 * un setter pour le bonus de force 
	 * @param bonusStrength le nouveau bonus de force 
	 */
	public void setBonusStrength(int bonusStrength) {
		this.bonusStrength = bonusStrength;
	}
	
	/**
	 * un getter pour le bonus d'intelligence 
	 * @return le bonus d'intelligence 
	 */
	public int getBonusIntelligence() {
		return bonusIntelligence;
	}
	
	/**
	 * Un setter pour le bonus d'intelligence 
	 * @param bonusIntelligence le nouveau bonus d'intelligence 
	 */
	public void setBonusIntelligence(int bonusIntelligence) {
		this.bonusIntelligence = bonusIntelligence;
	}
	
	/**
	 * Un getter pour le bonus de dextérité 
	 * @return le bonus de dextérité 
	 */
	public int getBonusDexterity() {
		return bonusDexterity;
	}
	
	/**
	 * un setter pour le bonus de dextérité 
	 * @param bonusDexterity le nouveau bonus de dextérité 
	 */
	public void setBonusDexterity(int bonusDexterity) {
		this.bonusDexterity = bonusDexterity;
	}
	
	/**
	 * Un getter pour le bonus d'endurance 
	 * @return bonus d'endurance 
	 */
	public int getBonusEndurance() {
		return bonusEndurance;
	}
	
	/**
	 * Un setter pour le bonus d'endurance 
	 * @param bonusEndurance le nouveau bonus d'endurance 
	 */
	public void setBonusEndurance(int bonusEndurance) {
		this.bonusEndurance = bonusEndurance;
	}
	
	/**
	 * Un gettter pour le bonus de vitesse
	 * @return le bonus de vitesse 
	 */
	public int getBonusSpeed() {
		return bonusSpeed;
	}
	
	/**
	 * un setter pour le bonus de vitesse
	 * @param bonusSpeed le nouveau bonus de vitesse 
	 */
	public void setBonusSpeed(int bonusSpeed) {
		this.bonusSpeed = bonusSpeed;
	}
	/**
	 * La méthode utilisation implémentée par l'interface utilisable 
	 * @param perso le perso sur qui utiliser l'arme
	 * @return le texte à afficher sur l'interface 
	 */
	@Override
	public String utilisation(PersonnageCombattant perso){
		String d = "";
        PersoGroupe perso1 = (PersoGroupe) perso;
		if(perso1.getWeapon()!=null){
			Game.getGame().ajoutInventaire(perso1.getWeapon());
		}
        Game.getGame().enleverInventaire(this);
		perso1.setWeapon(this);
		d = perso.getName()+" s'équipe de "+this.getName()+" !";
        return d ;
	}

	/**
	 * La méthode pour le comparer à un autre objet 
	 */
	@Override
    public boolean equals(Object obj) {
		if (this == obj) {
			return true ;
		} else if (obj.getClass() != this.getClass()) {
			return false ;
		} else {
			Weapon perso = (Weapon)obj ;
			if (Objects.equals(this.getName(), perso.getName()) && Objects.equals(this.getDescription(), perso.getDescription()) && Objects.equals(this.getAccuracy(), perso.getAccuracy()) && Objects.equals(this.getBonusDexterity(), perso.getBonusDexterity()) && Objects.equals(this.getBonusEndurance(), perso.getBonusEndurance()) && Objects.equals(this.getBonusIntelligence(), perso.getBonusIntelligence()) && Objects.equals(this.getBonusSpeed() , perso.getBonusSpeed()) && Objects.equals(this.getBonusStrength(), perso.getBonusStrength()) && Objects.equals(this.getDammage(), perso.getDammage())) {
				return true ;
			} else {
				return false ;
			}
		}
    	
    }
	
}