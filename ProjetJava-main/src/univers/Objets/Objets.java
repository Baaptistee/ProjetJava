package univers.Objets;

import java.util.Objects;

import univers.Collectibles;
/**
 * une classe pour les objets en tous genres (potions de soin, pépites d'or ...)
 */
public class Objets implements Collectibles{
	
	

	private int prix ;
	private boolean vendable ;
	private String name ;
	private String description ;
	
	@Override
	public String getName() {
		return this.name ;
	}
	
	@Override
	public String getDescription() {
		return this.description ;
	}
	
	@Override
	public boolean isVendable() {
		return this.vendable ;
	}
	
	@Override
	public int getPrix() {
		return this.prix ;
	}
	
	@Override
	public String toString() {
		return "Objets [prix=" + prix + ", vendable=" + vendable + ", name=" + name + ", description=" + description
				+ "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Objets other = (Objets) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name) && prix == other.prix
				&& vendable == other.vendable;
	}
	
}