package com.cabinetmedical.statisticsexportservice.domain.statistics.dto;

public class AppointmentsPerDoctorDTO {

    private String doctorName;

    private int appointments;

    public AppointmentsPerDoctorDTO() {
    }

    public AppointmentsPerDoctorDTO(
            String doctorName,
            int appointments
    ) {
        this.doctorName = doctorName;
        this.appointments = appointments;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(
            String doctorName
    ) {
        this.doctorName = doctorName;
    }

    public int getAppointments() {
        return appointments;
    }

    public void setAppointments(
            int appointments
    ) {
        this.appointments = appointments;
    }
}