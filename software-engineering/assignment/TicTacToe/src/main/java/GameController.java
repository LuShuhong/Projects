import com.tictactoe.board.GameBoard;
import com.tictactoe.command.Start;
import com.tictactoe.game.Game;
import com.tictactoe.player.Player;
import com.tictactoe.player.PlayerFactory;
import com.tictactoe.strategy.EasyStrategy;
import com.tictactoe.strategy.HardStrategy;
import com.tictactoe.strategy.NormalStrategy;
import com.tictactoe.strategy.Strategy;
import com.tictactoe.command.Start;

import java.util.Locale;
import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
        GameBoard newGameBoard = GameBoard.getInstance();
        PlayerFactory playerFactory = new PlayerFactory();
        Player humanPlayer = playerFactory.getPlayer("human");
        Player aiPlayer = playerFactory.getPlayer("ai");
        Game game = Game.getInstance();
        Strategy strategy;
        Player currentPlayer;

        if(humanPlayer == null || aiPlayer == null) throw new playerNotFoundException("Cannot create player");

        System.out.println("\nWorld's Best Tic-Tac-Toe Game\n");
        System.out.println("Select Difficulty Level(easy/normal/hard)");
        Scanner scanner = new Scanner(System.in);
        String difficulty = scanner.nextLine();
        difficulty = difficulty.toLowerCase();
        System.out.println(difficulty.toUpperCase() + " level selected");

        if(difficulty.equals("easy") ){
            strategy = new EasyStrategy();
        } else if (difficulty.equals("normal")) {
            strategy = new NormalStrategy();
        } else if (difficulty.equals("hard")) {
            strategy = new HardStrategy();
        } else{
            throw new inValidDifficultyException("Please only enter the difficulty level provided");
        }

        aiPlayer.setStrategy(strategy);
        System.out.println("Do you want to play first or second");
        String humanPlayerOrder = scanner.nextLine().toLowerCase();

        if(humanPlayerOrder.equals("first")) currentPlayer = humanPlayer;
        else if (humanPlayerOrder.equals("second")) currentPlayer = aiPlayer;
        else throw new invalidPlayOrderException("Please only enter 'first' or 'second'");

        game.executeCommand(new Start(newGameBoard, humanPlayer,aiPlayer,currentPlayer));

    }

    public static class playerNotFoundException extends RuntimeException {
        public playerNotFoundException(String message){
            super(message);
        }
    }

    public static class inValidDifficultyException extends RuntimeException {
        public inValidDifficultyException(String message){
            super(message);
        }
    }

    public static class invalidPlayOrderException extends RuntimeException {
        public invalidPlayOrderException(String message){
            super(message);
        }
    }
}
