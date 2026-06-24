package com.cabinetmedical.statisticsexportservice.domain.export;

import com.cabinetmedical.statisticsexportservice.domain.export.dto.PatientDTO;

import java.util.List;

public class PatientExport extends ExportData {

    private List<PatientDTO> patients;

    public PatientExport(
            ExportFormat exportFormat,
            List<PatientDTO> patients
    ) {

        super(exportFormat);

        this.patients = patients;
    }

    public List<PatientDTO> getPatients() {
        return patients;
    }

    @Override
    public String export() {

        return exportFormat.export(this);
    }
}