package univers.armes;

import univers.Collectibles;
// import java.util.ArrayList;
import univers.Eleme;
// import univers.personnages.*;

/** A Weapon object represents the weapon a character carries, it has certains bonus and caracteristics associated to it
 */
public class Weapon implements Collectibles {
	/** the bonus the weapon gives to dammage 
	 */
	private int dammage ;
	
	/** The accuracy of the weapon
	 * 
	 */
	private int accuracy ;
	//private int durability ;
	/** The name of the weapon
	 * 
	 */
	private String name ; 
	
	/** the description of the weapon
	 * 
	 */
	private String description ; 
	//private boolean broken ;
	/**The bonus given by the weapon to strength
	 * 
	 */
	private int bonusStrength ;
	/** The bonus given by the weapon to Intelligence 
	 * 
	 */
	private int bonusIntelligence ;
	/** The bonus given by the weapon to Dexterity 
	 * 
	 */
	private int bonusDexterity ;
	/** The bonus given by the weapon to Endurance 
	 * 
	 */
	private int bonusEndurance ;
	/** The bonus given by the weapon to Speed 
	 * 
	 */
	private int bonusSpeed ;
	/** The element of the weapon
	 * 
	 */
	private Eleme element ;
	/** The type of the weapon
	 * 
	 */
	private boolean vendable ;
	
	private int prix ; 
	
	private WeaponType weaponType ;
	
	/** The constructor of the class 
	 * 
	 * @param dammage
	 * @param accuracy
	 * @param name
	 * @param description
	 * @param bonusStrength
	 * @param bonusIntelligence
	 * @param bonusDexterity
	 * @param bonusEndurance
	 * @param bonusSpeed
	 */
	public Weapon(int dammage, int accuracy, /*int durability, */ String name, String description, int bonusStrength, int bonusIntelligence, int bonusDexterity, int bonusEndurance, int bonusSpeed){
		this.dammage = dammage ;
		this.accuracy = accuracy  ;
		//this.durability = durability ;
		this.name = name ;
		this.description = description ;
		this.bonusStrength = bonusStrength ;
		this.bonusDexterity = bonusDexterity ;
		this.bonusEndurance = bonusEndurance ;
		this.bonusIntelligence = bonusIntelligence ;
		this.bonusSpeed = bonusSpeed ;
		//this.broken = false ;
	}
	
	/* getter for Element 
	 * @return
	 */
	public Eleme getElement() {
		return element;
	}
	/** setter for Element
	 * 
	 * @param element the new Element wanted for the weapon 
	 */
	public void setElement(Eleme element) {
		this.element = element;
	}
	public void setDammage(int dammage) {
		this.dammage = dammage;
	}	
	/*public boolean isBroken() {
		return broken;
	}
	public void setBroken(boolean broken) {
		this.broken = broken;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	*/
	/* getter for Name 
	 * 
	 */
	@Override
	public String getName() {
		return name;
	}
	/** setter for Name
	 * 
	 * @param name the new Name wanted for the weapon 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/* getter for description 
	 * @return
	 */
	@Override
	public String getDescription() {
		return description;
	}
	/** setter for description
	 * 
	 * @param description the new description wanted for the weapon 
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/* getter for dammage 
	 * @return
	 */
	public int getDammage() {
		return dammage;
	}
	/* getter for accuracy 
	 * @return 
	 */
	public int getAccuracy() {
		return accuracy;
	}
	/** setter for accuracy
	 * 
	 * @param accuracy the new accuracy wanted for the weapon 
	 */
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	/* getter for bonusStrength 
	 * @return
	 */
	public int getBonusStrength() {
		return bonusStrength;
	}
	/** setter for bonusStrength
	 * 
	 * @param bonusStrength the new bonusStrength wanted for the weapon 
	 */
	public void setBonusStrength(int bonusStrength) {
		this.bonusStrength = bonusStrength;
	}
	/* getter for bonusIntelligence 
	 * 
	 */
	
	public int getBonusIntelligence() {
		return bonusIntelligence;
	}
	/** setter for bonusIntelligence
	 * 
	 * @param bonusIntelligence the new bonusIntelligence wanted for the weapon 
	 */
	public void setBonusIntelligence(int bonusIntelligence) {
		this.bonusIntelligence = bonusIntelligence;
	}
	/* getter for bonusDexterity 
	 * @return
	 */
	public int getBonusDexterity() {
		return bonusDexterity;
	}
	/** setter for bonusDexterity
	 * 
	 * @param bonusDexterity the new bonusDexterity wanted for the weapon 
	 */
	public void setBonusDexterity(int bonusDexterity) {
		this.bonusDexterity = bonusDexterity;
	}
	/* getter for bonusEndurance 
	 * @return
	 */
	public int getBonusEndurance() {
		return bonusEndurance;
	}
	/** setter for bonusEndurance
	 * 
	 * @param bonusEndurance the new bonusEndurance wanted for the weapon 
	 */
	public void setBonusEndurance(int bonusEndurance) {
		this.bonusEndurance = bonusEndurance;
	}
	/* getter for weaponType 
	 * 
	 */
	public WeaponType getWeaponType() {
		return weaponType;
	}
	/** setter for weaponType
	 * 
	 * @param weaponType the new weaponType wanted for the weapon 
	 */
	public void setWeaponType(WeaponType weaponType) {
		this.weaponType = weaponType;
	}
	/* getter for bonusSpeed  
	 * 
	 */
	public int getBonusSpeed() {
		return bonusSpeed;
	}
	/** setter for bonusSpeed
	 * 
	 * @param bonusSpeed the new bonusSpeed wanted for the weapon 
	 */
	public void setBonusSpeed(int bonusSpeed) {
		this.bonusSpeed = bonusSpeed;
	}

	@Override
	public boolean isVendable() {
		return this.vendable;
	}

	@Override
	public int getPrix() {
		return this.prix;
	}

	
	
}