import actions.ActionsGlobal;
import board.*;
import board.tile.*;
import player.*;
import util.Ressources;

import java.util.*;

public abstract class Game{
  protected int nbTours;
  protected Board board;
  protected Map<Player, ActionsGlobal> players;

  /** Créé la partie
   * @param board
   * @param nbTours nombre de tours du jeu
   */
  public Game(Board board, int nbTours){
    this.board = board;
    this.nbTours = nbTours;
    this.players= new HashMap<>();
  }

  /** Ajoute un joueur à la partie
   * @param p joueur à ajouter au jeu
   */
  public abstract void addPlayer(Player p);

  /** Fait tourner le jeu tour par tour, s'arrète lorsque les conditions sont atteintes et affiche le/s gagnant.es.
   *
   */
  public void play(){
    int currentTour = 1;
    boolean boardisempty = false;
    while (currentTour <= nbTours && !boardisempty){
      System.out.println("---------------------- TOUR "+ currentTour + " ----------------------");
      System.out.println("------ Ressources des Joueurs -----");
      printPlayersRessources();
      for (Map.Entry<Player, ActionsGlobal> player : players.entrySet()){
        // manageTurn s'occupe de l'affichage pendant le tour d'une personne
        manageTurn(player.getKey(), player.getValue());
        if (board.nbCasesLibres() == 0) {
          boardisempty = true;
          break;
        }
      }
      System.out.println();
      currentTour++;
    }
    if(boardisempty)
      System.out.println("Il n'y a plus de cases à conquérir !");
    else System.out.println("Les " + nbTours + " tours sont terminés ! La partie est finie.");
    getWinner();
  }

  /** Trouve et affiche qui est/sont le/s gagnant.e/s
   *
   */
  public void getWinner() {
    List<Player> winners = new ArrayList<>();

    for (Player player : players.keySet()) {
      player.setScore(countPoints(player));
      if (winners.isEmpty())
        winners.add(player);
      else {
        Player currentWinner = winners.get(0);
        if (player.getScore() == currentWinner.getScore())
          winners.add(player);
        if (player.getScore() > currentWinner.getScore()) {
          winners.clear();
          winners.add(player);
        }
      }
    }
    System.out.println("------Ressources finales : ------");
    printPlayersRessources();
    System.out.println();
    if (winners.size() == 1)
      System.out.println("Le / la gagnant.e est " + winners.get(0).getName() + " !");
    else{
      System.out.println("Il y a plusieurs gagnant.es à égalité : ");
      for(Player player : winners){
        System.out.println("    -" + player.getName());
      }
    }
  }

  /** Compte les points des joueurs
   *
   * @param player dont il faut compter les points
   * @return Les points de player
   */
  public abstract int countPoints(Player player);


    /** Manages the turn of a player
     * @param current player who's turn it is
     * @param action player's actions
     */
  public abstract void manageTurn(Player current, ActionsGlobal action);

  /** Retourne la n-ième case où le joueur peut poser son unité
   *
   * @param n
   * @return Case
   */
  public Case searchCase(int n){
    for (int i = 0; i < board.getWidth(); i++){
      for (int j =0; j < board.getHeight(); j++){
        Case c = board.getCase(i, j);
        if (n == 0 && !c.isBusy() && !(c instanceof Sea))
          return c;
        if (!c.isBusy() && !(c instanceof Sea))
          n--;
      }
    }
    return null;
  }

  /** affiche les ressources de tous les joueurs
   *
   */
  public void printPlayersRessources(){
    for(Player player : players.keySet()){
      System.out.println(player.getName() + " a :");
      for (Ressources r : Ressources.values()){
        System.out.println("    -" + r.name() + " : " + player.getRessource(r));
      }
    }
  }
}
