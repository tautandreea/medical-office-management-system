package com.cabinetmedical.statisticsexportservice.controllers.export;

import com.cabinetmedical.statisticsexportservice.domain.export.ExportType;

import com.cabinetmedical.statisticsexportservice.services.export.PatientExportService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/export/patients")
public class PatientExportController {

    private final PatientExportService
            patientExportService;

    public PatientExportController(
            PatientExportService patientExportService
    ) {

        this.patientExportService =
                patientExportService;
    }

    @GetMapping("/{type}")
    public String exportPatients(

            @PathVariable ExportType type
    ) {

        return patientExportService
                .exportPatients(type);
    }
}