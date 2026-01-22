package com.example.tasktest.service.impl;

import com.example.tasktest.repository.TaskRepository;
import com.example.tasktest.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Task getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }



    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
