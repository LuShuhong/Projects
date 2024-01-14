package com.tictactoe.player;

import com.tictactoe.board.GameBoard;
import com.tictactoe.strategy.Strategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AiPlayerTest {
    private Player aiPlayer;
    private Strategy mockStrategy;
    private GameBoard mockGameBoard;

    @BeforeEach
    void setup() {
        PlayerFactory playerFactory = new PlayerFactory();
        aiPlayer = playerFactory.getPlayer("ai");
        mockGameBoard = Mockito.mock(GameBoard.class);
        mockStrategy = Mockito.mock(Strategy.class);
        aiPlayer.setStrategy(mockStrategy);
    }

    @Test
    void testGetPlayerType() {
        assertEquals("ai", aiPlayer.getPlayerType(), "Player type should be 'ai'");
    }

    @Test
    void testMakeMove(){
        when(mockStrategy.decideMove(mockGameBoard)).thenReturn(new int[]{1,1});
        aiPlayer.makeMove(mockGameBoard,0,0);
        verify(mockStrategy).decideMove(mockGameBoard);
        verify(mockGameBoard).markCell(2,1,1);
    }
}