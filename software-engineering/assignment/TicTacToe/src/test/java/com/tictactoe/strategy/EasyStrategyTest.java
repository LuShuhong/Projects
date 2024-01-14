package com.tictactoe.strategy;

import com.tictactoe.board.GameBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EasyStrategyTest {
    private Strategy strategy;
    private GameBoard gameBoard;

    @BeforeEach
    void setup() {
        strategy = new EasyStrategy();
        gameBoard = Mockito.mock(GameBoard.class);
    }

    @Test
    void testDecideMove() {
        int[] theMove = new int[] {2,2};
        when(gameBoard.emptyCells()).thenReturn(new ArrayList<>(Arrays.asList(theMove)));
        int[] chosenMove = strategy.decideMove(gameBoard);

        assertEquals(chosenMove, theMove);
    }

}