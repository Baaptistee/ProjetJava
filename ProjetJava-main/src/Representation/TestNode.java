package Representation;

import java.util.ArrayList;
import java.util.Objects;
import univers.Statistiques;

/**
 * La classe TestNode représente les nodes dont le node suivant sera déterminé à partir d'un test sur le statistiques des personnages du groupe
 */
public class TestNode extends InnerNode {

    private Statistiques statATester;
    private int difficulteTest;
    private int nombreReussiteNecessaire;

    /**
     * Un constructeur pour la classe 
     * @param nom Le nom du testNode
     * @param description La description du testNode 
     * @param imageName le path de l'image associée
     * @param options La liste des possibilités pour les testNode 
     * @param statATester La statistique à tester 
     * @param difficulteTest la difficulté du test 
     * @param nombreReussiteNecessaire le nombre de succès parmi les personnages du groupe nécessaire pour le réussir 
     */
    public TestNode(String nom, String description, String imageName,ArrayList<Node> options, Statistiques statATester, Integer difficulteTest,int nombreReussiteNecessaire){
        super(nom, description, imageName, options);

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
     * Un constructeur pour la classe 
     * @param nom Le nom du testNode
     * @param description La description du testNode 
     * @param imageName le path de l'image associée
     * @param statATester La statistique à tester 
     * @param difficulteTest la difficulté du test 
     * @param nombreReussiteNecessaire le nombre de succès parmi les personnages du groupe nécessaire pour le réussir 
     */
    public TestNode(String nom,String description,String imageName, Statistiques statATester,Integer difficulteTest, int nombreReussiteNecessaire){
        super(nom, description,imageName);

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
     * Un constructeur pour la classe 
     * @param description La description du testNode 
     * @param imageName le path de l'image associée
     * @param statATester La statistique à tester 
     * @param difficulteTest la difficulté du test 
     * @param nombreReussiteNecessaire le nombre de succès parmi les personnages du groupe nécessaire pour le réussir 
     */
    public TestNode(String description, Statistiques statATester,Integer difficulteTest, int nombreReussiteNecessaire){
        super("Node" + Node.getTotalNode() + 1, description);

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
     * un getter pour le nombre de réussites nécessaire 
     * @return le nombre de réussites nécessaires 
     */
    public int getNombreReussiteNecessaire() {
        return nombreReussiteNecessaire;
    }

    /**
     * Un setter pour le nombre de réussites nécessaires 
     * @param nombreReussiteNecessaire le nouveau nombre de réussites nécessaires
     */
    public void setNombreReussiteNecessaire(int nombreReussiteNecessaire) {
        if(nombreReussiteNecessaire<=0){
            throw new IllegalArgumentException("Le nombre de réussite necessaire ne peut pas être négatif");
        }
        this.nombreReussiteNecessaire = nombreReussiteNecessaire;
    }

    /**
     * un getter pour la statistique à tester
     * @return la statistique à tester 
     */
    public Statistiques getStatATester() {
        return statATester;
    }

    /**
     * Un setter pour la statistique à tester 
     * @param statATester la nouvelle statistique à tester 
     */
    public void setStatATester(Statistiques statATester) {
        this.statATester = statATester;
    }

    /**
     * Un getter pour la difficulté du test
     * @return la difficulté du test 
     */
    public int getDifficulteTest() {
        return difficulteTest;
    }

    /**
     * Un setter pour la difficulté du test
     * @param difficulteTest la nouvelle disfficulté du test 
     */
    public void setDifficulteTest(int difficulteTest) {
         if(difficulteTest<0){
            throw new IllegalArgumentException("La difficulté du test ne peut pas être négatif");
        }
        this.difficulteTest = difficulteTest;
    }

    /**
     * une méthode pour sélectionner le node suivant 
     * @return le node suivant 
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
     * la méthode pour obtenir le node suivant
     * @return le node suivant 
     */
	@Override
	public Node goNext() {
			Node a = this.select() ;
			a.setFormerNode(this);
			return a ;
			
	}
	/**
     * Une méthode pour obtenir l'équivalent en string du node 
     * @return le string du node 
     */
    @Override
    public String toString() {
        return "TestNode" + super.toString();
    }

    /**
     * Une méthode pour savoir si l'objet est égal à un autre 
     * @param obj l'objet à comparer
     * @return si le node est égal ou pas 
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