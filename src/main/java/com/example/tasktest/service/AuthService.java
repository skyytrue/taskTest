package com.example.tasktest.service;

import com.example.tasktest.DTO.AuthRequestDto;
import com.example.tasktest.DTO.AuthResponseDto;
import com.example.tasktest.DTO.UserCreateDto;

public interface AuthService {
    AuthResponseDto register(UserCreateDto dto);
    AuthResponseDto login(AuthRequestDto dto);
}