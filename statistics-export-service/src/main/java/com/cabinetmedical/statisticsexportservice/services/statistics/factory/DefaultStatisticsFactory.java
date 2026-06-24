package com.cabinetmedical.statisticsexportservice.services.statistics.factory;

import com.cabinetmedical.statisticsexportservice.domain.statistics.StatisticsStrategy;
import com.cabinetmedical.statisticsexportservice.domain.statistics.StatisticsType;

import com.cabinetmedical.statisticsexportservice.domain.statistics.factory.StatisticsFactory;

import com.cabinetmedical.statisticsexportservice.services.statistics.strategies.AppointmentsPerDoctorStrategy;
import com.cabinetmedical.statisticsexportservice.services.statistics.strategies.PatientsByAgeGroupStrategy;
import com.cabinetmedical.statisticsexportservice.services.statistics.strategies.PatientsByDiagnosisStrategy;

import org.springframework.stereotype.Component;

@Component
public class DefaultStatisticsFactory
        extends StatisticsFactory {

    private final PatientsByDiagnosisStrategy
            patientsByDiagnosisStrategy;

    private final PatientsByAgeGroupStrategy
            patientsByAgeGroupStrategy;

    private final AppointmentsPerDoctorStrategy
            appointmentsPerDoctorStrategy;

    public DefaultStatisticsFactory(

            PatientsByDiagnosisStrategy
                    patientsByDiagnosisStrategy,

            PatientsByAgeGroupStrategy
                    patientsByAgeGroupStrategy,

            AppointmentsPerDoctorStrategy
                    appointmentsPerDoctorStrategy
    ) {

        this.patientsByDiagnosisStrategy =
                patientsByDiagnosisStrategy;

        this.patientsByAgeGroupStrategy =
                patientsByAgeGroupStrategy;

        this.appointmentsPerDoctorStrategy =
                appointmentsPerDoctorStrategy;
    }

    @Override
    public StatisticsStrategy createStrategy(
            StatisticsType type
    ) {

        if (
                type ==
                        StatisticsType.PATIENTS_BY_DIAGNOSIS
        ) {

            return patientsByDiagnosisStrategy;
        }

        if (
                type ==
                        StatisticsType.PATIENTS_BY_AGE_GROUP
        ) {

            return patientsByAgeGroupStrategy;
        }

        if (
                type ==
                        StatisticsType.APPOINTMENTS_PER_DOCTOR
        ) {

            return appointmentsPerDoctorStrategy;
        }

        throw new RuntimeException(
                "Invalid statistics type"
        );
    }
}