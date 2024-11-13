package com.example.calenderprojectjpa.dto;

import com.example.calenderprojectjpa.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto  {
    private Long id;
    private String username;
    private String title;
    private String contents;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public ScheduleResponseDto(Long id, String username, String title, String contents, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getUsername(), schedule.getTitle(), schedule.getContents(), schedule.getCreatedDate(), schedule.getModifiedDate());
    }
}