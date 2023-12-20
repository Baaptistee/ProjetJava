package univers.competences;

import java.io.Serializable;
import java.util.Objects;

/** A class that is used to represents competences
 * they will be a distinction beteen passive and active competences later 
 */
public abstract class Competences implements Serializable{
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
		try { if (name==null){
			throw new IllegalArgumentException("Nom doit être rempli (compétence)");
		}
		this.description = description ;
		this.name = name ;
	} catch (IllegalArgumentException e){
		System.out.println(e.getMessage());
	}
	}
	
	/** the default constructeur
	 * 
	 */
	public Competences() {
		this.description = null ;
		this.name = null ;
	}
	
	public Competences(String nom) {
		this.name = nom ;
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


	@Override
	public String toString() {
		return "[description=" + description + ", name=" + name + "] ";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competences other = (Competences) obj;
		return Objects.equals(this.getDescription(), other.getDescription()) && Objects.equals(this.getName(), other.getName());
	}
}