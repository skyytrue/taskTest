package com.example.tasktest.service;

import com.example.tasktest.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    Comment create(Comment comment);
    List<Comment> getByTask(Long taskId);
    Comment getById(Long id);
    Comment update(Long id, Comment comment);
    void delete(Long id);
}
