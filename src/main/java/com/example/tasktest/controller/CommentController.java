package com.example.tasktest.controller;

import com.example.tasktest.entity.Comment;
import com.example.tasktest.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;

    @PostMapping
    public Comment create(@RequestBody Comment comment) {
        return service.create(comment);
    }

    @GetMapping
    public List<Comment> byTask(@RequestParam Long task_id) {
        return service.getByTask(task_id);
    }

    @GetMapping("/{id}")
    public Comment get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PatchMapping("/{id}")
    public Comment update(@PathVariable Long id, @RequestBody Comment comment) {
        return service.update(id, comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
