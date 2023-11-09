# ProjetJava
Projet Java de Shyrel TOUIL et Baptiste Matrat pour le premier semestre de la 3eme année de licence MIAGE à l'Université Paris Dauphine

DESCRIPTION DES DIFFERENTS PACKAGES :

I. Le package Interface Jeu :

Ce package contient tout ce qui est en rapport avec l'interface graphique du jeu, le travail dessus est loin d'être fini. 
Nous utilisons le module swing pour la réaliser.

II. Le package Représentation :

Ce package contient tout ce qui est en rapport avec la modélisation des Nodes et est constitué des classes suivantes :
- La classe mère abstraite Node qui est la super de toute les classes Nodes suivantes
- La classe InnerNode, qui est utilisée pour les Nodes purement textuels servant de transition entre 2 autres Nodes par exemple, elle affichera toujours le même Node ensuite
- La classe ChooseNode, notre équivalent du DecisionNode de la consigne, où le joueur doit choisir entre plusieurs possibilités qui sont symbolisées par des différents Nodes possibles
- La classe ChanceNode où le nextNode est déterminé aléatoirement entre une Liste de Nodes prédéfinis
- La classe TestNode où une des caractéristiques des membres du groupe sera testée, en cas de réussite, c'est le successNode qui est le nextNode, en cas d'échec, c'est le failureNode
- La classe TerminalNode pour les Nodes de fin d'histoire ou de game Over
- La classe Game qui permet de représenter et de configurer le jeu
- La classe FightNode qui servira à terme pour les combats du jeu, elle est pour l'instant vide ou presque 

II. Le package Univers 

Ce package est lui même constitué de plusieurs sous-package :

A. Le package univers.armes :

Ce package contient tout ce qui est relatif aux armes, il contient les choses suivantes :
- Une enum WeaponTypes qui contient les différents types d'armes possibles, pour l'instant ces types d'armes n'ont pas d'impact autre que des restrictions d'équipement pour les différents membres du groupe.
- La classe Weapon qui est utilisée pour toutes les armes du jeu

B. Le package univers.competences :

Ce package contient tout ce qui est relatif aux compétences, il contient les classes suivantes : 
- La classe abstraite competences qui sera la classe mère de toutes les autres compétences
- La classe abstraite competencesActives, classe fille de competences qui sera la classe mère de toutes les compétences actives du jeu. Il n'y a pas encore de compétences passives mais il est prévu d'en créer dans la suite du développement.
- La classe CompetenceSoin, qui servira pour toutes les compétences de soin du jeu
- La classe CompetenceDammage qui servira pour toutes les compétences d'attaques du jeu

Il est prévu de créer des classes pour avoir des compétences plus variées comme une classe pour des compétences de buffs de statistiques ou encore des classes dédiées pour des compétences plus spécifiques (se protéger par exemple).

C. Le package univers.personnages : 

Ce package contient tout ce qui est relatif aux personnages du jeu, il contient plusieurs classes ainsi qu'un autre sous package pour les personnages du groupe : 
- Une classe mère Personnage qui contient tous les Personnages du Jeu, elle a peut-être vocation à être supprimée car il n'y a pour l'instant aucun autre personnage qui nécessitera d'être instancié autre que des personnages combattants
- Une classe abstraite PersonnageCombattant qui sert pour tous les personnages combattant c'est à dire ceux qui se retrouveront dans les FightNode
- Une classe abstraite fille de PersonnageCombattant, PersonnageAdversaire qui concerne les Personnages qui seront les adversaires dans les FightNode et qui rassemble leurs méthodes spécifiques
- Une classe abstraite PersoGroupe fille de PersonnageCombattant qui concerne les Personnages qui seront dans le groupe du Joueur, elle est la classe mère de toutes les classes servant aux personnages du groupe.
- le package univers.personnages.personnagesGroupe contient les 4 classes Singleton qui représentent les 4 personnages du groupe du joueur

D. Le package univers.Objets :

Ce package contient tout ce qui est relatif aux objets dans le jeu. Il n'y a qu'une Classe Objet qui sera la classe mère de tous les objets. 
Il n'est pas encore très garni mais dans le futur il contiendra des classes filles pour objets plus spécifiques comme des objets de soin par exemple. 

E. Le reste :

Il y a 2 Enum et une Interface qui n'ont pas été placées dans un sous-package spécifique pour l'instant (cela peut être amené à évoluer) :
- Une Enum Statistiques qui contient toutes les Statistiques du Jeu, utilisée notamment pour la fonction TestStat.
- Une Enum Eleme qui contient les différents Éléments du jeu
- Une Interface Collectibles qui servira pour tous les objets du jeu, c'est à dire tout ce qui pourra être obtenu en butin d'un combat ou dans un coffre par exemple. Ces objets auront la possibilité d'être vendu ensuite par exemple

AVANT-GOÛT DE L'HISTOIRE :

Notre histoire se situera dans un monde de Medieval Fantasy. 
Le personnage principal sera un des membres de la Cour d'un Prince accusé d'avoir tué son père le Roi pour prendre le pouvoir, il suivra le Prince dans sa fuite et restera à coté pour mener l'enquête et découvrir la lumière sur cette affaire et possiblement l'innocenter. 
Leur groupe sera composé de 4 ou 5 personnages (pour l'instant 4 mais ce n'est pas encore décidé et fixé) dont au moins un.e Mage, un.e Chevalier.e et un.e Soigneur.euse. (Les design des personnages ne sont pas encore fixés)
Le joueur contrôlera dans les combats l'ensemble des membres du groupe mais en dehors de ceux-ci, il est prévu que les autres membres aient une part de "libre-arbitre", notamment le Prince. 

AMELIORATION DU PROJET A VENIR :

