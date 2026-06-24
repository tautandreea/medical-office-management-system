package com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.medicalrecord;

import com.cabinetmedical.statisticsexportservice.domain.export.ExportData;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportFormat;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportType;
import com.cabinetmedical.statisticsexportservice.domain.export.MedicalRecordExport;
import com.cabinetmedical.statisticsexportservice.domain.export.dto.MedicalRecordDTO;

public class MedicalRecordDocExportFormat
        implements ExportFormat {

    @Override
    public ExportType getType() {

        return ExportType.DOC;
    }

    @Override
    public String export(
            ExportData data
    ) {

        MedicalRecordExport export =
                (MedicalRecordExport) data;

        StringBuilder doc =
                new StringBuilder();

        doc.append(
                "===== MEDICAL RECORD =====\n\n"
        );

        for (
                MedicalRecordDTO record :
                export.getMedicalRecords()
        ) {

            doc.append(
                    "Record ID: "
            ).append(
                    record.getId()
            ).append("\n");

            doc.append(
                    "Patient ID: "
            ).append(
                    record.getPatientId()
            ).append("\n");

            doc.append(
                    "Symptoms: "
            ).append(
                    record.getSymptoms()
            ).append("\n");

            doc.append(
                    "Diagnosis: "
            ).append(
                    record.getDiagnosis()
            ).append("\n");

            doc.append(
                    "Treatment: "
            ).append(
                    record.getTreatment()
            ).append("\n");

            doc.append(
                    "-----------------------------------\n"
            );
        }

        return doc.toString();
    }
}