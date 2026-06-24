package com.cabinetmedical.statisticsexportservice.infrastructure.statistics;

import com.cabinetmedical.statisticsexportservice.infrastructure.statistics.dto.PatientDTO;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class PatientClient {

    private final RestTemplate restTemplate =
            new RestTemplate();

    public List<PatientDTO> getPatients() {

        String url =
                "http://localhost:8081/patients";

        PatientDTO[] response =
                restTemplate.getForObject(
                        url,
                        PatientDTO[].class
                );

        return response != null
                ? Arrays.asList(response)
                : List.of();
    }
}