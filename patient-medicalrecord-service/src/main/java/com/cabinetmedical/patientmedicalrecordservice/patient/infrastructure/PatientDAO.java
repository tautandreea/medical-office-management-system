package com.cabinetmedical.patientmedicalrecordservice.patient.infrastructure;

import com.cabinetmedical.patientmedicalrecordservice.patient.domain.Patient;

import com.cabinetmedical.patientmedicalrecordservice.patient.domain.daocontracts.IPatientDAO;

import com.cabinetmedical.patientmedicalrecordservice.patient.infrastructure.tableEntities.PatientTableEntity;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientDAO implements IPatientDAO {

    private final PatientRepository patientRepository;

    public PatientDAO(
            PatientRepository patientRepository
    ) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAll() {

        return patientRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public Patient findById(int id) {

        Optional<PatientTableEntity> entity =
                patientRepository.findById(id);

        return entity
                .map(this::mapToDomain)
                .orElse(null);
    }

    @Override
    public List<Patient> findByName(String name) {

        return patientRepository
                .findByFirstNameContainingIgnoreCase(name)
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public boolean existsByCnp(String cnp) {

        return patientRepository.existsByCnp(cnp);
    }

    @Override
    public List<Patient> findByAge(int age) {

        return patientRepository
                .findByAge(age)
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public boolean insert(Patient patient) {

        try {

            PatientTableEntity entity =
                    mapToTableEntity(patient);

            patientRepository.save(entity);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean update(Patient patient) {

        try {

            PatientTableEntity entity =
                    mapToTableEntity(patient);

            patientRepository.save(entity);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean delete(int id) {

        try {

            patientRepository.deleteById(id);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    // MAPPERS

    private Patient mapToDomain(
            PatientTableEntity entity
    ) {

        return new Patient(
                entity.getId(),
                entity.getCnp(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getAge(),
                entity.getGender(),
                entity.getEmail(),
                entity.getPhone()
        );
    }

    private PatientTableEntity mapToTableEntity(
            Patient patient
    ) {

        return new PatientTableEntity(
                patient.getId(),
                patient.getCnp(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getAge(),
                patient.getGender(),
                patient.getEmail(),
                patient.getPhone()
        );
    }
}