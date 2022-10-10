package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void MapToTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test", "Test");
        Task task = new Task();

        //When & Then
        assertTrue(taskMapper.mapToTask(taskDto).getClass().isInstance(task));
    }

    @Test
    void MapToTaskDtoTest() {
        //Given
        Task task = new Task(1L, "Test", "Test");
        TaskDto taskDto = new TaskDto(2L, "Test2", "Test2");

        //When & Then
        assertTrue(taskMapper.mapToTaskDto(task).getClass().isInstance(taskDto));
    }

    @Test
    void MapToTaskDtoList() {
        //Given
        Task task = new Task(1L, "Test", "Test");
        List<Task> testList = List.of(task);

        TaskDto taskDto = new TaskDto(2L, "Test2", "Test2");
        List<TaskDto> testListDto = List.of(taskDto);

        //When & Then
        assertTrue(taskMapper.mapToTaskDtoList(testList).get(0).getClass().isInstance(testListDto.get(0)));
    }
}