package com.cabinetmedical.statisticsexportservice.services.export;

import com.cabinetmedical.statisticsexportservice.domain.export.ExportEntity;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportFormat;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportType;

import com.cabinetmedical.statisticsexportservice.domain.export.MedicalRecordExport;

import com.cabinetmedical.statisticsexportservice.domain.export.dto.MedicalRecordDTO;

import com.cabinetmedical.statisticsexportservice.domain.export.factory.ExportFormatFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class MedicalRecordExportService {

    private final RestTemplate restTemplate =
            new RestTemplate();

    private final ExportFormatFactory
            exportFormatFactory;

    public MedicalRecordExportService(
            ExportFormatFactory exportFormatFactory
    ) {

        this.exportFormatFactory =
                exportFormatFactory;
    }

    public List<MedicalRecordDTO> getMedicalRecords() {

        try {

            String url =
                    "http://localhost:8081/medical-records";

            MedicalRecordDTO[] records =
                    restTemplate.getForObject(
                            url,
                            MedicalRecordDTO[].class
                    );

            if (records == null) {

                return List.of();
            }

            return Arrays.asList(records);

        } catch (Exception e) {

            return List.of();
        }
    }

    public String exportMedicalRecords() {

        ExportFormat format =
                exportFormatFactory.createFormat(

                        ExportEntity.MEDICAL_RECORD,

                        ExportType.DOC
                );

        MedicalRecordExport export =
                new MedicalRecordExport(
                        format,
                        getMedicalRecords()
                );

        return export.export();
    }

    public MedicalRecordDTO getMedicalRecordById(
            int id
    ) {

        try {

            String url =
                    "http://localhost:8081/medical-records/"
                            + id;

            return restTemplate.getForObject(
                    url,
                    MedicalRecordDTO.class
            );

        } catch (Exception e) {

            return null;
        }
    }

    public String exportMedicalRecordById(
            int id
    ) {

        MedicalRecordDTO record =
                getMedicalRecordById(id);

        if (record == null) {

            return "Medical record not found";
        }

        ExportFormat format =
                exportFormatFactory.createFormat(

                        ExportEntity.MEDICAL_RECORD,

                        ExportType.DOC
                );

        MedicalRecordExport export =
                new MedicalRecordExport(

                        format,

                        List.of(record)
                );

        return export.export();
    }
}