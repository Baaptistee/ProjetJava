package univers;


public class PersoGroupe extends Personnage {
	private int niveau ; 
	private int experience ;
	private int force ;
	private int intelligence ;
	private int dexterite ;
	private int vie ;
	
	public PersoGroupe(String nom, String description, int dexterite, int force, int intelligence, int vie) {
		super(nom, description) ;
		this.dexterite = dexterite ;
		this.intelligence = intelligence ; 
		this.force = force ;
		this.niveau = 1 ;
		this.experience = 0 ;
		this.vie = vie ; 
	}
	
	public int getNiveau() {
		return niveau;
	}


	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public int getForce() {
		return force;
	}


	public void setForce(int force) {
		this.force = force;
	}


	public int getIntelligence() {
		return intelligence;
	}


	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}


	public int getDexterite() {
		return dexterite;
	}


	public void setDexterite(int dexterite) {
		this.dexterite = dexterite;
	}


	public int getVie() {
		return vie;
	}


	public void setVie(int vie) {
		this.vie = vie;
	}

	// une fonction qui gère le gain d'XP
	public void gainExperience(int xp) {
		
		experience += xp ; 
		// si il y a assez d'expérience 
		if (this.getExperience() >= this.getNiveau()*10 + 90) {
			//On appelle la fonction gain de niveau 
			this.gainNiveau() ;
			// on réinitialise l'expérience enlevant celle qui a servi au gain de niveau 
			this.setExperience(getExperience() - (getNiveau()*10 + 90)) ;
		}
	}
	// la fonction gain de niveau sera override dans chacune des classes filles parce que chaque personnage va gagner de l'expérience différemment
	public void gainNiveau() {
		
	}
	
	
	
}
