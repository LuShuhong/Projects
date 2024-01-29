package com.thg.rest;

import com.thg.rest.repositaory.TaskRepository;
import com.thg.rest.domain.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TaskRepository taskRepository) {
        return args -> {
            log.info("Preloading " + taskRepository.save(new Task("Shopping",false,4)));
            log.info("Preloading " + taskRepository.save(new Task("Sports",true,1)));
            log.info("Preloading " + taskRepository.save(new Task("Coding",true,2)));
            log.info("Preloading " + taskRepository.save(new Task("Sleep",true,1)));
            log.info("Preloading " + taskRepository.save(new Task("Eating",true,1)));
            log.info("Preloading " + taskRepository.save(new Task("Groceries",true,3)));
        };
    }
}
