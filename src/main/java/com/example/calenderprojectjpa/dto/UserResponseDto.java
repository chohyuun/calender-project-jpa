package com.example.calenderprojectjpa.dto;

import com.example.calenderprojectjpa.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public UserResponseDto(Long id,String name, String email, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getCreatedDate(), user.getModifiedDate());
    }
}
