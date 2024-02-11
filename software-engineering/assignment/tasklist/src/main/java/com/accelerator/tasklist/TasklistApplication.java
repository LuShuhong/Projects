package com.accelerator.tasklist;

import com.accelerator.tasklist.model.Status;
import com.accelerator.tasklist.model.Task;
import com.accelerator.tasklist.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class TasklistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasklistApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(TaskRepository repository) {
		return args -> {
			Task task = new Task(
					null,
					"Shopping",
					"Go Grocery Shopping on Saturday",
					Status.IN_PROGRESS,
					5,
					LocalDateTime.now(),
					null

			);

			repository.save(task);
		};
	}
}
