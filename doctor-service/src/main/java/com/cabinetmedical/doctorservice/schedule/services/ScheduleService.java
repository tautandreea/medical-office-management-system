package com.cabinetmedical.doctorservice.schedule.services;

import com.cabinetmedical.doctorservice.doctor.domain.Doctor;
import com.cabinetmedical.doctorservice.doctor.domain.daocontracts.IDoctorDAO;

import com.cabinetmedical.doctorservice.schedule.domain.Schedule;
import com.cabinetmedical.doctorservice.schedule.domain.daocontracts.IScheduleDAO;
import com.cabinetmedical.doctorservice.schedule.domain.dto.CreateScheduleDTO;
import com.cabinetmedical.doctorservice.schedule.domain.dto.UpdateScheduleDTO;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class ScheduleService {

    private final IScheduleDAO scheduleDAO;

    private final IDoctorDAO doctorDAO;

    public ScheduleService(
            IScheduleDAO scheduleDAO,
            IDoctorDAO doctorDAO
    ) {
        this.scheduleDAO = scheduleDAO;
        this.doctorDAO = doctorDAO;
    }

    // GET ALL

    public List<Schedule> getAllSchedules() {

        return scheduleDAO.findAll();
    }

    // GET BY ID

    public Schedule getScheduleById(
            int id
    ) {

        return scheduleDAO.findById(id);
    }

    // GET BY DOCTOR

    public List<Schedule> getSchedulesByDoctorId(
            int doctorId
    ) {

        return scheduleDAO.findByDoctorId(
                doctorId
        );
    }

    // CREATE

    public boolean createSchedule(
            CreateScheduleDTO dto
    ) {

        if (!isValid(dto)) {
            return false;
        }

        Schedule schedule =
                new Schedule(
                        0,
                        dto.getDoctorId(),
                        dto.getDayOfWeek().toUpperCase(),
                        dto.getStartTime(),
                        dto.getEndTime()
                );

        return scheduleDAO.insert(schedule);
    }

    // UPDATE

    public boolean updateSchedule(
            UpdateScheduleDTO dto
    ) {

        Schedule existing =
                scheduleDAO.findById(
                        dto.getScheduleId()
                );

        if (existing == null) {
            return false;
        }

        if (!isValid(dto)) {
            return false;
        }

        Schedule updated =
                new Schedule(
                        dto.getScheduleId(),
                        dto.getDoctorId(),
                        dto.getDayOfWeek().toUpperCase(),
                        dto.getStartTime(),
                        dto.getEndTime()
                );

        return scheduleDAO.update(updated);
    }

    // DELETE

    public boolean deleteSchedule(
            int id
    ) {

        Schedule existing =
                scheduleDAO.findById(id);

        if (existing == null) {
            return false;
        }

        return scheduleDAO.delete(id);
    }

    // =====================================
    // VALIDATIONS
    // =====================================

    private boolean isValid(
            CreateScheduleDTO dto
    ) {

        return validateDoctor(dto.getDoctorId())
                && validateDay(dto.getDayOfWeek())
                && validateTimeInterval(
                dto.getStartTime(),
                dto.getEndTime()
        )
                && validateDuplicate(
                dto.getDoctorId(),
                dto.getDayOfWeek(),
                dto.getStartTime(),
                dto.getEndTime()
        )
                && validateOverlap(
                dto.getDoctorId(),
                dto.getDayOfWeek(),
                dto.getStartTime(),
                dto.getEndTime()
        );
    }

    private boolean isValid(
            UpdateScheduleDTO dto
    ) {

        return validateDoctor(dto.getDoctorId())
                && validateDay(dto.getDayOfWeek())
                && validateTimeInterval(
                dto.getStartTime(),
                dto.getEndTime()
        );
    }

    // doctor exists

    private boolean validateDoctor(
            int doctorId
    ) {

        Doctor doctor =
                doctorDAO.findById(
                        doctorId
                );

        return doctor != null;
    }

    // valid day

    private boolean validateDay(
            String day
    ) {

        if (day == null) {
            return false;
        }

        List<String> validDays =
                List.of(
                        "MONDAY",
                        "TUESDAY",
                        "WEDNESDAY",
                        "THURSDAY",
                        "FRIDAY",
                        "SATURDAY",
                        "SUNDAY"
                );

        return validDays.contains(
                day.toUpperCase()
        );
    }

    // start < end

    private boolean validateTimeInterval(
            String startTime,
            String endTime
    ) {

        try {

            LocalTime start =
                    LocalTime.parse(startTime);

            LocalTime end =
                    LocalTime.parse(endTime);

            return start.isBefore(end);

        } catch (Exception e) {

            return false;
        }
    }

    // no duplicates

    private boolean validateDuplicate(
            int doctorId,
            String day,
            String startTime,
            String endTime
    ) {

        List<Schedule> schedules =
                scheduleDAO.findByDoctorId(
                        doctorId
                );

        return schedules.stream()
                .noneMatch(
                        s ->
                                s.getDayOfWeek()
                                        .equalsIgnoreCase(day)
                                        &&
                                        s.getStartTime()
                                                .equals(startTime)
                                        &&
                                        s.getEndTime()
                                                .equals(endTime)
                );
    }

    // no overlaps

    private boolean validateOverlap(
            int doctorId,
            String day,
            String startTime,
            String endTime
    ) {

        List<Schedule> schedules =
                scheduleDAO.findByDoctorId(
                        doctorId
                );

        LocalTime newStart =
                LocalTime.parse(startTime);

        LocalTime newEnd =
                LocalTime.parse(endTime);

        for (Schedule existing : schedules) {

            if (!existing.getDayOfWeek()
                    .equalsIgnoreCase(day)) {

                continue;
            }

            LocalTime existingStart =
                    LocalTime.parse(
                            existing.getStartTime()
                    );

            LocalTime existingEnd =
                    LocalTime.parse(
                            existing.getEndTime()
                    );

            boolean overlap =
                    newStart.isBefore(existingEnd)
                            &&
                            newEnd.isAfter(existingStart);

            if (overlap) {
                return false;
            }
        }

        return true;
    }
}