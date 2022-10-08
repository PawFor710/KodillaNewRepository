package com.crud.tasks.controller;


import com.crud.tasks.domain.TaskDto;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskController taskController;

    @Test
    void shouldGetTasks() throws Exception {
        //Given
        List<TaskDto> taskDtoList = List.of(new TaskDto(1L, "test task", "doing test"),
                new TaskDto(2L, "test task2", "doing test2"));

        when(taskController.getTasks()).thenReturn(ResponseEntity.ok(taskDtoList));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/tasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                //From first element
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title", Matchers.is("test task")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].content", Matchers.is("doing test")))
                //From second element
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].title", Matchers.is("test task2")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].content", Matchers.is("doing test2")));

    }

    @Test
    void shouldDeleteTask() throws Exception {
        //Given
        List<TaskDto> taskDtoList = List.of(new TaskDto(1L, "test task", "doing test"),
                new TaskDto(2L, "test task2", "doing test2"));


        when(taskController.deleteTask(taskDtoList.get(0).getId())).thenReturn(ResponseEntity.ok().build());

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/tasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void shouldUpdateTask() throws Exception {
        //Given
        List<TaskDto> taskDtoList = List.of(new TaskDto(1L, "test task", "doing test"),
                new TaskDto(2L, "test task2", "doing test2"));
        TaskDto taskDto = new TaskDto(1L, "test task updated", "updating test");

        when(taskController.updateTask(taskDtoList.get(0))).thenReturn(ResponseEntity.ok(taskDto));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/tasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void shouldCreateTask() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(3L, "Tesk test3", "doing test3");

        when(taskController.createTask(taskDto)).thenReturn(ResponseEntity.ok().build());

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/tasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));

    }

    @Test
    void shouldGetTask() throws Exception {
        //Given
        List<TaskDto> taskDtoList = List.of(new TaskDto(1L, "test task", "doing test"),
                new TaskDto(2L, "test task2", "doing test2"));

        when(taskController.getTask(1L)).thenReturn(ResponseEntity.ok(taskDtoList.get(0)));

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/tasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }
}