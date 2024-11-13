package com.example.calenderprojectjpa.service;

import com.example.calenderprojectjpa.dto.UserResponseDto;
import com.example.calenderprojectjpa.entity.User;
import com.example.calenderprojectjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public UserResponseDto signUp(String name, String email) {
        User user = new User(name, email);
        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }

    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findByIdOrElseThrow(id);
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    public void delete(Long id) {
        User user = userRepository.findByIdOrElseThrow(id);
        userRepository.delete(user);
    }
}
