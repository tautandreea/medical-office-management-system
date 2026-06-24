package com.cabinetmedical.statisticsexportservice.infrastructure.statistics;

import com.cabinetmedical.statisticsexportservice.infrastructure.statistics.dto.DoctorDTO;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class DoctorClient {

    private final RestTemplate restTemplate =
            new RestTemplate();

    public List<DoctorDTO> getDoctors() {

        String url =
                "http://localhost:8082/doctors";

        DoctorDTO[] response =
                restTemplate.getForObject(
                        url,
                        DoctorDTO[].class
                );

        return response != null
                ? Arrays.asList(response)
                : List.of();
    }
}