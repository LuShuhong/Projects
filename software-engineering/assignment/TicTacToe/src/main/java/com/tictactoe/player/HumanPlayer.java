package com.tictactoe.player;

import com.tictactoe.board.GameBoard;
import com.tictactoe.strategy.Strategy;

import java.util.ArrayList;

public class HumanPlayer implements Player{
    private int playerNumber = 1;
    @Override
    public void makeMove(GameBoard gameBoard, int xCoordinate, int yCoordinate) {
        gameBoard.markCell(playerNumber,xCoordinate,yCoordinate);

    }

    @Override
    public String getPlayerType() {
        return "human";
    }

    @Override
    public void setStrategy(Strategy strategy) {
    }

}
