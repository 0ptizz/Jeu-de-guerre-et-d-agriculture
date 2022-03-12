package actions;
import board.tile.*;
import player.*;
import units.*;
import util.Ressources;

import java.util.Iterator;

public class ActionsWorker extends ActionsGlobal{

    /** Constructeur d'une action
     *
     * @param p joueur auquel est relié l'action
     */
    public ActionsWorker(Player p) {
        super(p);
    }

    /** Pose une unité sur une case
     *
     * @param c case
     * @param size taille de l'unité
     * @return si l'unité a bien été posée
     */
    public boolean setUnit(Case c, int size) {
      if (!c.isBusy()) {
          WorkerUnit unit = new WorkerUnit(this.p, c);
          return true;
      }
      else {
          return false;
      }
    }

    /** Action de ne rien faire pendant le tour
     *
     */
    public void nothing() {
        for (Unit uni : this.p.getUnits()) {
          if (uni.getCase() instanceof Forest || uni.getCase() instanceof Plain) {
              this.p.addRessource(Ressources.Gold,1);
          }
          if (uni.getCase() instanceof Desert) {
              this.p.addRessource(Ressources.Gold,2);
          }
        }
        salary();
    }

    /** Donne le salaire aux armées du joueur
     *
     */
    public void salary() {
      int gold = this.p.getRessource(Ressources.Gold);
      Iterator<Unit> it = this.p.getUnits().listIterator();

      while (it.hasNext()){
        Unit uni = it.next();
        int cost = uni.getSalary();
        gold = gold - cost;
        if ( gold < 0) {
          this.p.setRessources(Ressources.Gold,0);
          it.remove();
          System.out.println(p.getName() + " ne peut pas payer son " + uni + ", il démissionne.");
        }
        else
            this.p.setRessources(Ressources.Gold, gold);
      }
    }

    /** Échange les Ressources du joueur contre de l'or
     *
     */
    public void exchange() {
        if (this.p.getRessource(Ressources.Wheat)>=1){
          int res = (this.p.getRessource(Ressources.Wheat))*2;
          this.p.addRessource(Ressources.Gold,res);
          this.p.setRessources(Ressources.Wheat,0);
        }
        if (this.p.getRessource(Ressources.Wood)>=1){
          int res = (this.p.getRessource(Ressources.Wood))*2;
          this.p.addRessource(Ressources.Gold,res);
          this.p.setRessources(Ressources.Wood,0);
        }
        if (this.p.getRessource(Ressources.Rock)>=1){
          int res = (this.p.getRessource(Ressources.Rock))*8;
          this.p.addRessource(Ressources.Gold,res);
          this.p.setRessources(Ressources.Rock,0);
        }
        if (this.p.getRessource(Ressources.Sand)>=1){
          int res = this.p.getRessource(Ressources.Sand)*5;
          this.p.addRessource(Ressources.Gold, res);
          this.p.setRessources(Ressources.Sand,0);
        }
      }

    /** Les unités du joueur lui produise leur ressources
     *
     */
    public void produce(){
      for ( Unit uni : this.p.getUnits()) {
        uni.produceRessources();
      }
    }
}
