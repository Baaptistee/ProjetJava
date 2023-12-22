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
			CompetencesActives c1 = new CompetenceSoin("Attaque de base", "Une attaque de base avec l'arme", 0, 100,false) ;
			CompetencesActives c2 = new CompetenceDammage("Attaque puissante", "une attaque puissante", 5, 100, 10, 1, Eleme.NONE, false, true) ;
			competence.add(c2) ;
			competence.add(c1) ;
			CompetenceDammage tailladeLarge = new CompetenceDammage("Taillade Large", "Une grande taillade qui inflige de légers dégâts à tous les ennemis. ", 10, 100, 5, 1, Eleme.NONE, true, true) ;
			competence.add(tailladeLarge) ;
			ArrayList<Eleme> faiblesses = new ArrayList<Eleme>() ;
			ArrayList<Eleme> resistances = new ArrayList<Eleme>() ;
			Weapon arc = new Weapon(7, 100,"Apparaitra tu", "Un arc solide mais vetuste.", 1, 2, 2, 2, 4);
			instance = new Soigneur("Soigneur", "Description du soigneur", 5, 5, 5, 5, 5, 30, 40, competence, faiblesses, resistances) ;
			instance.setImage("image/Soigneur.png");
			instance.setWeapon(arc);

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
		int a = this.getBaseStrength(), b = this.getBaseIntelligence(), c = this.getBaseDexterity(), d = this.getBaseSpeed(), e = this.getBaseEndurance() ;
		// le gain de statistique se fait aléatoirement 
		this.setStrength(getBaseStrength() + 1 + random.nextInt(2)) ;
		setIntelligence(getBaseIntelligence() + 1 + random.nextInt(3)) ;
		setDexterity(getBaseDexterity() + 1 + random.nextInt(1)) ;
		setSpeed(getBaseSpeed() + 1 + random.nextInt(1)) ; 
		setEndurance(getBaseEndurance() + 1 + random.nextInt(1)) ;
		
		String t = this.getName() + " passe niveau " + this.getLevel() + "! / Force : " + a + " -> " + this.getBaseStrength() + "/Intelligence : " + b + " -> " + this.getBaseIntelligence() + "/Dexterite : " + c + " -> " + this.getBaseDexterity() + "/Vitesse : " + d + " -> " + this.getBaseSpeed() + "/Endurance : " + e + " -> " + this.getBaseEndurance();
		
		// apprentissage de nouvelles compétences régulièrement en cas de gain de niveau 
		if (this.getLevel() == 2) {
			CompetenceSoin soinRapide = new CompetenceSoin("Soin Rapide", "Un soin mineur peu coûteux en mana", 2, 3, false) ;
			this.getCompetences().add(soinRapide) ;
			t += "/Il apprend la compétence active : Soin Rapide !" ;
		}
		return t ;
	}
	
	

}