import com.tictactoe.board.GameBoard;
import com.tictactoe.command.Load;
import com.tictactoe.command.Play;
import com.tictactoe.exception.Exception;
import com.tictactoe.game.Game;
import com.tictactoe.player.Player;
import com.tictactoe.player.PlayerFactory;
import com.tictactoe.strategy.Strategy;

import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        GameBoard newGameBoard = GameBoard.getInstance();
        PlayerFactory playerFactory = new PlayerFactory();
        Player humanPlayer = playerFactory.getPlayer("human");
        Player aiPlayer = playerFactory.getPlayer("ai");
        Strategy strategy;
        Player currentPlayer;

        if(humanPlayer == null || aiPlayer == null) throw new Exception.playerNotFoundException("Cannot create player");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWorld's Best Tic-Tac-Toe Game\n");
        System.out.println("Load an existing game? (yes/no)");

        String isLoad = scanner.nextLine();
        if(isLoad.equalsIgnoreCase("yes")){
            game.executeCommand(new Load());
        } else if (isLoad.equalsIgnoreCase("no")){
            System.out.println("Select Difficulty Level(easy/normal/hard)");
            String difficulty = scanner.nextLine();
            difficulty = difficulty.toLowerCase();

            System.out.println(difficulty.toUpperCase() + " level selected");

            System.out.println("Do you want to play first or second");
            String humanPlayerOrder = scanner.nextLine().toLowerCase();

            if(humanPlayerOrder.equals("first")) currentPlayer = humanPlayer;
            else if (humanPlayerOrder.equals("second")) currentPlayer = aiPlayer;
            else throw new Exception.invalidPlayOrderException("Please only enter 'first' or 'second'");

            game.executeCommand(new Play(game,newGameBoard,difficulty,humanPlayer,aiPlayer,currentPlayer));
        } else{
            throw new RuntimeException("You must enter yes or no");
        }

    }
}
