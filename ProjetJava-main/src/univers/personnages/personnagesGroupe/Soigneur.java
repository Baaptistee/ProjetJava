package univers.personnages.personnagesGroupe;

import java.util.ArrayList;
import java.util.Random;

import univers.Eleme;
import univers.armes.Weapon;
//import univers.armes.Weapon;
import univers.competences.*;
import univers.personnages.PersoGroupe;
/** a character of the group, the healer 
 * I created just this one to do some tests but there will be more later 
 */
public class Soigneur extends PersoGroupe{
	/** the class is a singleton so we have the instance of the class 
	 * 
	 */
	private static Soigneur instance ;
	
	/** 
	 * Le constructeur en privé car c'est une classe singleton 
	 * @param nom le nom du personnage 
	 * @param description la description du personnage 
	 * @param dexterite la dexterité de base du personnage 
	 * @param strengh la force du personnage 
	 * @param intelligence l'intelligence du perso
	 * @param endurance l'endurance du perso
	 * @param speed la vitesse du perso 
	 * @param maxMana le mana Maximum du personnage 
	 * @param maxLifePoints les Points de vie maximum du perso 
	 * @param competences La liste des compétences de base du perso 
	 * @param faiblesses les faiblesses du perso 
	 * @param resistances les resistances du perso 
	 */
	private Soigneur  (String nom, String description, int dexterite, int strengh, int intelligence, int endurance, int speed, int maxMana, int maxLifePoints, ArrayList<CompetencesActives> competences, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances){
		super(nom, description, dexterite, strengh, intelligence, endurance, speed, maxMana, maxLifePoints, competences, faiblesses, resistances) ;
	}
	
	/**
	 * Un getter pour l'instance Soigneur 
	 * @return l'instance Soigneur
	 */
	public static Soigneur getSoigneur() {
		if (instance == null) {
			ArrayList<CompetencesActives> competence = new ArrayList<CompetencesActives>() ;
			CompetencesActives c1 = new CompetenceSoin("Soin Mineur", "Soigne légèrement un allié", 5, 10,false) ;
			CompetencesActives c2 = new CompetenceDammage("Coup de Baton", "Un coup de baton peu puissant", 0, 100, 4, 1, Eleme.NONE, false, true) ;
			competence.add(c2) ;
			competence.add(c1) ;
			ArrayList<Eleme> faiblesses = new ArrayList<Eleme>() ;
			ArrayList<Eleme> resistances = new ArrayList<Eleme>() ;
			Weapon baton = new Weapon(7, 100,"Baton Solide", "Un Baton solide mais vétuste", 1, 2, 2, 2, 4);
			instance = new Soigneur("Soigneur", "Description du soigneur", 5, 5, 5, 5, 5, 30, 40, competence, faiblesses, resistances) ;
			instance.setImage("image/Soigneur.png");
			instance.setWeapon(baton);

		}
		return instance ;
	}
	/**
	 * Fonction pour recommencer un nouveau Soigneur en cas de nouvelle partie par exemple
	 */
	public static void newSoigneur(){
		instance = null ;
	}

	/**
	 * La méthode equals pour vérifier si l'objet comparé est égal
	 * @param obj l'objet comparé
	 * @return si l'objet est le même ou pas 
	 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			else
				return false ;
		}
	
	/**
	 * Pour convertir le personnage en String 
	 * @return La conversion en String 
	 */
	@Override
	public String toString() {
		return "Soigneur " + super.toString();
	}

	/**
	 * La fonction pour quand le personnage gagne un niveau 
	 */
	public String gainNiveau() {
		Random random = new Random() ;
		this.setLevel(getLevel()+1);
		int a = this.getBaseStrength(), b = this.getBaseIntelligence(), c = this.getBaseDexterity(), d = this.getBaseSpeed(), e = this.getBaseEndurance() , f = this.getMaxLifePoints(), g=this.getMaxMana();
		// le gain de statistique se fait aléatoirement 
		this.setStrength(getBaseStrength() + 1 + random.nextInt(2)) ;
		setIntelligence(getBaseIntelligence() + 1 + random.nextInt(3)) ;
		setDexterity(getBaseDexterity() + 1 + random.nextInt(1)) ;
		setSpeed(getBaseSpeed() + 1 + random.nextInt(1)) ; 
		setEndurance(getBaseEndurance() + 1 + random.nextInt(1)) ;
		setMaxLifePoints((f)+3+random.nextInt(5));
		setMaxMana(g+2+random.nextInt(3));
		
		String t = this.getName() + " passe niveau " + this.getLevel() + "! / Force : " + a + " -> " + this.getBaseStrength() + "/Intelligence : " + b + " -> " + this.getBaseIntelligence() + "/Dexterite : " + c + " -> " + this.getBaseDexterity() + "/Vitesse : " + d + " -> " + this.getBaseSpeed() + "/Endurance : " + e + " -> " + this.getBaseEndurance()+ "/PV Max : "+f+" -> "+this.getMaxLifePoints()+"/PM Max : "+g+" -> "+this.getMaxMana();
		
		// apprentissage de nouvelles compétences régulièrement en cas de gain de niveau 
		if (this.getLevel() == 2) {
			CompetenceDammage soinRapide = new CompetenceDammage("Lumière sacrée", "Une attaque magique de lumière sur tous les ennemis", 10, 100, 8, 1, Eleme.LUMIERE, false, false) ;
			this.getCompetences().add(soinRapide) ;
			t += "/Il apprend la compétence active : Lumière Sacrée !" ;
		}if (this.getLevel() == 3) {
			CompetenceSoin soinRapide = new CompetenceSoin("Aura de soin ", "Restaure la santé de tous les membres du groupe", 20, 20, true) ;
			this.getCompetences().add(soinRapide) ;
			t += "/Il apprend la compétence active : Aura de soin !" ;
		}if (this.getLevel() == 4) {
			CompetenceSoin soinRapide = new CompetenceSoin("Restauration", "Soigne toutes les blessures d'un allié", 10, 100, false) ;
			this.getCompetences().add(soinRapide) ;
			t += "/Il apprend la compétence active : Restauration" ;
		}if (this.getLevel() == 5) {
			CompetenceDammage soinRapide = new CompetenceDammage("Châtiment divin", "Une puissante attaque magique de lumière sur un seul ennemi", 20, 100, 20, 1, Eleme.LUMIERE, false, false) ;
			this.getCompetences().add(soinRapide) ;
			t += "/Il apprend la compétence active : Châtiment divin !" ;
		}
		return t ;
	}
	
	

}