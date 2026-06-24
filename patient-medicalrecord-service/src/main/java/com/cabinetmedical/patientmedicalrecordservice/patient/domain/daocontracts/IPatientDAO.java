package com.cabinetmedical.patientmedicalrecordservice.patient.domain.daocontracts;

import com.cabinetmedical.patientmedicalrecordservice.patient.domain.Patient;

import java.util.List;

public interface IPatientDAO {

    List<Patient> findAll();

    Patient findById(int id);

    List<Patient> findByName(String name);

    List<Patient> findByAge(int age);

    boolean existsByCnp(String cnp);

    boolean insert(Patient patient);

    boolean update(Patient patient);

    boolean delete(int id);
}