package player;
import units.ArmyUnit;
import util.Ressources;

public class ArmyPlayer extends Player {
    //Permet de compter le nombre d'unités posées par le joueur, en excluant celles qui ont été conquises
    protected int nbPersonalUnits;

    /** Constructeur d'un joueur du jeu de guerre
     *
     * @param name nom du joueur
     */
    public ArmyPlayer(String name) {
        super(name);
        super.ressources.put(Ressources.Food, 10);
        nbPersonalUnits = 0;
    }

    /** Ajoute un unité a la liste d'unités du joueur et compte cette unité dans nbPersonalUnits
     *
     */
    public void addPersonalUnit(){
        this.nbPersonalUnits++;
    }

    public int getNbPersonalUnits(){
        return nbPersonalUnits;
    }


}