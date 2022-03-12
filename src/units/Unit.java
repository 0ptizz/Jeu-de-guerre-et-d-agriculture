package units;
import player.*;
import board.tile.*;

public abstract class Unit {
  
    protected Player player;
    protected Case tile;

    /** unit constructor
     * @param p joueur d'appartenance de l'unité
     * @param c case sur laquelle est positionnée l'unité
     */
    public Unit(Player p, Case c){
      this.player = p;
      this.tile = c;
      this.player.addUnit(this);
      this.tile.setPlayer(player);
    }

    /** Retourne le joueur d'appartenance
     * @return joueur d'appartenance
     */
    public Player getPlayer(){
      return this.player;
    }

    /** Retourne la case sur laquelle est positionné l'unité
     * @return case de l'unité
     */
    public Case getCase(){
      return this.tile;
    }

    /**
     * l'unité produit les ressources et les donne au player
     */
    public abstract void produceRessources();

    /** l'unité prend son salaire */
    public abstract int getSalary();

    /** informations sur l'unité
     * @return informations sur l'unité
     */
    public String toString(){
      return "unité en position (" + tile.getPosX() + ", " + tile.getPosY() +")";
    }

    }

