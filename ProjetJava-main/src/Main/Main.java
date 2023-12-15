package Main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Interface.InterfaceJeu;
import Representation.*;
import univers.Collectibles;
import univers.Eleme;
import univers.competences.CompetenceDammage;
import univers.competences.CompetencesActives;
import univers.personnages.PersonnageAdversaire;
import univers.personnages.PersonnageCombattant;
import univers.Statistiques;
import univers.Objets.Objets;


public class Main {
     public static void main(String[] args) {

		// Tutoriel : 
		String joueur = Game.getGame().getNomJoueur() ;

		
		InnerNode n1 = new TextNode("??? : "+joueur+"... ! / Réveille-toi !!");
		InnerNode n2 = new ChooseNode("Continuer à dormir", "??? : Aller dêpeche toi on va être en retard !") ;
		InnerNode n3 = new ChooseNode("Continuer à dormir","??? : "+ joueur.toUpperCase()+" !!!!/ RÉVEILLE TOI !!");
		InnerNode n4 = new TextNode("Se réveiller", "??? : Ah enfin tu te décides ... Tu sais pourtant très bien qu'aujourd'hui est un jour important./");
		InnerNode n5 = new TextNode("Leo : Heu t'es sur que ça va ?/Allô la lune ici Leo t'as oublié que la remise des diplômes c'était aujourd'hui ou quoi ?/"+joueur+" : La remise des diplômes ?/Leo : Non mais je rêve ! Tu sais le diplôme de magie pour lequel on sue sang et eau depuis qu'on est gosse ?/C'est enfin le grand jour !!//<em>Les deux garçons se dépêchent d'enfiler leurs tenues et de se diriger vers le hall de la cérémonie.</em>");
		InnerNode n6 = new TextNode("Leo : Woaaah c'est beaucoup plus impressionant en vrai !/ Jeune fille : Ah enfin vous êtes là vous, je pensais que vous n'arriveriez jamais !/Leo : Désolé Anna, C'est "+joueur+" il se l'est joué Belle au bois Dormant ce matin./"+joueur+" : La ferme Leo, j'ai juste eu du mal à dormir hier soir à cause de tes ronflements. /Leo : Dit le mec qui faisait trembler la chambre ce matin .../<em> Les interrompt</em>/Anna : C'est pas bientôt fini vous deux ? Taisez vous ça va bientôt commencer.");
		InnerNode n7 = new TextNode("Le crépuscule enveloppait le château de mystère,/ tandis que "+joueur+", accompagné de son fidèle chevalier, du sage mage et de l'attentionné soigneur,/ décidait de fuir les murs imposants qui avaient été témoins de la tragédie royale./ Les lourdes portes du château s'ouvrirent silencieusement, et l'équipe s'éclipsa dans l'obscurité./ Guidés par l'ombre bienveillante de la nuit,/ "+joueur+" et ses compagnons chevauchèrent à travers les bois embrumés,/ laissant derrière eux les murmures inquiets du château endormi./ ");
		InnerNode n8= new ChooseNode("first choice","La lueur pâle de la lune éclairait leur chemin /alors qu'ils traversaient la forêt,/ cherchant refuge dans l'incertitude du destin qui les attendait./Ils ne savaient pas où leurs pas les conduiraient, /mais le besoin pressant de s'éloigner du château empreint de trahison les guidait./ Ils devaient prendre uen decision:");
		InnerNode n9= new TextNode("Chez Mage", "");
		InnerNode n10= new TextNode("Chez Chevalier", "Guidés par l'ombre bienveillante de la nuit,/ "+joueur+" et ses compagnons chevauchèrent à travers les bois embrumés,/ laissant derrière eux les murmures inquiets du château endormi./le domaine du père du chevalier émergea des ombres./ Une imposante silhouette de château se dressait contre le ciel nocturne,/ éclairée par la douce lueur des lanternes./ La cour intérieure, encadrée par des murailles de pierre solides,/ accueillit les fugitifs avec l'assurance de la loyauté./ Le portail grinça légèrement lorsqu'ils entrèrent,/ mais le silence qui enveloppait le domaine indiquait que leur arrivée n'avait pas été remarquée./ "+joueur+", le chevalier, le mage et le soigneur se dirigèrent vers la résidence principale, où le père du chevalier les attendait,/ ignorant encore les événements qui avaient secoué le royaume. ");
		InnerNode n11= new TextNode("Chez Soigneur", "");
		InnerNode n12 = new TextNode("Dans le hall majestueux du domaine du chevalier,/ le père écouta avec une attention grave le récit du prince et de son équipe./ Les yeux du vieil homme reflétaient l'inquiétude mêlée d'une détermination à défendre l'honneur de son fils et la quête de justice du prince./Cependant, à peine avaient-ils commencé à élaborer leurs plans que les lourds bruits de sabots résonnèrent à l'extérieur./ Les échos de la cavalerie du roi, armée jusqu'aux dents, annonçaient l'arrivée imminente de la garde royale.");
		InnerNode n13= new ChooseNode("second choice","Ils s'echapèrent précipitemment par un chemin secret qui menait à deux chemins différents. L'equipe divisée, ils demandèerent tous en coeur. Prince: Vers lequel allons nous"+joueur+"?");
		InnerNode n14= new TextNode("droite","A pas de loup, ils se precipitèreent dans ce chemin secret sinueu."+joueur+": SPLACH!!/"+joueur+" était tombé, le garde des environt l'avait entendu et se precipita à notre rencontre");
		InnerNode n15= new TextNode("Gauche","");
		FightNode n16= new FightNode("combat 1", "Attention, Deux gardes se précipites vers vous");
		ArrayList<PersonnageCombattant> opponents= new ArrayList<>();
		n16.setXp(150);
		ArrayList<Collectibles> bytin= new ArrayList<Collectibles>() ;
		Collectibles potion = new Objets("Potion de soin") ;
		Collectibles banane = new Objets("Banane") ;
		bytin.add(banane) ;
		bytin.add(potion) ;
		n16.setButin(bytin);
		n16.setOpponents(opponents);
		ArrayList <Eleme> resistances=new ArrayList<>();
		resistances.add(Eleme.FEU);
		resistances.add(Eleme.LUMIERE);
		int [] probaCompetences={7,3};
		ArrayList <CompetencesActives> jeanJacquesC= new ArrayList<>();
		jeanJacquesC.add(new CompetenceDammage("la mort", "rttt", 1, 1,150,1, Eleme.FOUDRE, false, true));
		jeanJacquesC.add(new CompetenceDammage("la mort 2", "2rttt", 0, 1,150,1, Eleme.FOUDRE, false, true));
		//opponents characters
		PersonnageAdversaire n17 = new PersonnageAdversaire("Jean Jacques", "fesf", 5, 4, 0, 3, 3, 7, 10,resistances,resistances, jeanJacquesC,probaCompetences);
		PersonnageAdversaire n18 = new PersonnageAdversaire("Jean Paul", "fecdfsf", 2, 4, 0, 3, 3, 7, 10,resistances ,resistances, jeanJacquesC, probaCompetences);
		opponents.add(n17);
		opponents.add(n18);
		InnerNode n19= new TextNode("foret foret, il pleut c'est la merde on a peur on a froid comment on va vivre MAMANNN");
		InnerNode n20= new ChooseNode("La sorciere", "grrr, on croise une personne bien chelou au plus profond de cette foret. Elle a l'air gentille mais chelou aussi");
		InnerNode n21= new TextNode("J'y vais", "On suit la dame dans sa maison patati patata");
		InnerNode n22= new TextNode("Je crève", "continue à courrir");

		n1.addOption(n2);
		n2.addOption(n4);
		n2.addOption(n3);
		n3.addOption(n4);
		n3.addOption(n2);
		n4.addOption(n5);
		n5.addOption(n6);
		n6.addOption(n7);
		n7.addOption(n8);
		n8.addOption(n9);
		n8.addOption(n10);
		n8.addOption(n11);
		n10.addOption(n12);
		n12.addOption(n13);
		n13.addOption(n14);
		n13.addOption(n15);
		n14.addOption(n16);
		n16.addOption(n19);
		n19.addOption(n20);
		n20.addOption(n21);
		n20.addOption(n22);
		

		


		Game.getGame().setFirstNode(n1) ;
		InterfaceJeu.ecranTitre();

		/* 
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
		FightNode Beginning = new FightNode("Découverte", "Oh non 2 monstres du Lockness sauvages apparaissent !",option);
		ArrayList<PersonnageCombattant> opponents= new ArrayList<>();
		Beginning.setXp(150);
		ArrayList<Collectibles> bytin= new ArrayList<Collectibles>() ;
		Collectibles potion = new Objets("Potion de soin") ;
		Collectibles banane = new Objets("Banane") ;

		bytin.add(banane) ;
		bytin.add(potion) ;
		Beginning.setButin(bytin);
		Beginning.setOpponents(opponents);
		ArrayList <Eleme> faiblesses=new ArrayList<>();
		faiblesses.add(Eleme.FEU);
		faiblesses.add(Eleme.GLACE);
		ArrayList <Eleme> resistances=new ArrayList<>();
		resistances.add(Eleme.FEU);
		resistances.add(Eleme.GLACE);
		int [] probaCompetences={7,3};

		ArrayList <CompetencesActives> locknessC= new ArrayList<>();
		locknessC.add(new CompetenceDammage("la mort", "rttt", 1, 1,150,1, Eleme.FOUDRE, false, true));
		locknessC.add(new CompetenceDammage("la mort 2", "2rttt", 0, 1,150,1, Eleme.FOUDRE, false, true));


		PersonnageAdversaire leMonstreduLockness= new PersonnageAdversaire("LocknessMonster1","hgfjrguerh", 4, 7, 1, 1,1,  5, 20, faiblesses, resistances,locknessC, probaCompetences);
		PersonnageAdversaire leMonstreduLockness2= new PersonnageAdversaire("LocknessMonster2","hgfjrguerh", 4, 7, 1, 1,1,  5, 20, faiblesses, resistances,locknessC, probaCompetences);
		opponents.add(leMonstreduLockness);
		opponents.add(leMonstreduLockness2);
		
		Game.getGame().setFirstNode(Beginning) ;
		InterfaceJeu.ecranTitre();
		*/
		




		
    }



}
