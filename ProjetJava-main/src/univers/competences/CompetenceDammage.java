package univers.competences;

import java.util.Random;

import univers.Eleme;
import univers.personnages.PersonnageCombattant;
/** a class for the dammaging competence 
 * 
 */
public class CompetenceDammage extends CompetencesActives{
	/** the accuracy of the competence 
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
	public boolean isGroupDammage() {
		return groupDammage;
	}
	/** a setter for groupdammage 
	 * 
	 * @param groupDammage
	 */
	public void setGroupDammage(boolean groupDammage) {
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
		if (utilisateur.getMana()<this.getCoutMana()) {
			d = "Pas assez de mana, rien ne se passe" ;
		} else {
			d = utilisateur.getName() + " utilise " + this.getName() + "./";
			// on effectue l'action le nb de cout qu'est censée taper l'attaque 
			for (int x=0 ; x<this.getNbHits() ; x++) {
				// on parcoure le groupe en cas de dommages de groupe
				if (this.isGroupDammage()) {
					for(int i = 0 ; i < cible.getGroupe().size() ; i++) {
						//on appelle la méthode esquive qui permet de savoir si le personnage a esquivé l'attaque 
						if (cible.getGroupe().get(i).esquive(this.getAccuracy(), utilisateur)) {
							d += getName() + " equive l'attaque et s'en tire sans dommage./" ;
						} else {
							// en cas de dommages physiques on se base sur la force et en cas de dégats magiques sur l'intelligence 
							if (this.isPhysical()) {
								b = this.getPower() + utilisateur.getStrength()/2 + random.nextInt(this.getPower()/2);
							} else {
								b = this.getPower() + utilisateur.getIntelligence()/2 + random.nextInt(this.getPower()/2);

							}
							// en cas de faiblesse élémentaire la cible subit 2 fois plus de dégâts 
							if (cible.getGroupe().get(i).getFaiblesses().contains(this.getElement())) {
								b *=2 ;
								d += "L'attaque est super efficace ! " ;
							}
							cible.getGroupe().get(i).dammage(b);
							d += cible.getGroupe().get(i).getName() + " subit " + b + " points de dégats." ;
						}
					}
				} else {
					if (cible.esquive(this.getAccuracy(), utilisateur)) {
						d += getName() + " equive l'attaque et s'en tire sans dommage./" ;
					} else {
						b = this.getPower() + utilisateur.getIntelligence()/2 + random.nextInt(this.getPower()/2);
						if (cible.getFaiblesses().contains(this.getElement())) {
							b *=2 ;
							d += "L'attaque est super efficace ! " ;
						}
						cible.dammage(b);
						d += cible.getName() + " subit " + b + " points de dégats." ;
					}
				
				}	
			}
		}
		return d ;
	}
}
