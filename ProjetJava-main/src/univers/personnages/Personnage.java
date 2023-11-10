package univers.personnages;
import java.awt.Image;

/** a class used to represents characters 
 * We might delete it later because for now all our characters will be fighting ones 
 */
public class Personnage{
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
    private Image img;
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
    	totalPerso++ ;
    	this.persoId = totalPerso ; 
    	this.name=name;
        this.description=description;
    }
    
    /*
    public Personnage(Image img, String name, String description){
        this.name=name;
        this.description=description;
        this.img=img;
    }
    */

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
    public Image getImage(){
        return img;
    }
    /** a setter for the name
     * 
     * @param name
     */
    public void setName(String name){
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
    public void setImage(Image img){
        this.img=img;
    }

}