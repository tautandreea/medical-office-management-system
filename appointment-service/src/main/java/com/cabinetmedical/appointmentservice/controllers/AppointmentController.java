package com.cabinetmedical.appointmentservice.controllers;

import com.cabinetmedical.appointmentservice.domain.Appointment;
import com.cabinetmedical.appointmentservice.domain.dto.CreateAppointmentDTO;
import com.cabinetmedical.appointmentservice.domain.dto.UpdateAppointmentDTO;
import com.cabinetmedical.appointmentservice.domain.enums.AppointmentStatus;
import com.cabinetmedical.appointmentservice.services.AppointmentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(
            AppointmentService appointmentService
    ) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {

        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(
            @PathVariable int id
    ) {

        return appointmentService.getAppointmentById(id);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getAppointmentsByDoctorId(
            @PathVariable int doctorId
    ) {

        return appointmentService
                .getAppointmentsByDoctorId(
                        doctorId
                );
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getAppointmentsByPatientId(
            @PathVariable int patientId
    ) {

        return appointmentService
                .getAppointmentsByPatientId(
                        patientId
                );
    }

    @GetMapping("/status/{status}")
    public List<Appointment> getAppointmentsByStatus(
            @PathVariable AppointmentStatus status
    ) {

        return appointmentService
                .getAppointmentsByStatus(
                        status
                );
    }

    @PutMapping("/{id}/cancel")
    public boolean cancelAppointment(
            @PathVariable int id
    ) {

        return appointmentService
                .cancelAppointment(id);
    }

    @PostMapping
    public boolean createAppointment(
            @RequestBody CreateAppointmentDTO dto
    ) {

        return appointmentService
                .createAppointment(dto);
    }

    @PutMapping
    public boolean updateAppointment(
            @RequestBody UpdateAppointmentDTO dto
    ) {

        return appointmentService
                .updateAppointment(dto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAppointment(
            @PathVariable int id
    ) {

        return appointmentService
                .deleteAppointment(id);
    }
}