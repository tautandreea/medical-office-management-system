package com.cabinetmedical.patientmedicalrecordservice.patient.controllers;

import com.cabinetmedical.patientmedicalrecordservice.patient.domain.Patient;

import com.cabinetmedical.patientmedicalrecordservice.patient.domain.dto.CreatePatientDTO;
import com.cabinetmedical.patientmedicalrecordservice.patient.domain.dto.UpdatePatientDTO;

import com.cabinetmedical.patientmedicalrecordservice.patient.services.PatientService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(
            PatientService patientService
    ) {
        this.patientService = patientService;
    }

    // GET ALL

    @GetMapping
    public List<Patient> getAllPatients() {

        return patientService.getAllPatients();
    }

    // GET BY ID

    @GetMapping("/{id}")
    public Patient getPatientById(
            @PathVariable int id
    ) {

        return patientService.getPatientById(id);
    }

    // SEARCH BY NAME

    @GetMapping("/search")
    public List<Patient> searchPatientsByName(
            @RequestParam String name
    ) {

        return patientService.searchPatientsByName(name);
    }

    // FILTER BY AGE

    @GetMapping("/filter/age")
    public List<Patient> filterPatientsByAge(
            @RequestParam int age
    ) {

        return patientService.filterPatientsByAge(age);
    }

    // CREATE

    @PostMapping
    public boolean createPatient(
            @RequestBody CreatePatientDTO dto
    ) {

        return patientService.createPatient(dto);
    }

    // UPDATE

    @PutMapping
    public boolean updatePatient(
            @RequestBody UpdatePatientDTO dto
    ) {

        return patientService.updatePatient(dto);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public boolean deletePatient(
            @PathVariable int id
    ) {

        return patientService.deletePatient(id);
    }
}