package univers;

import univers.personnages.PersonnageCombattant;

/**
 * une interface pour les objets utilisables dans l'inventaire 
 */
public interface Utilisable extends Collectibles{
    
    /**
     * une fonction pour utiliser l'objet
     * @param perso la cible de l'utilisation
     */
    String utilisation(PersonnageCombattant perso);
}
