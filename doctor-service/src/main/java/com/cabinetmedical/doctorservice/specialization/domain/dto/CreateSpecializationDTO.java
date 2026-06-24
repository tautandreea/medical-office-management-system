package com.cabinetmedical.doctorservice.specialization.domain.dto;

public class CreateSpecializationDTO {

    private String name;

    private String description;

    public CreateSpecializationDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}