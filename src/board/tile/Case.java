package board.tile;
import player.*;

public class  Case {

    protected int posX;
    protected int posY;
    protected int capacity;
    protected int cost;
    protected Player player;

    /** constructeur d'une case
     *
     * @param x position en x sur le plateau
     * @param y postion en y sur le plateau
     * @param Cost coût pour une unité
     * @param Capacity capacité max d'unité
     */
    public Case(int x, int y, int Cost, int Capacity){
        posX = x;
        posY = y;
        cost = Cost;
        capacity = Capacity;
        player = null;
    }
    /**
     * @return the index X of this Case
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @return the index Y of this Case
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @return the Player of this Case
     */
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player p) {
      this.player = p;
    }

    /**
     * @return the Capacity of this Case
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return the Cost of this Case
     */
    public int getCost() {
        return cost;
    }

    /**
     * @return <code>true</code> if there is a Playe in this Case
     */
    public boolean isBusy() {
        return !(this.player == null);
    }

    /**
     * @return a description of action
     */
    public String toString() {
        return "Case : ["+posX+"]x ["+posY+"]y";
    }

    public boolean equals(Object o){
        if (o instanceof Case){
          Case other = (Case) o;
          return this.posX == other.getPosX() && this.posY == other.getPosY() && this.player == other.getPlayer() && this.cost == other.getCost() && this.capacity == other.getCapacity();
        }
        return false;
    }

}
