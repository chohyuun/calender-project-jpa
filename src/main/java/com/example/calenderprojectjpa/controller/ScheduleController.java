package com.example.calenderprojectjpa.controller;

import com.example.calenderprojectjpa.dto.ScheduleRequestDto;
import com.example.calenderprojectjpa.dto.ScheduleResponseDto;
import com.example.calenderprojectjpa.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    // 일정 신규 등록
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@Validated @RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.createSchedule(requestDto.getTitle(), requestDto.getContents(), requestDto.getUserId());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    // 다 건 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules() {
        List<ScheduleResponseDto> scheduleResponseDto = scheduleService.getAllSchedules();
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    // 단 건 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getSchedule(@PathVariable Long id) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.getSchedule(id);

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    // 일정 단 건 수정
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @Validated @RequestBody ScheduleRequestDto requestDto
    ) {
        scheduleService.updateSchedule(id, requestDto.getTitle(), requestDto.getContents());
        return new ResponseEntity<>(scheduleService.getSchedule(id), HttpStatus.OK);
    }

    // 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
