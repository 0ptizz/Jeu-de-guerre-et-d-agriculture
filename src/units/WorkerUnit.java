package units;
import board.tile.*;
import player.*;
import java.util.*;
import util.Ressources;

public class WorkerUnit extends Unit {

  public WorkerUnit(Player p, Case tile){
    super(p, tile);
  }

  public void produceRessources() {
    if ( this.tile instanceof Desert ) {
      this.player.addRessource(Ressources.Sand, 1);
    }

    if ( this.tile instanceof Forest ) {
      this.player.addRessource(Ressources.Wood,1);
    }

    if ( this.tile instanceof Mountains ) {
      this.player.addRessource(Ressources.Rock,1);
    }

    if ( this.tile instanceof Plain ) {
      this.player.addRessource(Ressources.Wheat,1);
    }
    
  }
// Ajoute le salaire au unite
  public int getSalary() {
    return this.tile.getCost();
  }

  public String toString(){
    return "ouvrier en position (" + tile.getPosX() +", " + tile.getPosY() + ").";
  }
}
