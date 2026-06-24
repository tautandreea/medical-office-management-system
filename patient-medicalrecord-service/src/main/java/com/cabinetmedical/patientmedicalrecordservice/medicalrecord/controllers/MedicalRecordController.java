package com.cabinetmedical.patientmedicalrecordservice.medicalrecord.controllers;

import com.cabinetmedical.patientmedicalrecordservice.medicalrecord.domain.MedicalRecord;
import com.cabinetmedical.patientmedicalrecordservice.medicalrecord.domain.dto.CreateMedicalRecordDTO;
import com.cabinetmedical.patientmedicalrecordservice.medicalrecord.domain.dto.UpdateMedicalRecordDTO;
import com.cabinetmedical.patientmedicalrecordservice.medicalrecord.services.MedicalRecordService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-records")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(
            MedicalRecordService medicalRecordService
    ) {
        this.medicalRecordService = medicalRecordService;
    }

    // GET ALL

    @GetMapping
    public List<MedicalRecord> getAllMedicalRecords() {

        return medicalRecordService
                .getAllMedicalRecords();
    }

    // GET BY ID

    @GetMapping("/{id}")
    public MedicalRecord getMedicalRecordById(
            @PathVariable int id
    ) {

        return medicalRecordService
                .getMedicalRecordById(id);
    }

    // GET BY PATIENT

    @GetMapping("/patient/{patientId}")
    public List<MedicalRecord> getMedicalRecordsByPatient(
            @PathVariable int patientId
    ) {

        return medicalRecordService
                .getMedicalRecordsByPatient(patientId);
    }

    // GET BY DOCTOR

    @GetMapping("/doctor/{doctorId}")
    public List<MedicalRecord> getMedicalRecordsByDoctor(
            @PathVariable int doctorId
    ) {

        return medicalRecordService
                .getMedicalRecordsByDoctor(doctorId);
    }

    // FILTER BY DIAGNOSIS

    @GetMapping("/filter/diagnosis")
    public List<MedicalRecord> filterByDiagnosis(
            @RequestParam String value
    ) {

        return medicalRecordService
                .filterByDiagnosis(value);
    }

    // FILTER BY TREATMENT

    @GetMapping("/filter/treatment")
    public List<MedicalRecord> filterByTreatment(
            @RequestParam String value
    ) {

        return medicalRecordService
                .filterByTreatment(value);
    }

    // CREATE

    @PostMapping
    public boolean createMedicalRecord(
            @RequestBody CreateMedicalRecordDTO dto
    ) {

        return medicalRecordService
                .createMedicalRecord(dto);
    }

    // UPDATE

    @PutMapping
    public boolean updateMedicalRecord(
            @RequestBody UpdateMedicalRecordDTO dto
    ) {

        return medicalRecordService
                .updateMedicalRecord(dto);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public boolean deleteMedicalRecord(
            @PathVariable int id
    ) {

        return medicalRecordService
                .deleteMedicalRecord(id);
    }
}