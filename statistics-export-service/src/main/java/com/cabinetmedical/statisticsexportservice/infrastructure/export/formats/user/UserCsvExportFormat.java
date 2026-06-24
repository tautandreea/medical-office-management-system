package com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.user;

import com.cabinetmedical.statisticsexportservice.domain.export.ExportData;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportFormat;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportType;
import com.cabinetmedical.statisticsexportservice.domain.export.UserExport;
import com.cabinetmedical.statisticsexportservice.domain.export.dto.UserDTO;

public class UserCsvExportFormat
        implements ExportFormat {

    @Override
    public ExportType getType() {

        return ExportType.CSV;
    }

    @Override
    public String export(
            ExportData data
    ) {

        UserExport export =
                (UserExport) data;

        StringBuilder csv =
                new StringBuilder();

        csv.append(
                "ID,Username,Email,Role\n"
        );

        for (
                UserDTO user :
                export.getUsers()
        ) {

            csv.append(
                            user.getId()
                    ).append(",")

                    .append(
                            user.getUsername()
                    ).append(",")

                    .append(
                            user.getEmail()
                    ).append(",")

                    .append(
                            user.getRole()
                    ).append("\n");
        }

        return csv.toString();
    }
}