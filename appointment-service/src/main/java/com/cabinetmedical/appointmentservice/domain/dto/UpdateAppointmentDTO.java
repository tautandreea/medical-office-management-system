package com.cabinetmedical.appointmentservice.domain.dto;

import com.cabinetmedical.appointmentservice.domain.enums.AppointmentStatus;

import java.time.LocalDateTime;

public class UpdateAppointmentDTO {

    private int id;

    private int patientId;

    private int doctorId;

    private LocalDateTime appointmentDate;

    private AppointmentStatus status;

    public UpdateAppointmentDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(
            int id
    ) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(
            int patientId
    ) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(
            int doctorId
    ) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(
            LocalDateTime appointmentDate
    ) {
        this.appointmentDate = appointmentDate;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(
            AppointmentStatus status
    ) {
        this.status = status;
    }
}