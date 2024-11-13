package com.example.calenderprojectjpa.dto;

import lombok.Getter;

@Getter
    public class UserRequestDto {
        private Long id;
        private String name;
        private String email;
        private String password;

        public UserRequestDto(Long id, String name, String email, String password) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
        }
}
