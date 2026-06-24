package com.cabinetmedical.patientmedicalrecordservice.patient.domain.dto;

import com.cabinetmedical.patientmedicalrecordservice.patient.domain.enums.Gender;

public class CreatePatientDTO {

    private String firstName;

    private String lastName;

    private int age;

    private Gender gender;

    private String email;

    private String phone;

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    private String cnp;

    public CreatePatientDTO() {
    }

    public CreatePatientDTO(
            String firstName,
            String lastName,
            int age,
            Gender gender,
            String email,
            String phone,
            String cnp
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.cnp = cnp;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}