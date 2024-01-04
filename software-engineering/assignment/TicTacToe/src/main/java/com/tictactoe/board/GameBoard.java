package com.tictactoe.board;

import com.tictactoe.game.Game;
import com.tictactoe.player.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameBoard implements Board{

    private int[][] gameBoardArray;
    private int row;
    private int column;

    private static GameBoard instance;
    private GameBoard(int row, int column){
        this.row = row;
        this.column = column;
        this.gameBoardArray = new int[row][column];
    }
    public static GameBoard getInstance(int row, int column){
        if(instance == null){
            instance = new GameBoard(row,column);
        }
        return instance;
    }



    @Override
    public boolean isBoardFull() {
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(gameBoardArray[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public int isWinner() {
        for(int i = 0; i < row; i++){
            if(this.rowWinCondition(i)) return gameBoardArray[i][0];
        }

        for(int j = 0; j < column; j++){
            if(this.columnWinCondition(j)) return gameBoardArray[0][j];
        };

        if(this.mainDiagonalWinCondition()) return gameBoardArray[0][0];
        if(this.antiDiagonalWinCondition()) return gameBoardArray[0][column-1];

        return 0;
    }

    @Override
    public boolean hasWinner() {
        if(isWinner() != 0) return true;
        return false;
    }


    private boolean rowWinCondition(int rowIndex){
        int firstCell = gameBoardArray[rowIndex][0];
        for(int j = 1; j < column; j++){
            if(gameBoardArray[rowIndex][j] != firstCell) return false;
        }
        return true;
    }

    private boolean columnWinCondition(int columnIndex){
        int firstCell = gameBoardArray[0][columnIndex];
        for(int i = 1; i < row; i++){
            if(gameBoardArray[i][columnIndex] != firstCell) return false;
        }
        return true;
    }

    private boolean mainDiagonalWinCondition(){
        int firstCell = gameBoardArray[0][0];
        for(int i = 1; i < row; i ++){
            if (gameBoardArray[i][i] != firstCell) return false;
        }
        return true;
    }

    private boolean antiDiagonalWinCondition(){
        int firstCell = gameBoardArray[0][column-1];
        for(int i = 1; i < row; i ++){
            if (gameBoardArray[i][column-i-1] != firstCell) return false;
        }
        return true;
    }


    @Override
    public boolean isCellEmpty(int xCoordinate, int yCoordinate) {
        if(gameBoardArray[xCoordinate-1][yCoordinate-1] == 0){
            return true;
        }
        return false;
    }

    @Override
    public int[][] markCell(int playerNumber, int xCoordinate, int yCoordinate) {
        //move this check to Game? and handle exception?
        if(this.isCellEmpty(xCoordinate, yCoordinate) && !this.isBoardFull() && this.isValidCell(xCoordinate,yCoordinate)){
            gameBoardArray[xCoordinate-1][yCoordinate-1] = playerNumber;
        }
        return gameBoardArray;
    }

    @Override
    public boolean isValidCell(int xCoordinate, int yCoordinate) {
        if(xCoordinate > row || yCoordinate > column){
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                boardString.append(cellToString(gameBoardArray[i][j]));
                if(j<column - 1){
                    boardString.append("|");
                }
            }
            boardString.append("\n");
            if(i<row-1){
                for(int j = 0; j < column; j++){
                    boardString.append("---");
                    if(j < column-1){
                        boardString.append("+");
                    }
                }
                boardString.append("\n");
            }
        }
        return boardString.toString();
    }

    private String cellToString(int cellValue){
        if(cellValue == 0){
            return "   ";
        }
        return cellValue == 1? " X ": " O ";
    }
}
