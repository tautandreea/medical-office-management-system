package com.cabinetmedical.appointmentservice.domain.dto;

import java.time.LocalDateTime;

public class CreateAppointmentDTO {

    private int patientId;

    private int doctorId;

    private LocalDateTime appointmentDate;

    public CreateAppointmentDTO() {
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
}