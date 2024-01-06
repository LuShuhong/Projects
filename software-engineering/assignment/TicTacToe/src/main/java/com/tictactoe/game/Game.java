package com.tictactoe.game;

import com.tictactoe.board.GameBoard;
import com.tictactoe.command.Command;
import com.tictactoe.player.Player;

//this class seems excessive
public class Game {
    private static Game instance;
    private Command command;

    public static Game getInstance(){
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }

    public void executeCommand(Command command){
        command.execute();
    }


    public boolean isGameEnded(){
        if(!GameBoard.getInstance().isBoardFull() && !GameBoard.getInstance().hasWinner()) return false;
        return true;
    }

    public void playMove(GameBoard gameBoard,Player player,int xCoordinate, int yCoordinate){
        player.makeMove(gameBoard,xCoordinate,yCoordinate);
    }

}
