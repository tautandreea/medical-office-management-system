package com.cabinetmedical.doctorservice.schedule.controllers;

import com.cabinetmedical.doctorservice.schedule.domain.Schedule;
import com.cabinetmedical.doctorservice.schedule.domain.dto.CreateScheduleDTO;
import com.cabinetmedical.doctorservice.schedule.domain.dto.UpdateScheduleDTO;
import com.cabinetmedical.doctorservice.schedule.services.ScheduleService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(
            ScheduleService scheduleService
    ) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<Schedule> getAllSchedules() {

        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public Schedule getScheduleById(
            @PathVariable int id
    ) {

        return scheduleService.getScheduleById(id);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Schedule> getSchedulesByDoctorId(
            @PathVariable int doctorId
    ) {

        return scheduleService.getSchedulesByDoctorId(
                doctorId
        );
    }

    @PostMapping
    public boolean createSchedule(
            @RequestBody CreateScheduleDTO dto
    ) {

        return scheduleService.createSchedule(dto);
    }

    @PutMapping
    public boolean updateSchedule(
            @RequestBody UpdateScheduleDTO dto
    ) {

        return scheduleService.updateSchedule(dto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSchedule(
            @PathVariable int id
    ) {

        return scheduleService.deleteSchedule(id);
    }
}