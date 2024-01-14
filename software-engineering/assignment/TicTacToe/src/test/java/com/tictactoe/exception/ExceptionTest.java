package com.tictactoe.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {

    @Test
    void testInvalidCellException() {
        assertThrows(Exception.invalidCellException.class, () -> {
            throw new Exception.invalidCellException("Invalid Cell");
        });
    }

    @Test
    void testPlayerNotFoundException() {
        assertThrows(Exception.playerNotFoundException.class, () -> {
            throw new Exception.playerNotFoundException("Player Not Found");
        });
    }

    @Test
    void testInValidDifficultyException() {
        assertThrows(Exception.inValidDifficultyException.class, () -> {
            throw new Exception.inValidDifficultyException("Invalid Difficulty");
        });
    }

    @Test
    void testInvalidPlayOrderException() {
        assertThrows(Exception.invalidPlayOrderException.class, () -> {
            throw new Exception.invalidPlayOrderException("Invalid Play Order");
        });
    }
}