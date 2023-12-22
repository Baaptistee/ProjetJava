package Main;
//import Event.*;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map;
import java.util.Map;

//import javax.swing.ImageIcon;


//import javax.print.attribute.TextSyntax;
//import javax.swing.JOptionPane;

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
import univers.Objets.ObjetsDeSoin;
import univers.armes.Weapon;


public class Main {
     public static void main(String[] args) {

		ArrayList<String> persoGroupeImagePath = new ArrayList<>() ;
		for (PersonnageCombattant persoGroupp : Game.getGame().getGroupeJoueur()){
			if (persoGroupp.getImageLien()!=null){
			persoGroupeImagePath.add(persoGroupp.getImageLien());
			}
		}

		// Tutoriel : 
		String joueur = Game.getGame().getNomJoueur() ;
		ArrayList <String> optionn= new ArrayList<>();
		optionn.add("image/MC Mage.png");
		optionn.add("image/Soigneur.png");
/********************************************************** INTRODUCTION ***************************************************************/
		InnerNode n1 = new TextNode("","Dans le royaume enchanté de FantaisieLalalande, le château majestueux se dressait, dominant la paisible contrée. Au sommet de la hiérarchie royale régnait le roi bien-aimé et son épouse, la princesse adorée de tous. Le prince, jeune et ambitieux, partageait avec sa femme des jours heureux au sein de ce lieu empreint de magie et de splendeur.","image/Chatea.jpg");
		InnerNode n2 = new TextNode("","Cependant, une ombre sombre s'abattit soudainement sur cette félicité. Un matin, le château fut secoué par la terrible nouvelle : le roi gisait sans vie dans ses appartements, le sang maculant les murs et les tapisseries. Le choc ébranla la cour et plongea FantaisieLalalande dans une atmosphère de mystère et de suspicion.","image/Chatea.jpg");
		InnerNode n3 = new TextNode("","La nouvelle se répandit comme une traînée de poudre, et rapidement, les regards accusateurs se tournèrent vers le prince. Les murmures des courtisans et des citoyens circulaient dans les couloirs du château comme une sinistre mélodie.	Le prince, accablé par le deuil et la calomnie, se retrouva confronté à des soupçons persistants. Alors même qu'il pleurait la perte de son père, des murmures s'élevaient, jetant une ombre sur son innocence. Les récents désaccords entre le prince et le roi étaient amplifiés, jetant une lumière sinistre sur leur relation.","image/Chatea.jpg") ;
		InnerNode n4 = new TextNode("","Un jour, alors que le prince errait dans les jardins du château, il entendit des murmures sournois provenant des courtisans :/"+"\"Le prince doit être le coupable. Pourquoi d'autre aurait-il tant de querelles avec le roi ?/" + "\"Le pouvoir l'a corrompu, c'est évident. Il était prêt à tout pour monter sur le trône." + "\"Le roi n'aurait jamais été retrouvé mort si le prince ne l'avait pas tué. C'est une évidence !\"","image/Chatea.jpg");
		InnerNode n5 = new TextNode("","Ces insinuations atteignirent leur apogée lorsque la garde royale, sous le commandement de conseillers ambitieux, se mit en chasse du prince, le déclarant suspect numéro un dans la mort du roi. Pris au dépourvu, le prince se retrouva dans une situation désespérée. Face à l'injustice et à la menace qui pesaient sur sa vie, le prince prit une décision audacieuse. Dans le secret de la nuit, il rassembla un groupe hétéroclite de compagnons loyaux : un voleur rusé, un soigneur compatissant et un mage mystérieux. Ensemble, ils s'échappèrent du château, fuyant les gardes déterminés et la colère du peuple.","image/Chatea.jpg");
		InnerNode n6 = new TextNode("","Leur quête était simple mais périlleuse : trouver la vérité derrière la mort du roi et prouver l'innocence du prince.","image/Chatea.jpg");
		InnerNode n7 = new ChooseNode("Êtes-vous pret à demarrer l'aventure","image/Chatea.jpg");
		InnerNode n8 = new TextNode("Je suis prêt(e)","C'est parti !","image/Chatea.jpg");
		Node n9= new TerminalNode("Je ne suis pas prêt(e)","A la prochaine !","image/Chatea.jpg");

/********************************************************** DEBUT **************************************************************/
		
		InnerNode n11 = new ChooseNode("Le prince et ses compagnons fuyaient le château en quête de réponses. Ils atteignirent une clairière éclairée par la lueur de la lune. Là, le groupe se figea, cherchant une solution."+ "Le voleur brisa le silence.\"Cher compagnons, il nous faut des forces. Les Chevaliers et les Soigneurs sont les plus proches. Que choisissons-nous ?\"","image/Chatea.jpg");
		InnerNode n12 = new TextNode("Chez Chevalier", "Le groupe, ayant choisi de se diriger vers le Chevalier, se rendit dans le domaine derrière le château royal. Les arbres formaient une allée menant à la demeure du Chevalier, éclairée par la lueur des torches dans l'obscurité.Le voleur observa attentivement, cherchant d'éventuels pièges. Le mage, silencieux, contempla le ciel étoilé.Devant les grandes portes du domaine, le prince s'adressa à ses compagnons : \"Convainquons le père du Chevalier de notre innocence. Son influence pourrait être cruciale\"./Le groupe pénétra dans le domaine, prêt à confronter le père du Chevalier pour obtenir son soutien dans leur quête pour rétablir la vérité.","image/DansVille.png");
		InnerNode n13 = new TextNode("Chez Soigneur", "C'est à plusieurs lieues d'ici ? Il y a des cheveux YAHHH, direction le désert arabica.","image/mystery-2169794_1280.jpg");

/************************************************************* SOIGNEUR *******************************************************************/
		InnerNode n15S = new TextNode("","Le groupe s'aventura plus loin du château, suivant un sentier sinueux qui les mena finalement à la demeure du Soigneur.Le Soigneur habitait une petite maison entourée de jardins verdoyants. Des herbes aromatiques poussaient en abondance, embaumant l'air d'un parfum apaisant.L'intérieur de la maison était simple mais confortable. Des étagères étaient remplies de potions et d'herbes médicinales. Une ambiance paisible régnait, rompue seulement par le crépitement du feu dans la cheminée.","");
		InnerNode n16S= new TextNode("","Alors que le groupe prenait place, la Soeur du Soigneur parut hésitante. \"Il y a quelque chose que vous devez savoir à propos du duc et de la reine. C'est une histoire délicate, mais la vérité doit éclater.\" Elle révéla alors l'information sur l'aventure entre le duc et la reine, laissant le groupe abasourdi par la complexité des intrigues qui entouraient la cour royale.","image/mystery-2169794_1280.jpg");
		InnerNode n17S= new TextNode("","Soudain, des bruits de bottes retentirent à l'extérieur. La garde royale était sur le point d'entrer dans la maison./ \"Au nom du royaume, vous êtes tous en état d'arrestation pour conspiration contre la couronne !\"/Le Mage, rapide d'esprit, chuchota au groupe :\"Il faut s'échapper pour enquêter chez le duc. C'est notre seule chance de prouver l'innocence du prince.\"","image/mystery-2169794_1280.jpg");
		InnerNode n18S = new ChooseNode("Ils s'échappèrent précipitamment par un chemin secret qui menait à deux portes différents. L'équipe divisée, ils demandèrent tous en chœur. Quelle porte prendre, " + joueur + "?","image/mystery-2169794_1280.jpg");
		InnerNode n19S = new TextNode("Droite", "À pas de loup, ils se précipitèrent dans la foret. " + joueur + ": SPLACH!!/" + joueur + " était tombé, le garde des environs l'avait entendu et se précipita à notre rencontre","image/mystery-2169794_1280.jpg");
		ArrayList<Integer> probabilityy = new ArrayList<Integer>();
		probabilityy.add(7);
		probabilityy.add(3);
		InnerNode n20S = new TestNode("Gauche","Test de force pour l'ouverture de la porte","image/mystery-2169794_1280.jpg", Statistiques.STRENGTH, 4, 2);
		InnerNode n21S = new TextNode("","S'echaper Go duc ","image/mystery-2169794_1280.jpg");
		InnerNode n22S = new TextNode("","Sortie dans la forêt","image/mystery-2169794_1280.jpg");
		
		//Passage du desert
		ArrayList <Integer> probability = new ArrayList<Integer>();
		probability.add(4);
		probability.add(6);
		InnerNode n13S = new ChanceNode("Description désert", probability);
		InnerNode n14S = new TextNode("","Une tempête de sable approche, vous avez tout juste le temps de passer un test de force pour voir si vous pouvez résister ou au contraire vous devrez fuir.","image/mystery-2169794_1280.jpg");

		// FIGHT NODE n15S
		FightNode n15 = new FightNode("Attention au loin, les dangereux de la tribu du désert approchent... YAH YAH affrontons-les","image/knight-3274300_1280.jpg");

		ArrayList<PersonnageCombattant> opponents1= new ArrayList<>();
		n15.setXp(250);
		Map<Collectibles, Integer> bytin1= new HashMap<>() ;
		Collectibles potion = new Objets("Potion trala de soin") ;
		Collectibles banane = new Objets("Banane") ;
		bytin1.put(banane, 4) ;
		bytin1.put(potion, 4) ;
		n15.setButin(bytin1);
		ArrayList <Eleme> resistancess=new ArrayList<>();
		resistancess.add(Eleme.FEU);
		resistancess.add(Eleme.LUMIERE);
		int [] probaCompetences={7,3};
		ArrayList <CompetencesActives> jeanJacquesC= new ArrayList<>();
		jeanJacquesC.add(new CompetenceDammage("la mort", "rttt", 1, 1,150,1, Eleme.FOUDRE, false, true));
		jeanJacquesC.add(new CompetenceDammage("la mort 2", "2rttt", 0, 1,150,1, Eleme.FOUDRE, false, true));
		//PersonnageAdversaire n19S = new PersonnageAdversaire("Jean Jacques", "fesf", 5, 4, 2, 3, 3, 7, 10,resistancess,resistancess, jeanJacquesC,probaCompetences);
		//PersonnageAdversaire n20S = new PersonnageAdversaire("Jean Paul", "fecdfsf", 2, 4, 3, 3, 3, 7, 10,resistancess ,resistancess, jeanJacquesC, probaCompetences);
		PersonnageAdversaire n21 = new PersonnageAdversaire("Jean Paul", "fecdfsf", 2, 4, 4, 3, 3, 7, 10,resistancess ,resistancess, jeanJacquesC, probaCompetences);
		PersonnageAdversaire n22 = new PersonnageAdversaire("Jean Paul", "fecdfsf", 2, 4, 4, 3, 3, 7, 10,resistancess ,resistancess, jeanJacquesC, probaCompetences);
		//opponents1.add(n19S);
		//opponents1.add(n20S);
		opponents1.add(n21);
		opponents1.add(n22);
		n15.setOpponents(opponents1);


		//InnerNode n17S = new TestNode("Test de résistance à la tempête de sable", false, Statistiques.ENDURANCE, 3, 1);
		//InnerNode n18S = new TextNode("Le groupe a échoué. Il n'est pas capable de résister à la tempête. Il faut fuir.","image/mystery-2169794_1280.jpg");
		InnerNode n23 = new TextNode("","Le groupe a réussi le test !","image/mystery-2169794_1280.jpg");
		InnerNode n24S = new TextNode("","Pas le temps de fuir, il est trop tard, la tempête est là. / Mage : Je vais ouvrir une porte magique dans une autre dimension.","image/mystery-2169794_1280.jpg");
		InnerNode n25S = new TextNode("","Affrontement tempête de sable","image/mystery-2169794_1280.jpg");
		InnerNode n28S = new TextNode("","Mage : Bon, on n'ira pas chez toi. C'est plus prudent ici. Prise de décision","image/mystery-2169794_1280.jpg");
		InnerNode n29S = new ChooseNode("choix", "choix de formule pour aller chez le duc","image/mystery-2169794_1280.jpg");
		InnerNode n30S = new TextNode("ABADUDUS EXTREMADUS", "Hmm, ce n'est pas la bonne formule.","image/mystery-2169794_1280.jpg");
		InnerNode n31S = new TextNode("ABABBUDOUS RAMALOXUS", "Hmm, ce n'est pas la bonne formule.","image/mystery-2169794_1280.jpg");
		InnerNode n32S = new TextNode("ABUDUS AJACABADUS", "Bravo, c'était la bonne.","image/mystery-2169794_1280.jpg");
		InnerNode n33S = new TextNode("","Vous avez fait le mauvais choix. Réessayez.","image/mystery-2169794_1280.jpg");
		TextNode n27S = new TextNode("","Go chez Soigneur","image/mystery-2169794_1280.jpg");
		InnerNode n34S = new TextNode("","DÉBAT","image/mystery-2169794_1280.jpg");
		




/******************************************************** CHEVALIER ***********************************************************/
		InnerNode n15C = new TextNode("","Le père du Chevalier expliqua tristement la situation. \"Le roi avait des dettes de jeu, causant des conflits à la cour, surtout avec le duc, son meilleur ami.\"Des rumeurs couraient, affirmant que le roi pillait le royaume et que le château était condamné à la ruine. ","image/DansVille.png");
		InnerNode n16C= new TextNode("","Un débat houleux s'ensuivit :/Le Chevalier : \"Le roi n'aurait jamais fait ça. Il a toujours été un souverain juste et bienveillant.\"/Le Mage : \"Il est peut-être temps de considérer les faits. Si le royaume est en danger, nous devons agir.\"Le Voleur : \"Cherchons la vérité avant de prendre des décisions irréversibles.\"/La mère du Chevalier arriva avec un air préoccupé. \"L'autre fois, j'ai entendu une dispute très grave dans le château. Le roi, ivre, menaçait de mort le duc. Il est possible qu'il ait commis des actes regrettables.\"Le Prince : \"Cela pourrait expliquer les tensions entre le roi et le duc. Le duc aurait des raisons de vouloir la mort du roi pour sa propre protection. Nous devons explorer toutes les possibilités avant de tirer des conclusions.\"", "image/DansVille.png");
		InnerNode n17C= new TextNode("","Soudain, des bruits de bottes retentirent à l'extérieur. La garde royale était sur le point d'entrer dans le château./ \"Au nom du royaume, vous êtes tous en état d'arrestation pour conspiration contre la couronne !\"/Le Voleur, rapide d'esprit, chuchota au groupe : \"Il faut s'échapper pour enquêter chez le duc. C'est notre seule chance de prouver l'innocence du prince.\"","image/DansVille.png");
		InnerNode n18C = new ChooseNode("","Ils s'échappèrent précipitamment par un chemin secret qui menait à deux chemins différents. L'équipe divisée, ils demandèrent tous en chœur. Prince: Vers lequel allons-nous, " + joueur + "?","image/mystery-2169794_1280.jpg");
		InnerNode n19C = new TextNode("droite", "À pas de loup, ils se précipitèrent dans ce chemin secret sinueux. " + joueur + ": SPLACH!!/" + joueur + " était tombé, le garde des environs l'avait entendu et se précipita à notre rencontre","image/mystery-2169794_1280.jpg");
		ArrayList<Integer> probabilityii = new ArrayList<Integer>();
		probabilityy.add(7);
		probabilityy.add(3);
		InnerNode n20C = new ChanceNode("Gauche", "Go Go Go on trace","image/mystery-2169794_1280.jpg",probabilityii);
		InnerNode n21C = new TextNode("","Impasse, c'est là où on fait demi-tour et on prend le chemin de droite","image/mountain-41818_1280.png");
		InnerNode n22C = new TextNode("","Sortie dans la forêt","image/ForetVersLuisant.jpg");
		FightNode n23C = new FightNode("Attention, Deux gardes se précipitent vers vous","image/mountain-41818_1280.png");
		// ArrayList<PersonnageCombattant> opponents= new ArrayList<>();
		// n23C.setXp(150);
		// ArrayList<Collectibles> bytin= new ArrayList<Collectibles>() ;
		// bytin.add(banane) ;
		// bytin.add(potion) ;
		// n23C.setButin(bytin);
		// opponents.add(n19S);
		// opponents.add(n20S);
		// n23C.setOpponents(opponents);
		InnerNode n24C = new TextNode("","La forêt, un labyrinthe d'ombres et de murmures, enveloppe le petit groupe alors qu'ils s'y enfoncent plus profondément. Le chevalier, habitué à des batailles en plein jour, ressent une anxiété grandissante. \"Restons sur nos gardes. Cette forêt cache plus que des arbres.Le voleur, furtif mais aujourd'hui vulnérable, murmure avec inquiétude, \"On dirait que la forêt nous dévore. Comment allons-nous sortir d'ici?\"","image/ForetVersLuisant.jpg");
		InnerNode n25C= new ChooseNode("Alors qu'ils avancent dans l'obscurité, ils distinguent une lumière étrange dans le lointain. Ils s'en approchent prudemment pour découvrir une petite clairière où une sorcière étrange, vêtue de haillons et entourée de mystérieux artefacts, les observe avec des yeux perçants. \"Bienvenue, voyageurs perdus. Vous avez l'air perdu, voulez-vous vous abriter chez moi?\"", "image/ForetPeur.jpg");
		InnerNode n26C = new TextNode("J'y vais", "La sorcière mystérieuse les mène à sa humble demeure, éclairée par des bougies vacillantes et emplie d'herbes aromatiques séchant au plafond. Ils s'installent autour d'une vieille table en bois, échangeant des regards méfiants et curieux. La sorcière, tout en remuant une mixture dans un chaudron, les observe avec une lueur d'amusement dans les yeux.","image/haunted-house-151506_1280.png");
		InnerNode n28C = new ChooseNode("\"J'ai fait de délicieuses friandises. Laquelle voulez vous?\"","image/haunted-house-151506_1280.png");
		InnerNode n29C = new TextNode("Pain aux épices", "Au fur et à mesure que la soirée avance, la conversation dérive vers des sujets plus sérieux. \"Parlez-moi de votre duc,\" demande le prince d'un ton circonspect. \"Nous devons nous rendre chez lui, mais la forêt nous a égarés.La sorcière, sirotant une infusion, révèle avec prudence, \"Le duc est venu me rendre visite récemment. Il cherchait une plante rare, le Valavumdum. Une herbe toxique aux propriétés intrigantes.\"","image/haunted-house-151506_1280.png");
		InnerNode n30C = new TextNode("Velouté de vers de terre", "Au fur et à mesure que la soirée avance, la conversation dérive vers des sujets plus sérieux. \"Parlez-moi de votre duc,\" demande le prince d'un ton circonspect. \"Nous devons nous rendre chez lui, mais la forêt nous a égarés.La sorcière, sirotant une infusion, révèle avec prudence, \"Le duc est venu me rendre visite récemment. Il cherchait une plante rare, le Valavumdum. Une herbe toxique aux propriétés intrigantes.\"","image/haunted-house-151506_1280.png");
		InnerNode n31C = new TextNode("Bouillie de grenouille", "Au fur et à mesure que la soirée avance, la conversation dérive vers des sujets plus sérieux. \"Parlez-moi de votre duc,\" demande le prince d'un ton circonspect. \"Nous devons nous rendre chez lui, mais la forêt nous a égarés.La sorcière, sirotant une infusion, révèle avec prudence, \"Le duc est venu me rendre visite récemment. Il cherchait une plante rare, le Valavumdum. Une herbe toxique aux propriétés intrigantes.\"","image/haunted-house-151506_1280.png");
		InnerNode n32C = new TextNode("Eau", "Au fur et à mesure que la soirée avance, la conversation dérive vers des sujets plus sérieux. \"Parlez-moi de votre duc,\" demande le prince d'un ton circonspect. \"Nous devons nous rendre chez lui, mais la forêt nous a égarés.La sorcière, sirotant une infusion, révèle avec prudence, \"Le duc est venu me rendre visite récemment. Il cherchait une plante rare, le Valavumdum. Une herbe toxique aux propriétés intrigantes.\"","image/haunted-house-151506_1280.png");
		InnerNode n33C=new TextNode("", "Le mage, intrigué, demande, \"Où pourrait-il trouver cette plante ?\"La sorcière, les yeux pétillants de malice, donne quelques indications vagues. Suivez le sentier à l\'est, mais méfiez-vous des illusions. Le duc est un homme rusé, et ses intentions peuvent être aussi sombres que la nuit.Sans se douter de la double nature de leur hôtesse, l'équipe, guidée par ces indices, se prépare à quitter la mystérieuse demeure et à reprendre leur quête à travers la forêt nocturne.", "image/haunted-house-151506_1280.png");
		InnerNode n27C = new TextNode("Pas confiance", "Continue à courir","image/ForetPeur.jpg");
		InnerNode n34C= new FightNode("Soudain, la sorcière dévoile son crapaud géant magique, le lançant contre le groupe. Les yeux de la sorcière brillent d'une lueur maléfique alors qu'elle annonce : \"Il y a une prime pour ceux qui ramènent le prince au château.Le chevalier, réagissant rapidement, dégaine son épée. \"Préparez-vous, elle n'est pas ce qu'elle semble être !\" crie-t-il à ses compagnons.", "image/ForetPeur.jpg");
		InnerNode n35C= new TextNode("","Le jour se lève, dissipant les ombres de la nuit et révélant peu à peu le paysage qui les entoure. L'équipe, encore marquée par le combat avec la sorcière, s'émerge de la forêt. À l'horizon, se dresse majestueusement le château du duc, ses tours imposantes se découpant contre le ciel qui prend des teintes douces","image/ExterieurchateauForet.jpg");
		InnerNode n36C = new TestNode("L'équipe arrive devant l'entrée massive du château, mais une étrange quiétude règne. Aucun signe de vie, aucun murmure de serviteurs ni de bruit de pas dans les couloirs.Le chevalier, pressentant quelque chose d'inhabituel, murmure, \"Le château semble désert. Restez sur vos gardes, mes amis.\"La porte massive du château résiste à leurs premières tentatives pour l'ouvrir. Le chevalier,le voleur, le soigneur avec le mage et le prince, se prépare à un test de force.", Statistiques.STRENGTH, 4, 3);
		InnerNode n37C= new TextNode("", "Ils ont réussi le test force.", joueur);



		
		

	
		ArrayList <Integer> probabilityyi = new ArrayList<Integer>();
		probabilityyi.add(6);
		probabilityyi.add(2);
		probabilityyi.add(2);
	
		InnerNode n24B = new ChanceNode("C'est la détresse", probabilityyi);
	;
		InnerNode n25B = new TextNode("","Je m'enfuis dans la forêt","image/ForetPeur.jpg");
		InnerNode n26B = new TextNode("","Je trouve une cachette","image/ForetPeur.jpg");
		InnerNode n27B = new TextNode("","Elle nous a vus, go fight avec elle","image/ForetPeur.jpg");
		FightNode n31 = new FightNode("La sorcière vous attaque","image/ForetPeur.jpg");

		ArrayList<PersonnageCombattant> opponents2= new ArrayList<>();
		n31.setXp(150);
		ArrayList<Collectibles> bytin2= new ArrayList<Collectibles>() ;
		Collectibles potion2 = new Objets("Potion de soin") ;
		Collectibles banane2 = new Objets("Banane") ;
		bytin2.add(banane2) ;
		bytin2.add(potion2) ;
		// n31.setButin(bytin);
	
		ArrayList <Eleme> resistances2=new ArrayList<>();
		resistances2.add(Eleme.FEU);
		resistances2.add(Eleme.LUMIERE);
		int [] probaCompetences2={6,4};
		ArrayList <CompetencesActives> sorciere= new ArrayList<>();
		sorciere.add(new CompetenceDammage("la mort", "rttt", 1, 1,150,1, Eleme.FOUDRE, false, true));
		sorciere.add(new CompetenceDammage("la mort 2", "2rttt", 0, 1,150,1, Eleme.FOUDRE, false, true));
		PersonnageAdversaire n32 = new PersonnageAdversaire("sorciere", "fesf", 5, 4, 5, 3, 3, 7, 10,resistances2,resistances2, sorciere,probaCompetences2);
		opponents2.add(n32);
		n31.setOpponents(opponents2);
		
		
		
		

		//Introduction
		n1.addOption(n22C);
		n2.addOption(n3);
		n3.addOption(n4);
		n4.addOption(n5);
		n5.addOption(n6);
		n6.addOption(n7);
		n7.addOption(n8);
		n7.addOption(n9);

		//Debut
		n8.addOption(n11);
		n11.addOption(n12);
		n11.addOption(n13);
		

		//Soigneur
		n13.addOption(n15S);
		n15S.addOption(n16S);
		n16S.addOption(n17S);
		n17S.addOption(n18S);
		n18S.addOption(n19S);
		n18S.addOption(n20S);
		n20S.addOption(n21S);
		n20S.addOption(n22S);
		//n20S.addOption(n23C);





		//n13.addOption(n14S);
		

		//Reussite tempete
		//n23S.addOption(n25S);
		n25S.addOption(n27S);
		n27S.addOption(n34S);
		n34S.addOption(n33);

		//Echec tempete
		n18S.addOption(n24S);
		n24S.addOption(n28S);
		n28S.addOption(n34S);
		n34S.addOption(n29S);
		n29S.addOption(n30S);
		n29S.addOption(n31S);
		n29S.addOption(n32S);
		n30S.addOption(n33S);
		n31S.addOption(n33S);
		n33S.addOption(n29S);
		n32S.addOption(n33);



		//chevalier
		n12.addOption(n15C);
		n15C.addOption(n16C);
		n16C.addOption(n17C);
		n17C.addOption(n18C);
		n18C.addOption(n19C);
		n18C.addOption(n20C);
		n20C.addOption(n21C);
		n20C.addOption(n22C);
		n19C.addOption(n22C);
		//n23C.addOption(n33);
		//n21C.addOption(n23C);
		n22C.addOption(n24C);
		n24C.addOption(n25C);
		n25C.addOption(n26C);
		n25C.addOption(n27C);
		n26C.addOption(n28C);
		n28C.addOption(n29C);
		n28C.addOption(n30C);
		n28C.addOption(n31C);
		n28C.addOption(n32C);
		n29C.addOption(n33C);
		n30C.addOption(n33C);
		n31C.addOption(n33C);
		n32C.addOption(n33C);
		




		// n10.addOption(n12);
		// n12.addOption(n13);
		// n13.addOption(n14);
		// n13.addOption(n15);
		// n15.addOption(n155);
		// n15.addOption(n1555);
		// n155.addOption(n19);
		// n1555.addOption(n19);

		// // Fight Node Garde n16
		// n14.addOption(n16);
		// n16.addOption(n19);

		//sorciere 
		// n19.addOption(n20);
		// n20.addOption(n211);
		// n20.addOption(n222);

		//chance Node
		//n22.addOption(n24B);
		n24B.addOption(n25B);
		n24B.addOption(n26B);
		n24B.addOption(n27B);
		//Go ducc
		n25B.addOption(n33);
		n26B.addOption(n33);
		n27B.addOption(n31);

		
		// //n21.addOption(n25);
		// n25.addOption(n26);
		// n26.addOption(n27);
		// n26.addOption(n28);
		// n26.addOption(n29);
		// n26.addOption(n30);

		//fightNode sorciere
		// n27.addOption(n31);
		// n28.addOption(n31);
		// n29.addOption(n31);
		// n30.addOption(n31);
		// //Go ducc
		// n31.addOption(n33);


		
		
		
		

		



		
		
		ArrayList<PersonnageCombattant> opponents8= new ArrayList<PersonnageCombattant>();
		Map<Collectibles, Integer> bytin8= new HashMap() ;
		Collectibles potion8 = new Objets("Potion de mort") ;
		Collectibles banane8 = new Objets("Banane") ;
		

		bytin1.put(banane8, 3) ;
		bytin1.put(potion8, 6) ;
		ArrayList <Eleme> resistancess2=new ArrayList<>();
		resistancess.add(Eleme.FEU);
		resistancess.add(Eleme.LUMIERE);
		int [] probaCompetences8={7,3};
		ArrayList <CompetencesActives> jeanJacquesCtest= new ArrayList<>();
		jeanJacquesCtest.add(new CompetenceDammage("la mort", "rttt", 1, 1,150,1, Eleme.FOUDRE, false, true));
		jeanJacquesCtest.add(new CompetenceDammage("la mort 2", "2rttt", 0, 1,150,1, Eleme.FOUDRE, false, true));
		PersonnageAdversaire n19Stest = new PersonnageAdversaire("Jean Jacques", "fesf", 5, 4, 2, 3, 3, 20, 10,resistancess,resistancess, jeanJacquesCtest,probaCompetences8);
		PersonnageAdversaire n20Stest = new PersonnageAdversaire("Jean Paul", "fecdfsf", 2, 4, 3, 3, 3, 20, 10,resistancess ,resistancess, jeanJacquesCtest, probaCompetences8);
		//PersonnageAdversaire n21Stest = new PersonnageAdversaire("Jean Paul", "fecdfsf", 2, 4, 4, 3, 3, 7, 10,resistancess ,resistancess, jeanJacquesC, probaCompetences8);
		//PersonnageAdversaire n22Stest = new PersonnageAdversaire("Jean Paul", "fecdfsf", 2, 4, 4, 3, 3, 7, 10,resistancess ,resistancess, jeanJacquesC, probaCompetences8);
		n19Stest.setImage("image/Grenouille.png");
		n20Stest.setImage("image/Grenouille.png");

		opponents8.add(n19Stest);
		opponents8.add(n20Stest);
		//opponents8.add(n21Stest);
		//opponents8.add(n22Stest);

		InnerNode nodeTest = new FightNode("FightNode Test !", "Fight Node test !!", "", opponents8, 250, bytin1);
		ArrayList<String> cinqPersonnages = new ArrayList<String>();
		nodeTest.setImageName("image/ForetJolie.png");
		SoinNode soinNode = new SoinNode("Node de soin", "Vos joueurs devraient être soignés je vous invite à aller voir dans le superbe menu statut codé par un mec très bg !");

		nodeTest.addOption(soinNode);
		nodeTest.addOption(n2);

		

		for (int i = 0; i < 4;i++){
			cinqPersonnages.add("image/MC_Mage.png");
		}
		//Liste des images perso

		ArrayList<String> n1I=new ArrayList<>();
		n1I.add("image/Roi.png");
		n1I.add("image/reine.png");
		n1.setImagePersoList(n1I);

		ArrayList<String> n2I=new ArrayList<>();
		n2I.add("image/princeFight.png");
		n2.setImagePersoList(n2I);

		ArrayList<String> n3I=new ArrayList<>();
		//n3I.add("image/prince.png");
		n3I.add("image/SideCharacter.png");
		n3I.add("image/Marchand.png");
		n3.setImagePersoList(n3I);
		n4.setImagePersoList(n3I);

		ArrayList<String> groupeI= new ArrayList<>();
		groupeI.add("image/MC_Mage.png");
		groupeI.add("image/Soigneur.png");
		groupeI.add("image/prince.png");
		groupeI.add("image/chevalier.png");
		groupeI.add("image/voleur.png");
		n5.setImagePersoList(groupeI);
		n7.setImagePersoList(groupeI);

		Weapon arc = new Weapon(7, 100,"ARME TEST", "Un arc solide mais vetuste.", 1, 2, 2, 2, 4);

		// Game.getGame().getInventaire().put(potion8, 2);
		// ObjetsDeSoin potionDeSointest = new ObjetsDeSoin("Potion de soin TEST", 6, 8);
		// Game.getGame().getInventaire().put(potionDeSointest, 4);
		// Game.getGame().getInventaire().put(potion2, 9);
		// Game.getGame().getInventaire().put(potion, 3);
		// Game.getGame().getInventaire().put(arc, 1);

		ObjetNode objeNode = new ObjetNode("Node test", "Le groupe gagne une potion de test de merde");
		Map<Collectibles, Integer> trucAAjouter = new HashMap<Collectibles, Integer>();
		trucAAjouter.put(potion, 2);
		objeNode.setObjets(trucAAjouter);
		ObjetConditionNode conditionNode = new ObjetConditionNode("Node test", "Le prochain node sera déterminé à partir de vos objets hihi", potion);
		conditionNode.addOption(nodeTest);
		conditionNode.addOption(n1);
		objeNode.addOption(conditionNode);


		Game.getGame().setFirstNode(n1) ;
		
		//InterfaceJeu.afficherImageDansInterface("tatata");

		InterfaceJeu.ecranTitre();

		

		/* 
		// instance of InnerNode 
		InnerNode test = new TextNode("Oui !", "<html> L'histoire se déroule dans un royaume médiéval,/ où le prince héritier, un homme bien-aimé du peuple,/ est soudainement suspecté d'avoir assassiné le roi, son propre père,/ afin de s'emparer de la couronne./Malgré son innocence, les preuves semblent accablantes, et il est contraint de fuir pour échapper à la pendaison....","image/mystery-2169794_1280.jpg", true) ; // balise html a revoir            		
		Node test1 = new TerminalNode("Pas encore ", "<html> A la prochaine alors","image/a.jpg") ; // balise html a revoir            		
		

		
		Node Final = new TerminalNode("Final", "<html> Le test pour le JALON touche à sa fin./ À travers ce test, vous avez pu voir des/ - TextNodes/ - ChooseNodes/ - TerminalNodes/ - ChanceNodes/ Nous vous réservons bien sûr un FightNode qui est actuellement en cours de construction./ Nous espérons que cette petite mise en bouche vous aura plu. /Passez une bonne fin de journée ! /Cette fenêtre va maintenant se fermer automatiquement dans quelques secondes :)","image/a.jpg");         		
		
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
		randomNode.add(new ChooseNode("Possibilité 1", "<html>Vous êtes tombés sur la première possibilité ! /Passez une bonne journée !","image/a.jpg", option1));
		randomNode.add(new ChooseNode("Possibilité 2", "<html>Vous êtes tombés sur la deuxième possibilité ! /Passez une bonne soirée !","image/a.jpg", option2));
		
		// arrayList of chance node
		ArrayList <Integer> probability = new ArrayList<Integer>();
		probability.add(6);
		probability.add(4);

		//instance of Chance node
		ChanceNode test7 = new ChanceNode("Chance Node", "Le prochain node est déterminé de manière aléatoire !! Retenez votre souffle ....",randomNode,"image/knight-3274300_1280.jpg", probability);   
        // Lier le TerminalNode "Final" à la fin de test1
	
		

		ArrayList<Node> t = new ArrayList<Node>() ;
		InnerNode test9 = new TextNode("Échec du groupe", "Le groupe a échoué malheureusement mais ce n'est pas grave ! Ce n'est que le premier jalon","image/a.jpg", false) ;
		InnerNode test10 = new TextNode("Réussite du groupe", "Le groupe a réussi le test ! Vous pouvez être fier d\'eux.","image/a.jpg", false) ;
		ArrayList<Node> u = new ArrayList<Node>() ;
		u.add(test7) ;
		test9.setOptions(u) ;
		test10.setOptions(u) ;
		TestNode test8 = new TestNode("Test Node", "<html>Le prochain node va être déterminé en faisant un test de force aux personnages du groupe /Celui-ci est basé sur leur statistique de force mais aussi sur une légère part d'aléatoire ... /Vont-ils réussir ?","image/a.jpg", false, t, Statistiques.STRENGTH, 13, 3) ;
		
		t.add(test10) ;
		t.add(test9) ;
		
		test8.setOptions(t) ;
		
		n.add(test8) ;
		test.setOptions(n);
		
		
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
