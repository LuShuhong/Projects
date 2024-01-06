package com.tictactoe.board;

import com.tictactoe.player.Player;

import java.util.ArrayList;

public interface Board {
    boolean isBoardFull();
    int isWinner();
    boolean hasWinner();
    boolean isCellEmpty(int xCoordinate, int yCoordinate);
    ArrayList<int[]> emptyCells();
    int[][] markCell(int playerNumber,int xCoordinate, int yCoordinate);
    boolean isValidCell(int xCoordinate, int yCoordinate);
}
