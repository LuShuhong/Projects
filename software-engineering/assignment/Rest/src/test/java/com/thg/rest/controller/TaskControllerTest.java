package com.thg.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thg.rest.repositaory.TaskRepository;
import com.thg.rest.service.Task;
import com.thg.rest.TaskModelAssembler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskModelAssembler taskModelAssembler;

    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @Test
    public void getAllTasksTest() throws Exception {

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        ;
    }


    @Test
    public void createTaskTest() throws Exception {
        Task newTask = new Task();

        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(newTask)))
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void updateTaskTest() throws Exception {

        Task updatedTask = new Task();

        mockMvc.perform(put("/tasks/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updatedTask)))
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void deleteTaskTest() throws Exception {

        mockMvc.perform(delete("/tasks/{id}", 1L))
                .andExpect(status().isOk())

        ;
    }

}