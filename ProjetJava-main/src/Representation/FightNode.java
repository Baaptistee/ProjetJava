

package Representation;
import java.util.ArrayList;
import java.util.Objects;

import Interface.InterfaceJeu;
import univers.Collectibles;
import univers.personnages.* ;
import java.util.HashMap;
import java.util.Map;

/**
 * La classe pour les noeuds de combats
 */
public class FightNode extends InnerNode {
	
	private ArrayList<PersonnageCombattant> opponents = new ArrayList<>(); //The opponents field represents a collection of combatant characters that the player may face in a combat scenario.
	private int xp ;
	private Map<Collectibles, Integer> butin = new HashMap<Collectibles,Integer>();
	private Map<PersonnageCombattant, Object[]> actions = new HashMap<>();


    /**
	 * Le constructeur de la classe FIghtNode 
	 * @param name le nom du fightNode
     * @param description La description du fightNode
	 * @param imageName Le lien d'image de fond du node 
     */
	public FightNode(String nom, String description,String imageName) {
				super(nom, description, imageName) ;
	}
	/**
	 * Un autre constructeur 
	 * @param description La description
	 * @param imageName Le lien de l'image de fond du node
	 */
	public FightNode(String description, String imageName){
		super("Node" + Node.getTotalNode()+1, description,imageName) ;
	}

	/**
	 * Un autre constructeur de la classe 
	 * @param nom le nom du node 
	 * @param description La description du node 
	 * @param imageName L'imagePath du fond du node 
	 * @param opponents Les adversaires du groupe
	 * @param xp L'xp gagnée à la fin du combat
	 * @param butin le butin gagné à la fin du combat 
	 */
	public FightNode(String nom, String description,String imageName, ArrayList<PersonnageCombattant> opponents, int xp, Map<Collectibles, Integer> butin){
				super(nom, description, imageName) ;
				this.opponents=opponents;
				this.xp = xp;
				this.butin = butin ;
				this.actions= new HashMap<PersonnageCombattant, Object[]>();
	}
	
	/**
	 * un getter pour les adversaires
	 * @return les adversaires 
	 */
	public ArrayList<PersonnageCombattant> getOpponents() {
		return opponents;
	}

	/**
	 * un getter pour les opponents encore vivant du groupe
	 * @return les adversaires encore vivants
	 */
	public ArrayList<PersonnageCombattant> getOpponentsVivant() {
		ArrayList<PersonnageCombattant> groupeVivant = new ArrayList<PersonnageCombattant>() ;
		for (int i = 0 ; i < this.getOpponents().size() ; i++){
			if (this.getOpponents().get(i).enVie()){
				groupeVivant.add(this.getOpponents().get(i)) ;
			}
		}
		return groupeVivant ;
	}

	/**
	 * un setter pour les opponents
	 * @param opponents les nouveaux opponents à set 
	 */
	public void setOpponents(ArrayList<PersonnageCombattant> opponents) {
		if( opponents.isEmpty()){
			throw new IllegalStateException("La liste des adversaires est null");
		}
		this.opponents = opponents;
	}

	/**
	 * un getter pour l'xp gagnée
	 * @return l'xp
	 */
	public int getXp() {
		return xp;
	}

	/**
	 * un setter pour l'xp 
	 * @param xp la nouvelle xp
	 */
	public void setXp(int xp) {
		this.xp = xp;
	}

	/**
	 * Un getter pour le butin
	 * @return le butin 
	 */
	public Map<Collectibles, Integer> getButin() {
		return butin;
	}

	/**
	 * un setter pour le butin
	 * @param butin le set des butins
	 */
	public void setButin(Map<Collectibles, Integer> butin) {
		if (butin ==null){
			throw new IllegalArgumentException("Le butin ne peut être null "+this.getNom());
		}
		this.butin = butin;
	}

	/**
	 * Une méthode pour déterminer si dans le groupe des gens sont encore vivants
	 * @param groupe le groupe à déterminer
	 * @return si le groupen est vivant ou pas 
	 */
	public boolean isGroupEnVie(ArrayList<PersonnageCombattant> groupe ){
		if (groupe ==null){
			throw new IllegalArgumentException("Le groupe à tester ne peut être null !");
		}
		boolean retour = false ;
		for (int i = 0 ; i < groupe.size(); i++) {
			if (groupe.get(i).enVie()) {
				retour = true ;
			}
		}
		return retour ;
	}

