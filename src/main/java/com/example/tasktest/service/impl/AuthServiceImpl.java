package com.example.tasktest.service.impl;

import com.example.tasktest.DTO.AuthRequestDto;
import com.example.tasktest.DTO.AuthResponseDto;
import com.example.tasktest.DTO.UserCreateDto;
import com.example.tasktest.entity.User;
import com.example.tasktest.repository.UserRepository;
import com.example.tasktest.service.AuthService;
import com.example.tasktest.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthResponseDto register(UserCreateDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setRole("USER");
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);
        return new AuthResponseDto(jwtUtil.generateToken(user.getUsername()));
    }

    public AuthResponseDto login(AuthRequestDto dto) {
        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow();

        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return new AuthResponseDto(jwtUtil.generateToken(user.getUsername()));
    }
}

