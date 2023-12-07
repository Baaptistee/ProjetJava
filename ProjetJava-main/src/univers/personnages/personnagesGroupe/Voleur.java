package univers.personnages.personnagesGroupe;


import java.util.ArrayList;
import java.util.Random;

import univers.Eleme;
//import univers.armes.Weapon;
import univers.armes.WeaponType;
import univers.competences.*;
import univers.personnages.PersoGroupe;

public class Voleur extends PersoGroupe{
	/** the class is a singleton so we have the instance of the class 
	 * 
	 */
	private static Voleur instance ;
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
	private Voleur (String nom, String description, int dexterite, int strengh, int intelligence, int endurance, int speed, int maxMana, int maxLifePoints, ArrayList<CompetencesActives> competences, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances, ArrayList<WeaponType> armePossible){
		super(nom, description, dexterite, strengh, intelligence, endurance, speed, maxMana, maxLifePoints, competences, faiblesses, resistances, armePossible) ;
	}
	
	/** a getter for the instance Mage 
	 * 
	 * @return
	 */
	public static Voleur getVoleur() {
		if (instance == null) {
			ArrayList<CompetencesActives> competence = new ArrayList<CompetencesActives>() ;
			CompetencesActives c1 = new CompetenceDammage("Attaque de base", "Une attaque de base avec l'arme", 0, 100, 5, 1, Eleme.NONE, false, true) ;
			CompetencesActives c2 = new CompetenceDammage("Attaque puissante", "une attaque puissante", 5, 100, 10, 1, Eleme.NONE, false, true) ;
			competence.add(c2) ;
			competence.add(c1) ;
			ArrayList<Eleme> faiblesses = new ArrayList<Eleme>() ;
			ArrayList<Eleme> resistances = new ArrayList<Eleme>() ;
			ArrayList<WeaponType> armePo = new ArrayList<WeaponType>() ;
			instance = new Voleur("Voleur", "Description du voleur", 5, 5, 5, 5, 5, 30, 40, competence, faiblesses, resistances, armePo) ;
		}
		return instance ;
	}
	@Override
	public String toString() {
		return "Voleur " + super.toString();
	}

	/** a function for when the character  gains a level
	 * 
	 */
	
	// qu'une seule vérification dans le equals car classe est un singleton
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			else
				return false ;
		}
		
	public String gainNiveau() {
		Random random = new Random() ;
		this.setLevel(getLevel()+1);
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
			CompetenceDammage lancerDeCouteaux = new CompetenceDammage("Lancer de couteaux", "Lance un couteau sur un ennemi 3 fois, mais avec une précision réduite.", 5, 70, 4, 3, Eleme.NONE, false, true);
			this.getCompetences().add(lancerDeCouteaux) ;
			t += "/Il apprend la compétence active : Lancer de couteaux !" ;
		}
		
		return t ;
	}
	
}
