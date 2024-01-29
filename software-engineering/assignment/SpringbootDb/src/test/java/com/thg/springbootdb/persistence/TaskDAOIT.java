package com.thg.springbootdb.persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskDAOIT {
    private final TaskDAO taskDAO;
    @Autowired
    public TaskDAOIT(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }
    @Test
    public void test_getTasks() throws Exception {
        Assertions.assertEquals(8, taskDAO.getAllTasks().size());
    } }