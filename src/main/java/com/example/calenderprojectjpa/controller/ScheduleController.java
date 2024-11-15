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

    /**
     * 일정 생성
      * @param requestDto
     *      title, contents, userId(user table FK)
     * @return scheduleResponse 일정 등록 내용
     */
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@Validated @RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.createSchedule(requestDto.getTitle(), requestDto.getContents(), requestDto.getUserId());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    /**
     *  다 건 조회
     *  @return list scheduleResponse
     *      등록 된 일정 내용 전체
     */
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getAllSchedules() {
        List<ScheduleResponseDto> scheduleResponseDto = scheduleService.getAllSchedules();
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    /**
     *  단 건 조회
     * @param id
     * @return scheduleResponse
     */
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getSchedule(@PathVariable Long id) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.getSchedule(id);

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    /**
     * 일정 수정
     * @param id
     * @param requestDto
     *      title, contents 중 하나만 수정 되어도 수정
     * @return scheduleResponse
     *      수정된 내용 출력
     */
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @Validated @RequestBody ScheduleRequestDto requestDto
    ) {
        scheduleService.updateSchedule(id, requestDto.getTitle(), requestDto.getContents());
        return new ResponseEntity<>(scheduleService.getSchedule(id), HttpStatus.OK);
    }

    /**
     * 일정 삭제
     * @param id
     * @return none
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
