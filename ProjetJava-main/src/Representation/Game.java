package Representation;

import java.util.ArrayList;

import Interface.InterfaceJeu;
import univers.personnages.*;
import univers.personnages.personnagesGroupe.* ;

public class Game {
	
	private static ArrayList<PersonnageCombattant> groupeJoueur ;
	
	public static ArrayList<PersonnageCombattant> getGroupeJoueur() {
		if (groupeJoueur==null) {
			groupeJoueur.add(Soigneur.getSoigneur()) ;
			groupeJoueur.add(Mage.getMage()) ;
			groupeJoueur.add(Chevalier.getChevalier()) ;
			groupeJoueur.add(Voleur.getVoleur()) ;
		}
		return groupeJoueur;
	}
	
	public void configGame() {
		InterfaceJeu.configFenetre();
	}
}
