package player;
import java.util.*;
import util.*;
import units.*;

public class Player {

    protected String name;
    protected int score;
    protected Map<Ressources,Integer> ressources;
    protected List<Unit> units;

    /** Constructeur du joueur
     * @param name du joueur
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.ressources = new HashMap<>();
        ressources.put(Ressources.Gold, 0);
        ressources.put(Ressources.Wood, 0);
        ressources.put(Ressources.Wheat, 0);
        ressources.put(Ressources.Sand, 0);
        ressources.put(Ressources.Rock, 0);
        ressources.put(Ressources.Food, 0);
        this.units = new ArrayList<Unit>();
    }

    /**
    * Returns the player Name
    * @return nom du joueur
    */
    public String getName() {
        return this.name;
    }

    /** change le score du joueur
     *
     * @param score score à assigner au joueur
     */
    public void setScore( int score) {
        this.score = score;
    }

    /** Retourne le score du joueur
     *
     * @return score du joueur
     */
    public int getScore() {
        return this.score;
    }

    /** Associe la valeur val à la ressource r
     * 
     * @param r ressource
     * @param val valeur à associer à la ressource
     */
    public void setRessources(Ressources r,int val) {
        this.ressources.put(r,val);
    }

    /** Retourne une ressource en particulier du joueur
     *
     * @param r ressource recherchée
     * @return ressource r du joueur
     */
    public int getRessource(Ressources r){
      return this.ressources.get(r);
    }

    /** Ajoute n à la ressource r
     * 
     * @param r ressource
     * @param n nombre a ajouter
     */
    public void addRessource(Ressources r, int n){
        int actualRes = ressources.get(r);
        ressources.put(r, actualRes + n);
    }

    /** Retourne la liste des unités du joueur
     *
     * @return liste des unités du joueur
     */
    public List<Unit> getUnits() {
        return this.units;
    }

    /** Ajoute une unité à la liste des unités du joueur
     *
     * @param unit uniter à ajouter
     */
    public void addUnit(Unit unit){
        this.units.add(unit);
    }

    /** Supprime une unité de la liste des unités du joueur
     *
     * @param unit unité à supprimer
     */
    public void deleteUnit(Unit unit){
        for (Unit u : this.units){
            if (unit == u) {
                units.remove(unit);
                break;
            }
        }
    }

    /** Teste l'égalité avec un objet
     *
     * @param o
     * @return true si ce sont les memes, false sinon
     */
    public boolean equals(Object o){
        if (o instanceof Player){
          Player other = (Player) o;
          return (this.name == other.getName() && this.score == other.getScore());
        }
        return false;
    }
}
