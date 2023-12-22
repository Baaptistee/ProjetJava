package Representation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import Interface.InterfaceJeu;
import univers.personnages.*;
import univers.personnages.personnagesGroupe.* ;
import univers.*;

/**
 * la classe qui sert à stimuler notre jeu et à sauvegarder 
 */
public class Game implements Serializable {
	
	private ArrayList<PersonnageCombattant> groupeJoueur ;
	private Node currentNode ;
	private Node firstNode ;
	private static Game instance;
	private Map<Collectibles, Integer> inventaire = new HashMap<>();
	private String nomJoueur = "Baptiste";

	/**
	 * constructeur privé
	 */
	private Game(){}
	
	/**
	 * une méthode qui renvoie le groupe de joueur
	 * @return le groupe de joueur 
	 */
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

	/**
	 * une méthode pour get l'instance de jeu
	 * @return l'instance de jeu
	 */
	public static Game getGame(){
		if (instance == null){
			instance = new Game() ;
		}
		return instance ;
	}

	/**
	 * un getter pour le nom du joueur
	 * @return le nom du joueur 
	 */
	public String getNomJoueur(){
		return this.nomJoueur;
	}

	/**
	 * un setter pour l'instance
	 * @param newGame le nouveau jeu 
	 */
	public static void setGame(Game newGame){
		instance = newGame ;
	}

	/**
	 * une méthode pour commencer une nouvelle partie
	 */
	public static void newGame(){
		instance = null ;
		Chevalier.newChevalier();
		Mage.newMage();
		Soigneur.newSoigneur();
		Voleur.newVoleur();
	}

	/**
	 * une méthode pour sauvegarder le jeu
	 */
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

	/**
	 * un getter pour l'inventaire 
	 * @return l'inventaire
	 */
	public Map<Collectibles,Integer> getInventaire(){
		return this.inventaire;
	}

	/**
	 * une méthode pour ajouter un objet à l'inventaire
	 * @param objet l'objet à ajouter
	 */
	public void ajoutInventaire(Collectibles objet){
		if (inventaire.containsKey(objet)){
			int u = inventaire.remove(objet);
			inventaire.put(objet, u+1);
		} else {
			inventaire.put(objet, 1);
		}
	}

	/**
	 * une méthode pour enlever un objet de l'inventaire
	 * @param objet l'objet à enlever
	 */
	public void enleverInventaire(Collectibles objet){
		if(!inventaire.containsKey(objet)){
			throw new IllegalArgumentException("L'objet n'est pas dans l'inventaire");
		}
		if (inventaire.get(objet)==1){
			inventaire.remove(objet);
		} else {
			int u = inventaire.remove(objet);
			inventaire.put(objet, u-1);
		}
	}

	/**
	 * une méthode pour obtenir le node actuel
	 * @return le node actuel
	 */
	public Node getCurrentNode(){
		return this.currentNode ;
	}

	/**
	 * une méthode pour obtenir le Premier Node
	 * @return le premier Node 
	 */
	public Node getFirstNode(){
		return this.firstNode ;
	}

	/**
	 * Une méthode pour set le premier Node 
	 * @param node le nouveau premier Node 
	 */
	public void setFirstNode(Node node){
		this.firstNode=node ;
	}

	/**
	 * Une méthode pour set le node actuel
	 * @param node le node actuel 
	 */
	public void setCurrentNode(Node node){
		this.currentNode = node ;
	}
	/**
	 * une méthode pour get le groupe de joueur vivant 
	 * @return le groupe de joueur vivant
	 */
	public ArrayList<PersonnageCombattant> getGroupeJoueurVivant() {
		ArrayList<PersonnageCombattant> joueurEnVie = new ArrayList<PersonnageCombattant>() ;

		for (int i = 0 ; i<this.getGroupeJoueur().size(); i++) {
			if (this.getGroupeJoueur().get(i).enVie()) {
				joueurEnVie.add(this.getGroupeJoueur().get(i)) ;
			}
		}
		return joueurEnVie ;
	}
	
	/**
	 * une méthode pour configurer le jeu 
	 */
	public void configGame() {
		InterfaceJeu.configFenetre() ;
	}
}