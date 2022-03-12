# l2s4-projet-2021

# Equipe

- Remi Dewame
- Axel Roelants
- Anouk Bachelet

# Sujet

[Le sujet 2021](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)

# Livrables

## Livrable 1

Pour ce premier livrable, nous avons travaillé sur la modélisation des personnages.
Pour la modéliser nous proposons une classe Personnage (potentiellement abstraite), Ouvrier et Armée (qui hériteraient de Personnage).

Personnage aura donc comme attributs :

	- protected int cost
	- protected Player player
	- protected Case case

et pour méthodes :

	- Personnage(Player p) : void
	- getPlayer() : Case
	- getCase() : Player
	- setCase(Case c) : void
	- toString() : String
	- produceRessources() : int
	- giveSalary() : int

Personnage aura comme méthodes :

	- Personnage(Player p) : void
	- setCase(Case c) : void
	- toString() : String
	- produceRessources() : int
	- giveSalary() : int

Et Armée aura comme attribut :

	- private int taille

et pour méthodes :

	- Armée(Player p,int taille) : void
	- conquer(Case c) : void
	- produceRessources() : int
	- giveSalary() : int
	- toString() : String
	- getTaille() : int
	- setTaille(int n) : void
	- addSoldier(int n) : void

### Difficultés restant à résoudre

## Livrable 2
Pour ce second livrable, nous avons travaillé sur la modélisation du plateau. Pour la modéliser nous proposons une classe Board et une interface Case (avec 5 classes de chaque type de case qui implémenterons Case).

Board aura donc comme attributs :

	- private int widthX
	- private int heightY
	- private Case[][] tableau

et pour méthodes :

	- Board(int width,int height) : void
	- getHeight() : int
	- getWidth() : int
	- getCase(int x, int y) : Case
	- isFull() : boolean

Case aura comme attributs :

	- private int PosX
	- private int PosY
	- private Player player
	- capacity int
	- cost int

et aura comme méthodes :

	- getPosX() : int
	- getPosY() : int
	- getPlayer() : Player
	- getCapacity() : int
	- getCost() : int
	- isBusy() : boolean
	- toString() : String

Et les 5 classes :

	- PlainCase
	- SeaCase
	- DesertCase
	- ForestCase
	- MountainCase
Implémenterons les méthodes et attributs de Case.
### Atteinte des objectifs

### Difficultés restant à résoudre
Il y aura sans doute d'autres méthodes à ajouter à Board et à Case.
## Livrable 3
Pour ce troisième livrable, nous avons travaillé sur la modélisation des actions des personnages. Pour la modéliser nous proposons une classe Game (qui aura le role d'enclencher les actions de chaque joueur, à chaque tour) et GameMain (qui lancera une partie, avec un nombre de joueur donner et le type de partie souhaité).

Game aura donc comme attributs :

	- private List<Player> players
	- private Board board
	- private int TypeGame
	- private int nbTours

et comme méthodes :

	- Game(Board b, int nbtours) : void
	- addPlayer(PLayer p) : void
	- play() : void
	- manageTurn(Player current) : boolean

Et GameMain aura comme unique méthode :

	- main(String[] args) : void

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 4
L'UML du livvrable 4 est dans le dossier livrable sous format png.
Il y a eu egalement l'ajout des classes Actions qui n'avaient pas été modélisé au livrable 3.

ActionsGlobal est une classe abstraite qui aura comme attribut :

	- protected PLayer p
	
et pour methodes :

	- ActionsGlobal(Player p)
	- setUnit() : void
	- nothing() : void
	- salary() : void
	- exchange() : void

Et les classes ActionsWorker et ActionsArmy heriterons de la classe ActionsGlobal pour completer les methodes abstraites de cette derniere.

### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

## Semaine 1
- Création d'un exel où l'on peut travailler ensemble en ligne.
- Début de la création de personnage sur exel et sur papier.

## Semaine 2
- Finalisation de la modélisation des personnages.
- Début de la création des classes Player.

## Semaine 3
- Début de la création des classes Plateau.
- Création en cours des classes Player.
- Tout ça en UML, sur papier et sur exel.

## Semaine 4
- Finalisation de la modélisation du plateau.
- Tentative d'UML global.
- Et début de code pour les classes en rapport avec personnage.

## Semaine 5
- Début de la modélisation du Game et GameMain
- Normalement, la modélisation de Game et GameMain accomplie
- Construction du code pour certaines classes du projet
- changement de l'interface Case.java en classe et des cases qui l'implementaient en classe qui en herite
## Semaine 6
- Création des classes Player et Case
## Semaine 7
- Création des tests unitaires
- classe WorkerPlayer complétée
- rajout de fonctions equals et set/get dans certaines classes
- classe WorkerUnit complétée 
- ajout de Food dans Ressources

## Semaine 8
- Création des classes Actions  
- Construction du Board

## Semaine 9
- Construction des classes Actions  
- Construction du Board

## Semaine 10
- Construction des classes Actions  
- Construction du Board  
- Changement d'un attribut dans Player(Unit) en List<Unit>

## Interruption pédagogique de printemps
- Board changé en classe abstraite afin de pouvoir gérer la capacité et le prix d'une case en fonction du type de jeu  
- Board terminé  
- test Case complété  
- Construction des actions et des tests  
- Création de deux MainGame : 
    - MainWorkerGame pour le jeu de développement agricole
    - MainArmyGame pour le jeu de guerre
- Makefile commencé  
- Écriture de la documentation

## Semaine 11
- MainWorkerGame et MainArmyGame sont complets  
- Continuation des tests  
- Game et ses fonctions héréditaires sont complètes  
- Correction de fonctions qui n'étaient pas encore testées  

## Semaine 12
- Jeu agricole fonctionnel
- Ajout de make agricole.jar et make guerre.jar
- Finition des tests
- Correction de quelques bugs
- Création UML final (Final.png)
- Projet fini !
