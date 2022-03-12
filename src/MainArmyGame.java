import board.ArmyBoard;
import player.ArmyPlayer;
import player.WorkerPlayer;

import java.util.Random;

public class MainArmyGame {
    public static void main(String[] args) {
        final int NB_TOURS  = 10;



        if (args.length < 2){
            System.out.println("Au moins deux joueurs sont requis pour jouer à ce jeu !");
        }
        else{
            ArmyBoard board = new ArmyBoard(10, 10);
            board.printBoard();
            ArmyGame game = new ArmyGame(board, NB_TOURS); //pour le moment le jeu fera 10 tours
            for (int i = 0; i < args.length; i++){
                game.addPlayer(new ArmyPlayer(args[i]));
            }
            game.play();
        }
    }
}
