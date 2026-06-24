package com.cabinetmedical.statisticsexportservice.infrastructure.statistics;

import com.cabinetmedical.statisticsexportservice.infrastructure.statistics.dto.AppointmentDTO;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AppointmentClient {

    private final RestTemplate restTemplate =
            new RestTemplate();

    public List<AppointmentDTO> getAppointments() {

        String url =
                "http://localhost:8083/appointments";

        AppointmentDTO[] response =
                restTemplate.getForObject(
                        url,
                        AppointmentDTO[].class
                );

        return response != null
                ? Arrays.asList(response)
                : List.of();
    }
}