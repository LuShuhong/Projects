package com.thg.accelerator.se.shuhong.assignments.EmployeeManagement;

public class NoSuchEmployeeException extends Exception {
    private static final String message = "Cannot Find Employee with Id %s";
    public NoSuchEmployeeException(String value){
        super(message.formatted(value));
    }
}