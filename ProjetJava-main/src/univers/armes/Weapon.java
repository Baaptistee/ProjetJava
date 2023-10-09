package univers.armes;

import java.util.ArrayList;

import univers.personnages.*;

public abstract class Weapon {
	private int dammage ;
	private int accuracy ;
	private int durability ;
	private String name ; 
	private String description ; 
	private boolean broken ;
	private int bonusStrength ;
	private int bonusIntelligence ;
	private int bonusDexterity ;
	private int bonusEndurance ;
	private ArrayList<PersoGroupe> authorizedCharacter ;
	
	public Weapon(int dammage, int accuracy, int durability, String name, String description, int bonusStrength, int bonusIntelligence, int bonusDexterity, int bonusEndurance){
		this.dammage = dammage ;
		this.accuracy = accuracy  ;
		this.durability = durability ;
		this.name = name ;
		this.description = description ;
		this.bonusStrength = bonusStrength ;
		this.bonusDexterity = bonusDexterity ;
		this.bonusEndurance = bonusEndurance ;
		this.bonusIntelligence = bonusIntelligence ;
		this.broken = false ;
	}
	
	
	public boolean isBroken() {
		return broken;
	}


	public void setBroken(boolean broken) {
		this.broken = broken;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public int getDammage() {
		return dammage;
	}
	public void setDamage(int damage) {
		this.dammage = damage;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}


	public int getBonusStrength() {
		return bonusStrength;
	}


	public void setBonusStrength(int bonusStrength) {
		this.bonusStrength = bonusStrength;
	}


	public int getBonusIntelligence() {
		return bonusIntelligence;
	}


	public void setBonusIntelligence(int bonusIntelligence) {
		this.bonusIntelligence = bonusIntelligence;
	}


	public int getBonusDexterity() {
		return bonusDexterity;
	}


	public void setBonusDexterity(int bonusDexterity) {
		this.bonusDexterity = bonusDexterity;
	}


	public int getBonusEndurance() {
		return bonusEndurance;
	}


	public void setBonusEndurance(int bonusEndurance) {
		this.bonusEndurance = bonusEndurance;
	}
	
}
