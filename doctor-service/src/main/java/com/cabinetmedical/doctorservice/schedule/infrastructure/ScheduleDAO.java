package com.cabinetmedical.doctorservice.schedule.infrastructure;

import com.cabinetmedical.doctorservice.schedule.domain.Schedule;
import com.cabinetmedical.doctorservice.schedule.domain.daocontracts.IScheduleDAO;
import com.cabinetmedical.doctorservice.schedule.infrastructure.tableEntities.ScheduleTableEntity;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScheduleDAO implements IScheduleDAO {

    private final ScheduleRepository scheduleRepository;

    public ScheduleDAO(
            ScheduleRepository scheduleRepository
    ) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> findAll() {

        return scheduleRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public Schedule findById(int id) {

        Optional<ScheduleTableEntity> entity =
                scheduleRepository.findById(id);

        return entity
                .map(this::mapToDomain)
                .orElse(null);
    }

    @Override
    public List<Schedule> findByDoctorId(int doctorId) {

        return scheduleRepository
                .findByDoctorId(doctorId)
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public boolean insert(Schedule schedule) {

        try {

            scheduleRepository.save(
                    mapToTableEntity(schedule)
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean update(Schedule schedule) {

        try {

            scheduleRepository.save(
                    mapToTableEntity(schedule)
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean delete(int id) {

        try {

            scheduleRepository.deleteById(id);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    private Schedule mapToDomain(
            ScheduleTableEntity entity
    ) {

        return new Schedule(
                entity.getId(),
                entity.getDoctorId(),
                entity.getDayOfWeek(),
                entity.getStartTime(),
                entity.getEndTime()
        );
    }

    private ScheduleTableEntity mapToTableEntity(
            Schedule schedule
    ) {

        return new ScheduleTableEntity(
                schedule.getScheduleId(),
                schedule.getDoctorId(),
                schedule.getDayOfWeek(),
                schedule.getStartTime(),
                schedule.getEndTime()
        );
    }
}