	/**
	 * Une méthode pour déterminer si le combat est fini ou pas 
	 * @return si le combat est fini ou pas 
	 */
	public boolean isOver() {
		boolean retour = false ;
		int t = 0 ;
		if (this.isGroupEnVie(this.getOpponents())){
			t++ ;
		}
		
		if(this.isGroupEnVie(Game.getGame().getGroupeJoueur())){
			t++;
		}
		if (t==1){
			retour = true ; 
		}
		return retour ;
	}
	
	/**
	 * la méthode pour display le Node 
	 * On s'assure que les ennemis sont bien en vie et à leur maximum
	 */
	public void display() {

		for(int i = 0; i<this.getOpponents().size() ; i++){
			this.getOpponents().get(i).setGroupe(opponents);
			this.getOpponents().get(i).setMana(this.getOpponents().get(i).getMaxMana()) ;
			this.getOpponents().get(i).setLifePoints(this.getOpponents().get(i).getMaxLifePoints());
			this.getOpponents().get(i).setAlive(true);
		}
		super.display();
	}
	
	/**
	 * un getter pour action
	 * @return action
	 */
	public Map<PersonnageCombattant,Object[]> getAction() {
		if (this.actions == null){
			this.actions  = new HashMap<>();
				return this.actions ;
		} else {

		return actions ;
		}
	}

	/**
	 * une méthode pour ajouter une action à action
	 * @param utilisateur l'utilisateur de la compétence à rajouter
	 * @param competenceCible un tableau contenant la compétence et la cible 
	 */
	public void putAction(PersonnageCombattant utilisateur, Object[] competenceCible){
		if (utilisateur==null){
			throw new IllegalArgumentException("L'utilisateur ne peut pas être null");
		}
		if (this.actions == null){
			this.actions  = new HashMap<>();
		}
		this.actions.put(utilisateur, competenceCible) ;

	}

	/**
	 * une méthode pour retirer une compétence d'action
	 * @param utilisateur
	 */
	public void removeAction(PersonnageCombattant utilisateur) {
		if (utilisateur==null){
			throw new IllegalArgumentException("L'utilisateur ne peut pas être null");
		}
		this.actions.remove(utilisateur) ;
	}

	/**
	 * une méthode pour vider action
	 */
	public void videActions() {
		this.actions = null ;
	}

	/**
	 * une méthode pour gérer le gain du butin
	 * @return le texte pour l'afficher dans l'interface
	 */
	public String gainButin(){
		String d = "" ;
		if (!this.butin.isEmpty()){
			for (Collectibles objet : this.butin.keySet()) {
                d += "Le groupe remporte "+ butin.get(objet)+ " " + objet.getName() + " !/";
				for(int i =0; i<this.butin.get(objet);i++){
                    Game.getGame().ajoutInventaire(objet);
                }
            }
		}
		return d ;
	}	

	/**
	 * Une méthode pour le gain d'xp
	 * @return le texte à afficher dans l'interface
	 */
	public String gainXP() {

		String d = "L'ensemble du groupe remporte " + this.getXp() + " points d'expériences !/";
				
		return d ;
	}
	

	/**
	 * l'override de la fonction goNext
	 * @return Le node suivant
	 */
	@Override
	public Node goNext() {

		if (this.isGroupEnVie(Game.getGame().getGroupeJoueur())) {
			InterfaceJeu.Victoire(this) ;
		} else {
			InterfaceJeu.Defaite(this) ;
		}	
		return null ;
	}
	/**
	 * Override de la méthode toString()
	 */
	@Override
	public String toString() {
		return "FightNode:"+super.toString();
	}
	
	/**
	 * un override de la méthode equals 
	 */
	 @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        FightNode fightNode = (FightNode) obj;
        return super.equals(obj) &&
               Objects.equals(this.getOpponents(), fightNode.getOpponents()) &&
               Objects.equals(this.getXp(),fightNode.getXp()) &&
               Objects.equals(this.getButin(), fightNode.getButin());
    }
}