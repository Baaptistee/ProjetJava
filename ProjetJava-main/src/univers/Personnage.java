package univers;
import java.awt.Image;

public class Personnage{
    private String name;
    private String description;
    private Image img;

    public Personnage(Image img,String name, String description){
        this.name=name;
        this.description=description;
        this.img=img;

    }

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

    public void setDescription(String description){
        this.description=description;
    }

    public void setImage(Image img){
        this.img=img;
    }

}
