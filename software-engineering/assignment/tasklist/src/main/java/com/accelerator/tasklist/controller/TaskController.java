package com.accelerator.tasklist.controller;

import com.accelerator.tasklist.model.Status;
import com.accelerator.tasklist.model.Task;
import com.accelerator.tasklist.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/task")
@CrossOrigin
public class TaskController {

    private final TaskRepository repository;

    @Autowired
    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Task> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Task not Found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Task task) {
        repository.save(task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Task task, @PathVariable Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Task not Found!");
        }
        repository.save(task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("/filter/{taskName}")
    public List<Task> findByTaskName(@PathVariable String taskName) {
        return repository.findAllByTaskNameContains(taskName);
    }

    @GetMapping("/filter/status/{status}")
    public List<Task> findByStatus(@PathVariable Status status) {
        return repository.listByStatus(status);
    }

}
