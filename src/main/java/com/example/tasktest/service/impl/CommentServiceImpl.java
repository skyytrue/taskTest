package com.example.tasktest.service.impl;

import com.example.tasktest.entity.Comment;
import com.example.tasktest.repository.CommentRepository;
import com.example.tasktest.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    public Comment create(Comment comment) {
        return repository.save(comment);
    }

    public List<Comment> getByTask(Long taskId) {
        return repository.findByTaskId(taskId);
    }

    public Comment getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    public Comment update(Long id, Comment comment) {
        Comment c = getById(id);
        c.setText(comment.getText());
        return repository.save(c);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
