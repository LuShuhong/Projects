package com.thg.rest;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class TaskController {
    private final TaskRepository taskRepository;

    TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public CollectionModel<EntityModel<Task>> all() {

        List<EntityModel<Task>> tasks = taskRepository.findAll().stream()
                .map(task -> EntityModel.of( task,
                        linkTo(methodOn(TaskController.class).one(task.getId())).withSelfRel(),
                        linkTo(methodOn(TaskController.class).all()).withRel("tasks")))
                .collect(Collectors.toList());

        return CollectionModel.of(tasks,linkTo(methodOn(TaskController.class).all()).withSelfRel());
    }

    @PostMapping("/tasks")
    public Task newTask(@RequestBody Task newTask) {
        return taskRepository.save(newTask);
    }

    @GetMapping("/tasks/{id}")
    public EntityModel<Task> one(@PathVariable Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow( () -> new TaskNotFoundException(id));
        return EntityModel.of(task, //
                linkTo(methodOn(TaskController.class).one(id)).withSelfRel(),
                linkTo(methodOn(TaskController.class).all()).withRel("tasks"));
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
