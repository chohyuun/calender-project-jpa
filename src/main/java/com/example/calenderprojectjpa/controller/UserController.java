package com.example.calenderprojectjpa.controller;

import com.example.calenderprojectjpa.dto.UserLoginRequestDto;
import com.example.calenderprojectjpa.dto.UserRequestDto;
import com.example.calenderprojectjpa.dto.UserResponseDto;
import com.example.calenderprojectjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // create user
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signUp(@Validated @RequestBody UserRequestDto requestDto) {
        UserResponseDto userResponseDto = userService.signUp(
                requestDto.getName(),
                requestDto.getEmail(),
                requestDto.getPassword()
        );
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    // get user data
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") Long id) {
        UserResponseDto userResponseDto = userService.getUserById(id);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    // delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id) {
        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserLoginRequestDto requestDto) {
        userService.login(requestDto.getEmail(), requestDto.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
