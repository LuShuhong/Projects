package com.tictactoe.player;

import com.tictactoe.board.GameBoard;
import com.tictactoe.strategy.Strategy;

public class AiPlayer implements Player{
    private int playerNumber = 2;
    private Strategy strategy;

    public AiPlayer(){
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    private int[] executeStrategy(GameBoard gameBoard){
        return strategy.decideMove(gameBoard);
    }

    @Override
    public void makeMove(GameBoard gameBoard, int xCoordinate, int yCoordinate) {
        //ignoreXCoordinate and yCoordinate passed in
        int [] cellToPlay = executeStrategy(gameBoard);
        int cellToPlayXCoordinate = cellToPlay[0];
        int cellToPlayYCoordinate = cellToPlay[1];
        //Should it be controlled by Game class instead? Intuitively, players make move on the game board?
        gameBoard.markCell(playerNumber,cellToPlayXCoordinate,cellToPlayYCoordinate);
    }

    @Override
    public String getPlayerType() {
        return "ai";
    }


}
