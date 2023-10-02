package univers;

public class Personnage {
	
	private String nom ;
	private String description ;
	
	public Personnage(String nom, String description) {
		this.nom = nom ;
		this.description = description ;
	}
	
	public String getNom() {
		return nom ;
	}
	
	public String getDescription() {
		return description ; 
	}
	
	public void setDescription(String newDescription) {
		this.description = newDescription ;
	}
}
