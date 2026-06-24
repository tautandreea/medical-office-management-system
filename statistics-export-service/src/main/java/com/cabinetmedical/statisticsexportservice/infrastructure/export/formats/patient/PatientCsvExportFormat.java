package com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.patient;

import com.cabinetmedical.statisticsexportservice.domain.export.ExportData;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportFormat;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportType;
import com.cabinetmedical.statisticsexportservice.domain.export.PatientExport;
import com.cabinetmedical.statisticsexportservice.domain.export.dto.PatientDTO;

public class PatientCsvExportFormat
        implements ExportFormat {

    @Override
    public ExportType getType() {

        return ExportType.CSV;
    }

    @Override
    public String export(
            ExportData data
    ) {

        PatientExport export =
                (PatientExport) data;

        StringBuilder csv =
                new StringBuilder();

        csv.append(
                "ID,FirstName,LastName,Age,Gender\n"
        );

        for (
                PatientDTO patient :
                export.getPatients()
        ) {

            csv.append(
                            patient.getId()
                    ).append(",")

                    .append(
                            patient.getFirstName()
                    ).append(",")

                    .append(
                            patient.getLastName()
                    ).append(",")

                    .append(
                            patient.getAge()
                    ).append(",")

                    .append(
                            patient.getGender()
                    ).append("\n");
        }

        return csv.toString();
    }
}