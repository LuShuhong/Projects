package com.accelerator.tasklist.repository;

import com.accelerator.tasklist.model.Status;
import com.accelerator.tasklist.model.Task;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class TaskCollectionRepository {

    private final List<Task> taskList = new ArrayList<>();

    public TaskCollectionRepository() {
    }

    public List<Task> findAll() {
        return taskList;
    }

    public Optional<Task> findById(Integer id) {
        return taskList.stream().filter(t -> t.id().equals(id)).findFirst();
    }


    public void save(Task task) {
        taskList.removeIf( t -> t.id().equals(task.id()));
        taskList.add(task);
    }

    @PostConstruct
    private void init() {
        Task task = new Task(
                1,
                "Shopping",
                "Go Grocery Shopping on Saturday",
                Status.IN_PROGRESS,
                5,
                LocalDateTime.now(),
                null

        );

        taskList.add(task);
    }

    public boolean existsByID(Integer id) {
        return taskList.stream().filter(t -> t.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        taskList.removeIf( t -> t.id().equals(id));
    }
}
