package com.tictactoe.player;

import com.tictactoe.board.GameBoard;
import com.tictactoe.strategy.Strategy;

public class AiPlayer implements Player{
    private int playerNumber = 2;
    private Strategy strategy;

    public AiPlayer(){
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    @Override
    public void makeMove(int xCoordinate, int yCoordinate) {
        //Should it be controlled by Game class instead? Intuitively, players make move on the game board?
        GameBoard gameBoard = GameBoard.getInstance(3, 3);
        gameBoard.markCell(playerNumber,xCoordinate,yCoordinate);
    }
}
