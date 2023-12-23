package univers.personnages.personnagesGroupe;


//import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import univers.Eleme;
import univers.armes.Weapon;
//import univers.armes.Weapon;
import univers.competences.*;
import univers.personnages.PersoGroupe;

public class Mage extends PersoGroupe {
	
	private static Mage instance ;
	
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
	private Mage (String nom, String description, int dexterite, int strengh, int intelligence, int endurance, int speed, int maxMana, int maxLifePoints, ArrayList<CompetencesActives> competences, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances){
		super(nom, description, dexterite, strengh, intelligence, endurance, speed, maxMana, maxLifePoints, competences, faiblesses, resistances) ;
	}
	
	/**
	 * Un getter pour l'instance Mage 
	 * @return l'instance Mage
	 */
	public static Mage getMage() {
		if (instance == null) {
			ArrayList<CompetencesActives> competence = new ArrayList<CompetencesActives>() ;
			CompetencesActives c1 = new CompetenceDammage("Coup de grimoire", "Une attaque de base avec la tranche de son grimoire de magie infligeant peu de dégâts", 0, 100, 3, 1, Eleme.NONE, false, true) ;
			CompetenceDammage bouleDeFeu = new CompetenceDammage("Boule de feu", "Une petite boule de feu infligeant quelques dégâts", 7, 95, 12, 1, Eleme.FEU, false, false);
			competence.add(bouleDeFeu) ;
			competence.add(c1) ;
			Weapon grimoire = new Weapon(7, 100,"Vieux Grimoire", "Un vieux grimoire de magie ancienne", 0, 4, 1, 2, 4);

			ArrayList<Eleme> faiblesses = new ArrayList<Eleme>() ;
			ArrayList<Eleme> resistances = new ArrayList<Eleme>() ;
			instance = new Mage("Mage", "Description du Mage", 5, 5, 5, 5, 5, 30, 40, competence, faiblesses, resistances) ;
			instance.setImage("image/MC_Mage.png");
			instance.setWeapon(grimoire);

		}
		return instance ;
	}

	/**
	 * Fonction pour recommencer un nouveau mage en cas de nouvelle partie par exemple
	 */
	public static void newMage(){
		instance = null ;
	}

	/**
	 * Pour convertir le personnage en String 
	 * @return La conversion en String 
	 */
	@Override
	public String toString() {
		return "Mage " + super.toString();
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
	 * La fonction pour quand le personnage gagne un niveau 
	 */
	public String gainNiveau() {
		Random random = new Random() ;
		this.setLevel(this.getLevel()+1);
		int a = this.getBaseStrength(), b = this.getBaseIntelligence(), c = this.getBaseDexterity(), d = this.getBaseSpeed(), e = this.getBaseEndurance(), f = this.getMaxLifePoints(), g = this.getMaxMana() ;
		// le gain de statistique se fait aléatoirement 
		this.setStrength(getBaseStrength() + 1 + random.nextInt(2)) ;
		setIntelligence(getBaseIntelligence() + 1 + random.nextInt(3)) ;
		setDexterity(getBaseDexterity() + 1 + random.nextInt(1)) ;
		setSpeed(getBaseSpeed() + 1 + random.nextInt(1)) ; 
		setEndurance(getBaseEndurance() + 1 + random.nextInt(1)) ;
		setMaxLifePoints((f)+3+random.nextInt(5));
		setMaxMana(g+3+random.nextInt(8));
		
		String t = this.getName() + " passe niveau " + this.getLevel() + "! / Force : " + a + " -> " + this.getBaseStrength() + "/Intelligence : " + b + " -> " + this.getBaseIntelligence() + "/Dexterite : " + c + " -> " + this.getBaseDexterity() + "/Vitesse : " + d + " -> " + this.getBaseSpeed() + "/Endurance : " + e + " -> " + this.getBaseEndurance()+ "/PV Max : "+f+" -> "+this.getMaxLifePoints()+"/PM Max : "+g+" -> "+this.getMaxMana();
		
		// apprentissage de nouvelles compétences régulièrement en cas de gain de niveau 
		if (this.getLevel() == 2) {
			CompetenceDammage bouleDeFeu = new CompetenceDammage("Chaîne d'Éclairs", "Une petite chaîne d'éclair qui frappe tous les ennemis", 10, 95, 10, 1, Eleme.FOUDRE, true, false);
			this.getCompetences().add(bouleDeFeu) ;
			t += "/Il apprend la compétence active : Chaîne d'Éclairs !" ;
		}if (this.getLevel() == 3) {
			CompetenceDammage bouleDeFeu = new CompetenceDammage("Rafale de Feu", "Une rafale de plusieurs boule de feu qui cible un ennemi", 15, 95, 8, 3, Eleme.FEU, false, false);
			this.getCompetences().add(bouleDeFeu) ;
			t += "/Il apprend la compétence active : Rafale de feu !" ;
		}if (this.getLevel() == 4) {
			CompetenceDammage bouleDeFeu = new CompetenceDammage("Déflagration", "Une énorme boule de feu infligeant beaucoup de dégâts à un ennemi", 20, 95, 20, 1, Eleme.FEU, false, false);
			this.getCompetences().add(bouleDeFeu) ;
			t += "/Il apprend la compétence active : Déflagration !" ;
		}if (this.getLevel() == 5) {
			CompetenceDammage bouleDeFeu = new CompetenceDammage("Tonnerre Fracassant", "Un énorme éclair frappe tous les ennemis leur infligeant beaucoup de dégâts", 25, 95, 15, 1, Eleme.FEU, true, false);
			this.getCompetences().add(bouleDeFeu) ;
			t += "/Il apprend la compétence active : Tonerre Fracassant !" ;
		}
		
		return t ;
	}
	
}