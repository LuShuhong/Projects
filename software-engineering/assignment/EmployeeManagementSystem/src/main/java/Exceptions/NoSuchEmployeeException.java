package Exceptions;

public class NoSuchEmployeeException extends Exception {
    private static final String message = "Cannot Find Employee with Id %s";
    public NoSuchEmployeeException(String value){
        super(message.formatted(value));
    }
}
