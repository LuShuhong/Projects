package com.thg.rest.controller;

import com.thg.rest.domain.Task;
import com.thg.rest.service.TaskModelAssembler;
import com.thg.rest.TaskNotFoundException;
import com.thg.rest.repositaory.TaskRepository;
import org.springframework.data.domain.Sort;
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
    private final TaskModelAssembler taskModelAssembler;

    TaskController(TaskRepository taskRepository, TaskModelAssembler taskModelAssembler) {
        this.taskRepository = taskRepository;
        this.taskModelAssembler = taskModelAssembler;
    }

    @GetMapping("/tasks")
    public CollectionModel<EntityModel<Task>> all() {
        List<EntityModel<Task>> tasks = taskRepository.findAll(Sort.by(Sort.Direction.ASC, "priority")).stream() //
                .map(taskModelAssembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(tasks, linkTo(methodOn(TaskController.class).all()).withSelfRel());
    }

    @GetMapping("/tasks/in-progress")
    public CollectionModel<EntityModel<Task>> allInProgressTasks(){
        List<EntityModel<Task>> tasks = taskRepository.findByIsComplete(false).stream()
                .map(taskModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(tasks, linkTo(methodOn(TaskController.class).allInProgressTasks()).withSelfRel());
    }

    @GetMapping("/tasks/complete")
    public CollectionModel<EntityModel<Task>> allCompletedTasks(){
        List<EntityModel<Task>> tasks = taskRepository.findByIsComplete(true).stream()
                .map(taskModelAssembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(tasks, linkTo(methodOn(TaskController.class).allCompletedTasks()).withSelfRel());
    }



    @PostMapping("/tasks")
    public Task newTask(@RequestBody Task newTask) {
        return taskRepository.save(newTask);
    }

    @GetMapping("/tasks/{id}")
    public EntityModel<Task> one(@PathVariable Long id) {
        Task task = taskRepository.findById(id) //
                .orElseThrow(() -> new TaskNotFoundException(id));

        return taskModelAssembler.toModel(task);
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
