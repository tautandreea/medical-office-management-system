package com.cabinetmedical.doctorservice.doctor.infrastructure;

import com.cabinetmedical.doctorservice.doctor.domain.Doctor;
import com.cabinetmedical.doctorservice.doctor.domain.daocontracts.IDoctorDAO;
import com.cabinetmedical.doctorservice.doctor.infrastructure.tableEntities.DoctorTableEntity;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorDAO implements IDoctorDAO {

    private final DoctorRepository doctorRepository;

    public DoctorDAO(
            DoctorRepository doctorRepository
    ) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> findAll() {

        return doctorRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public Doctor findById(int id) {

        Optional<DoctorTableEntity> entity =
                doctorRepository.findById(id);

        return entity
                .map(this::mapToDomain)
                .orElse(null);
    }

    @Override
    public List<Doctor> findByName(String name) {

        return doctorRepository
                .findByFirstNameContainingIgnoreCase(name)
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public List<Doctor> findBySpecializationId(
            int specializationId
    ) {

        return doctorRepository
                .findBySpecializationId(specializationId)
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public boolean insert(Doctor doctor) {

        try {

            doctorRepository.save(
                    mapToTableEntity(doctor)
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean update(Doctor doctor) {

        try {

            doctorRepository.save(
                    mapToTableEntity(doctor)
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean delete(int id) {

        try {

            doctorRepository.deleteById(id);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    private Doctor mapToDomain(
            DoctorTableEntity entity
    ) {

        return new Doctor(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getSpecializationId(),
                entity.getCv(),
                entity.getPhoto()
        );
    }

    private DoctorTableEntity mapToTableEntity(
            Doctor doctor
    ) {

        return new DoctorTableEntity(
                doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getSpecializationId(),
                doctor.getCv(),
                doctor.getPhoto()
        );
    }
}