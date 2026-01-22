package com.example.tasktest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String password;

    private String role;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;

    @Column(name = "createdTime")
    private LocalDateTime createdAt;

    @Column(name = "updatedTime")
    private LocalDateTime updatedAt;

}
