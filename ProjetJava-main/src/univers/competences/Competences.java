package univers.competences;

/** A class that is used to represents competences
 * they will be a distinction beteen passive and active competences later 
 */
public abstract class Competences {
	/** The description of the competence
	 * 
	 */
	private String description ;
	/** The name of the competence 
	 * 
	 */
	private String name ; 
	/** The constructor of the class 
	 * 
	 * @param name
	 * @param description
	 */
	public Competences(String name, String description) {
		this.description = description ;
		this.name = name ;
	}
	
	/** the default constructeur
	 * 
	 */
	public Competences() {
		this.description = null ;
		this.name = null ;
	}
	
	/** a Getter for the description
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	/** a setter for description
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/** a Getter for the name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/** a setter for name 
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
