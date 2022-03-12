package board;

import board.tile.*;

public class WorkerBoard extends Board{
    /** constructeur d'un plateau pour le jeu de Ferme
     *
     * @param x largeur du plateau
     * @param y hauteur du plateau
     */
    public WorkerBoard(int x, int y){
        super (x, y);
    }

    /** Créée une case du type associé à casetype
     *
     * @param x position x de la case
     * @param y position y de la case
     * @param caseType type de la case ( 0-> Desert, 1-> Foret, 2-> Montagne, 3-> Plaine, default-> Mer)
     */
    public void setCase(int x, int y, int caseType){
        switch (caseType){
            case 0:
                tableau[x][y] = new Desert(x, y, 3, 1);
                break;
            case 1:
                tableau[x][y] = new Forest(x, y, 1, 1);
                break;
            case 2:
                tableau[x][y] = new Mountains(x, y, 5, 1);
                break;
            case 3:
                tableau[x][y] = new Plain(x, y, 1, 1);
                break;
            case 4:
                tableau[x][y] = new Sea(x, y);
            default:
                break;
        }
    }
}
