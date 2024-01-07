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

import java.util.Scanner;

public class Play implements Command {
    private Game game;
    private GameBoard gameBoard;
    private Player humanPlayer;
    private Player aiPlayer;
    private Player currentPlayer;
    private String difficulty;
    private Strategy strategy;
    private PlayerFactory playerFactory= new PlayerFactory();


    public Play(Game game, GameBoard gameBoard, String difficulty, Player humanPlayer, Player aiPlayer, Player currentPlayer){
        this.game = game;
        this.gameBoard = gameBoard;
        this.difficulty = difficulty;
        this.humanPlayer = humanPlayer;
        this.aiPlayer = aiPlayer;
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void execute() {
        if(difficulty.equals("easy") ){
            strategy = new EasyStrategy();
        } else if (difficulty.equals("normal")) {
            strategy = new NormalStrategy();
        } else if (difficulty.equals("hard")) {
            strategy = new HardStrategy();
        } else{
            throw new Exception.inValidDifficultyException("Please only enter the difficulty level provided");
        }

        Scanner scanner = new Scanner(System.in);
        aiPlayer.setStrategy(strategy);
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
