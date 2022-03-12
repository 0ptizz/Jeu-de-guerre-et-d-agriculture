package board;
import board.tile.*;

import java.util.Random;

public abstract class Board {
    protected final int widthX;
    protected final int heightY;
    protected Case[][] tableau;
    private Random rand;

    /** Constructeur du plateau
     *
     * @param x largeur du plateau
     * @param y hauteur du plateau
     */
    public Board(int x, int y) {
        this.widthX = x;
        this.heightY = y;
        tableau = new Case[x][y];

        rand = new Random();

        // environ 2/3 du tableau sont de la mer
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                int r = rand.nextInt(3);
                if (r <= 1)
                    tableau[i][j] = new Sea(i, j);
                else{
                    int test = rand.nextInt(4);
                    setCase(i, j, test);
                }

            }
        }
        checkBoard();
    }

    /** Vérifie si toutes les cases qui sont autre chose que la mer ont au moins une voisine qui n'est pas de la mer
     *
     */
    private void checkBoard(){
        // vérifie les cases sur les côtés
        for (int j = 1; j < this.heightY - 1; j++){
            if (!(tableau[0][j] instanceof Sea) &&
                    tableau[1][j] instanceof Sea &&
                    tableau[0][j - 1] instanceof Sea &&
                    tableau[0][j + 1] instanceof Sea) {
                setCase(0, j, 4);
            }
            if (!(tableau[this.widthX-1][j] instanceof Sea) &&
                    tableau[this.widthX-2][j] instanceof Sea &&
                    tableau[this.widthX-1][j - 1] instanceof Sea &&
                    tableau[this.widthX-1][j + 1] instanceof Sea) {
                setCase(widthX - 1, j, 4);
            }
        }
        for (int i = 1; i < this.widthX - 1; i++){
            if (!(tableau[i][0] instanceof Sea) &&
                    tableau[i][1] instanceof Sea &&
                    tableau[i-1][0] instanceof Sea &&
                    tableau[i+1][0] instanceof Sea) {
                setCase(i, 0, 4);
            }
            if (!(tableau[i][heightY-1] instanceof Sea) &&
                    tableau[i][heightY-2] instanceof Sea &&
                    tableau[i-1][heightY-1] instanceof Sea &&
                    tableau[i+1][heightY-1] instanceof Sea) {
                setCase(i, heightY - 1, 4);
            }
        }
        // vérifie les coins
        if (!(tableau[0][0] instanceof Sea) &&
                tableau[0][1] instanceof Sea &&
                tableau[1][0] instanceof Sea) {
            setCase(0, 0, 4);
        }
        if (!(tableau[this.widthX - 1][0] instanceof Sea) &&
                tableau[this.widthX - 1][1] instanceof Sea &&
                tableau[this.widthX - 2][0] instanceof Sea) {
            setCase(this.widthX - 1, 0, 4);
        }
        if (!(tableau[0][this.heightY -1] instanceof Sea) &&
                tableau[1][this.heightY -1] instanceof Sea &&
                tableau[0][this.heightY -2] instanceof Sea) {
            setCase(0, this.heightY - 1, 4);
        }
        if (!(tableau[this.widthX-1][this.heightY -1] instanceof Sea) &&
                tableau[this.widthX-2][this.heightY -1] instanceof Sea &&
                tableau[this.widthX-1][this.heightY -2] instanceof Sea) {
            setCase(this.widthX-1, this.heightY - 1, 4);
        }

        // vérifie les cases à l'interieur
        for (int i = 1; i < widthX - 1; i++){
            for (int j = 1; j < heightY - 1; j++){
                if (!(tableau[i][j] instanceof Sea) &&
                tableau[i-1][j] instanceof Sea &&
                tableau[i+1][j] instanceof Sea &&
                tableau[i][j-1] instanceof Sea &&
                tableau[i][j+1] instanceof Sea){
                    setCase(i, j, 4);
                }
            }
        }

    }

    /** Créée une case du type associé à casetype
     *
     * @param x position x de la case
     * @param y position y de la case
     * @param caseType type de la case ( 0-> Desert, 1-> Foret, 2-> Montagne, 3-> Plaine, default-> Mer)
     */
    public abstract void setCase(int x, int y, int caseType);

    /** Retourne la hauteur du plateau
     *
     * @return hauteur du plateau
     */
    public int getHeight() {
        return this.heightY;
    }

    /** retourne la largeur du plateau
     *
     * @return largeur du plateau
     */
    public int getWidth() {
        return this.widthX;
    }

    /** retourne la case a la postion (x, y)
     *
     * @param x position x de la case
     * @param y position y de la case
     * @return case a la position (x, y)
     */
    public Case getCase(int x, int y) {
        try {
            return this.tableau[x][y];
        } catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }

    /** Retourne le nombre de cases vides sur lesquelles les joueurs peuvent poser une unité
     *
     * @return nb cases libres
     */
    public int nbCasesLibres(){
        int res = 0;
        for (int i = 0; i < this.widthX; i++){
            for(int j = 0; j < this.heightY; j++){
                if(!tableau[i][j].isBusy() && !(tableau[i][j] instanceof Sea))
                    res++;
            }
        }
        return res;
    }

    /** affiche le plateau dans le terminal
     *
     */
    public void printBoard(){
        for (int i = 0; i < widthX; i++){
            System.out.println();
            for (int j = 0; j < heightY; j++){
                System.out.print(" | " + tableau[i][j].toString());
            }
            System.out.println(" |");
        }
        System.out.println();
    }

}
