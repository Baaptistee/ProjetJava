package univers.competences;

import java.util.Objects;
import java.util.Random;

import univers.Eleme;
import univers.personnages.PersonnageCombattant;
/** a class for the dammaging competence 
 * 
 */
public class CompetenceDammage extends CompetencesActives{
	/** the accuracy of the competence 
	 * 
	 * 
	 */
	private int accuracy ;
	/** the power of the competence 
	 * 
	 */
	private int power ;
	/** the variable used to represent if the competence a group damaging one 
	 * 
	 */
	private boolean groupDammage ;
	/** the numbers of hits the competence does 
	 * 
	 */
	private int nbHits ;
	/** the element of the competence 
	 * 
	 */
	private Eleme element ;
	/** is the capacity physical or magical 
	 * 
	 */
	private boolean physical ; // on fait la convention qu'une attaque non physique est donc magique
	/** the constructor of the class
	 * 
	 * @param nom
	 * @param description
	 * @param coutMana
	 * @param accuracy
	 * @param power
	 * @param nbHits
	 * @param element
	 * @param groupDammage
	 * @param physical
	 */
	public CompetenceDammage(String nom, String description, int coutMana, int accuracy, int power, int nbHits, Eleme element, boolean groupDammage, boolean physical){
		super(nom, description, coutMana) ;
		this.accuracy = accuracy ;
		this.power =power ;
		this.groupDammage = groupDammage ;
		this.nbHits = nbHits ;
		this.element = element ;
		this.physical = physical ;
	}
	public CompetenceDammage(String nom) {
		super(nom);
	}
	/** a getter for accuracy
	 * 
	 * @return
	 */
	public int getAccuracy() {
		return accuracy;
	}
	/** a setter for accuracy
	 * 
	 * @param accuracy
	 */
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	
	/** a getter for power 
	 * 
	 * @return
	 */
	public int getPower() {
		return power;
	}
	
	/** a setter for power 
	 * 
	 * @param power
	 */
	public void setPower(int power) {
		this.power = power;
	}
	/** a getter for groupDammage
	 * 
	 * @return
	 */
	public boolean isGroup() {
		return groupDammage;
	}
	/** a setter for groupdammage 
	 * 
	 * @param groupDammage
	 */
	public void setGroup(boolean groupDammage) {
		this.groupDammage = groupDammage;
	}
	/** a getter for the nbHits
	 * 
	 * @return
	 */
	public int getNbHits() {
		return nbHits;
	}
	/** A setter for the nbHits 
	 * 
	 * @param nbHits
	 */
	public void setNbHits(int nbHits) {
		this.nbHits = nbHits;
	}
	/** a getter for Element 
	 * 
	 * @return
	 */
	public Eleme getElement() {
		return element;
	}
	/** a setter for Element 
	 * 
	 * @param element
	 */
	public void setElement(Eleme element) {
		this.element = element;
	}
	/** a getter for physical
	 * 
	 * @return
	 */
	public boolean isPhysical() {
		return physical;
	}
	/** a setter for physical
	 * 
	 * @param physical
	 */
	public void setPhysical(boolean physical) {
		this.physical = physical;
	}
	
	@Override
	public String toString() {
		return "CompetenceDammage " + super.toString() + " [accuracy=" + accuracy + ", power=" + power + ", groupDammage=" + groupDammage
				+ ", nbHits=" + nbHits + ", element=" + element + ", physical=" + physical + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompetenceDammage other = (CompetenceDammage) obj;
		return this.getAccuracy() == other.getAccuracy() && getElement() == other.getElement() && this.isGroup() == other.isGroup()
				&& this.getNbHits() == other.getNbHits() && this.isPhysical() == other.isPhysical() && this.getPower() == other.getPower() &&
				this.getCoutMana() == other.getCoutMana() && 
				Objects.equals(this.getDescription(), other.getDescription()) && Objects.equals(this.getName(), other.getName());
	}
	/**a rewrite of the utilisation of the competence 
	 * The competence will not work if the user doesn't have the mana for it 
	 * @param
	 * @param 
	 * 	
	 */
	@Override
	public String utilisation(PersonnageCombattant utilisateur, PersonnageCombattant cible) {
		Random random = new Random() ;
		String d ;
		int b ;
		// on teste si l'utilisateur a assez de mana 
		if (cible.getGroupeVivant().size()==0){
			d = "nope" ;
			return d ;
		} else if(!cible.enVie()){
			cible = cible.getGroupeVivant().get(0) ;
		}
		if (utilisateur.getMana()<this.getCoutMana()) {
			d = "Pas assez de mana, rien ne se passe" ;
		} else {
			d = utilisateur.getName() + " utilise " + this.getName() + "./";
			utilisateur.setMana(utilisateur.getMana()-this.getCoutMana());
			// on effectue l'action le nb de cout qu'est censée taper l'attaque 
			for (int x=0 ; x<this.getNbHits() ; x++) {
				// on parcoure le groupe en cas de dommages de groupe
				if (this.isGroup()) {
					for(int i = 0 ; i < cible.getGroupe().size() ; i++) {
						//on appelle la méthode esquive qui permet de savoir si le personnage a esquivé l'attaque 
						if (cible.getGroupeVivant().get(i).esquive(this.getAccuracy(), utilisateur)) {
							d += cible.getGroupeVivant().get(i).getName() + " equive l'attaque et s'en tire sans dommage./" ;
						} else {
							// en cas de dommages physiques on se base sur la force et en cas de dégats magiques sur l'intelligence 
							if (this.isPhysical()) {
								b = this.getPower() + utilisateur.getStrength()/2 + random.nextInt(this.getPower()/2);
							} else {
								b = this.getPower() + utilisateur.getIntelligence()/2 + random.nextInt(this.getPower()/2);
							}
							// en cas de faiblesse élémentaire la cible subit 2 fois plus de dégâts 
							if (cible.getGroupeVivant().get(i).getFaiblesses().contains(this.getElement())) {
								b *=2 ;
								d += "L'attaque est super efficace ! /" ;
							} else if (cible.getGroupeVivant().get(i).getResistances().contains(this.getElement())) {
								b /=2 ;
								d += "L'attaque n'est pas très efficace ... /" ;
							}
							cible.getGroupeVivant().get(i).dammage(b);
							d += cible.getGroupeVivant().get(i).getName() + " subit " + b + " points de dégats./" ;
							if (!cible.getGroupeVivant().get(i).enVie()){
								cible.setAlive(false);
								
								d += cible.getName() + " est vaincu(e) !/" ;
								System.out.println(d) ;
							}
						}
					}
				} else {
					if (cible.esquive(this.getAccuracy(), utilisateur)) {
						d += cible.getName() + " equive l'attaque et s'en tire sans dommage./" ;
					} else {
						b = this.getPower() + utilisateur.getIntelligence()/2 + random.nextInt(this.getPower()/2);
						if (cible.getFaiblesses().contains(this.getElement())) {
							b *=2 ;
							d += "L'attaque est super efficace ! " ;
						} else if (cible.getResistances().contains(this.getElement())) {
								b /=2 ;
								d += "L'attaque n'est pas très efficace ... /" ;
						}
						cible.dammage(b);
						d += cible.getName() + " subit " + b + " points de dégats. /" ;
						if (!cible.enVie()){
							cible.setAlive(false);
							d += cible.getName() + " est vaincu(e) !/" ;
						}
					}
				
				}	
			}
		}
		return d ;
	}
}