package univers.personnages;

public class PersonnageCombattant extends Personnage{
	private int level ; 
	private int strength ;
	private int intelligence ;
	private int dexterity ;
	private int lifePoints ;
	private int maxLifePoints ;
	private boolean alive ;
	private int endurance ; 
	
	
	public PersonnageCombattant(String nom, String description, int dexterite, int force, int intelligence, int endurance, int maxLifePoints) {
		super(nom, description) ;
		this.dexterity = dexterite ;
		this.intelligence = intelligence ; 
		this.strength = force ;
		this.level = 1 ;
		this.maxLifePoints = maxLifePoints ;
		this.lifePoints = maxLifePoints ;
		this.endurance = endurance ; 
		this.alive = true ;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public int getStrength() {
		return strength;
	}


	public void setStrength(int strengh) {
		this.strength = strengh;
	}


	public int getIntelligence() {
		return intelligence;
	}


	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}


	public int getDexterity() {
		return dexterity;
	}


	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}


	public int getEndurance() {
		return endurance;
	}


	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}


	public int getLifePoints() {
		return lifePoints;
	}


	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}


	public int getMaxLifePoints() {
		return maxLifePoints;
	}


	public void setMaxLifePoints(int maxLifePoints) {
		this.maxLifePoints = maxLifePoints;
	}


	public boolean isAlive() {
		return alive;
	}


	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public boolean enVie() {
		
		if (this.getLifePoints() <= 0) {
			this.setAlive(false);
		}
		return this.isAlive() ;
	}
	
	// une méthode pour s'assurer que le personnage n'overheal pas 
	public void noOverHeal() {
		if (this.getLifePoints() >= this.getMaxLifePoints()) {
			this.setLifePoints(this.getMaxLifePoints()) ;
		}
	}
	
	// une méthode pour faire subir des dégâts à nos personnages 
	public void dammage(int dammage) {
		// les dégats sont réduits par l'endurance 
		int a = dammage - (endurance/2) ;
		// on veut que nos personnages subissent au moins 1 dégât 
		if (a <= 0) {
			a = 1 ;
		}
		
		this.setLifePoints(this.getLifePoints() - a) ;
		this.setAlive(this.enVie()) ;
	}
	
	// une méthode pour soigner les personnages
	public void heal(int heal) {
		this.setLifePoints(this.getLifePoints() + heal) ;
		this.noOverHeal(); 
		
	}
	
}
