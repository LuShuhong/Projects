package com.accelerator.tasklist.repository;

import com.accelerator.tasklist.model.Status;
import com.accelerator.tasklist.model.Task;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends ListCrudRepository<Task,Integer> {
    List<Task> findAllByTaskNameContains(String taskName);

    @Query("""
            SELECT * FROM Task
            WHERE status = :status
            """)
    List<Task> listByStatus(@Param("status") Status status);
}
