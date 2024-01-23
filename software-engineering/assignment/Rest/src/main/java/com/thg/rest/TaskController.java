package com.thg.rest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskRepository taskRepository;

    TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public List<Task> all() {
        return taskRepository.findAll();
    }

    @PostMapping("/tasks")
    public Task newTask(@RequestBody Task newTask) {
        return taskRepository.save(newTask);
    }

    @GetMapping("/tasks/{id}")
    public Task one(@PathVariable Long id) {
        return taskRepository.findById(id).orElseThrow( () -> new TaskNotFoundException(id));
    }

    @PutMapping("/tasks/{id}")
    public Task replaceTask(@RequestBody Task newTask, @PathVariable Long id) {
        return taskRepository.findById(id)
                .map( task -> {
                    task.setTask(newTask.getTask());
                    task.setComplete(newTask.getIsComplete());
                    return taskRepository.save(task);
                })
                .orElseGet( () -> {
                    newTask.setId(id);
                    return taskRepository.save(newTask);
                });
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }



}
