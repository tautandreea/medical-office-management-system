package com.cabinetmedical.doctorservice.doctor.services;

import com.cabinetmedical.doctorservice.doctor.domain.Doctor;
import com.cabinetmedical.doctorservice.doctor.domain.daocontracts.IDoctorDAO;
import com.cabinetmedical.doctorservice.doctor.domain.dto.CreateDoctorDTO;
import com.cabinetmedical.doctorservice.doctor.domain.dto.UpdateDoctorDTO;

import com.cabinetmedical.doctorservice.specialization.domain.Specialization;
import com.cabinetmedical.doctorservice.specialization.domain.dto.CreateSpecializationDTO;
import com.cabinetmedical.doctorservice.specialization.services.SpecializationService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final IDoctorDAO doctorDAO;

    private final SpecializationService specializationService;

    public DoctorService(
            IDoctorDAO doctorDAO,
            SpecializationService specializationService
    ) {
        this.doctorDAO = doctorDAO;
        this.specializationService = specializationService;
    }

    public List<Doctor> getAllDoctors() {

        return doctorDAO.findAll();
    }

    public Doctor getDoctorById(int id) {

        return doctorDAO.findById(id);
    }

    public List<Doctor> searchDoctorsByName(
            String name
    ) {

        return doctorDAO.findByName(name);
    }

    public List<Doctor> getDoctorsBySpecialization(
            int specializationId
    ) {

        return doctorDAO.findBySpecializationId(
                specializationId
        );
    }

    public boolean createDoctor(
            CreateDoctorDTO dto
    ) {

        if (dto == null) {
            return false;
        }

        if (dto.getFirstName() == null
                || dto.getFirstName().isBlank()) {

            return false;
        }

        if (dto.getLastName() == null
                || dto.getLastName().isBlank()) {

            return false;
        }

        Specialization specialization =
                specializationService.getSpecializationByName(
                        dto.getSpecializationName()
                );

        if (specialization == null) {

            CreateSpecializationDTO createSpec =
                    new CreateSpecializationDTO();

            createSpec.setName(
                    dto.getSpecializationName()
            );

            createSpec.setDescription(
                    "Auto generated"
            );

            specializationService.createSpecialization(
                    createSpec
            );

            specialization =
                    specializationService.getSpecializationByName(
                            dto.getSpecializationName()
                    );
        }

        Doctor doctor =
                new Doctor(
                        0,
                        dto.getFirstName(),
                        dto.getLastName(),
                        specialization.getId(),
                        dto.getCv(),
                        dto.getPhoto()
                );

        return doctorDAO.insert(
                doctor
        );
    }

    public boolean updateDoctor(
            UpdateDoctorDTO dto
    ) {

        Doctor existingDoctor =
                doctorDAO.findById(
                        dto.getId()
                );

        if (existingDoctor == null) {
            return false;
        }

        Specialization specialization =
                specializationService.getSpecializationByName(
                        dto.getSpecializationName()
                );

        if (specialization == null) {
            return false;
        }

        Doctor updatedDoctor =
                new Doctor(
                        dto.getId(),
                        dto.getFirstName(),
                        dto.getLastName(),
                        specialization.getId(),
                        dto.getCv(),
                        dto.getPhoto()
                );

        return doctorDAO.update(
                updatedDoctor
        );
    }

    public boolean deleteDoctor(
            int id
    ) {

        Doctor existingDoctor =
                doctorDAO.findById(id);

        if (existingDoctor == null) {
            return false;
        }

        return doctorDAO.delete(id);
    }
}