package com.tictactoe.player;

import com.tictactoe.board.GameBoard;
import com.tictactoe.strategy.Strategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HumanPlayerTest {
    private Player humanPlayer;
    private GameBoard mockGameBoard;

    @BeforeEach
    void setup() {
        PlayerFactory playerFactory = new PlayerFactory();
        humanPlayer = playerFactory.getPlayer("human");
        mockGameBoard = Mockito.mock(GameBoard.class);
    }

    @Test
    void testGetPlayerType() {
        assertEquals("human", humanPlayer.getPlayerType(), "Player type should be 'human'");
    }

    @Test
    void testMakeMove() {
        humanPlayer.makeMove(mockGameBoard,1,1);
        verify(mockGameBoard).markCell(1,1,1);
    }

}