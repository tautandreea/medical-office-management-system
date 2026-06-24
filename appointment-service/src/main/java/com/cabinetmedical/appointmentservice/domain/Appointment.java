package com.cabinetmedical.appointmentservice.domain;

import com.cabinetmedical.appointmentservice.domain.enums.AppointmentStatus;

import java.time.LocalDateTime;

public class Appointment {

    private AppointmentID appointmentID;

    private int patientId;

    private int doctorId;

    private LocalDateTime appointmentDate;

    private AppointmentStatus status;

    public Appointment() {
    }

    public Appointment(
            int id,
            int patientId,
            int doctorId,
            LocalDateTime appointmentDate,
            AppointmentStatus status
    ) {

        this.appointmentID =
                new AppointmentID(id);

        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public int getId() {
        return appointmentID.getId();
    }

    public void setId(int id) {
        this.appointmentID.setId(id);
    }

    public AppointmentID getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(
            AppointmentID appointmentID
    ) {
        this.appointmentID = appointmentID;
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