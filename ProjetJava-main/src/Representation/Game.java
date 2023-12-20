package Representation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.swing.JOptionPane;

import Interface.InterfaceJeu;
import univers.personnages.*;
import univers.personnages.personnagesGroupe.* ;
import univers.*;

public class Game implements Serializable {
	
	private ArrayList<PersonnageCombattant> groupeJoueur ;
	private Node currentNode ;
	private Node firstNode ;
	private static Game instance;
	private Map<Collectibles, Integer> inventaire ;
	private String nomJoueur = "Baptiste";

	private Game(){}
	
	public ArrayList<PersonnageCombattant> getGroupeJoueur() {
		if (this.groupeJoueur==null) {
			this.groupeJoueur = new ArrayList<PersonnageCombattant>() ;
			this.groupeJoueur.add(Soigneur.getSoigneur()) ;
			this.groupeJoueur.add(Mage.getMage()) ;
			this.groupeJoueur.add(Chevalier.getChevalier()) ;
			this.groupeJoueur.add(Voleur.getVoleur()) ;
		}
		return groupeJoueur;
	}


	public static Game getGame(){
		if (instance == null){
			instance = new Game() ;
		}
		return instance ;
	}

	public String getNomJoueur(){
		return this.nomJoueur;
	}

	public static void setGame(Game newGame){
		instance = newGame ;
	}

	public static void newGame(){
		instance = null ;
		Chevalier.newChevalier();
		Mage.newMage();
		Soigneur.newSoigneur();
		Voleur.newVoleur();
	}

	public void sauvegarde() {
		if (!(this.currentNode instanceof FightNode)){
			File dossierSauvegardes = new File("Sauvegardes");
			if (!dossierSauvegardes.exists()) {
				dossierSauvegardes.mkdir();  // Crée le dossier Sauvegardes si inexistant
			}
	
			long timestamp = System.currentTimeMillis();
    		Date date = new Date();
    		date.setTime(timestamp);

    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    		String nomFichier = "Sauvegardes/Sauvegarde_" + sdf.format(date) + ".txt";

    		try (ObjectOutputStream oos = new ObjectOutputStream(
            		new FileOutputStream(new File(nomFichier)))) {
       		 oos.writeObject(this);
    		} catch (IOException e) {
       		 e.printStackTrace();
    		}
		} else {
			JOptionPane.showMessageDialog(null, "Désolé, impossible de sauvegarder lors d'un combat !", "Alerte", JOptionPane.WARNING_MESSAGE);
		}
	}

	public Map<Collectibles,Integer> getInventaire(){
		return this.inventaire;
	}


	public Node getCurrentNode(){
		return this.currentNode ;
	}

	public Node getFirstNode(){
		return this.firstNode ;
	}

	public void setFirstNode(Node node){
		this.firstNode=node ;
	}

	public void setCurrentNode(Node node){
		this.currentNode = node ;
		//System.out.println("current node set ");
	}
	
	public ArrayList<PersonnageCombattant> getGroupeJoueurVivant() {
		ArrayList<PersonnageCombattant> joueurEnVie = new ArrayList<PersonnageCombattant>() ;

		for (int i = 0 ; i<this.getGroupeJoueur().size(); i++) {
			if (this.getGroupeJoueur().get(i).enVie()) {
				joueurEnVie.add(this.getGroupeJoueur().get(i)) ;
			}
		}
		return joueurEnVie ;
	}
	
	public void configGame() {
		InterfaceJeu.configFenetre() ;
	}
}