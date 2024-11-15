package com.example.calenderprojectjpa.controller;

import com.example.calenderprojectjpa.config.PasswordEncoder;
import com.example.calenderprojectjpa.dto.UserLoginRequestDto;
import com.example.calenderprojectjpa.dto.UserRequestDto;
import com.example.calenderprojectjpa.dto.UserResponseDto;
import com.example.calenderprojectjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입
     * @param requestDto
     * @return userResponse
     *      비밀번호를 제외한 유저 정보
     */
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signUp(@Validated @RequestBody UserRequestDto requestDto) {
        UserResponseDto userResponseDto = userService.signUp(
                requestDto.getName(),
                requestDto.getEmail(),
                passwordEncoder.encode(requestDto.getPassword())
        );
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    /**
     * 유저 전체 조회
     * @return list userResponse
     *      비밀번호를 제외한 유저 정보 리스트 출력
     */
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> userResponseDtoList = userService.getAllUsers();

        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }

    /**
     * 유저 정보 단건 조회
     * @param id
     * @return userResponse
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") Long id) {
        UserResponseDto userResponseDto = userService.getUserById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    /**
     * 유저 삭제
     * @param id
     * @return none
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id) {
        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 로그인
     * @param requestDto
     *      email, password 검증
     * @return none
     */
    @GetMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserLoginRequestDto requestDto) {
        userService.login(requestDto.getEmail(), requestDto.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
