package com.example.tasktest.controller;

import com.example.tasktest.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @GetMapping("/{id}")
    public Task get(@PathVariable Long id) {
        return taskService.getById(id);
    }

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAll();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}
