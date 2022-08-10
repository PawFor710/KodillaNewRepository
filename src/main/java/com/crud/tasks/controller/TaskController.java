package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;

    @GetMapping
    public List<TaskDto> getTasks() {
        List<Task> tasks = service.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
    }

    @GetMapping(value = "{id}")
    public TaskDto getTask(@PathVariable Long id) {
        Task task = service.getTaskById(id);
        return taskMapper.mapToTaskDto(task);
    }

    @DeleteMapping(value = "{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
    }

    @PutMapping(value = "{task}")
    public TaskDto updateTask(@PathVariable  TaskDto task) {
        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @PostMapping(value = "{task}")
    public void createTask(@PathVariable  TaskDto task) {

    }
}
