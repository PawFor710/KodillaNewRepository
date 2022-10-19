package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DbServiceTest {

    @Autowired
    private DbService dbService;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void saveTaskAndGetAllTasksTest() {
        //Given
        Task task = new Task(1L, "Test", "Test");
        Task task2 = new Task(2L, "Test2", "Test3");
        Task task3 = new Task(3L, "Test3", "Test3");

        dbService.saveTask(task);
        dbService.saveTask(task2);
        dbService.saveTask(task3);

        //When
        int result = dbService.getAllTasks().size();

        //Then
        assertEquals(3, result);

        //Cleaning
        taskRepository.deleteAll();

    }

    @Test
    void getTaskTest() throws TaskNotFoundException {
        //Given
        Task task = new Task(1L, "Test", "Test");
        Task task2 = new Task(2L, "Test2", "Test3");
        Task task3 = new Task(3L, "Test3", "Test3");

        dbService.saveTask(task);
        dbService.saveTask(task2);
        dbService.saveTask(task3);

        //When
        Task result = dbService.getTask(131L);
        String title = result.getTitle();
        String content = result.getContent();

        //Then
        assertEquals("Test", title);
        assertEquals("Test", content);

        //Cleaning
        taskRepository.deleteAll();
    }

    @Test
    void deleteTaskTest() {
        //Given
        Task task = new Task(1L, "Test", "Test");
        Task task2 = new Task(2L, "Test2", "Test3");
        Task task3 = new Task(3L, "Test3", "Test3");

        dbService.saveTask(task);
        dbService.saveTask(task2);
        dbService.saveTask(task3);

        dbService.deleteById(137L);

        //When
        int result = dbService.getAllTasks().size();

        //Then
        assertEquals(2, result);

        //Cleaning
        taskRepository.deleteAll();
    }
}