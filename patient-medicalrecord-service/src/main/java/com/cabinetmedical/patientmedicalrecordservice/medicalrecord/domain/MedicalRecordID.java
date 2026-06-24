package com.cabinetmedical.patientmedicalrecordservice.medicalrecord.domain;

public class MedicalRecordID {

    private int id;

    public MedicalRecordID() {
    }

    public MedicalRecordID(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}