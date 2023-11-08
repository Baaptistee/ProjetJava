package univers.personnages;

import univers.Eleme;
//import java.util.ArrayList;
//import univers.armes.*;
import univers.competences.Competences;
import univers.competences.CompetencesActives;

import java.util.ArrayList;
import java.util.Random;
//import univers.personnages.*;

/** 
 * une classe utilisée pour les personnages adverses dans les fight node
 * 
 */
public class PersonnageAdversaire extends PersonnageCombattant {
	/**
	 * les competences du personnages
	 */
	private CompetencesActives[] competences ; // un tableau avec les compétences utilisables par le personnage ainsi que la probabilité que celui-ci l'utilise 
	/** 
	 * la proba associée à chacune de ces compétences 
	 */
	private int[] probaCompetences ;
	/**
	 * le groupe de ce personnage combattant
	 */
	private ArrayList<PersonnageCombattant> groupe ;
	
	/**
	 * le constructeur de la classe
	 * @param nom
	 * @param description
	 * @param dexterite
	 * @param force
	 * @param intelligence
	 * @param endurance
	 * @param speed
	 * @param maxLifePoints
	 * @param maxMana
	 * @param faiblesses
	 * @param resistances
	 * @param competences
	 * @param probaCompetences
	 */
	public PersonnageAdversaire(String nom, String description, int dexterite, int force, int intelligence, int endurance, int speed,  int maxLifePoints, int maxMana, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances, CompetencesActives[] competences, int[] probaCompetences) {
		
		super(nom, description, dexterite, force, intelligence, endurance, speed, maxMana, maxLifePoints, resistances, faiblesses) ;
		this.competences = competences ;
		this.probaCompetences = probaCompetences ;
	}
	/**
	 * un getter pour les compétences 
	 * @return
	 */
	public CompetencesActives[] getCompetences() {
		return competences;
	}
	/**
	 * un setter pour les compétences 
	 * @param competences
	 */
	public void setCompetences(CompetencesActives[] competences) {
		this.competences = competences;
	}
	
	/**
	 * un getter pour la proba des compétences
	 * @return
	 */
	public int[] getProbaCompetences() {
		return probaCompetences;
	}
	/** 
	 * un getter pour le groupe
	 */
	public ArrayList<PersonnageCombattant> getGroupe() {
		return groupe;
	}
	/**
	 * un setter pour le groupe 
	 * @param groupe
	 */
	public void setGroupe(ArrayList<PersonnageCombattant> groupe) {
		this.groupe = groupe;
	}

	/**
	 * une fonction pour sélectionner de manière "aléatoire" une compétence
	 * @return
	 */
	public CompetencesActives selectionAttaque() {
		Random random = new Random() ;
		int total = 0 ;
		boolean pokemon = true ;
		CompetencesActives o = this.getCompetences()[0] ;
		boolean manaCost = false ;
		boolean noUselessHeal = false ;
		while ((manaCost==false)||(noUselessHeal==false)){
			manaCost = false ;
			noUselessHeal = false ;
			for (int i = 0 ; i < this.getProbaCompetences().length ; i++){
				total += this.getProbaCompetences()[i] ;
			}

			int a = random.nextInt(total-1) + 1 ;
		
			total = 0 ;
			int i = 0 ;
			while ((pokemon == true)&(i < this.getProbaCompetences().length)){
				total += this.getProbaCompetences()[i] ;
				if (total >= a) {
					pokemon = false ;
					o = this.getCompetences()[i] ;
				}
				i++ ;
			}
		// on vérifie que le personnage a assez de mana pour lancer la compétence 
			if (this.getMana()>o.getCoutMana()) {
				manaCost = true ;
			}
		
			// on vérifie que si c'est une compétence de soin, il y a bien des personnages alliés à soigner 
			if (o.getClass().getName()=="univers.competences.CompetencesSoin") {
				for (int k = 0 ; k < this.getGroupe().size() ; k++){
					if (this.getGroupe().get(k).getLifePoints()<this.getGroupe().get(k).getMaxLifePoints()){
						noUselessHeal = true ;
					}
				}
			}
		}
		return o ;
	}

	/** 
	 * une fonction pour sélectionner la cible de cette attaque 
	 * @param competence
	 * @return
	 */
	// une fonction pour la sélection aléatoire de la cible 
	public PersonnageCombattant selectionCible(CompetencesActives competence) {
		PersonnageCombattant d = getGroupeJoueur().get(0) ;
		Random random = new Random() ;

		// on ne se soucie pas des compétences ciblant des groupes ici, peu importe leur cible, elles affecteront le groupe ciblé 
		// si on lance une compétence de soin on le fait uniquement sur les allies 
		if (competence.getClass().getName()=="univers.competences.CompetencesSoin") {
			// on va vérifier que la cible est bien blessée 
			boolean z = false ;
			while ((z = false)){
				int i = random.nextInt(this.getGroupe().size()) ;
				if (this.getGroupe().get(i).getLifePoints()<this.getGroupe().get(i).getMaxLifePoints()){
						z = true ;
						d = this.getGroupe().get(i) ;
				}
			}
		} else {
			
			int u = random.nextInt(getGroupeJoueur().size()) ;
			d = getGroupeJoueur().get(u) ;
		}
		return d ;
	}
	//public static void main(String[] args) {
		//PersonnageAdverse test = new PersonnageAdverse(...	
	//}
	
}
