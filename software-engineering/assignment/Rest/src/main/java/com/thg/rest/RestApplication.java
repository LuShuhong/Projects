package com.thg.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {

	private final TaskRepository taskRepository;
	private final TaskModelAssembler taskModelAssembler;

	public RestApplication(TaskRepository taskRepository, TaskModelAssembler taskModelAssembler) {
		this.taskRepository = taskRepository;
		this.taskModelAssembler = taskModelAssembler;
	}

	public static void main(String[] args) {

		SpringApplication.run(RestApplication.class, args);
	}

}
