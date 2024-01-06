package com.tictactoe.command;

import com.tictactoe.board.GameBoard;
import com.tictactoe.game.Game;
import com.tictactoe.player.Player;
import com.tictactoe.player.PlayerFactory;

import java.util.Scanner;

public class Start implements Command {
    private GameBoard gameBoard;
    private Player humanPlayer;
    private Player aiPlayer;
    private Player currentPlayer;
    private Game game = Game.getInstance();
    private PlayerFactory playerFactory= new PlayerFactory();

    public Start(GameBoard gameBoard, Player humanPlayer, Player aiPlayer, Player currentPlayer){
        this.gameBoard = gameBoard;
        this.humanPlayer = humanPlayer;
        this.aiPlayer = aiPlayer;
        this.currentPlayer = currentPlayer;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(gameBoard);

        while(!game.isGameEnded()){
            int row = 0;
            int column=0;
            if(currentPlayer == humanPlayer){
                System.out.println("Enter the row you want to place your token");
                String rowToPlay = scanner.nextLine();
                System.out.println("Enter the column you want to place your token");
                String columnToPlay = scanner.nextLine();
                row = Integer.parseInt(rowToPlay);
                column = Integer.parseInt(columnToPlay);
            }
            game.playMove(gameBoard,currentPlayer,row,column);
            System.out.println(gameBoard);
            currentPlayer = (currentPlayer == humanPlayer) ? aiPlayer : humanPlayer;
        }

        if(gameBoard.hasWinner()){
            System.out.println(playerFactory.getPlayerFromPlayerNumber(gameBoard.isWinner()) + " won!");
        } else{
            System.out.println("It's a draw");

        }



    }
}
