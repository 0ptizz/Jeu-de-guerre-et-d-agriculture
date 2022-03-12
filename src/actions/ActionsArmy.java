package actions;
import player.*;
import board.*;
import board.tile.*;
import units.*;
import util.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActionsArmy extends ActionsGlobal{
    Board board;

    /** Constructeur d'une action
     *
     * @param p joueur auquel est relié l'action
     */
    public ActionsArmy(ArmyPlayer p, Board board) {
        super(p);
        this.board = board;
    }

    /** Pose une unité sur une case
     *
     * @param c case
     * @param size taille de l'unité
     * @return si l'unité a bien été posée
     */
    public boolean setUnit(Case c,int size) {
      if (!c.isBusy()) {
          ArmyUnit unit = new ArmyUnit((ArmyPlayer) this.p, c, size);
          conquest(unit);
          return true;
      }
      else {
          System.out.println("La case est déjà occupée.");
          return false;
      }
    }

    /** Action de ne rien faire pendant le tour
     *
     */
    public void nothing() {
      salary();
      exchange();
    }

    /** Donne le salaire aux armées du joueur
     *
     */
    public void salary() {
      int food = this.p.getRessource(Ressources.Food);
      Iterator<Unit> it = this.p.getUnits().listIterator();

      while(it.hasNext()) {
        ArmyUnit unit = (ArmyUnit) it.next();
        int size = unit.getSize();
        if ( unit.getCase() instanceof Desert) {
          food -= 2*size;
        }
        else {
          food -= size;
        }
        if ( food < 0) {
          this.p.setRessources(Ressources.Food,0);
          it.remove();
          this.p.addRessource(Ressources.Gold,1);
          System.out.println(p.getName() + " n'a pas assez de nourriture pour nourrir son " + unit + " Elle meurt donc dans d'atroces souffrances");
          System.out.println("La mort de ses guerriers lui rapporte 1 pièce d'or.");
        }
        else
            p.setRessources(Ressources.Food, food);
      }
    }

    /** Échange les Ressources du joueur contre de l'or
     *
     */
    public void exchange() {
        if (this.p.getRessource(Ressources.Wheat)>=1){
          int res = (this.p.getRessource(Ressources.Wheat))*5;
          this.p.addRessource(Ressources.Food,res);
          this.p.setRessources(Ressources.Wheat,0);
        }
        if (this.p.getRessource(Ressources.Wood)>=1){
          int res = this.p.getRessource(Ressources.Wood);
          this.p.addRessource(Ressources.Food,res);
          this.p.setRessources(Ressources.Wood,0);
        }
      }

    /** Les unités du joueur lui produise leur ressources
     *
     */
    public void produce(){
      for (Unit uni : this.p.getUnits()) {
        uni.produceRessources();
      }
    }

    /** L'unité conquiert les cases adjacentes à la sienne
     *
     * @param uni unité
     */
    private void conquest(ArmyUnit uni) {
        System.out.println("L'unité tente de conquérir les terres adjacentes.");
        /* parametre de la case du uni*/
        int x = uni.getCase().getPosX();
        int y = uni.getCase().getPosY();
        int size = uni.getSize();

        /* case autour de uni */
        List<Case> conq = new ArrayList<Case>();
        Case nord = board.getCase(x-1,y);
        conq.add(nord);
        Case ouest = board.getCase(x,y-1);
        conq.add(ouest);
        Case sud = board.getCase(x+1,y);
        conq.add(sud);
        Case est = board.getCase(x,y+1);
        conq.add(est);

        /* actions du conquest */
        for (Case cas : conq) {
            if ( cas == null || cas.getPlayer() == null)
                continue;

            Player autre = cas.getPlayer();
            int sizeAutre = 0;
            ArmyUnit unitAutre = null;
            for ( Unit unit : autre.getUnits()) {
                if (unit.getCase().equals(cas)) {
                    ArmyUnit unitt = (ArmyUnit) unit;
                    sizeAutre = unitt.getSize();
                    if (unit.getCase() instanceof Mountains)
                        sizeAutre += 2;
                    unitAutre = unitt;
                    break;
                }
            }
            if (unitAutre == null)
                continue;
            if ( sizeAutre < size && !autre.equals(this.p)) {
                if (sizeAutre == 1) {
                    this.p.addUnit(unitAutre);
                    cas.setPlayer(this.p);
                    autre.deleteUnit(unitAutre);
                    this.p.addRessource(Ressources.Gold,2);
                    System.out.println("L'armée de " + autre.getName() + " en position (" + cas.getPosX()+", "+cas.getPosY()+
                            ") s'est rendue ! Elle appartient désormais à " + p.getName());
                    System.out.println(p.getName() + " gagne 2 pièces d'or !");
                }
                else {
                    unitAutre.changeSize(sizeAutre / 2);
                    System.out.println("L'armée de " + p.getName() + " attaque celle de " + autre.getName() + "!!!");
                    System.out.println("L'armée de "+autre.getName()+" s'en sort avec la moitié de sa garnison encore en vie.");
                }
            }
            else {
                unitAutre.changeSize(sizeAutre+1);
                this.p.addRessource(Ressources.Gold,1);
                System.out.println("L'armée de " + p.getName() + " renforce ses troupes de 1 à la position (" + unitAutre.getCase().getPosX() +"," +unitAutre.getCase().getPosY()+") !!!");
                System.out.println(p.getName() + " gagne 1 pièces d'or !");
            }
        }
    }
}
