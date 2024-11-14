package com.example.calenderprojectjpa.dto;

import com.example.calenderprojectjpa.entity.Schedule;
import com.example.calenderprojectjpa.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto  {
    private Long id;
    private Long userId;
    private String title;
    private String contents;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;

    public ScheduleResponseDto(Long id, Long userId, String title, String contents, LocalDateTime createDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getUser().getId(), schedule.getTitle(), schedule.getContents(), schedule.getCreatedDate(), schedule.getModifiedDate());
    }
}
