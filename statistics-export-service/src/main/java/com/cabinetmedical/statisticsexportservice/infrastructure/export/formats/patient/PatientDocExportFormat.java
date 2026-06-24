package com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.patient;

import com.cabinetmedical.statisticsexportservice.domain.export.*;

public class PatientDocExportFormat
        implements ExportFormat {

    @Override
    public ExportType getType() {

        return ExportType.DOC;
    }

    @Override
    public String export(
            ExportData data
    ) {

        PatientExport export =
                (PatientExport) data;

        StringBuilder doc =
                new StringBuilder();

        doc.append(
                "===== PATIENTS =====\n\n"
        );

        export.getPatients().forEach(patient -> {

            doc.append(
                    "ID: "
            ).append(
                    patient.getId()
            ).append("\n");

            doc.append(
                    "Name: "
            ).append(
                    patient.getFirstName()
            ).append(" ");

            doc.append(
                    patient.getLastName()
            ).append("\n");

            doc.append(
                    "Age: "
            ).append(
                    patient.getAge()
            ).append("\n");

            doc.append(
                    "Gender: "
            ).append(
                    patient.getGender()
            ).append("\n");

            doc.append(
                    "---------------------\n"
            );
        });

        return doc.toString();
    }
}