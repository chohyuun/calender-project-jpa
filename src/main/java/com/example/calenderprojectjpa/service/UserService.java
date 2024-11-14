package com.example.calenderprojectjpa.service;

import com.example.calenderprojectjpa.config.PasswordEncoder;
import com.example.calenderprojectjpa.dto.UserResponseDto;
import com.example.calenderprojectjpa.entity.User;
import com.example.calenderprojectjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto signUp(String name, String email, String password) {
        User user = new User(name, email, password);
        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail(), savedUser.getCreatedDate(), savedUser.getModifiedDate());
    }

    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findByIdOrElseThrow(id);
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getCreatedDate(), user.getModifiedDate());
    }

    public void delete(Long id) {
        User user = userRepository.findByIdOrElseThrow(id);
        userRepository.delete(user);
    }

    public void login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect password");
        }
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserResponseDto::toDto).toList();
    }
}
