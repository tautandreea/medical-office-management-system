package com.cabinetmedical.doctorservice.schedule.infrastructure;

import com.cabinetmedical.doctorservice.schedule.infrastructure.tableEntities.ScheduleTableEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository
        extends JpaRepository<ScheduleTableEntity, Integer> {

    List<ScheduleTableEntity>
    findByDoctorId(int doctorId);
}