package univers.personnages;
import java.awt.Image;
import java.io.Serializable;
import java.util.Objects;

/** a class used to represents characters 
 * We might delete it later because for now all our characters will be fighting ones 
 */
public class Personnage implements Serializable{
    /** the name of the character 
     * 
     */
	private String name;
	/** the description of the character 
	 * 
	 */
    private String description;
    /** the image of the character 
     * Not used yet 
     */
    private String imageLien;
    /** a static variable representing the total of characters 
     * 
     */
    private static int totalPerso = 0 ;
    /** the id of the chacacter 
     * 
     */
    private int persoId ;
    
    /** the constructor of the class 
     * 
     * @param name
     * @param description
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
    
    
    public Personnage(String name, String description, String imageLien){
        this.name=name;
        this.description=description;
        this.imageLien=imageLien;
    }
    

    //Getters Setters
    /** a getter for the name
     * 
     * @return
     */
    public String getName(){
        return name;
    }
    /** a gette rfor the description 
     * 
     * @return
     */
    public String getDescription(){
        return description;
    }
    /** a getter for the Image 
     * 
     * @return
     */
    public String getImageLien(){
        return this.imageLien;
    }
    /** a setter for the name
     * 
     * @param name
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
    /** a getter for the PersoId
     * 
     * @return
     */
    public int getPersoId() {
    	return this.persoId ;
    }
    /** a setter for the description 
     * 
     * @param description
     */
    public void setDescription(String description){
        this.description=description;
    }
    /** a setter for image 
     * 
     * @param img
     */
    public void setImage(String img){
        this.imageLien=img;
    }
    
    @Override
	public String toString() {
		return " [name=" + name + ", description=" + description + ", img=" + imageLien + ", persoId=" + persoId
				+ "]";
	}

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