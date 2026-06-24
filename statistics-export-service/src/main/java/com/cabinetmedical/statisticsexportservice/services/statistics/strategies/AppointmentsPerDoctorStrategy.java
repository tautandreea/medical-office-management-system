package com.cabinetmedical.statisticsexportservice.services.statistics.strategies;

import com.cabinetmedical.statisticsexportservice.domain.statistics.StatisticsStrategy;
import com.cabinetmedical.statisticsexportservice.domain.statistics.dto.AppointmentsPerDoctorDTO;

import com.cabinetmedical.statisticsexportservice.infrastructure.statistics.DoctorClient;
import com.cabinetmedical.statisticsexportservice.infrastructure.statistics.AppointmentClient;

import com.cabinetmedical.statisticsexportservice.infrastructure.statistics.dto.DoctorDTO;
import com.cabinetmedical.statisticsexportservice.infrastructure.statistics.dto.AppointmentDTO;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentsPerDoctorStrategy
        implements StatisticsStrategy {

    private final DoctorClient doctorClient;

    private final AppointmentClient appointmentClient;

    public AppointmentsPerDoctorStrategy(

            DoctorClient doctorClient,

            AppointmentClient appointmentClient
    ) {

        this.doctorClient =
                doctorClient;

        this.appointmentClient =
                appointmentClient;
    }

    @Override
    public Object generateStatistics() {

        List<DoctorDTO> doctors =
                doctorClient.getDoctors();

        List<AppointmentDTO> appointments =
                appointmentClient.getAppointments();

        List<AppointmentsPerDoctorDTO>
                result =
                new ArrayList<>();

        for (
                DoctorDTO doctor :
                doctors
        ) {

            int count = 0;

            for (
                    AppointmentDTO appointment :
                    appointments
            ) {

                if (
                        appointment.getDoctorId()
                                == doctor.getId()
                ) {

                    count++;
                }
            }

            result.add(

                    new AppointmentsPerDoctorDTO(

                            doctor.getFirstName()
                                    + " "
                                    + doctor.getLastName(),

                            count
                    )
            );
        }

        return result;
    }
}