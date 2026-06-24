package com.cabinetmedical.statisticsexportservice.controllers.export;

import com.cabinetmedical.statisticsexportservice.domain.export.ExportType;
import com.cabinetmedical.statisticsexportservice.services.export.DoctorExportService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/export/doctors")
public class DoctorExportController {

    private final DoctorExportService
            doctorExportService;

    public DoctorExportController(
            DoctorExportService doctorExportService
    ) {

        this.doctorExportService =
                doctorExportService;
    }

    @GetMapping("/{type}")
    public String exportDoctors(

            @PathVariable ExportType type
    ) {

        return doctorExportService
                .exportDoctors(type);
    }
}