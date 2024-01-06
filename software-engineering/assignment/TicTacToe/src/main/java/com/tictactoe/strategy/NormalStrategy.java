package com.tictactoe.strategy;

import com.tictactoe.board.GameBoard;

public class NormalStrategy implements Strategy{
    @Override
    public int[] decideMove(GameBoard gameBoard) {
        return new int[0];
    }
}
