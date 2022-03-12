import actions.*;
import board.WorkerBoard;
import board.tile.*;
import player.*;
import util.Ressources;

import java.util.Random;

public class WorkerGame extends Game{

    /**
     * Créé le jeu
     *
     * @param board   Plateau de jeu
     * @param nbTours nombre de tours du jeu
     */
    public WorkerGame(WorkerBoard board, int nbTours) {
        super(board, nbTours);
    }

    /** Ajoute un joueur à la partie
     * @param p joueur à ajouter au jeu
     */
    public void addPlayer(Player p){
        this.players.put(p, new ActionsWorker(p));
    }

    public int countPoints(Player player){
        System.out.println("Score de " + player.getName() + " : " + player.getRessource(Ressources.Gold) + ".");
        return player.getRessource(Ressources.Gold);
    }


    /** Gère le tour d'un joueur
     * @param current joueur qui joue à ce tour
     * @param action actions liées au joueur
     */
    public void manageTurn(Player current, ActionsGlobal action) {
        System.out.println("--- C'est le tour de " + current.getName() +" ! ---");
        Random rdm = new Random();
        int id_action = rdm.nextInt(2);
        switch (id_action) {
            case 0:
                System.out.println(current.getName() + " déploie un ouvrier sur une tuile.");
                int nextCase = rdm.nextInt(board.nbCasesLibres());
                Case c = searchCase(nextCase);
                if(c != null) {
                    action.setUnit(c, 1);
                    System.out.println("Son ouvrier est déployé en position (" + c.getPosX() + "," + c.getPosY() + ").");
                }
                break;
            case 1:
                System.out.println(current.getName() + " échange ses ressources pour de l'or.");
                action.exchange();
                break;
            default:
                System.out.println(current.getName() + "ne fait rien.");
                break;
        }
        action.produce();
        action.salary();
        System.out.println();

    }

}
