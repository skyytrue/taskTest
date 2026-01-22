package com.example.tasktest.service;

import com.example.tasktest.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();
    User findById(Long id);
    void delete(Long id);
}
