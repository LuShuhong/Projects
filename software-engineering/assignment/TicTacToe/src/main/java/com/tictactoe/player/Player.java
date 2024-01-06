package com.tictactoe.player;

import com.tictactoe.board.GameBoard;
import com.tictactoe.strategy.Strategy;

public interface Player {
    void makeMove(GameBoard gameBoard, int xCoordinate, int yCoordinate);
    String getPlayerType();
    void setStrategy(Strategy strategy);


}
