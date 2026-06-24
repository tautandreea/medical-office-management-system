package com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.patient;

import com.cabinetmedical.statisticsexportservice.domain.export.*;

public class PatientXmlExportFormat
        implements ExportFormat {

    @Override
    public ExportType getType() {

        return ExportType.XML;
    }

    @Override
    public String export(
            ExportData data
    ) {

        PatientExport export =
                (PatientExport) data;

        StringBuilder xml =
                new StringBuilder();

        xml.append("<patients>\n");

        export.getPatients().forEach(patient -> {

            xml.append("  <patient>\n");

            xml.append(
                    "    <id>"
            ).append(
                    patient.getId()
            ).append(
                    "</id>\n"
            );

            xml.append(
                    "    <firstName>"
            ).append(
                    patient.getFirstName()
            ).append(
                    "</firstName>\n"
            );

            xml.append(
                    "    <lastName>"
            ).append(
                    patient.getLastName()
            ).append(
                    "</lastName>\n"
            );

            xml.append(
                    "    <age>"
            ).append(
                    patient.getAge()
            ).append(
                    "</age>\n"
            );

            xml.append(
                    "    <gender>"
            ).append(
                    patient.getGender()
            ).append(
                    "</gender>\n"
            );

            xml.append("  </patient>\n");
        });

        xml.append("</patients>");

        return xml.toString();
    }
}