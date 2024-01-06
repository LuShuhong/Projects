package com.tictactoe.strategy;

import com.tictactoe.board.GameBoard;

public interface Strategy {
    int[] decideMove(GameBoard gameBoard);
}
