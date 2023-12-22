package univers.personnages;
import java.io.Serializable;
import java.util.Objects;

/**
 * une classe pour les personnages du jeu 
 */
public class Personnage implements Serializable{
    
    private String name;
	private String description;
    private String imageLien;
    private static int totalPerso = 0 ;
    private int persoId ;
    
    /** 
     * Le constructeur de la classe 
     * @param name le nom du personnage 
     * @param description sa description
     */
    public Personnage(String name, String description) {
            if (name==null){
                throw new IllegalArgumentException("Le nom ne peut pas être null (Personnage)!");
            }
            if (name.length()>=13){
                throw new IllegalArgumentException("Le nom des persos est maximum de 12 caractères !"+name);
            }
            totalPerso++ ;
    	    this.persoId = totalPerso ;
    	    this.name=name;
            this.description=description;
    }
    
    /**
     * Un autre constructeur 
     * @param name le nom du personnage 
     * @param description sa description 
     * @param imageLien le path de son image
     */
    public Personnage(String name, String description, String imageLien){
        this.name=name;
        this.description=description;
        this.imageLien=imageLien;
    }
    

    /**
     * Un getter pour le nom 
     * @return le nom 
     */
    public String getName(){
        return name;
    }
    
    /**
     * Un getter pour la description
     * @return la description
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * Un getter pour le path de l'image 
     * @return le path de l'image
     */
    public String getImageLien(){
        return this.imageLien;
    }
    
    /**
     * Un setter pour le nom 
     * @param name le nouveau nom 
     */
    public void setName(String name){
        if (name == null){
            throw new IllegalArgumentException("Le nom ne peut être null") ;
        }
        if (name.length()>=13){
                throw new IllegalArgumentException("Le nom des persos est maximum de 12 caractères !"+name);
        }
        this.name=name;
    }
    
    /**
     * Un getter pour l'id unique du perso 
     * @return l'id du perso 
     */
    public int getPersoId() {
    	return this.persoId ;
    }
    
    /**
     * Un setter pour la description
     * @param description la nouvelle description 
     */
    public void setDescription(String description){
        this.description=description;
    }
    
    /**
     * Un setter pour l'image Path 
     * @param img l'image path 
     */
    public void setImage(String img){
        this.imageLien=img;
    }
    
    /**
	 * Pour convertir le personnage en String 
	 * @return La conversion en String 
	 */
    @Override
	public String toString() {
		return " [name=" + name + ", description=" + description + ", img=" + imageLien + ", persoId=" + persoId
				+ "]";
	}

    /**
	 * La méthode equals pour vérifier si l'objet comparé est égal
	 * @param obj l'objet comparé
	 * @return si l'objet est le même ou pas 
	 */
	@Override
    public boolean equals(Object obj) {
		if (this == obj) {
			return true ;
		} else if (obj.getClass() != this.getClass()) {
			return false ;
		} else {
			Personnage perso = (Personnage)obj ;
			if (Objects.equals(this.getName(), perso.getName()) && Objects.equals(this.getDescription(), perso.getDescription()) && Objects.equals(this.getImageLien(), perso.getImageLien()) && this.getPersoId() == perso.getPersoId()) {
				
				return true ;
			} else {
				return false ;
			}
		}
    	
    }

}