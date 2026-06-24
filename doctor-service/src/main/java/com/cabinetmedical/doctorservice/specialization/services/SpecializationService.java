package com.cabinetmedical.doctorservice.specialization.services;

import com.cabinetmedical.doctorservice.specialization.domain.Specialization;
import com.cabinetmedical.doctorservice.specialization.domain.daocontracts.ISpecializationDAO;
import com.cabinetmedical.doctorservice.specialization.domain.dto.CreateSpecializationDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {

    private final ISpecializationDAO specializationDAO;

    public SpecializationService(
            ISpecializationDAO specializationDAO
    ) {
        this.specializationDAO = specializationDAO;
    }

    public List<Specialization> getAllSpecializations() {

        return specializationDAO.findAll();
    }

    public Specialization getSpecializationById(
            int id
    ) {

        return specializationDAO.findById(id);
    }

    public Specialization getSpecializationByName(
            String name
    ) {

        return specializationDAO.findByName(name);
    }

    public boolean createSpecialization(
            CreateSpecializationDTO dto
    ) {

        if (dto == null) {
            return false;
        }

        if (dto.getName() == null
                || dto.getName().isBlank()) {

            return false;
        }

        Specialization existing =
                specializationDAO.findByName(
                        dto.getName()
                );

        if (existing != null) {
            return false;
        }

        Specialization specialization =
                new Specialization(
                        0,
                        dto.getName(),
                        dto.getDescription()
                );

        return specializationDAO.insert(
                specialization
        );
    }
}