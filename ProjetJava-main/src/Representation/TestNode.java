package Representation;

import java.util.ArrayList;
import java.util.Objects;
import univers.Statistiques;

/**
 * The TestNode class represents a node in the game that involves testing player statistics.
 * It extends the InnerNode class.
 */
public class TestNode extends InnerNode {

    private Statistiques statATester;
    private int difficulteTest;
    private int nombreReussiteNecessaire;

    /**
     * Constructs a TestNode with the specified parameters.
     *
     * @param nom The name of the TestNode.
     * @param description The description of the TestNode.
     * @param imageName The name of the associated image.
     * @param checkPoint Indicates whether the TestNode is a checkpoint.
     * @param options The list of options available for the TestNode.
     * @param statATester The statistics to be tested.
     * @param difficulteTest The difficulty level of the test.
     * @param nombreReussiteNecessaire The number of successes required for the test.
     */
    public TestNode(String nom, String description, String imageName, boolean checkPoint,ArrayList<Node> options, Statistiques statATester, Integer difficulteTest,int nombreReussiteNecessaire){
        super(nom, description, imageName, checkPoint, options);

        if (difficulteTest == null) {
            throw new IllegalArgumentException("La difficulté du test ne peut pas être null. ");
        }

        if (statATester == null) {
            throw new IllegalArgumentException("La statistique à tester ne peut pas etre null. ");
        }

        if (nombreReussiteNecessaire < 0) {
            throw new IllegalArgumentException("Le nombre de réussite ne peut pas être null. ");
        }

        this.difficulteTest = difficulteTest;
        this.statATester = statATester;
        this.nombreReussiteNecessaire = nombreReussiteNecessaire;
    }

    /**
     * Constructs a TestNode with the specified parameters and generates a default name.
     *
     * @param description The description of the TestNode.
     * @param checkPoint Indicates whether the TestNode is a checkpoint.
     * @param statATester The statistics to be tested.
     * @param difficulteTest The difficulty level of the test.
     * @param nombreReussiteNecessaire The number of successes required for the test.
     */
    public TestNode(String description, boolean checkPoint, Statistiques statATester,Integer difficulteTest, int nombreReussiteNecessaire){
        super("Node" + Node.getTotalNode() + 1, description, checkPoint);

        if (difficulteTest == null) {
            throw new IllegalArgumentException("La difficulté du test ne peut pas être null. ");
        }

        if (statATester == null) {
            throw new IllegalArgumentException("La statistique à tester ne peut pas etre null. ");
        }

        if (nombreReussiteNecessaire < 0) {
            throw new IllegalArgumentException("Le nombre de réussite ne peut pas être null. ");
        }
        this.difficulteTest = difficulteTest;
        this.statATester = statATester;
        this.nombreReussiteNecessaire = nombreReussiteNecessaire;
    }

    /**
     * Gets the number of successes required for the test.
     *
     * @return The number of successes required.
     */
    public int getNombreReussiteNecessaire() {
        return nombreReussiteNecessaire;
    }

    /**
     * Sets the number of successes required for the test.
     *
     * @param nombreReussiteNecessaire The number of successes required.
     */
    public void setNombreReussiteNecessaire(int nombreReussiteNecessaire) {
        if(nombreReussiteNecessaire<=0){
            throw new IllegalArgumentException("Le nombre de réussite necessaire ne peut pas être négatif");
        }
        this.nombreReussiteNecessaire = nombreReussiteNecessaire;
    }

    /**
     * Gets the statistics to be tested.
     *
     * @return The statistics to be tested.
     */
    public Statistiques getStatATester() {
        return statATester;
    }

    /**
     * Sets the statistics to be tested.
     *
     * @param statATester The statistics to be tested.
     */
    public void setStatATester(Statistiques statATester) {
        this.statATester = statATester;
    }

    /**
     * Gets the difficulty level of the test.
     *
     * @return The difficulty level of the test.
     */
    public int getDifficulteTest() {
        return difficulteTest;
    }

    /**
     * Sets the difficulty level of the test.
     *
     * @param difficulteTest The difficulty level of the test.
     */
    public void setDifficulteTest(int difficulteTest) {
         if(difficulteTest<0){
            throw new IllegalArgumentException("La difficulté du test ne peut pas être négatif");
        }
        this.difficulteTest = difficulteTest;
    }

    /**
     * Selects the next node based on the test results.
     *
     * @return The next node.
     */
    public Node select() {
        if (this.getOptions().isEmpty()) {
            throw new IllegalStateException("La liste des options ne peut pas être vide");
        }
            int totalReussite = 0;

            for (int i = 0; i < Game.getGame().getGroupeJoueur().size(); i++) {
                if (Game.getGame().getGroupeJoueur().get(i).testStat(this.getDifficulteTest(), this.getStatATester())) {
                    totalReussite++;
                }
            }
            if (totalReussite >= this.getNombreReussiteNecessaire()) {
                if (this.getOptions().size() >= 1) {
                    return this.getOptions().get(0);
                } else {
                    throw new IndexOutOfBoundsException("L'index de l'option est invalide");
                }
            } else {
                if (this.getOptions().size() >= 2) {
                    return this.getOptions().get(1);
                } else {
                    throw new IndexOutOfBoundsException("L'index de l'option est invalide");
                }
            }
        
    }

    /**
     * Advances to the next node based on the test results.
     */
	@Override
	public Node goNext() {
			Node a = this.select() ;
			a.setFormerNode(this);
			return a ;
			
	}
	/**
     * Returns a string representation of the TestNode.
     *
     * @return A string representation of the TestNode.
     */
    @Override
    public String toString() {
        return "TestNode" + super.toString();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj The reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        TestNode testNode = (TestNode) obj;
        return super.equals(obj) &&
               Objects.equals(this.getStatATester(), testNode.getStatATester()) &&
               Objects.equals(this.getDifficulteTest(), testNode.getDifficulteTest()) &&
               Objects.equals(this.getNombreReussiteNecessaire(), testNode.getNombreReussiteNecessaire());
    }

}