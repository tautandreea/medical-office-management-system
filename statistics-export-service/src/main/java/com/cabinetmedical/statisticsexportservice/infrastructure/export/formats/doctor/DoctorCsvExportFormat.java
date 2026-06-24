package com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.doctor;

import com.cabinetmedical.statisticsexportservice.domain.export.DoctorExport;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportData;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportFormat;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportType;
import com.cabinetmedical.statisticsexportservice.domain.export.dto.DoctorDTO;

public class DoctorCsvExportFormat
        implements ExportFormat {

    @Override
    public ExportType getType() {

        return ExportType.CSV;
    }

    @Override
    public String export(
            ExportData data
    ) {

        DoctorExport export =
                (DoctorExport) data;

        StringBuilder csv =
                new StringBuilder();

        csv.append(
                "ID,FirstName,LastName,Specialization\n"
        );

        for (
                DoctorDTO doctor :
                export.getDoctors()
        ) {

            csv.append(
                            doctor.getId()
                    ).append(",")

                    .append(
                            doctor.getFirstName()
                    ).append(",")

                    .append(
                            doctor.getLastName()
                    ).append(",")

                    .append(
                            doctor.getSpecializationName()
                    ).append("\n");
        }

        return csv.toString();
    }
}