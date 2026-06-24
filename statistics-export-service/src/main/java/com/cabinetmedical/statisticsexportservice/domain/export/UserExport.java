package com.cabinetmedical.statisticsexportservice.domain.export;

import com.cabinetmedical.statisticsexportservice.domain.export.dto.UserDTO;

import java.util.List;

public class UserExport extends ExportData {

    private List<UserDTO> users;

    public UserExport(
            ExportFormat exportFormat,
            List<UserDTO> users
    ) {

        super(exportFormat);

        this.users = users;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    @Override
    public String export() {

        return exportFormat.export(this);
    }
}