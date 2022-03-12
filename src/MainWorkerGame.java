import java.util.Random;
import board.*;
import player.WorkerPlayer;

public class MainWorkerGame {
  public static void main(String[] args) {
    final int NB_TOURS = 6;

    if (args.length < 2){
      System.out.println("Au moins deux joueurs sont requis pour jouer à ce jeu !");
    }
    else{
      WorkerBoard board = new WorkerBoard(10, 10);

      board.printBoard();
      WorkerGame game = new WorkerGame(board, NB_TOURS); //pour le moment le jeu fera 10 tours
      for (int i = 0; i < args.length; i++){
        game.addPlayer(new WorkerPlayer(args[i]));
      }
      game.play();
    }
  }
}
