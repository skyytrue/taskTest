package com.example.tasktest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String description;

    @Column(name = "createdTime")
    private LocalDateTime createdAt;

    @Column(name = "updatedTime")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "task")
    private List<Comment> comments;
}
