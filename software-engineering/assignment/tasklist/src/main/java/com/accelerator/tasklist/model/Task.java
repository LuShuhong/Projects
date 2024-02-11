package com.accelerator.tasklist.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


public record Task(
        @Id
        Integer id,
        @NotBlank
        String taskName,
        String desc,
        Status status,

        int priority,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated
) {
}
