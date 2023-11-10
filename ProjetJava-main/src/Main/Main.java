package Main;

import java.util.ArrayList;
import Representation.*;
import univers.Statistiques;


public class Main {
     public static void main(String[] args) {

		// instance of InnerNode 
		InnerNode test = new TextNode("Oui !", "<html> L'histoire se déroule dans un royaume médiéval,/ où le prince héritier, un homme bien-aimé du peuple,/ est soudainement suspecté d'avoir assassiné le roi, son propre père,/ afin de s'emparer de la couronne./Malgré son innocence, les preuves semblent accablantes, et il est contraint de fuir pour échapper à la pendaison....", true) ; // balise html a revoir            		
		Node test1 = new TerminalNode("Pas encore ", "<html> A la prochaine alors") ; // balise html a revoir            		
		
		ArrayList<Node> n = new ArrayList<Node>() ;
		
		Node Final = new TerminalNode("Final", "<html> Le test pour le JALON touche à sa fin./ À travers ce test, vous avez pu voir des/ - TextNodes/ - ChooseNodes/ - TerminalNodes/ - ChanceNodes/ Nous vous réservons bien sûr un FightNode qui est actuellement en cours de construction./ Nous espérons que cette petite mise en bouche vous aura plu. /Passez une bonne fin de journée ! /Cette fenêtre va maintenant se fermer automatiquement dans quelques secondes :)");         		
		
		//InnerNode test2 = new InnerNode("The story", "<html> Le prince se cache dans un village voisin,/ espérant rassembler des éléments pour prouver son innocence et rétablir son nom./ Ses amis loyaux, le soigneur compatissant, le chevalier courageux et le magicien astucieux,/ décident de l'aider en menant leur propre enquête pour découvrir la vérité qui le disculpera.", true) ; // balise html a revoir   
		//InnerNode test3 = new InnerNode("The story", "<html> En tant qu'un de ces amis,/ le joueur se retrouve plongé au cœur d'une enquête complexe et dangereuse./ Vous devrez chercher des indices,/ interroger des témoins et déjouer les complots qui visent à incriminer le prince./Il faudra parfois se battre pour défendre vos amis/ des adversaires déterminés à garder le secret./ En chemin,/ vous devrez également surmonter des épreuves aléatoires pour progresser dans votre quête.", true) ; // balise html a revoir            		
		//InnerNode test4 = new InnerNode("The story", "<html> Votre mission sera de prendre les bonnes decisions/ pour rassembler suffisamment de preuves et prouver ou pas /l'innocence du prince et identifier le véritable coupable/ derrière le meurtre du roi./ Le destin du royaume repose entre vos mains./ Vous vous devrez faire preuve de courage,/ de perspicacité et de loyauté/ pour résoudre le mystère de la couronne perdue.", true) ; // balise html a revoir            		
		//InnerNode test5 = new InnerNode("The story", "<html>Il s'agit d'un jeux qui controlera tous les personnages/ Cependant, il faudra neamoins choisir un personnage qui te suivra tout le long du jeux./Voici une breve presentation des personnages(Suivant).", true) ; // balise html a revoir         
		//InnerNode test6 = new InnerNode("The story", "<html> <span><b>Le Magicien Mystique</b></span>/Le Magicien Mystique est le gardien des secrets anciens et des pouvoirs mystérieux./ Il est habillé de robes sombres et ornementées,/son regard est empreint de sagesse./ Avec son bâton magique étincelant,/ il maîtrise les éléments et peut invoquer des sorts envoûtants pour résoudre les énigmes les plus complexes./ Le Magicien est le choix idéal pour ceux qui recherchent la magie/ et la puissance spirituelle pour naviguer dans un monde/ rempli de mystères et de défis.", true) ; // balise html a revoir     
		
		// choices of first chooseNode (Beginning)
		ArrayList <Node> option= new ArrayList<>();
		option.add(test);
		option.add(test1);
			
		
		// choices of chooseNode "Interrogatoire"
		ArrayList <Node> option1= new ArrayList<>();
		option1.add(Final);
		option1.add(Final);
		option1.add(Final);

		//choices of chooseNode "Caserne"
		ArrayList <Node> option2= new ArrayList<>();
		option2.add(Final);
		option2.add(Final);

		// random choice of ChanceNode
		ArrayList <Node> randomNode = new ArrayList<Node>();
		randomNode.add(new ChooseNode("Possibilité 1", "<html>Vous êtes tombés sur la première possibilité ! /Passez une bonne journée !", option1));
		randomNode.add(new ChooseNode("Possibilité 2", "<html>Vous êtes tombés sur la deuxième possibilité ! /Passez une bonne soirée !", option2));
		
		// arrayList of chance node
		ArrayList <Integer> probability = new ArrayList<Integer>();
		probability.add(6);
		probability.add(4);

		//instance of Chance node
		ChanceNode test7 = new ChanceNode("Chance Node", "Le prochain node est déterminé de manière aléatoire !! Retenez votre souffle ....",randomNode, probability);   
        // Lier le TerminalNode "Final" à la fin de test1
	
		

		ArrayList<Node> t = new ArrayList<Node>() ;
		InnerNode test9 = new TextNode("Échec du groupe", "Le groupe a échoué malheureusement mais ce n'est pas grave ! Ce n'est que le premier jalon", false) ;
		InnerNode test10 = new TextNode("Réussite du groupe", "Le groupe a réussi le test ! Vous pouvez être fier d\'eux.", false) ;
		ArrayList<Node> u = new ArrayList<Node>() ;
		u.add(test7) ;
		test9.setOptions(u) ;
		test10.setOptions(u) ;
		TestNode test8 = new TestNode("Test Node", "<html>Le prochain node va être déterminé en faisant un test de force aux personnages du groupe /Celui-ci est basé sur leur statistique de force mais aussi sur une légère part d'aléatoire ... /Vont-ils réussir ?", false, t, Statistiques.STRENGTH, 13, 3) ;
		
		t.add(test10) ;
		t.add(test9) ;
		
		test8.setOptions(t) ;
		
		n.add(test8) ;
		test.setOptions(n) ;
		
		
		// instance of first chooseNode (Begenning)
		Node Beginning = new ChooseNode("Découverte", "<html>Bienvenue dans \"Qui a tué le roi ?\"./ Êtes vous prêts à lancer une nouvelle partie dans ce jeux où vous êtes le heros ?",option);
		Beginning.display();
		
     }

}
