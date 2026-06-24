package com.cabinetmedical.patientmedicalrecordservice.medicalrecord.domain.dto;

public class UpdateMedicalRecordDTO {

    private int id;

    private String symptoms;

    private String diagnosis;

    private String treatment;

    public UpdateMedicalRecordDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}