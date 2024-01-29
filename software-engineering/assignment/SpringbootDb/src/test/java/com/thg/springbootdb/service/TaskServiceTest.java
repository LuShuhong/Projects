package com.thg.springbootdb.service;

import com.thg.springbootdb.domain.Task;
import com.thg.springbootdb.persistence.TaskDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TaskServiceTest {

    private TaskService taskService;
    @BeforeEach
    public void setUp() throws Exception{
        TaskDAO taskDAO = mock(TaskDAO.class);
        List<Task> tasksList = List.of(
                new Task("Shopping",false,3),
                new Task("Coding",false,2),
                new Task("Exercising",true,1),
                new Task("Studying",false,4)
        );
        when(taskDAO.getAllTasks()).thenReturn(tasksList);
        taskService = new TaskService(taskDAO);
    }

    @Test
    public void testGetAllTasks() throws Exception {

        assertEquals(4, taskService.getAllTasks().size());
    }
}