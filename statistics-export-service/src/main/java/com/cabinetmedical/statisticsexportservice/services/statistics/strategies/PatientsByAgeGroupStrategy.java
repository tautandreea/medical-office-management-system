package com.cabinetmedical.statisticsexportservice.services.statistics.strategies;

import com.cabinetmedical.statisticsexportservice.domain.statistics.StatisticsStrategy;
import com.cabinetmedical.statisticsexportservice.domain.statistics.dto.PatientsByAgeGroupDTO;

import com.cabinetmedical.statisticsexportservice.infrastructure.statistics.PatientClient;
import com.cabinetmedical.statisticsexportservice.infrastructure.statistics.dto.PatientDTO;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientsByAgeGroupStrategy
        implements StatisticsStrategy {

    private final PatientClient patientClient;

    public PatientsByAgeGroupStrategy(
            PatientClient patientClient
    ) {

        this.patientClient =
                patientClient;
    }

    @Override
    public Object generateStatistics() {

        List<PatientDTO> patients =
                patientClient.getPatients();

        int group1 = 0;
        int group2 = 0;
        int group3 = 0;
        int group4 = 0;

        for (
                PatientDTO patient :
                patients
        ) {

            int age =
                    patient.getAge();

            if(age <= 18) {

                group1++;
            }

            else if(age <= 40) {

                group2++;
            }

            else if(age <= 65) {

                group3++;
            }

            else {

                group4++;
            }
        }

        List<PatientsByAgeGroupDTO>
                result =
                new ArrayList<>();

        result.add(
                new PatientsByAgeGroupDTO(
                        "0-18",
                        group1
                )
        );

        result.add(
                new PatientsByAgeGroupDTO(
                        "19-40",
                        group2
                )
        );

        result.add(
                new PatientsByAgeGroupDTO(
                        "41-65",
                        group3
                )
        );

        result.add(
                new PatientsByAgeGroupDTO(
                        "65+",
                        group4
                )
        );

        return result;
    }
}