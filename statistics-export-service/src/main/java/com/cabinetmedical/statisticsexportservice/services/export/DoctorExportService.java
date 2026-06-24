package com.cabinetmedical.statisticsexportservice.services.export;

import com.cabinetmedical.statisticsexportservice.domain.export.DoctorExport;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportEntity;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportFormat;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportType;

import com.cabinetmedical.statisticsexportservice.domain.export.dto.DoctorDTO;
import com.cabinetmedical.statisticsexportservice.domain.export.factory.ExportFormatFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class DoctorExportService {

    private final RestTemplate restTemplate =
            new RestTemplate();

    private final ExportFormatFactory
            exportFormatFactory;

    public DoctorExportService(
            ExportFormatFactory exportFormatFactory
    ) {

        this.exportFormatFactory =
                exportFormatFactory;
    }

    public List<DoctorDTO> getDoctors() {

        try {

            String url =
                    "http://localhost:8082/doctors";

            DoctorDTO[] doctors =
                    restTemplate.getForObject(
                            url,
                            DoctorDTO[].class
                    );

            if (doctors == null) {

                return List.of();
            }

            return Arrays.asList(doctors);

        } catch (Exception e) {

            return List.of();
        }
    }

    public String exportDoctors(
            ExportType type
    ) {

        ExportFormat format =
                exportFormatFactory.createFormat(

                        ExportEntity.DOCTOR,

                        type
                );

        DoctorExport export =
                new DoctorExport(
                        format,
                        getDoctors()
                );

        return export.export();
    }
}