package com.tictactoe.strategy;

import com.tictactoe.board.GameBoard;

import java.util.ArrayList;
import java.util.Random;

public class EasyStrategy implements Strategy {

    @Override
    public int[] decideMove(GameBoard gameBoard) {
        ArrayList<int[]> emptyCells = gameBoard.emptyCells();
        Random random = new Random();
        int randomIndex = random.nextInt(emptyCells.size());
        int[] randomElement = emptyCells.get(randomIndex);
        return randomElement;
    }
}