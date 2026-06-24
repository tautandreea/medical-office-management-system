package com.cabinetmedical.doctorservice.specialization.infrastructure;

import com.cabinetmedical.doctorservice.specialization.infrastructure.tableEntities.SpecializationTableEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecializationRepository
        extends JpaRepository<SpecializationTableEntity, Integer> {

    Optional<SpecializationTableEntity>
    findByNameIgnoreCase(String name);
}