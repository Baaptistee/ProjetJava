package Representation;

import java.util.ArrayList;

import Interface.InterfaceJeu;
import univers.personnages.*;
import univers.personnages.personnagesGroupe.* ;

public class Game {
	
	private static ArrayList<PersonnageCombattant> groupeJoueur ;
	
	public static ArrayList<PersonnageCombattant> getGroupeJoueur() {
		if (groupeJoueur==null) {
			groupeJoueur = new ArrayList<PersonnageCombattant>() ;
			groupeJoueur.add(Soigneur.getSoigneur()) ;
			groupeJoueur.add(Mage.getMage()) ;
			groupeJoueur.add(Chevalier.getChevalier()) ;
			groupeJoueur.add(Voleur.getVoleur()) ;
		}
		return groupeJoueur;
	}
	
	public static ArrayList<PersonnageCombattant> getGroupeJoueurVivant() {
		ArrayList<PersonnageCombattant> joueurEnVie = new ArrayList<PersonnageCombattant>() ;

		for (int i = 0 ; i<getGroupeJoueur().size(); i++) {
			if (getGroupeJoueur().get(i).enVie()) {
				joueurEnVie.add(getGroupeJoueur().get(i)) ;
			}
		}
		return joueurEnVie ;
	}
	
	public void configGame() {
		InterfaceJeu.configFenetre() ;
	}
}