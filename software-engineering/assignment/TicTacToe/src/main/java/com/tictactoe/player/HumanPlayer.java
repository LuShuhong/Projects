package com.tictactoe.player;

import com.tictactoe.board.GameBoard;

public class HumanPlayer implements Player{
    private int playerNumber = 1;
    @Override
    public void makeMove(int xCoordinate, int yCoordinate) {
        GameBoard gameBoard = GameBoard.getInstance(3, 3);
        gameBoard.markCell(playerNumber,xCoordinate,yCoordinate);

    }
}
