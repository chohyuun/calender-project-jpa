package com.example.calenderprojectjpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class ScheduleRequestDto {
    @NotBlank
    @Size(max = 20, message = "제목은 20글자를 넘을 수 없습니다.")
    private final String title;

    @Size(max = 200, message = "할일 내용은 200글자를 넘을 수 없습니다.")
    private final String contents;

    private final Long userId;

    public ScheduleRequestDto(String title, String contents, Long userId) {
        this.title = title;
        this.contents = contents;
        this.userId = userId;
    }
}
