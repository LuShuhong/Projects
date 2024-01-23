package com.thg.rest;

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
            log.info("Preloading " + taskRepository.save(new Task("Shopping",false)));
            log.info("Preloading " + taskRepository.save(new Task("Sports",true)));
        };
    }
}
