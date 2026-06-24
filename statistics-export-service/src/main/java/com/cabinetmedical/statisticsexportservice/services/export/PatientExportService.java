package com.cabinetmedical.statisticsexportservice.services.export;

import com.cabinetmedical.statisticsexportservice.domain.export.ExportEntity;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportFormat;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportType;

import com.cabinetmedical.statisticsexportservice.domain.export.PatientExport;

import com.cabinetmedical.statisticsexportservice.domain.export.dto.PatientDTO;

import com.cabinetmedical.statisticsexportservice.domain.export.factory.ExportFormatFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PatientExportService {

    private final RestTemplate restTemplate =
            new RestTemplate();

    private final ExportFormatFactory
            exportFormatFactory;

    public PatientExportService(
            ExportFormatFactory exportFormatFactory
    ) {

        this.exportFormatFactory =
                exportFormatFactory;
    }

    public List<PatientDTO> getPatients() {

        try {

            String url =
                    "http://localhost:8081/patients";

            PatientDTO[] patients =
                    restTemplate.getForObject(
                            url,
                            PatientDTO[].class
                    );

            if (patients == null) {

                return List.of();
            }

            return Arrays.asList(
                    patients
            );

        } catch (Exception e) {

            e.printStackTrace();

            return List.of();
        }
    }

    public String exportPatients(
            ExportType type
    ) {

        ExportFormat format =
                exportFormatFactory.createFormat(

                        ExportEntity.PATIENT,

                        type
                );

        PatientExport export =
                new PatientExport(
                        format,
                        getPatients()
                );

        return export.export();
    }
}