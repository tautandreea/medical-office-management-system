package com.cabinetmedical.appointmentservice.infrastructure;

import com.cabinetmedical.appointmentservice.domain.Appointment;
import com.cabinetmedical.appointmentservice.domain.daocontracts.IAppointmentDAO;
import com.cabinetmedical.appointmentservice.infrastructure.tableEntities.AppointmentTableEntity;
import com.cabinetmedical.appointmentservice.domain.enums.AppointmentStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AppointmentDAO implements IAppointmentDAO {

    private final AppointmentRepository appointmentRepository;

    public AppointmentDAO(
            AppointmentRepository appointmentRepository
    ) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> findAll() {

        return appointmentRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public Appointment findById(int id) {

        Optional<AppointmentTableEntity> entity =
                appointmentRepository.findById(id);

        return entity
                .map(this::mapToDomain)
                .orElse(null);
    }

    @Override
    public List<Appointment> findByDoctorId(
            int doctorId
    ) {

        return appointmentRepository
                .findByDoctorId(doctorId)
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public List<Appointment> findByPatientId(
            int patientId
    ) {

        return appointmentRepository
                .findByPatientId(patientId)
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public boolean insert(
            Appointment appointment
    ) {

        try {

            appointmentRepository.save(
                    mapToTableEntity(
                            appointment
                    )
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean update(
            Appointment appointment
    ) {

        try {

            appointmentRepository.save(
                    mapToTableEntity(
                            appointment
                    )
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean delete(
            int id
    ) {

        try {

            appointmentRepository.deleteById(id);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public List<Appointment> findByStatus(
            AppointmentStatus status
    ) {

        return appointmentRepository
                .findByStatus(status)
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    private Appointment mapToDomain(
            AppointmentTableEntity entity
    ) {

        return new Appointment(
                entity.getId(),
                entity.getPatientId(),
                entity.getDoctorId(),
                entity.getAppointmentDate(),
                entity.getStatus()
        );
    }

    private AppointmentTableEntity mapToTableEntity(
            Appointment appointment
    ) {

        return new AppointmentTableEntity(
                appointment.getId(),
                appointment.getPatientId(),
                appointment.getDoctorId(),
                appointment.getAppointmentDate(),
                appointment.getStatus()
        );
    }
}