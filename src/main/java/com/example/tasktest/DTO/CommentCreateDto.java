package com.example.tasktest.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateDto {
    private Long taskId;
    private Long userId;
    private String text;
}
