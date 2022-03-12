package actions;
import player.*;
import board.tile.*;
import units.*;

public abstract class ActionsGlobal {
    protected Player p;

    /** Constructeur d'une action
     *
     * @param p joueur auquel est relié l'action
     */
    public ActionsGlobal(Player p) {
        this.p = p;
    }

    /** Pose une unité sur une case
     *
     * @param c case
     * @param size taille de l'unité
     * @return si l'unité a bien été posée
     */
    public abstract boolean setUnit(Case c, int size);

    /** Le joueur choisit de ne rien faire
     *
     */
    public abstract void nothing();

    /** Donne le salaire aux armées du joueur
     *
     */
    public abstract void salary();

    /** Échange les Ressources du joueur contre de l'or
     *
     */
    public abstract void exchange();

    /** Les unités du joueur lui produise leur ressources
     *
     */
    public abstract void produce();

}