package com.example.tasktest.service;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    Task create(Task task);
    Task getById(Long id);
    List<Task> getAll();
    void delete(Long id);
}
