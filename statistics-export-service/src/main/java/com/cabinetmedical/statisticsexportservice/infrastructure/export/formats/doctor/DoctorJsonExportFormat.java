package com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.doctor;

import com.cabinetmedical.statisticsexportservice.domain.export.*;

public class DoctorJsonExportFormat
        implements ExportFormat {

    @Override
    public ExportType getType() {

        return ExportType.JSON;
    }

    @Override
    public String export(
            ExportData data
    ) {

        DoctorExport export =
                (DoctorExport) data;

        StringBuilder json =
                new StringBuilder();

        json.append("[\n");

        for (
                int i = 0;
                i < export.getDoctors().size();
                i++
        ) {

            var doctor =
                    export.getDoctors().get(i);

            json.append("  {\n");

            json.append(
                    "    \"id\": "
            ).append(
                    doctor.getId()
            ).append(",\n");

            json.append(
                    "    \"firstName\": \""
            ).append(
                    doctor.getFirstName()
            ).append("\",\n");

            json.append(
                    "    \"lastName\": \""
            ).append(
                    doctor.getLastName()
            ).append("\",\n");

            json.append(
                    "    \"specialization\": \""
            ).append(
                    doctor.getSpecializationName()
            ).append("\"\n");

            json.append("  }");

            if (
                    i <
                            export.getDoctors().size() - 1
            ) {

                json.append(",");
            }

            json.append("\n");
        }

        json.append("]");

        return json.toString();
    }
}