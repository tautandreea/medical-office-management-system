package com.cabinetmedical.statisticsexportservice.infrastructure.statistics.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicalRecordDTO {

    private int patientId;

    private String diagnosis;

    public MedicalRecordDTO() {
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(
            int patientId
    ) {
        this.patientId = patientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(
            String diagnosis
    ) {
        this.diagnosis = diagnosis;
    }
}