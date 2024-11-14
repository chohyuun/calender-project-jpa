package com.example.calenderprojectjpa.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UserLoginRequestDto {
    @Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @Size(min = 5, message = "비밀번호는 5자 이상이어야 합니다.")
    private String password;

    public UserLoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
