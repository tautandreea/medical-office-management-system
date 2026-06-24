package com.cabinetmedical.doctorservice.doctor.domain;

public class Doctor {

    private DoctorID doctorID;

    private String firstName;

    private String lastName;

    private int specializationId;

    private String cv;

    private String photo;

    public Doctor() {
    }

    public Doctor(
            int id,
            String firstName,
            String lastName,
            int specializationId,
            String cv,
            String photo
    ) {
        this.doctorID = new DoctorID(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.specializationId = specializationId;
        this.cv = cv;
        this.photo = photo;
    }

    public int getId() {
        return doctorID.getId();
    }

    public void setId(int id) {
        this.doctorID.setId(id);
    }

    public DoctorID getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(DoctorID doctorID) {
        this.doctorID = doctorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}