package univers.competences;

import java.io.Serializable;
import java.util.Objects;

/**
 * Une classe pour les compétences 
 */
public abstract class Competences implements Serializable{
	
	private String description ;
	private String name ; 
	
	/**
	 * Le constucteur de la classe 
	 * @param name le nom de la classe 
	 * @param description la description de la classe 
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
	
	/**
	 * Le constructeur par défaut 
	 */
	public Competences() {
		this.description = null ;
		this.name = null ;
	}
	
	/**
	 * un constructeur avec juste le nom 
	 * @param nom le nom 
	 */
	public Competences(String nom) {
		this.name = nom ;
}

	/**
	 * Un getter pour la description 
	 * @return la description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Un setter pour la description
	 * @param description la nouvelle description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Un getter pour le nom 
	 * @return le nom 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Un setter pour le nom
	 * @param name le nouveau nom 
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Une méthode pour transformer en String 
	 */
	@Override
	public String toString() {
		return "[description=" + description + ", name=" + name + "] ";
	}

	/**
	 * Méthode pour comparer à un objet et vois si ils sont égaux 
	 */
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