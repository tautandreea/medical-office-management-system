package com.cabinetmedical.patientmedicalrecordservice.patient.domain;

public class PatientID {

    private int id;

    public PatientID() {
    }

    public PatientID(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}