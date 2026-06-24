package com.cabinetmedical.patientmedicalrecordservice.medicalrecord.infrastructure;

import com.cabinetmedical.patientmedicalrecordservice.medicalrecord.domain.MedicalRecord;
import com.cabinetmedical.patientmedicalrecordservice.medicalrecord.domain.daocontracts.IMedicalRecordDAO;
import com.cabinetmedical.patientmedicalrecordservice.medicalrecord.infrastructure.tableEntities.MedicalRecordTableEntity;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MedicalRecordDAO
        implements IMedicalRecordDAO {

    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordDAO(
            MedicalRecordRepository medicalRecordRepository
    ) {
        this.medicalRecordRepository =
                medicalRecordRepository;
    }

    @Override
    public List<MedicalRecord> findAll() {

        return medicalRecordRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public MedicalRecord findById(int id) {

        Optional<MedicalRecordTableEntity> entity =
                medicalRecordRepository.findById(id);

        return entity
                .map(this::mapToDomain)
                .orElse(null);
    }

    @Override
    public List<MedicalRecord> findByPatientId(
            int patientId
    ) {

        return medicalRecordRepository
                .findByPatientId(patientId)
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public List<MedicalRecord> findByDoctorId(
            int doctorId
    ) {

        return medicalRecordRepository
                .findByDoctorId(doctorId)
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public List<MedicalRecord> findByDiagnosis(
            String diagnosis
    ) {

        return medicalRecordRepository
                .findByDiagnosisContainingIgnoreCase(
                        diagnosis
                )
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public List<MedicalRecord> findByTreatment(
            String treatment
    ) {

        return medicalRecordRepository
                .findByTreatmentContainingIgnoreCase(
                        treatment
                )
                .stream()
                .map(this::mapToDomain)
                .toList();
    }

    @Override
    public boolean insert(
            MedicalRecord medicalRecord
    ) {

        try {

            medicalRecordRepository.save(
                    mapToTableEntity(medicalRecord)
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean update(
            MedicalRecord medicalRecord
    ) {

        try {

            medicalRecordRepository.save(
                    mapToTableEntity(medicalRecord)
            );

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean delete(int id) {

        try {

            medicalRecordRepository.deleteById(id);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    private MedicalRecord mapToDomain(
            MedicalRecordTableEntity entity
    ) {

        return new MedicalRecord(
                entity.getId(),
                entity.getPatientId(),
                entity.getDoctorId(),
                entity.getSymptoms(),
                entity.getDiagnosis(),
                entity.getTreatment()
        );
    }

    private MedicalRecordTableEntity mapToTableEntity(
            MedicalRecord medicalRecord
    ) {

        return new MedicalRecordTableEntity(
                medicalRecord.getId(),
                medicalRecord.getPatientId(),
                medicalRecord.getDoctorId(),
                medicalRecord.getSymptoms(),
                medicalRecord.getDiagnosis(),
                medicalRecord.getTreatment()
        );
    }
}