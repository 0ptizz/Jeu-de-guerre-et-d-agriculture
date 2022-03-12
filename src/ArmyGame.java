import actions.*;
import board.*;
import board.tile.*;
import player.*;
import units.Unit;
import util.Ressources;

import java.util.Random;

public class ArmyGame extends Game{
    private final static int MAX_UNITS = 35;

    /**
     * Creates the game
     *
     * @param board
     * @param nbTours nombre de tours du jeu
     */
    public ArmyGame(ArmyBoard board, int nbTours) {
        super(board, nbTours);
    }

    /** Ajoute un joueur à la partie
     * @param p joueur à ajouter au jeu
     */
    public void addPlayer(Player p){
        this.players.put(p, new ActionsArmy((ArmyPlayer) p, board));
    }


    /** Manages the turn of a player
     * @param current player who's turn it is
     * @param action player's actions
     * @return if the current player won or not
     */
    public void manageTurn(Player current, ActionsGlobal action) {
        ActionsArmy act = (ActionsArmy) action;
        ArmyPlayer cur = (ArmyPlayer) current;
        System.out.println("C'est le tour de " + current.getName() +" !");
        Random rdm = new Random();
        int id_action = rdm.nextInt(2);
        switch (id_action) {
            case 0:
                System.out.println(current.getName() + " déploie un une armée sur une tuile.");

                if (cur.getNbPersonalUnits() > MAX_UNITS){
                    System.out.println(current.getName() + " a déjà le maximum d'unités déployées qu'il peut avoir ! Il passe donc son tour");
                    break;
                }

                int nextCase = rdm.nextInt(board.nbCasesLibres());
                Case c = searchCase(nextCase);
                int army_size = rdm.nextInt(c.getCapacity()) + 1;
                act.setUnit(c, army_size);

                System.out.println("L'armée est composée de " + army_size + " guerriers et est placée en (" + c.getPosX()
                        + "," + c.getPosY() + ").");
                break;
            case 1:
                System.out.println(current.getName() + " ne fait rien.");
                break;
            default:
                break;
        }

        act.produce();
        act.salary();
        System.out.println();
    }

    public int countPoints(Player player){
        int res = player.getRessource(Ressources.Gold);
        for (Unit unit : player.getUnits()){
            Case c = unit.getCase();
            if(c instanceof Plain)
                res += 1;
            if(c instanceof Forest)
                res += 2;
            if(c instanceof Mountains || c instanceof Desert)
                res += 4;
        }
        // il peut y avoir qu'une seule unité par case
        if (player.getUnits().size() >= 10)
            res += 5;
        System.out.println("Score de " + player.getName() + " : " + res + ".");
        System.out.println("Nombre d'armées encore en vie : " + player.getUnits().size());
        System.out.println();
        return res;
    }

}
