package com.thg.springbootdb.controller;

import com.thg.springbootdb.domain.Task;
import com.thg.springbootdb.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TasksControllerTest {

    private TasksController tasksController;

    @BeforeEach
    public void setUp() throws Exception {
        TaskService taskService = mock(TaskService.class);

        List<Task> tasksList = List.of(
                new Task("Shopping",false,3),
                new Task("Coding",false,2),
                new Task("Exercising",true,1),
                new Task("Studying",false,4)
        );

        when(taskService.getAllTasks()).thenReturn(tasksList);
        tasksController = new TasksController(taskService);

    }

    @Test
    public void testTasks() throws Exception {
        assertEquals(4,tasksController.task().size());
    }
}