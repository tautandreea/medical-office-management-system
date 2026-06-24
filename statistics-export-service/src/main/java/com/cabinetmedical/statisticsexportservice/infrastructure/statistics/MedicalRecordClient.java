package com.cabinetmedical.statisticsexportservice.infrastructure.statistics;

import com.cabinetmedical.statisticsexportservice.infrastructure.statistics.dto.MedicalRecordDTO;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class MedicalRecordClient {

    private final RestTemplate restTemplate =
            new RestTemplate();

    public List<MedicalRecordDTO> getMedicalRecords() {

        String url =
                "http://localhost:8081/medical-records";

        MedicalRecordDTO[] response =
                restTemplate.getForObject(
                        url,
                        MedicalRecordDTO[].class
                );

        return response != null
                ? Arrays.asList(response)
                : List.of();
    }
}