package univers.Objets;

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
}