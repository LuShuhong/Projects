package com.tictactoe.board;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {
    private GameBoard gameBoard;

    @BeforeEach
    void setup() {
        gameBoard = GameBoard.getInstance(3, 3);
    }

    @AfterEach
    void cleanup(){
        gameBoard.reset();
    }

    @Test
    void testSingletonInstance() {
        GameBoard instance1 = GameBoard.getInstance();
        assertSame(instance1, gameBoard, "Singleton instances should be the same");
    }

    @Test
    void testBoardInitialisation() {
        int[][] boardArray = gameBoard.getGameBoardArray();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(0, boardArray[i][j], "Board should be initialised with all zeros");
            }
        }
    }

    private void fillBoard() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                gameBoard.markCell(1, i, j);
            }
        }
    }

    @Test
    void testIsBoardFull() {
        assertFalse(gameBoard.isBoardFull(), "New board should not be full");
        fillBoard();
        assertTrue(gameBoard.isBoardFull(), "Board should be full");
    }

    @Test
    void testIsWinner() {
        assertEquals(0, gameBoard.isWinner(), "New board should not have a winner");
        assertFalse(gameBoard.hasWinner());
        for (int i = 0; i < 3; i++) {
            gameBoard.markCell(1, 1, i + 1);
        }
        assertTrue(gameBoard.hasWinner());
        assertEquals(1, gameBoard.isWinner(), "Player 1 should be the winner");
    }

    @Test
    void testMarkCellAndIsCellEmpty() {
        assertTrue(gameBoard.isCellEmpty(1, 1), "Cell should be initially empty");
        gameBoard.markCell(1, 1, 1);
        assertFalse(gameBoard.isCellEmpty(1, 1), "Cell should not be empty after marking");
    }

    @Test
    void testInvalidCellException() {
        gameBoard.markCell(1, 1, 1);
        Exception exception = assertThrows(Exception.class, () -> {
            gameBoard.markCell(1, 1, 1);
        });
    }

    @Test
    void testEmptyCells() {
        assertEquals(9, gameBoard.emptyCells().size(), "A new board should have 9 empty cells");
        gameBoard.markCell(1, 1, 1);
        assertEquals(8, gameBoard.emptyCells().size(), "After marking one cell, there should be 8 empty cells");
    }

    @Test
    void testToString() {
        String initialBoardString = gameBoard.toString();
        assertNotNull(initialBoardString, "toString should not return null");
        assertTrue(initialBoardString.contains("   "), "Empty board should contain empty cells represented by spaces");
    }


}