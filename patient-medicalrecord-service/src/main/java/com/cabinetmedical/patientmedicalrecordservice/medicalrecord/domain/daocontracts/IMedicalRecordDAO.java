package com.cabinetmedical.patientmedicalrecordservice.medicalrecord.domain.daocontracts;

import com.cabinetmedical.patientmedicalrecordservice.medicalrecord.domain.MedicalRecord;

import java.util.List;

public interface IMedicalRecordDAO {

    List<MedicalRecord> findAll();

    MedicalRecord findById(int id);

    List<MedicalRecord> findByPatientId(int patientId);

    List<MedicalRecord> findByDoctorId(int doctorId);

    List<MedicalRecord> findByDiagnosis(String diagnosis);

    List<MedicalRecord> findByTreatment(String treatment);

    boolean insert(MedicalRecord medicalRecord);

    boolean update(MedicalRecord medicalRecord);

    boolean delete(int id);
}