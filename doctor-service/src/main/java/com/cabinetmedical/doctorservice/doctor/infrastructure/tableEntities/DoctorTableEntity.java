package com.cabinetmedical.doctorservice.doctor.infrastructure.tableEntities;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class DoctorTableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private int specializationId;

    @Column(columnDefinition = "TEXT")
    private String cv;

    private String photo;

    public DoctorTableEntity() {
    }

    public DoctorTableEntity(
            int id,
            String firstName,
            String lastName,
            int specializationId,
            String cv,
            String photo
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specializationId = specializationId;
        this.cv = cv;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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