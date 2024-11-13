package com.example.calenderprojectjpa.service;

import com.example.calenderprojectjpa.dto.ScheduleResponseDto;
import com.example.calenderprojectjpa.entity.Schedule;
import com.example.calenderprojectjpa.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScheduleService {
    private ScheduleRepository scheduleRepository;

    public ScheduleResponseDto createSchedule(String title, String contents) {
        Schedule schedule = new Schedule(title, contents);
        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents(), schedule.getCreatedDate(), schedule.getModifiedDate());
    }

    public List<ScheduleResponseDto> getAllSchedules() {
        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::toDto).toList();
    }

    public ScheduleResponseDto getSchedule(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents(), schedule.getCreatedDate(), schedule.getModifiedDate());
    }

    @Transactional
    public void updateSchedule(Long id, String title, String contents) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        findSchedule.update(title, contents);
    }

    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        scheduleRepository.delete(schedule);
    }
}
