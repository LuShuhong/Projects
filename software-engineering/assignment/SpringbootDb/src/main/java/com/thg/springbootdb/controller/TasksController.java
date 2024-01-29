package com.thg.springbootdb.controller;

import com.thg.springbootdb.domain.Task;
import com.thg.springbootdb.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TasksController {
    private final TaskService taskService;

    @Autowired
    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> task() throws Exception{
        return taskService.getAllTasks();
    }




}
