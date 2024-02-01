package com.thg.rest.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task {

    private @Id @GeneratedValue Long id;
    private String task;
    private boolean isComplete;
    private int priority;

    public Task(){};

    public Task(String task, boolean isComplete, int priority) {
        this.task = task;
        this.isComplete = isComplete;
        this.priority = priority;
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

    public int getPriority(){
        return this.priority;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setComplete(boolean complete) {
        this.isComplete = complete;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString(){
        return "Tasklist{" + " id = " + this.id + ", task = " + this.task + ", is task completed: " + isComplete +"}";
    }
}
