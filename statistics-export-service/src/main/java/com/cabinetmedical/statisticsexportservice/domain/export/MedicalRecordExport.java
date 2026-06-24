package com.cabinetmedical.statisticsexportservice.domain.export;

import com.cabinetmedical.statisticsexportservice.domain.export.dto.MedicalRecordDTO;

import java.util.List;

public class MedicalRecordExport extends ExportData {

    private List<MedicalRecordDTO> medicalRecords;

    public MedicalRecordExport(
            ExportFormat exportFormat,
            List<MedicalRecordDTO> medicalRecords
    ) {

        super(exportFormat);

        this.medicalRecords = medicalRecords;
    }

    public List<MedicalRecordDTO> getMedicalRecords() {
        return medicalRecords;
    }

    @Override
    public String export() {

        return exportFormat.export(this);
    }
}