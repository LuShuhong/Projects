package Exceptions;

public class NoEmployeeToComputeException extends Exception{
    private final static String message = "Number of Employees is 0";
    public NoEmployeeToComputeException(){
        super(message);
    }
}

