package Main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
		ArrayList <String> optionn= new ArrayList<>();
		optionn.add("image/MC Mage.png");
		optionn.add("image/Soigneur.png");
/********************************************************** INTRODUCTION ***************************************************************/
		InnerNode n0 = new TextNode("Bienvenue dans notre jeu", "Bienvenue dans Enquêtes et Trahisons !/Ce jeu a été réalisé par Shyrel Touil et Baptiste Matrat dans le cadre d'un projet d'étude pour le Premier Semestre de notre L3 MIDO à l'Université Paris Dauphine PSL/Nous espérons que vous passerez un bon moment !//C'est un jeu dont vous êtes le héros donc il vous suffit de cliquer sur les boutons pour découvrir l'histoire !/N'hésitez également pas à explorer notre Menu et ses sous-options !/Pensez également à sauvegarder assez régulièrement ;)", "image/ForetJolie.png");
		InnerNode n1 = new TextNode("","Dans le royaume enchanté de FantaisieLalalande, le château majestueux se dressait, dominant la paisible contrée. Au sommet de la hiérarchie royale régnait le roi bien-aimé et son épouse, la princesse adorée de tous. Le prince, jeune et ambitieux, partageait avec sa femme des jours heureux au sein de ce lieu empreint de magie et de splendeur.","image/Chatea.jpg");
		n0.addOption(n1);
		InnerNode n2 = new TextNode("","Cependant, une ombre sombre s'abattit soudainement sur cette félicité. Un matin, le château fut secoué par la terrible nouvelle : le roi gisait sans vie sur son divan. Le choc ébranla la cour et plongea FantaisieLalalande dans une atmosphère de mystère et de suspicion.","image/Chatea.jpg");
		InnerNode n3 = new TextNode("","La nouvelle se répandit comme une traînée de poudre, et rapidement, les regards accusateurs se tournèrent vers le prince. Les murmures des courtisans et des citoyens circulaient dans les couloirs du château comme une sinistre mélodie.	Le prince, accablé par le deuil et la calomnie, se retrouva confronté à des soupçons persistants. Alors même qu'il pleurait la perte de son père, des murmures s'élevaient, jetant une ombre sur son innocence. Les récents désaccords entre le prince et le roi étaient amplifiés, jetant une lumière sinistre sur leur relation.","image/Chatea.jpg") ;
		InnerNode n4 = new TextNode("","Un jour, alors que le prince errait dans les jardins du château, il entendit des murmures sournois provenant des courtisans :/"+"\"Le prince doit être le coupable. Pourquoi d'autre aurait-il tant de querelles avec le roi ?\"/ \"Le pouvoir l'a corrompu, c'est évident. Il était prêt à tout pour monter sur le trône." + "\"Le roi n'aurait jamais été retrouvé mort si le prince ne l'avait pas tué. C'est une évidence !\"","image/Chatea.jpg");
		InnerNode n5 = new TextNode("","Ces insinuations atteignirent leur apogée lorsque la garde royale, sous le commandement de conseillers ambitieux, se mit en chasse du prince, le déclarant suspect numéro un dans la mort du roi. Pris au dépourvu, le prince se retrouva dans une situation désespérée. Face à l'injustice et à la menace qui pesaient sur sa vie, le prince prit une décision audacieuse. Il rassembla un groupe hétéroclite de compagnons loyaux : un fidèle chevalier,un voleur rusé, un soigneur compatissant et un mage mystérieux. Ensemble, ils s'échappèrent du château, fuyant les gardes déterminés et la colère du peuple.","image/Chatea.jpg");
		InnerNode n6 = new TextNode("","Leur quête était simple mais périlleuse : trouver la vérité derrière la mort du roi et prouver l'innocence du prince.","image/Chatea.jpg");
		InnerNode n7 = new ChooseNode("Êtes-vous pret à demarrer l'aventure","image/Chatea.jpg");
		InnerNode n8 = new TextNode("Je suis prêt(e)","C'est parti !","image/Chatea.jpg");
		Node n9= new TerminalNode("Je ne suis pas prêt(e)","A la prochaine !","image/Chatea.jpg");

