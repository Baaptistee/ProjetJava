package univers;

public interface Collectibles {
	
	/**
	 * une fonction pour savoir si l'objet est vendable
	 * @return
	 */
	boolean isVendable() ;
	/**
	 * une fonction pour obtenir le prix de l'objet
	 * @return
	 */
	int getPrix() ;
	/**
	 * une fonction pour obtenir la description de l'objet
	 * @return
	 */
	String getDescription() ;
	/**
	 * uhe fonction pour obtenir le nom de l'objet
	 * @return
	 */
	String getName() ;
}