package univers.personnages;
import java.awt.Image;

public class Personnage{
    private String name;
    private String description;
    private Image img;
    private static int totalPerso = 0 ;
    private int persoId ;
    
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

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }
    public Image getImage(){
        return img;
    }

    public void setName(String name){
        this.name=name;
    }
    
    public int getPersoId() {
    	return this.persoId ;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setImage(Image img){
        this.img=img;
    }

}
