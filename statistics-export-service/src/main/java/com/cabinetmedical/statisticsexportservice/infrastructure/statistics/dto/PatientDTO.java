package com.cabinetmedical.statisticsexportservice.infrastructure.statistics.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientDTO {

    private int id;

    private int age;

    public PatientDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(
            int id
    ) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(
            int age
    ) {
        this.age = age;
    }
}