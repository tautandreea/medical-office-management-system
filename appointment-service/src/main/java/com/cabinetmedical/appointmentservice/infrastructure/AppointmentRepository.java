package com.cabinetmedical.appointmentservice.infrastructure;

import com.cabinetmedical.appointmentservice.domain.enums.AppointmentStatus;
import com.cabinetmedical.appointmentservice.infrastructure.tableEntities.AppointmentTableEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository
        extends JpaRepository<AppointmentTableEntity, Integer> {

    List<AppointmentTableEntity> findByDoctorId(
            int doctorId
    );

    List<AppointmentTableEntity> findByPatientId(
            int patientId
    );

    List<AppointmentTableEntity> findByStatus(
            AppointmentStatus status
    );
}