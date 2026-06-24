package com.cabinetmedical.appointmentservice.domain.daocontracts;

import com.cabinetmedical.appointmentservice.domain.Appointment;
import com.cabinetmedical.appointmentservice.domain.enums.AppointmentStatus;

import java.util.List;

public interface IAppointmentDAO {

    List<Appointment> findAll();

    Appointment findById(int id);

    List<Appointment> findByDoctorId(
            int doctorId
    );

    List<Appointment> findByPatientId(
            int patientId
    );

    List<Appointment> findByStatus(
            AppointmentStatus status
    );

    boolean insert(
            Appointment appointment
    );

    boolean update(
            Appointment appointment
    );

    boolean delete(
            int id
    );
}