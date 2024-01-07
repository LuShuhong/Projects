import com.tictactoe.board.GameBoard;
import com.tictactoe.command.StartGame;
import com.tictactoe.exception.Exception;
import com.tictactoe.game.Game;
import com.tictactoe.player.Player;
import com.tictactoe.player.PlayerFactory;
import com.tictactoe.strategy.EasyStrategy;
import com.tictactoe.strategy.HardStrategy;
import com.tictactoe.strategy.NormalStrategy;
import com.tictactoe.strategy.Strategy;

import java.time.LocalDateTime;
import java.util.Scanner;

public class GameController {
    public static void main(String[] args) {
        Game game = Game.getInstance();
        GameBoard newGameBoard = GameBoard.getInstance();
        PlayerFactory playerFactory = new PlayerFactory();
        Player humanPlayer = playerFactory.getPlayer("human");
        Player aiPlayer = playerFactory.getPlayer("ai");


        if(humanPlayer == null || aiPlayer == null) throw new Exception.playerNotFoundException("Cannot create player");

        game.executeCommand(new StartGame(game,newGameBoard,humanPlayer,aiPlayer));

    }
}
