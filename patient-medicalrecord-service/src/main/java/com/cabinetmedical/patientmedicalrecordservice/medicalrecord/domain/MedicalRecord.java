package com.cabinetmedical.patientmedicalrecordservice.medicalrecord.domain;

public class MedicalRecord {

    private MedicalRecordID medicalRecordID;

    private int patientId;

    private int doctorId;

    private String symptoms;

    private String diagnosis;

    private String treatment;

    public MedicalRecord() {
    }

    public MedicalRecord(
            int id,
            int patientId,
            int doctorId,
            String symptoms,
            String diagnosis,
            String treatment
    ) {

        this.medicalRecordID = new MedicalRecordID(id);

        this.patientId = patientId;
        this.doctorId = doctorId;

        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public int getId() {
        return medicalRecordID.getId();
    }

    public void setId(int id) {
        this.medicalRecordID.setId(id);
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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