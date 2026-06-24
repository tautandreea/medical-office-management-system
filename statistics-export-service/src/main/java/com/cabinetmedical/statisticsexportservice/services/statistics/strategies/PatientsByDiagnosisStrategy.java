package com.cabinetmedical.statisticsexportservice.services.statistics.strategies;

import com.cabinetmedical.statisticsexportservice.domain.statistics.StatisticsStrategy;
import com.cabinetmedical.statisticsexportservice.domain.statistics.dto.PatientsByDiagnosisDTO;

import com.cabinetmedical.statisticsexportservice.infrastructure.statistics.MedicalRecordClient;
import com.cabinetmedical.statisticsexportservice.infrastructure.statistics.dto.MedicalRecordDTO;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PatientsByDiagnosisStrategy
        implements StatisticsStrategy {

    private final MedicalRecordClient
            medicalRecordClient;

    public PatientsByDiagnosisStrategy(
            MedicalRecordClient medicalRecordClient
    ) {

        this.medicalRecordClient =
                medicalRecordClient;
    }

    @Override
    public Object generateStatistics() {

        List<MedicalRecordDTO> records =
                medicalRecordClient
                        .getMedicalRecords();

        Map<String, Integer> diagnostics =
                new HashMap<>();

        for (
                MedicalRecordDTO record :
                records
        ) {

            String diagnosis =
                    record.getDiagnosis();

            diagnostics.put(

                    diagnosis,

                    diagnostics.getOrDefault(

                            diagnosis,

                            0

                    ) + 1
            );
        }

        List<PatientsByDiagnosisDTO>
                result =
                new ArrayList<>();

        for (
                Map.Entry<String,Integer>
                        entry :
                diagnostics.entrySet()
        ) {

            result.add(

                    new PatientsByDiagnosisDTO(

                            entry.getKey(),

                            entry.getValue()
                    )
            );
        }

        return result;
    }
}