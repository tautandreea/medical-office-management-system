package com.cabinetmedical.statisticsexportservice.infrastructure.statistics.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentDTO {

    private int doctorId;

    public AppointmentDTO() {
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(
            int doctorId
    ) {
        this.doctorId = doctorId;
    }
}