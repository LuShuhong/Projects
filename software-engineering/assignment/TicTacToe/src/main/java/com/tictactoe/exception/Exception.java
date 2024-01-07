package com.tictactoe.exception;

public class Exception {
    public static class invalidCellException extends RuntimeException {
        public invalidCellException(String message){
            super(message);
        }
    }

    public static class playerNotFoundException extends RuntimeException {
        public playerNotFoundException(String message){
            super(message);
        }
    }

    public static class inValidDifficultyException extends RuntimeException {
        public inValidDifficultyException(String message){
            super(message);
        }
    }

    public static class invalidPlayOrderException extends RuntimeException {
        public invalidPlayOrderException(String message){
            super(message);
        }
    }
}
