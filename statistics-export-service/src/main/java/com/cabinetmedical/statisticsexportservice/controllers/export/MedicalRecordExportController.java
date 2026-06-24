package com.cabinetmedical.statisticsexportservice.controllers.export;

import com.cabinetmedical.statisticsexportservice.services.export.MedicalRecordExportService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/export/medical-records")
public class MedicalRecordExportController {

    private final MedicalRecordExportService
            medicalRecordExportService;

    public MedicalRecordExportController(
            MedicalRecordExportService medicalRecordExportService
    ) {

        this.medicalRecordExportService =
                medicalRecordExportService;
    }

    @GetMapping
    public String exportMedicalRecords() {

        return medicalRecordExportService
                .exportMedicalRecords();
    }

    @GetMapping("/{id}")
    public String exportMedicalRecordById(

            @PathVariable int id

    ) {

        return medicalRecordExportService
                .exportMedicalRecordById(id);
    }
}