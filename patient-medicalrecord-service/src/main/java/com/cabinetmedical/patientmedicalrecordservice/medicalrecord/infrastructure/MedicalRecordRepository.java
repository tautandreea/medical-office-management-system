package com.cabinetmedical.patientmedicalrecordservice.medicalrecord.infrastructure;

import com.cabinetmedical.patientmedicalrecordservice.medicalrecord.infrastructure.tableEntities.MedicalRecordTableEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRecordRepository
        extends JpaRepository<MedicalRecordTableEntity, Integer> {

    List<MedicalRecordTableEntity> findByPatientId(
            int patientId
    );

    List<MedicalRecordTableEntity> findByDoctorId(
            int doctorId
    );

    List<MedicalRecordTableEntity>
    findByDiagnosisContainingIgnoreCase(
            String diagnosis
    );

    List<MedicalRecordTableEntity>
    findByTreatmentContainingIgnoreCase(
            String treatment
    );
}