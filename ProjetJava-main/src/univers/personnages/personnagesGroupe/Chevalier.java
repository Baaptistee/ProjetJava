package univers.personnages.personnagesGroupe;

import java.util.ArrayList;
import java.util.Random;

import univers.Eleme;
import univers.armes.Weapon;
import univers.armes.WeaponType;
import univers.competences.*;
import univers.personnages.PersoGroupe;
/** a character of the group, the healer 
 * I created just this one to do some tests but there will be more later 
 */
public class Chevalier extends PersoGroupe{
	/** the class is a singleton so we have the instance of the class 
	 * 
	 */
	private static Chevalier instance ;
	/** the constructor is in private because it's a singleton
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
	private Chevalier  (String nom, String description, int dexterite, int strengh, int intelligence, int endurance, int speed, int maxMana, int maxLifePoints, ArrayList<Competences> competences, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances, ArrayList<WeaponType> armePossible){
		super(nom, description, dexterite, strengh, intelligence, endurance, speed, maxMana, maxLifePoints, competences, faiblesses, resistances, armePossible) ;
	}
	
	/** a getter for the instance soigneur 
	 * 
	 * @return
	 */
	public static Chevalier getChevalier() {
		if (instance == null) {
			ArrayList<Competences> competence = new ArrayList<Competences>() ;
			ArrayList<Eleme> faiblesses = new ArrayList<Eleme>() ;
			ArrayList<Eleme> resistances = new ArrayList<Eleme>() ;
			ArrayList<WeaponType> armePo = new ArrayList<WeaponType>() ;
			instance = new Chevalier("Nom du Soigneur", "Description du soigneur", 5, 5, 5, 5, 5, 30, 40, competence, faiblesses, resistances, armePo) ;
		}
		return instance ;
	}
	/** a function for when the character  gains a level
	 * 
	 */
	public String gainNiveau() {
		Random random = new Random() ;
		int a = this.getBaseStrength(), b = this.getBaseIntelligence(), c = this.getBaseDexterity(), d = this.getSpeed(), e = this.getBaseEndurance() ;
		// le gain de statistique se fait aléatoirement 
		this.setStrength(getBaseStrength() + 1 + random.nextInt(2)) ;
		setIntelligence(getBaseIntelligence() + 1 + random.nextInt(3)) ;
		setDexterity(getBaseDexterity() + 1 + random.nextInt(1)) ;
		setSpeed(getBaseSpeed() + 1 + random.nextInt(1)) ; 
		setEndurance(getBaseEndurance() + 1 + random.nextInt(1)) ;
		
		String t = this.getName() + " passe niveau " + this.getLevel() + "! / Force : " + a + " -> " + this.getBaseStrength() + "/Intelligence : " + b + " -> " + this.getBaseIntelligence() + "/Dexterite : " + c + " -> " + this.getBaseDexterity() + "/Vitesse : " + d + " -> " + this.getBaseSpeed() + "/Endurance : " + e + " -> " + this.getBaseEndurance();
		
		// apprentissage de nouvelles compétences régulièrement en cas de gain de niveau 
		if (this.getLevel() == 2) {
			CompetenceDammage tailladeLarge = new CompetenceDammage("Taillade Large", "Une grande taillade qui inflige de légers dégâts à tous les ennemis. ", 3, 80, 3, 1, Eleme.NONE, true, true) ;
			this.getCompetences().add(tailladeLarge) ;
			t += "/Il apprend la compétence active : Soin Rapide !" ;
		}
		return t ;
	}
	
	

}
