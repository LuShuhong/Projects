package com.tictactoe.game;

import com.tictactoe.board.GameBoard;
import com.tictactoe.command.Command;
import com.tictactoe.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameTest {
    private Game game;
    private GameBoard mockGameBoard;
    private Player mockPlayer;
    private Command mockCommand;

    @BeforeEach
    void setUp() {
        game = Game.getInstance();
        mockGameBoard = mock(GameBoard.class);
        mockPlayer = mock(Player.class);
        mockCommand = mock(Command.class);
    }

    @AfterEach
    void cleanUp() {
        game.gameReset();
    }

    @Test
    void testExecuteCommand() {
        game.executeCommand(mockCommand);
        verify(mockCommand).execute();
    }

    @Test
    void testIsGameEnded() {
        when(mockGameBoard.isBoardFull()).thenReturn(false);
        when(mockGameBoard.hasWinner()).thenReturn(false);

        assertFalse(game.isGameEnded(), "Game should not be ended if the board is not full and there is no winner");
        ;
    }

    //try more static mocking for learning
    @Test
    void testIsGameEnded2() {
        try (MockedStatic<GameBoard> mockedGameBoard = mockStatic(GameBoard.class)) {
            GameBoard mockBoard = mock(GameBoard.class);
            when(mockBoard.isBoardFull()).thenReturn(false);
            when(mockBoard.hasWinner()).thenReturn(false);
            mockedGameBoard.when(GameBoard::getInstance).thenReturn(mockBoard);

            Game game = Game.getInstance();

            assertFalse(game.isGameEnded(), "Game should not be ended if the board is not full and there is no winner");

            when(mockBoard.hasWinner()).thenReturn(true);
            assertTrue(game.isGameEnded(), "Game should be ended if there is a winner");
        }
    }

    @Test
    void testPlayMove() {
        int xCoordinate = 1;
        int yCoordinate = 1;

        game.playMove(mockGameBoard, mockPlayer, xCoordinate, yCoordinate);
        verify(mockPlayer).makeMove(mockGameBoard, xCoordinate, yCoordinate);
    }

}