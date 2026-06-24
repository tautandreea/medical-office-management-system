package com.cabinetmedical.patientmedicalrecordservice.patient.infrastructure;

import com.cabinetmedical.patientmedicalrecordservice.patient.infrastructure.tableEntities.PatientTableEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository
        extends JpaRepository<PatientTableEntity, Integer> {

    List<PatientTableEntity> findByFirstNameContainingIgnoreCase(
            String firstName
    );

    List<PatientTableEntity> findByAge(int age);

    boolean existsByCnp(String cnp);
}