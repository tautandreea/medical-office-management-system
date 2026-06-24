package com.cabinetmedical.doctorservice.doctor.infrastructure;

import com.cabinetmedical.doctorservice.doctor.infrastructure.tableEntities.DoctorTableEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository
        extends JpaRepository<DoctorTableEntity, Integer> {

    List<DoctorTableEntity>
    findByFirstNameContainingIgnoreCase(String name);

    List<DoctorTableEntity>
    findByLastNameContainingIgnoreCase(String name);

    List<DoctorTableEntity>
    findBySpecializationId(int specializationId);
}