/********************************************************** DEBUT **************************************************************/
		
		InnerNode n11 = new ChooseNode("Le prince et ses compagnons fuyaient le château en quête de réponses. Ils atteignirent une clairière éclairée par la lueur de la lune. Là, le groupe se figea, cherchant une solution."+ "Le voleur brisa le silence.\"Cher compagnons, il nous faut des forces. Les Chevaliers et les Soigneurs sont les plus proches. \"Faites un choix pour l'quipe?\"","image/Chatea.jpg");
		InnerNode n12 = new TextNode("Chez Chevalier", "Le groupe, ayant choisi de se diriger vers le Chevalier, se rendit dans le domaine derrière le château royal. Les arbres formaient une allée menant à la demeure du Chevalier.Devant les grandes portes du domaine, le prince s'adressa au chevalier : \"Convainquons ton père de notre innocence. Son influence pourrait être cruciale\"./Le groupe pénétra dans le domaine, prêt à confronter le père du Chevalier pour obtenir son soutien dans leur quête pour rétablir la vérité.","image/DansVille.png");

/******************************************************** CHEVALIER ***********************************************************/
		InnerNode n15C = new TextNode("","Le père du Chevalier expliqua tristement la situation. \"Le roi avait des dettes de jeu, causant des conflits à la cour, surtout avec le duc, son meilleur ami./\"Des rumeurs couraient, affirmant que le roi pillait le royaume et que le château était condamné à la ruine.\" ","image/DansVille.png");
		InnerNode n16C= new TextNode("","Un débat houleux s'ensuivit :/Le Chevalier : \"Le roi n'aurait jamais fait ça. Il a toujours été un souverain juste et bienveillant.\"/Le Mage : \"Il est peut-être temps de considérer les faits. Si le royaume est en danger, nous devons agir.\"/Le Voleur : \"Cherchons la vérité avant de prendre des décisions irréversibles.\"","image/DansVille.png");
		InnerNode n16B=new TextNode("", "La mère du Chevalier arriva avec un air préoccupé. \"L'autre fois, j'ai entendu une dispute très grave dans le château. Le roi, ivre, menaçait de mort le duc. Il est possible qu'il ait commis des actes regrettables.\"Le Prince : \"Cela pourrait expliquer les tensions entre le roi et le duc. Le duc aurait des raisons de vouloir la mort du roi pour sa propre protection. Nous devons explorer toutes les possibilités avant de tirer des conclusions.\"", "image/DansVille.png");
		InnerNode n17C= new TextNode("","Soudain, des bruits de bottes retentirent à l'extérieur. La garde royale était sur le point d'entrer dans le château./ \"Au nom du royaume, vous êtes tous en état d'arrestation pour conspiration contre la couronne !\"/Le Voleur, rapide d'esprit, chuchota au groupe : \"Il faut s'échapper pour enquêter chez le duc. C'est notre seule chance de prouver l'innocence du prince.\"","image/DansVille.png");
		InnerNode n18C = new ChooseNode("","Ils s'échappèrent précipitamment par un chemin secret qui menait à deux chemins différents. L'équipe divisée, ils demandèrent tous en chœur./ \"Quel coté choisir?\" ","image/corridor-6326724_1280.jpg");
		InnerNode n19C = new TextNode("droite", "À pas de loup, ils se précipitèrent dans ce chemin secret sinueux. Voleur : <em>SPLACH!!</em>/ Le voleur était tombé, le garde des environs l'avait entendu et se précipita à notre rencontre","image/corridor-6326724_1280.jpg");
		ArrayList<Integer> probabilite = new ArrayList<Integer>();
		probabilite.add(7);
		probabilite.add(3);
		InnerNode n20C = new ChanceNode("Gauche", "Les échos de leurs pas résonnent dans les couloirs déserts, et ils espèrent échapper à l'attention des gardes qui patrouillent. La fuite, leur seule option, devient une course contre le temps et le destin.","image/corridor-6326724_1280.jpg",probabilite);		
		InnerNode n21C = new TextNode("","Impasse, c'est là où on fait demi-tour et on prend le chemin de droite","image/corridor-6326724_1280.jpg");
		
		FightNode n23C = new FightNode("Attention, Deux gardes se précipitent vers vous","image/corridor-6326724_1280.jpg");
		n23C.setXp(150);
		ArrayList<PersonnageCombattant> opponent= new ArrayList<PersonnageCombattant>();
		Map<Collectibles, Integer> bytin8= new HashMap<>() ;
		Collectibles potion1 = new ObjetsDeSoin("Potion de Vie Mineure", 20, 0) ;
		Collectibles banane1 = new ObjetsDeSoin("Potion de Mana Mineure", 0, 20) ;
		Collectibles arme1 = new Weapon(0, 0, "Épée de fer", "Une épée tranchante en fer", 5, 2, 4, 5, 4);
		Collectibles arme2 = new Weapon(0, 0, "Bâton serti de rubis", "Un bâton magique très puissant", 2, 10, 4, 5, 4);

		int[] proba1 = {2,3,1};

		bytin8.put(banane1, 4) ;
		bytin8.put(arme1,2);
		bytin8.put(potion1, 2) ;
		bytin8.put(arme2, 2);
		n23C.setButin(bytin8);
		ArrayList <Eleme> resistances=new ArrayList<>();
		resistances.add(Eleme.FEU);
		resistances.add(Eleme.LUMIERE);
		ArrayList <CompetencesActives> jeanJacquesCtest= new ArrayList<>();
		jeanJacquesCtest.add(new CompetenceDammage("Attaque à la lance", "rttt", 5, 100,10,1, Eleme.NONE, false, true));
		jeanJacquesCtest.add(new CompetenceDammage("Coup d'épée", "2rttt", 0, 80,5,1, Eleme.NONE, false, true));
		jeanJacquesCtest.add(new CompetenceDammage("Ruée", "2rttt", 3, 80,8,1, Eleme.NONE, true, true));
			
		PersonnageAdversaire jeanJacques = new PersonnageAdversaire("Garde 1", "Bras droit du roi", 5, 4, 2, 3, 3, 30, 10,new ArrayList<>(),new ArrayList<>(), jeanJacquesCtest,proba1);
		PersonnageAdversaire jeanPaul = new PersonnageAdversaire("Garde 2", "Fidèle compagnon du roi", 2, 8, 1, 3, 1, 30, 10,new ArrayList<>() ,new ArrayList<>(), jeanJacquesCtest, proba1);
		jeanJacques.setImage("image/Gardes.png");
		jeanPaul.setImage("image/Gardes.png");
		opponent.add(jeanJacques);
		opponent.add(jeanPaul);
		n23C.setOpponents(opponent);
	
		
		InnerNode n24C = new TextNode("","La forêt, un labyrinthe d'ombres et de murmures, enveloppe le petit groupe alors qu'ils s'y enfoncent plus profondément. Le chevalier, habitué à des batailles en plein jour, ressent une anxiété grandissante. \"Restons sur nos gardes. Cette forêt cache plus que des arbres.Le voleur, furtif mais aujourd'hui vulnérable, murmure avec inquiétude, \"On dirait que la forêt nous dévore. Comment allons-nous sortir d'ici?\"","image/ForetVersLuisant.jpg");
		InnerNode n25C= new ChooseNode("Alors qu'ils avancent dans l'obscurité, ils distinguent une lumière étrange dans le lointain. Ils s'en approchent prudemment pour découvrir une petite clairière où une sorcière étrange, vêtue de haillons et entourée de mystérieux artefacts, les observe avec des yeux perçants. \"Bienvenue, voyageurs perdus. Voulez-vous vous abriter chez moi?\"", "image/ForetPeur.jpg");
		InnerNode n26C = new TextNode("J'y vais", "La sorcière mystérieuse les mène à sa humble demeure, éclairée par des bougies vacillantes et emplie d'herbes aromatiques séchant au plafond. Ils s'installent autour d'une vieille table en bois, échangeant des regards méfiants et curieux. La sorcière, tout en remuant une mixture dans un chaudron, les observe avec une lueur d'amusement dans les yeux.","image/haunted-house-151506_1280.png");
		InnerNode n28C = new ChooseNode("\"J'ai fait de délicieuses friandises. Laquelle voulez vous?\"","image/haunted-house-151506_1280.png");
		InnerNode n29C = new TextNode("Pain d'épices aux yeux de biche", "Au fur et à mesure que la soirée avance, la conversation dérive vers des sujets plus sérieux. \"Parlez-moi de votre duc,\" demande le prince d'un ton circonspect. \"Nous devons nous rendre chez lui, mais la forêt nous a égarés.La sorcière, sirotant une infusion, révèle avec prudence, \"Le duc est venu me rendre visite récemment. Il cherchait une plante rare, le Valavumdum. Une herbe toxique aux propriétés intrigantes.\"","image/haunted-house-151506_1280.png");
		InnerNode n30C = new TextNode("Velouté de vers de terre", "Au fur et à mesure que la soirée avance, la conversation dérive vers des sujets plus sérieux. \"Parlez-moi de votre duc,\" demande le prince d'un ton circonspect. \"Nous devons nous rendre chez lui, mais la forêt nous a égarés.La sorcière, sirotant une infusion, révèle avec prudence, \"Le duc est venu me rendre visite récemment. Il cherchait une plante rare, le Valavumdum. Une herbe toxique aux propriétés intrigantes.\"","image/haunted-house-151506_1280.png");
		InnerNode n31C = new TextNode("Bouillie de grenouille", "Au fur et à mesure que la soirée avance, la conversation dérive vers des sujets plus sérieux. \"Parlez-moi de votre duc,\" demande le prince d'un ton circonspect. \"Nous devons nous rendre chez lui, mais la forêt nous a égarés.La sorcière, sirotant une infusion, révèle avec prudence, \"Le duc est venu me rendre visite récemment. Il cherchait une plante rare, le Valavumdum. Une herbe toxique aux propriétés intrigantes.\"","image/haunted-house-151506_1280.png");
		InnerNode n32C = new TextNode("Eau", "Au fur et à mesure que la soirée avance, la conversation dérive vers des sujets plus sérieux. \"Parlez-moi de votre duc,\" demande le prince d'un ton circonspect. \"Nous devons nous rendre chez lui, mais la forêt nous a égarés.La sorcière, sirotant une infusion, révèle avec prudence, \"Le duc est venu me rendre visite récemment. Il cherchait une plante rare, le Valavumdum. Une herbe toxique aux propriétés intrigantes.\"","image/haunted-house-151506_1280.png");
		InnerNode n33C=new TextNode("", "Le mage, intrigué, demande, \"Où pourrait-il trouver cette plante ?\"/La sorcière, les yeux pétillants de malice, donne quelques indications vagues. /\"Suivez le sentier à l\'Est, mais méfiez-vous des illusions. Le duc est un homme rusé, et ses intentions peuvent être aussi sombres que la nuit.\"/Sans se douter de la double nature de leur hôtesse, l'équipe, guidée par ces indices, se prépare à quitter la mystérieuse demeure et à reprendre leur quête à travers la forêt nocturne.", "image/haunted-house-151506_1280.png");
		InnerNode n27C = new TextNode("Pas confiance", " Les ombres des arbres les enveloppent rapidement alors qu'ils courent, espérant échapper à la sorcière mystérieuse. La forêt dense devient leur alliée, dissimulant leur fuite tandis qu'ils s'éloignent de la clairière où la confrontation a eu lieu. ","image/ForetPeur.jpg");		
		FightNode n34C= new FightNode("Soudain, la sorcière dévoile son crapaud géant magique,sifle sa chauve souris,et libere sa plante carnivor. Les yeux de la sorcière brillent d'une lueur maléfique alors qu'elle annonce : \"Il y a une prime pour ceux qui ramènent le prince au château.\"/Le chevalier, réagissant rapidement, dégaine son épée. \"Préparez-vous, elle n'est pas ce qu'elle semble être !\" crie-t-il à ses compagnons.", "image/ForetPeur.jpg");
		n34C.setXp(125);
		ArrayList<PersonnageCombattant> opponent2= new ArrayList<PersonnageCombattant>();
		Map<Collectibles, Integer> bytin9= new HashMap<>() ;
		Collectibles potion2 = new ObjetsDeSoin("Potion de Vie Mineure", "Une petite potion de soin qui rend 20 points de Mie", 20, 0) ;
		Collectibles banane2 = new ObjetsDeSoin("Potion de Mana Majeure", "Une petite potion de soin qui rend 20 points de Mana", 0, 20) ;
		bytin9.put(banane2, 4) ;
		bytin9.put(potion2, 2) ;
		n34C.setButin(bytin8);
		ArrayList <Eleme> resistances1=new ArrayList<>();
		resistances1.add(Eleme.FEU);
		resistances1.add(Eleme.LUMIERE);
		//ArrayList <CompetencesActives> competence3= new ArrayList<>();
		ArrayList <CompetencesActives> competence2= new ArrayList<>();
		ArrayList <CompetencesActives> competence1= new ArrayList<>();

		competence1.add(new CompetenceDammage("Miasmes Toxiques", "rttt", 5, 90,10,1, Eleme.TENEBRE, false, true));
		competence1.add(new CompetenceDammage("Attaque de Magie noire", "2rttt", 10, 90,10,1, Eleme.TENEBRE, true, false));
		competence1.add(new CompetenceDammage("Coup de Griffe", "rttt", 0, 90,8,1, Eleme.NONE, false, true));
		
		competence2.add(new CompetenceDammage("Coup de Griffe", "rttt", 0, 90,8,1, Eleme.NONE, false, true));
		competence2.add(new CompetenceDammage("Ruée", "2rttt", 10, 90,8,1, Eleme.NONE, true, true));
		competence2.add(new CompetenceDammage("Crachat Toxique", "2rttt", 5, 90,10,1, Eleme.NONE, false, true));
		

		PersonnageAdversaire sorciere = new PersonnageAdversaire("Sorcière", "fesf", 5, 5, 5, 10, 5, 50, 20,new ArrayList<>(),new ArrayList<>(), competence1,proba1);
		
		PersonnageAdversaire crapeau = new PersonnageAdversaire("Crapadudus", "fecdfsf", 2, 4, 3, 3, 3, 20, 10,new ArrayList<>() ,new ArrayList<>(), competence2, proba1);
		PersonnageAdversaire chauveSouris = new PersonnageAdversaire("Chasouradus", "fecdfsf", 2, 4, 3, 3, 3, 20, 10,new ArrayList<>() ,new ArrayList<>(), competence2, proba1);
		PersonnageAdversaire carnivor= new PersonnageAdversaire("Carnivodus", "fecdfsf", 2, 4, 3, 3, 3, 20, 10,new ArrayList<>() ,new ArrayList<>(), competence2, proba1);
		sorciere.setImage("image/Sorciereforet.png");
		crapeau.setImage("image/Grenouille.png");
		chauveSouris.setImage("image/ChauveSouris.png");
		carnivor.setImage("image/Plantecarnivore.png");
		opponent2.add(sorciere);
		opponent2.add(crapeau);
		opponent2.add(chauveSouris);
		opponent2.add(carnivor);
		n34C.setOpponents(opponent2);
		InnerNode n35C= new TextNode("","Le jour se lève, dissipant les ombres de la nuit et révélant peu à peu le paysage qui les entoure. L'équipe, encore marquée par le combat avec la sorcière, s'émerge de la forêt. À l'horizon, se dresse majestueusement le château du duc, ses tours imposantes se découpant contre le ciel qui prend des teintes douces","image/ExterieurchateauForet.jpg");
		InnerNode n36C = new TestNode("","L'équipe arrive devant l'entrée massive du château, mais une étrange quiétude règne. Aucun signe de vie, aucun murmure de serviteurs ni de bruit de pas dans les couloirs.Le chevalier, pressentant quelque chose d'inhabituel, murmure, \"/Le château semble désert. Restez sur vos gardes, mes amis.\"/La porte massive du château résiste à leurs premières tentatives pour l'ouvrir. Le chevalier,le voleur, le soigneur avec le mage et le prince, se prépare à un test de force.","image/ExterieurchateauForet.jpg", Statistiques.STRENGTH, 12, 3);
		InnerNode n37C= new TextNode("", "Le groupe a réussi le test force.", "image/ExterieurchateauForet.jpg");		ArrayList<Integer>probabilité=new ArrayList<>();
		probabilité.add(8);
		probabilité.add(2);
		InnerNode n37B= new ChanceNode("","Le groupe a échoué au test de force","image/ExterieurchateauForet.jpg",probabilité);		
		Node n38B = new TerminalNode("", "Les gardes, arrivant pour interroger le duc dans le cadre de l'enquête, surprennent le prince devant la porte de la demeure du Duc. C'est un tournant tragique, marquant la fin du jeu pour le prince qui est finalement capturé. Le destin semble scellé alors que le prince doit faire face à une condamnation à mort par pendaison, prévue pour le lendemain. La tension et la désolation s'installent parmi le groupe, mettant en évidence l'ampleur de l'injustice qui plane sur eux. ", "image/ExterieurchateauForet.jpg");
		InnerNode n39B= new TextNode("", "Devant cet échec, ils décident de contourner la maison pour accéder au jardin. Les regards inquiets s'échangent parmi le groupe alors qu'ils se dirigent vers une autre entrée, espérant trouver une issue à travers le jardin du duc.", "image/ai-generated-7819202_1280.jpg");		InnerNode n38C= new SoinNode("", "Le soigneur, conscient de l'épuisement après le combat et les efforts pour ouvrir la porte, propose de prendre un moment pour se ressourcer. \"Nous devrions recharger nos batteries avant d'explorer davantage le château. Asseyons-nous un moment, mes amis.\"","image/ai-generated-7819202_1280.jpg");
		InnerNode n39C= new TextNode("", "Le prince et son équipe explorent le château, cherchant des indices pour résoudre le mystère qui les entoure. Chacun examine différents éléments, des portraits aux documents, à la recherche d'informations cruciales. Le soigneur repère des empreintes fraîches, suggérant une présence récente. Ensemble, ils espèrent trouver des réponses qui les guideront vers la vérité et l'innocence du prince.","image/ai-generated-7819202_1280.jpg");
		InnerNode n40C= new TestNode("", "En fouillant le jardin près de la forêt, l'équipe découvre une plante qui ressemble étrangement au Valavumdum. Le Mage va faire un test d'intelligence", "image/ExterieurchateauForet.jpg", Statistiques.INTELLIGENCE, 40, 2);
		
		InnerNode n41C= new TextNode("","Le Mage ayant réussit son test, s'exclame haut et fort, \"C'est le Valavuldum ! Le duc a menti sur la nature de sa quête.\"./L'équipe, soulagée d'avoir enfin mis la main sur l'objet de la quête du duc, se prépare à confronter celui-ci avec cette découverte inattendue. Ils redoublent d'efforts pour rassembler toutes les pièces du puzzle et élucider le mystère qui les a entraînés dans cette aventure complexe.","image/ExterieurchateauForet.jpg");		
		InnerNode n42B= new TextNode("", "Le groupe n'a pas réussi le test d'intelligence. Cette plante n'est pas celle recherchée", "image/ExterieurchateauForet.jpg");
		Node n42C= new TerminalNode("", "Le Prince, avec la preuve du Valavuldum en main, décide de se rendre au chateau. La vérité éclate, le duc avoue ses mensonges et sa machination. Face à ses actes, la justice est rendue. Le prince, désormais libre de toute accusation, voit la vérité triompher. Cependant, la sentence pour le duc est sévère, la justice imposant la pendaison pour ses actions malveillantes. La lumière de la vérité a dissipé les ombres de l'injustice, mais elle a également révélé la noirceur cachée derrière les murs du château. La quête du prince se termine par sa rédemption et la justice impartiale.", "image/ExterieurchateauForet.jpg");
		InnerNode n43C= new TextNode("","Soudain, la cuisinière qui revenait du marché les surprend en train de fouiller dans le jardin du duc. Son visage s'illumine de surprise et d'incompréhension. Elle décide simplement de prévenir les gardes et le duc de la situation." , "image/ExterieurchateauForet.jpg");
		InnerNode n44C= new TextNode("", "Le groupe se hâte discrètement à travers les allées, cherchant un chemin qui les ramènera à la sécurité de la forêt. Le suspense monte alors qu'ils évitent les regards curieux des gardes et des autres employés.", "image/ExterieurchateauForet.jpg");
		Node n45C= new TerminalNode("", "Le groupe réalise avec horreur que leur tentative d'évasion a été trop tardive. Le duc, accompagné des gardes, les surprend avant qu'ils n'aient pu atteindre la sécurité. Le prince est capturé, et un verdict hâtif est prononcé : il sera pendu le lendemain pour trahison.Le désespoir s'empare du prince et de ses compagnons. Ils comprennent que le duc est prêt à tout pour maintenir son mensonge et dissimuler la vérité. La nuit qui s'ensuit est sombre et chargée d'incertitudes, laissant le destin du prince suspendu à un file.", "image/ExterieurchateauForet.jpg");
		ObjetNode objetNode = new ObjetNode("Node test", "Le soigneur récupere quelques branches en tant que preuve","image/ExterieurchateauForet.jpg");
		Map<Collectibles, Integer> preuve = new HashMap<Collectibles, Integer>();
		Collectibles valavumdum = new Objets("Valavumdum", "La plante empoisonnée qui a tué le Roi !") ;
		preuve.put(valavumdum, 1);
		objetNode.setObjets(preuve);
		ObjetConditionNode conditionNode = new ObjetConditionNode("Node test", "Elles se retrouent stockées dans l'inventaire pour être préservées.","image/ExterieurchateauForet.jpg", valavumdum);		
		conditionNode.addOption(n42C);
		conditionNode.addOption(n43C);
		objetNode.addOption(conditionNode);
	
		ArrayList <Integer> probabilite2 = new ArrayList<Integer>();
		probabilite2.add(7);
		probabilite2.add(3);
		InnerNode n24B = new ChanceNode("","Le groupe, fuyant précipitamment la sorcière, est pris de terreur. Leurs pas résonnent dans la forêt obscurcie par la nuit, chaque bruissement de feuilles et chaque ombre mouvante accentuant leur angoisse. ", "image/ForetPeur.jpg",probabilite2);
		InnerNode n25B = new TextNode("","Le groupe réussit à semer la sorcière et à s'échapper de la forêt. Une lueur de soulagement traverse leurs visages tandis qu'ils quittent rapidement l'obscurité des bois, laissant la menace mystique derrière eux.","image/ForetPeur.jpg");
		InnerNode n27B = new TextNode("","Le groupe tente de s'enfuir, mais la sorcière les surprend par hasard. Un frisson d'effroi parcourt le groupe alors qu'ils se rendent compte qu'ils n'ont pas réussi à échapper à l'attention de la sorcière. La course désespérée se transforme en une confrontation soudaine, la sorcière apparaissant à un moment inopportun, prête à les affronter","image/ForetPeur.jpg");		
		

		//Introduction
		n1.addOption(n2);
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

		//chevalier
		n12.addOption(n15C);
		n15C.addOption(n16C);
		n16C.addOption(n16B);
		n16B.addOption(n17C);
		n17C.addOption(n18C);
		n18C.addOption(n19C);
		n18C.addOption(n20C);
		n20C.addOption(n21C);
		n20C.addOption(n24C);
		n19C.addOption(n23C);
		n23C.addOption(n24C);
		n21C.addOption(n23C);
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
		n33C.addOption(n34C);
		n34C.addOption(n35C);
		n35C.addOption(n36C);
		n36C.addOption(n37C);
		n37C.addOption(n38C);
		n27C.addOption(n24B);
		n24B.addOption(n25B);
		n25B.addOption(n35C);
		n24B.addOption(n27B);
		n38C.addOption(n39C);
		n39C.addOption(n40C);
		n40C.addOption(n41C);
		n40C.addOption(n42B);
		n42B.addOption(n43C);
		n43C.addOption(n44C);
		n44C.addOption(n45C); //terminal Node
		n41C.addOption(objetNode);
		objetNode.addOption(conditionNode);
		conditionNode.addOption(n42C);
		n36C.addOption(n37B);
		n37B.addOption(n38B);
		n37B.addOption(n39B);
		n39B.addOption(n40C); //Terminal Node
		n27B.addOption(n34C);
		



		// Listes image Personnages
		ArrayList<String> n1I=new ArrayList<>();
		n1I.add("image/Roi.png");
		n1I.add("image/reine.png");
		n1.setImagePersoList(n1I);

		ArrayList<String> n2I=new ArrayList<>();
		n2I.add("image/princeFight.png");
		n2.setImagePersoList(n2I);
		n42C.setImagePersoList(n2I);

		ArrayList<String> groupeI= new ArrayList<>();
		groupeI.add("image/MC_Mage.png");
		groupeI.add("image/Soigneur.png");
		groupeI.add("image/prince.png");
		groupeI.add("image/chevalier.png");
		groupeI.add("image/voleur.png");
		n5.setImagePersoList(groupeI);
		n7.setImagePersoList(groupeI);
		n6.setImagePersoList(groupeI);
		n11.setImagePersoList(groupeI);
		n12.setImagePersoList(groupeI);
		n18C.setImagePersoList(groupeI);
	
		n24C.setImagePersoList(groupeI);
		n36C.setImagePersoList(groupeI);
		n39B.setImagePersoList(groupeI);
		n38C.setImagePersoList(groupeI);
		n39C.setImagePersoList(groupeI);
		n44C.setImagePersoList(groupeI);
		n24B.setImagePersoList(groupeI);
		n25B.setImagePersoList(groupeI);

		ArrayList<String> n15CI= new ArrayList<>();
		n15CI.add("image/Marchand.png");
		n15C.setImagePersoList(n15CI);
		ArrayList<String> n16CI= new ArrayList<>();
		n16CI.add("image/SideCharacter.png");
		n16B.setImagePersoList(n16CI);

		ArrayList<String> n45CI= new ArrayList<>();
		n45CI.add("image/Duc.png");
		n45CI.add("image/Gardes.png");
		n45C.setImagePersoList(n45CI);

		ArrayList<String> n25CI = new ArrayList<>();
		n25CI.add("image/Sorciereforet.png");
		n25C.setImagePersoList(n25CI);
		n26C.setImagePersoList(n25CI);
		n33C.setImagePersoList(n25CI);
		n27B.setImagePersoList(n25CI);
		

		ArrayList<String> n29CI = new ArrayList<>();
		n29CI.add("image/biennial-1299851_1280.png");
		n29C.setImagePersoList(n29CI);;
		n30C.setImagePersoList(n29CI);
		n31C.setImagePersoList(n29CI);
		n32C.setImagePersoList(n29CI);
		n40C.setImagePersoList(n29CI);
		n41C.setImagePersoList(n29CI);
		n42B.setImagePersoList(n29CI);
		objetNode.setImagePersoList(n29CI);


		
		Game.getGame().setFirstNode(n0) ;
		InterfaceJeu.ecranTitre();

	}
}