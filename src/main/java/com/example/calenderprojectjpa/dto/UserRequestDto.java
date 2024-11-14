package com.example.calenderprojectjpa.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UserRequestDto {
    private Long id;

    @Size(max = 4, message = "이름은 4자를 넘을 수 없습니다.")
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    @Size(min = 5, message = "비밀번호는 5자 이상이어야 합니다.")
    private String password;

    public UserRequestDto(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
