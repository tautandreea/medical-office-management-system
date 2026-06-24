package com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.patient;

import com.cabinetmedical.statisticsexportservice.domain.export.*;

public class PatientJsonExportFormat
        implements ExportFormat {

    @Override
    public ExportType getType() {

        return ExportType.JSON;
    }

    @Override
    public String export(
            ExportData data
    ) {

        PatientExport export =
                (PatientExport) data;

        StringBuilder json =
                new StringBuilder();

        json.append("[\n");

        for (
                int i = 0;
                i < export.getPatients().size();
                i++
        ) {

            var patient =
                    export.getPatients().get(i);

            json.append("  {\n");

            json.append(
                    "    \"id\": "
            ).append(
                    patient.getId()
            ).append(",\n");

            json.append(
                    "    \"firstName\": \""
            ).append(
                    patient.getFirstName()
            ).append("\",\n");

            json.append(
                    "    \"lastName\": \""
            ).append(
                    patient.getLastName()
            ).append("\",\n");

            json.append(
                    "    \"age\": "
            ).append(
                    patient.getAge()
            ).append(",\n");

            json.append(
                    "    \"gender\": \""
            ).append(
                    patient.getGender()
            ).append("\"\n");

            json.append("  }");

            if (
                    i <
                            export.getPatients().size() - 1
            ) {

                json.append(",");
            }

            json.append("\n");
        }

        json.append("]");

        return json.toString();
    }
}