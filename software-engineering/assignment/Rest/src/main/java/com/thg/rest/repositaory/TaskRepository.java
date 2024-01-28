package com.thg.rest.repositaory;

import com.thg.rest.service.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
