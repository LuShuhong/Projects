package com.thg.rest;

public class TaskNotFoundException extends RuntimeException{
    TaskNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
