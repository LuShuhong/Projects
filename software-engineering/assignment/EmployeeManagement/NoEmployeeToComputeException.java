package com.thg.accelerator.se.shuhong.assignments.EmployeeManagement;

public class NoEmployeeToComputeException extends Exception{
    private final static String message = "Number of Employees is 0";
    public NoEmployeeToComputeException(){
        super(message);
    }
}

