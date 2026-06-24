package com.cabinetmedical.usernotificationservice.user.domain.dto;

import com.cabinetmedical.usernotificationservice.user.domain.enums.UserRole;

public class CreateUserDTO {

    private String username;

    private String password;

    private String email;

    private String phone;

    private UserRole role;

    private Integer doctorId;

    private Integer patientId;

    private Integer assistantId;

    public CreateUserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(
            String username
    ) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(
            String password
    ) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(
            String email
    ) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(
            String phone
    ) {
        this.phone = phone;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(
            UserRole role
    ) {
        this.role = role;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(
            Integer doctorId
    ) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(
            Integer patientId
    ) {
        this.patientId = patientId;
    }

    public Integer getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(
            Integer assistantId
    ) {
        this.assistantId = assistantId;
    }
}