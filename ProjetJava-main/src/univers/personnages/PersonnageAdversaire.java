package univers.personnages;

import univers.Eleme;
//import java.util.ArrayList;
//import univers.armes.*;
import univers.competences.Competences;
import univers.competences.CompetencesActives;

import java.util.ArrayList;
import java.util.Random;
//import univers.personnages.*;


public class PersonnageAdversaire extends PersonnageCombattant {
	
	private CompetencesActives[] competences ; // un tableau avec les compétences utilisables par le personnage ainsi que la probabilité que celui-ci l'utilise 
	private int[] probaCompetences ;
	private ArrayList<PersonnageCombattant> groupe ;
	private static ArrayList<PersoGroupe> groupeJoueur ;
	
	public PersonnageAdversaire(String nom, String description, int dexterite, int force, int intelligence, int endurance, int speed,  int maxLifePoints, int maxMana, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances, CompetencesActives[] competences, int[] probaCompetences) {
		
		super(nom, description, dexterite, force, intelligence, endurance, speed, maxMana, maxLifePoints, resistances, faiblesses) ;
		this.competences = competences ;
		this.probaCompetences = probaCompetences ;
	}

	public CompetencesActives[] getCompetences() {
		return competences;
	}

	public void setCompetences(CompetencesActives[] competences) {
		this.competences = competences;
	}
	

	public int[] getProbaCompetences() {
		return probaCompetences;
	}

	public void setProbaCompetences(int[] probaCompetences) {
		this.probaCompetences = probaCompetences;
	}
	
	
	// une fonction pour la sélection "aléatoire" de l'attaque 
	public ArrayList<PersonnageCombattant> getGroupe() {
		return groupe;
	}

	public void setGroupe(ArrayList<PersonnageCombattant> groupe) {
		this.groupe = groupe;
	}

	public static ArrayList<PersoGroupe> getGroupeJoueur() {
		return groupeJoueur;
	}

	public static void setGroupeJoueur(ArrayList<PersoGroupe> groupeJoueur) {
		PersonnageAdversaire.groupeJoueur = groupeJoueur;
	}

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
