package com.thg.rest.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskConstructorAndGetters() {
        String expectedTask = "Sample Task";
        boolean expectedIsComplete = true;

        Task task = new Task(expectedTask, expectedIsComplete);

        assertEquals(expectedTask, task.getTask());
        assertEquals(expectedIsComplete, task.getIsComplete());
    }

    @Test
    public void testSettersAndToString() {
        Task task = new Task();
        Long expectedId = 1L;
        String expectedTask = "Updated Task";
        boolean expectedIsComplete = false;

        task.setId(expectedId);
        task.setTask(expectedTask);
        task.setComplete(expectedIsComplete);

        assertEquals(expectedId, task.getId());
        assertEquals(expectedTask, task.getTask());
        assertEquals(expectedIsComplete, task.getIsComplete());
        assertTrue(task.toString().contains(expectedTask));
    }
}