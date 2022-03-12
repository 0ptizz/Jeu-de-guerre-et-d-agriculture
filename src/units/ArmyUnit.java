package units;
import player.*;
import board.tile.*;
import util.*;

public class ArmyUnit extends Unit {
    private int size;

    /**Constructeur d'une armée
     *
     * @param p joueur auquel elle appartient
     * @param tile case sur laquelle la poser
     * @param size taille de l'armée
     */
    public ArmyUnit(ArmyPlayer p, Case tile, int size){
      super (p, tile);
      this.size = size;
      p.addPersonalUnit();
    }

    public int getSize() {
        return this.size;
    }

    public void changeSize(int size) {
      this.size = size;
    }

    public void produceRessources() {
      if ( this.tile instanceof Forest )
        this.player.addRessource(Ressources.Wood, 1);
      if ( this.tile instanceof Plain )
        this.player.addRessource(Ressources.Wheat, 1);
    }

    // Retire le nombre ne nourriture necessaire au maintient des troupe
    public int getSalary() {
      int cost = 0;
      if ( this.tile instanceof Desert ) {
        cost = (this.size)*2;
      }
      if ( this.tile instanceof Forest ) {
        cost = this.size;
      }
      if ( this.tile instanceof Mountains ) {
        cost = this.size;
      }
      if ( this.tile instanceof Plain ) {
        cost = this.size;
      }
      return cost;
    }

    public String toString(){
        return "guerrier en position (" + tile.getPosX() + ", " + tile.getPosY() +")";
    }
}
