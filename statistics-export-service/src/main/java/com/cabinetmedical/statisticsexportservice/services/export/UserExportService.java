package com.cabinetmedical.statisticsexportservice.services.export;

import com.cabinetmedical.statisticsexportservice.domain.export.ExportEntity;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportFormat;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportType;
import com.cabinetmedical.statisticsexportservice.domain.export.UserExport;

import com.cabinetmedical.statisticsexportservice.domain.export.dto.UserDTO;

import com.cabinetmedical.statisticsexportservice.domain.export.factory.ExportFormatFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserExportService {

    private final RestTemplate restTemplate =
            new RestTemplate();

    private final ExportFormatFactory
            exportFormatFactory;

    public UserExportService(
            ExportFormatFactory exportFormatFactory
    ) {

        this.exportFormatFactory =
                exportFormatFactory;
    }

    public List<UserDTO> getUsers() {

        try {

            String url =
                    "http://localhost:8084/users";

            UserDTO[] users =
                    restTemplate.getForObject(
                            url,
                            UserDTO[].class
                    );

            if (users == null) {

                return List.of();
            }

            return Arrays.asList(users);

        } catch (Exception e) {

            return List.of();
        }
    }

    public String exportUsers() {

        ExportFormat format =
                exportFormatFactory.createFormat(

                        ExportEntity.USER,

                        ExportType.CSV
                );

        UserExport export =
                new UserExport(
                        format,
                        getUsers()
                );

        return export.export();
    }
}