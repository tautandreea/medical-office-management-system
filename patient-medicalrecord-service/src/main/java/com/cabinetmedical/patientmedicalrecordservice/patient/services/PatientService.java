package com.cabinetmedical.patientmedicalrecordservice.patient.services;

import com.cabinetmedical.patientmedicalrecordservice.patient.domain.Patient;

import com.cabinetmedical.patientmedicalrecordservice.patient.domain.daocontracts.IPatientDAO;

import com.cabinetmedical.patientmedicalrecordservice.patient.domain.dto.CreatePatientDTO;
import com.cabinetmedical.patientmedicalrecordservice.patient.domain.dto.UpdatePatientDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final IPatientDAO patientDAO;

    public PatientService(
            IPatientDAO patientDAO
    ) {
        this.patientDAO = patientDAO;
    }

    // GET ALL

    public List<Patient> getAllPatients() {

        return patientDAO.findAll();
    }

    // GET BY ID

    public Patient getPatientById(int id) {

        return patientDAO.findById(id);
    }

    // SEARCH BY NAME

    public List<Patient> searchPatientsByName(
            String name
    ) {

        return patientDAO.findByName(name);
    }

    // FILTER BY AGE

    public List<Patient> filterPatientsByAge(
            int age
    ) {

        return patientDAO.findByAge(age);
    }

    // CREATE

    public boolean createPatient(
            CreatePatientDTO dto
    ) {

        if (dto == null) {
            return false;
        }

        if (dto.getFirstName() == null
                || dto.getFirstName().isEmpty()) {

            return false;
        }

        if (dto.getLastName() == null
                || dto.getLastName().isEmpty()) {

            return false;
        }

        if (dto.getCnp() == null
                || dto.getCnp().isEmpty()) {

            return false;
        }

        if (patientDAO.existsByCnp(dto.getCnp())) {
            return false;
        }

        Patient patient = new Patient(
                0,
                dto.getCnp(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getAge(),
                dto.getGender(),
                dto.getEmail(),
                dto.getPhone()
        );

        return patientDAO.insert(patient);
    }

    // UPDATE

    public boolean updatePatient(
            UpdatePatientDTO dto
    ) {

        Patient existingPatient =
                patientDAO.findById(dto.getId());

        if (existingPatient == null) {
            return false;
        }

        Patient updatedPatient = new Patient(
                dto.getId(),
                dto.getCnp(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getAge(),
                dto.getGender(),
                dto.getEmail(),
                dto.getPhone()
        );

        return patientDAO.update(updatedPatient);
    }

    // DELETE

    public boolean deletePatient(int id) {

        Patient existingPatient =
                patientDAO.findById(id);

        if (existingPatient == null) {
            return false;
        }

        return patientDAO.delete(id);
    }
}