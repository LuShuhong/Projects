package com.thg.springbootdb.service;

import com.thg.springbootdb.domain.Task;
import com.thg.springbootdb.persistence.TaskDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskDAO taskDAO;

    public TaskService(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public List<Task> getAllTasks() throws Exception{
        return taskDAO.getAllTasks();
    }
}
