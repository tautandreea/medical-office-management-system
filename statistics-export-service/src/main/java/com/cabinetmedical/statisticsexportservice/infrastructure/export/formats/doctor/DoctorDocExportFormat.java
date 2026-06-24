package com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.doctor;

import com.cabinetmedical.statisticsexportservice.domain.export.DoctorExport;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportData;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportFormat;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportType;
import com.cabinetmedical.statisticsexportservice.domain.export.dto.DoctorDTO;

public class DoctorDocExportFormat
        implements ExportFormat {

    @Override
    public ExportType getType() {

        return ExportType.DOC;
    }

    @Override
    public String export(
            ExportData data
    ) {

        DoctorExport export =
                (DoctorExport) data;

        StringBuilder doc =
                new StringBuilder();

        doc.append(
                "===== DOCTORS =====\n\n"
        );

        for (
                DoctorDTO doctor :
                export.getDoctors()
        ) {

            doc.append(
                    "ID: "
            ).append(
                    doctor.getId()
            ).append("\n");

            doc.append(
                    "First Name: "
            ).append(
                    doctor.getFirstName()
            ).append("\n");

            doc.append(
                    "Last Name: "
            ).append(
                    doctor.getLastName()
            ).append("\n");

            doc.append(
                    "Specialization: "
            ).append(
                    doctor.getSpecializationName()
            ).append("\n");

            doc.append(
                    "---------------------------\n"
            );
        }

        return doc.toString();
    }
}