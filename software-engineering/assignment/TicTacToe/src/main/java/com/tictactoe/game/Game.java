package com.tictactoe.game;

import com.tictactoe.board.GameBoard;
import com.tictactoe.player.Player;

//this class seems excessive
public class Game {
    private static Game instance;

    public static Game getInstance(){
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }



    public boolean isGameEnded(){
        if(!GameBoard.getInstance().isBoardFull() && !GameBoard.getInstance().hasWinner()) return false;
        return true;
    }

    public void playMove(GameBoard gameBoard,Player player,int xCoordinate, int yCoordinate){
        player.makeMove(gameBoard,xCoordinate,yCoordinate);
    }

}
