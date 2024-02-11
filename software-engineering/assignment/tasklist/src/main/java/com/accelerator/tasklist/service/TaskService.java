package com.accelerator.tasklist.service;

import com.accelerator.tasklist.model.Status;
import com.accelerator.tasklist.model.Task;
import com.accelerator.tasklist.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findAll(){
        return repository.findAll();
    }

    public Optional<Task> findById(Integer id) {
        return repository.findById(id);
    }

    public void save(Task task) {
        repository.save(task);
    }

    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<Task> findAllByTaskNameContains(String taskName) {
        return repository.findAllByTaskNameContains(taskName);
    }

    public List<Task> listByStatus(Status status) {
        return repository.listByStatus(status);
    }

    public List<Task> sortByPriority() {
        return repository.sortByPriority();
    }
}