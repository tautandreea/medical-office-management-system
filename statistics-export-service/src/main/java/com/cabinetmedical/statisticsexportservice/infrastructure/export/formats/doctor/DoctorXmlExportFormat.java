package com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.doctor;

import com.cabinetmedical.statisticsexportservice.domain.export.DoctorExport;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportData;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportFormat;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportType;
import com.cabinetmedical.statisticsexportservice.domain.export.dto.DoctorDTO;

public class DoctorXmlExportFormat
        implements ExportFormat {

    @Override
    public ExportType getType() {

        return ExportType.XML;
    }

    @Override
    public String export(
            ExportData data
    ) {

        DoctorExport export =
                (DoctorExport) data;

        StringBuilder xml =
                new StringBuilder();

        xml.append("<doctors>\n");

        for (
                DoctorDTO doctor :
                export.getDoctors()
        ) {

            xml.append("  <doctor>\n");

            xml.append(
                    "    <id>"
            ).append(
                    doctor.getId()
            ).append(
                    "</id>\n"
            );

            xml.append(
                    "    <firstName>"
            ).append(
                    doctor.getFirstName()
            ).append(
                    "</firstName>\n"
            );

            xml.append(
                    "    <lastName>"
            ).append(
                    doctor.getLastName()
            ).append(
                    "</lastName>\n"
            );

            xml.append(
                    "    <specialization>"
            ).append(
                    doctor.getSpecializationName()
            ).append(
                    "</specialization>\n"
            );

            xml.append("  </doctor>\n");
        }

        xml.append("</doctors>");

        return xml.toString();
    }
}