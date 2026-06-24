package com.cabinetmedical.appointmentservice.services;

import com.cabinetmedical.appointmentservice.domain.Appointment;
import com.cabinetmedical.appointmentservice.domain.daocontracts.IAppointmentDAO;
import com.cabinetmedical.appointmentservice.domain.dto.CreateAppointmentDTO;
import com.cabinetmedical.appointmentservice.domain.dto.UpdateAppointmentDTO;
import com.cabinetmedical.appointmentservice.domain.enums.AppointmentStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final IAppointmentDAO appointmentDAO;

    private final RestTemplate restTemplate =
            new RestTemplate();

    public AppointmentService(
            IAppointmentDAO appointmentDAO
    ) {
        this.appointmentDAO = appointmentDAO;
    }

    // ======================
    // GET ALL
    // ======================

    public List<Appointment> getAllAppointments() {

        return appointmentDAO.findAll();
    }

    // ======================
    // GET BY ID
    // ======================

    public Appointment getAppointmentById(
            int id
    ) {

        return appointmentDAO.findById(id);
    }

    // ======================
    // GET BY DOCTOR
    // ======================

    public List<Appointment> getAppointmentsByDoctorId(
            int doctorId
    ) {

        return appointmentDAO.findByDoctorId(
                doctorId
        );
    }

    // ======================
    // GET BY PATIENT
    // ======================

    public List<Appointment> getAppointmentsByPatientId(
            int patientId
    ) {

        return appointmentDAO.findByPatientId(
                patientId
        );
    }

    // ======================
    // CREATE
    // ======================

    public boolean createAppointment(
            CreateAppointmentDTO dto
    ) {

        if (dto == null) {
            return false;
        }

        if (!existsPatient(
                dto.getPatientId()
        )) {

            return false;
        }

        if (!existsDoctor(
                dto.getDoctorId()
        )) {

            return false;
        }

        if (!isFutureAppointment(
                dto.getAppointmentDate()
        )) {

            return false;
        }

        if (
                hasConflict(
                        dto.getDoctorId(),
                        dto.getAppointmentDate()
                )
        ) {

            return false;
        }

        Appointment appointment =
                new Appointment(
                        0,
                        dto.getPatientId(),
                        dto.getDoctorId(),
                        dto.getAppointmentDate(),
                        AppointmentStatus.SCHEDULED
                );

        return appointmentDAO.insert(
                appointment
        );
    }

    // ======================
    // UPDATE
    // ======================

    public boolean updateAppointment(
            UpdateAppointmentDTO dto
    ) {

        Appointment existing =
                appointmentDAO.findById(
                        dto.getId()
                );

        if (existing == null) {
            return false;
        }

        if (!existsPatient(
                dto.getPatientId()
        )) {

            return false;
        }

        if (!existsDoctor(
                dto.getDoctorId()
        )) {

            return false;
        }

        Appointment updated =
                new Appointment(
                        dto.getId(),
                        dto.getPatientId(),
                        dto.getDoctorId(),
                        dto.getAppointmentDate(),
                        dto.getStatus()
                );

        return appointmentDAO.update(
                updated
        );
    }

    // ======================
    // DELETE
    // ======================

    public boolean deleteAppointment(
            int id
    ) {

        Appointment existing =
                appointmentDAO.findById(id);

        if (existing == null) {
            return false;
        }

        return appointmentDAO.delete(id);
    }

    // ======================
    // VALIDATIONS
    // ======================

    private boolean existsPatient(
            int patientId
    ) {

        try {

            String url =
                    "http://localhost:8081/patients/"
                            + patientId;

            Object response =
                    restTemplate.getForObject(
                            url,
                            Object.class
                    );

            return response != null;

        } catch (Exception e) {

            return false;
        }
    }

    private boolean existsDoctor(
            int doctorId
    ) {

        try {

            String url =
                    "http://localhost:8082/doctors/"
                            + doctorId;

            Object response =
                    restTemplate.getForObject(
                            url,
                            Object.class
                    );

            return response != null;

        } catch (Exception e) {

            return false;
        }
    }

    public List<Appointment> getAppointmentsByStatus(
            AppointmentStatus status
    ) {

        return appointmentDAO.findByStatus(
                status
        );
    }

    public boolean cancelAppointment(
            int id
    ) {

        Appointment appointment =
                appointmentDAO.findById(id);

        if (appointment == null) {
            return false;
        }

        appointment.setStatus(
                AppointmentStatus.CANCELLED
        );

        return appointmentDAO.update(
                appointment
        );
    }

    private boolean isFutureAppointment(
            LocalDateTime appointmentDate
    ) {

        return appointmentDate.isAfter(
                LocalDateTime.now()
        );
    }

    private boolean hasConflict(
            int doctorId,
            LocalDateTime appointmentDate
    ) {

        List<Appointment> appointments =
                appointmentDAO.findByDoctorId(
                        doctorId
                );

        return appointments.stream()
                .anyMatch(
                        a ->
                                a.getAppointmentDate()
                                        .equals(
                                                appointmentDate
                                        )
                );
    }
}