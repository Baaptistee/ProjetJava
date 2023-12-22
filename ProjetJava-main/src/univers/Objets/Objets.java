package univers.Objets;

import java.io.Serializable;
import java.util.Objects;

import univers.Collectibles;
/**
 * une classe pour les objets en tous genres (potions de soin, pépites d'or ...)
 */
public class Objets implements Collectibles, Serializable{
	
	

	private String name ;
	private String description ;
	
	/**
	 * Un constructeur 
	 * @param name
	 */
	public Objets(String name){
		this.name = name;
	}

	/**
	 * Un autre constructeur 
	 * @param name
	 * @param description
	 */
	public Objets(String name, String description){
		this.name = name;
		this.description=description;
	}

	/**
	 * Un getter pour le nom 
	 * @return le nom 
	 */
	@Override
	public String getName() {
		return this.name ;
	}
	
	/**
	 * Un getter pour la description
	 * @return la description  
	 */
	@Override
	public String getDescription() {
		return this.description ;
	}
	
	
	/**
	 * Une fonctionn pour obtenir l'équivalent en String du Node 
	 * @return l'équivalent en string du node 
	 */
	@Override
	public String toString() {
		return "Objets [, name=" + name + ", description=" + description
				+ "]";
	}


	/**
	 * Une fonction our comparer l'objet à un autre et savoir si ils sont égaux 
	 * @param obj l'objet auquel il est comparé
	 * @return si l'objet est égal ou pas 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Objets other = (Objets) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name) ;
	}
	
}