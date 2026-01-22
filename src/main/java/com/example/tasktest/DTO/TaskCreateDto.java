package com.example.tasktest.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskCreateDto {
    private String description;
    private Long userId;
}
