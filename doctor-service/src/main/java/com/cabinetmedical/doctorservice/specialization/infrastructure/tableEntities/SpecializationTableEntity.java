package com.cabinetmedical.doctorservice.specialization.infrastructure.tableEntities;

import jakarta.persistence.*;

@Entity
@Table(name = "specializations")
public class SpecializationTableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specializationId;

    @Column(unique = true)
    private String name;

    private String description;

    public SpecializationTableEntity() {
    }

    public SpecializationTableEntity(
            int specializationId,
            String name,
            String description
    ) {
        this.specializationId = specializationId;
        this.name = name;
        this.description = description;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
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