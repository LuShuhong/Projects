package com.tictactoe.command;

import com.tictactoe.board.GameBoard;
import com.tictactoe.exception.Exception;
import com.tictactoe.game.Game;
import com.tictactoe.player.Player;
import com.tictactoe.player.PlayerFactory;
import com.tictactoe.strategy.EasyStrategy;
import com.tictactoe.strategy.HardStrategy;
import com.tictactoe.strategy.NormalStrategy;
import com.tictactoe.strategy.Strategy;
import com.tictactoe.command.Save;

import java.util.Scanner;

public class StartGame implements Command {
    private Game game;
    private GameBoard gameBoard;
    private Player humanPlayer;
    private Player aiPlayer;
    private Player currentPlayer;
    private Strategy strategy;
    private PlayerFactory playerFactory= new PlayerFactory();


    public StartGame(Game game,GameBoard gameBoard, Player humanPlayer, Player aiPlayer){
        this.game = game;
        this.gameBoard = gameBoard;
        this.humanPlayer = humanPlayer;
        this.aiPlayer = aiPlayer;
    }

    @Override
    public void execute() {
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
            throw new Exception.inValidDifficultyException("Please only enter the difficulty level provided");
        }

        aiPlayer.setStrategy(strategy);
        System.out.println("Do you want to play first or second");
        String humanPlayerOrder = scanner.nextLine().toLowerCase();

        if(humanPlayerOrder.equals("first")) currentPlayer = humanPlayer;
        else if (humanPlayerOrder.equals("second")) currentPlayer = aiPlayer;
        else throw new Exception.invalidPlayOrderException("Please only enter 'first' or 'second'");

        System.out.println(gameBoard);

        while(!game.isGameEnded()){
            int row = 0;
            int column=0;
            if(currentPlayer == humanPlayer){
                System.out.println("Enter the row you want to place your token (or type 'save' to save the current game status)");
                String rowToPlay = scanner.nextLine();
                if(rowToPlay.equalsIgnoreCase("save")){
                    game.executeCommand(new Save(gameBoard));
                    break;
                }
                row = Integer.parseInt(rowToPlay);
                System.out.println("Enter the column you want to place your token");
                String columnToPlay = scanner.nextLine();
                column = Integer.parseInt(columnToPlay);
            }
            game.playMove(gameBoard,currentPlayer,row,column);
            System.out.println(gameBoard);
            currentPlayer = (currentPlayer == humanPlayer) ? aiPlayer : humanPlayer;
        }

        if(gameBoard.hasWinner()){
            System.out.println(playerFactory.getPlayerFromPlayerNumber(gameBoard.isWinner()) + " won!");
        } else if(gameBoard.isBoardFull()){
            System.out.println("It's a draw");
        }
    }
}
