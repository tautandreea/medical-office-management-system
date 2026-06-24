package com.cabinetmedical.doctorservice.doctor.domain.daocontracts;

import com.cabinetmedical.doctorservice.doctor.domain.Doctor;

import java.util.List;

public interface IDoctorDAO {

    List<Doctor> findAll();

    Doctor findById(int id);

    List<Doctor> findByName(String name);

    List<Doctor> findBySpecializationId(int specializationId);

    boolean insert(Doctor doctor);

    boolean update(Doctor doctor);

    boolean delete(int id);
}