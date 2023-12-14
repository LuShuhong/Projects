package Exceptions;

public class DuplicateEmployeeIdException extends Exception {
    private static final String message = "Employee Id %s must be unique";
    public DuplicateEmployeeIdException(int value){
        super(message.formatted(value));
    }
}
