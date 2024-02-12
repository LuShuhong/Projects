package com.accelerator.tasklist.controller;

import com.accelerator.tasklist.model.Status;
import com.accelerator.tasklist.model.Task;
import com.accelerator.tasklist.repository.TaskRepository;
import com.accelerator.tasklist.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/task")
@CrossOrigin
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Integer id) {
        return taskService.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Task not Found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Task create(@Valid @RequestBody Task task) {
        return taskService.save(task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Task update(@RequestBody Task task, @PathVariable Integer id) {
        if(!taskService.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Task not Found!");
        }
        return taskService.save(task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        taskService.deleteById(id);
    }

    @GetMapping("/filter/task_name/{taskName}")
    public List<Task> findByTaskName(@PathVariable String taskName) {
        return taskService.findAllByTaskNameContains(taskName);
    }

    @GetMapping("/filter/status/{status}")
    public List<Task> findByStatus(@PathVariable Status status) {
        return taskService.listByStatus(status);
    }

    @GetMapping("/priority")
    public List<Task> sortByPriority() {
        return taskService.sortByPriority();
    }
}
