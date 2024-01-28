package com.thg.rest.service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task {

    private @Id @GeneratedValue Long id;
    private String task;
    private boolean isComplete;

    public Task(){};

    public Task(String task, boolean isComplete) {
        this.task = task;
        this.isComplete = isComplete;
    }


    public Long getId(){
        return this.id;
    }

    public String getTask(){
        return this.task;
    }

    public boolean getIsComplete(){
        return this.isComplete;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString(){
        return "Tasklist{" + " id = " + this.id + ", task = " + this.task + ", is task completed: " + isComplete +"}";
    }
}
