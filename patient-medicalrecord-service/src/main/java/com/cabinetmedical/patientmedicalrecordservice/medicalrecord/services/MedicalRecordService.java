package com.cabinetmedical.patientmedicalrecordservice.medicalrecord.services;

import com.cabinetmedical.patientmedicalrecordservice.medicalrecord.domain.MedicalRecord;
import com.cabinetmedical.patientmedicalrecordservice.medicalrecord.domain.daocontracts.IMedicalRecordDAO;
import com.cabinetmedical.patientmedicalrecordservice.medicalrecord.domain.dto.CreateMedicalRecordDTO;
import com.cabinetmedical.patientmedicalrecordservice.medicalrecord.domain.dto.UpdateMedicalRecordDTO;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    private final IMedicalRecordDAO medicalRecordDAO;

    public MedicalRecordService(
            IMedicalRecordDAO medicalRecordDAO
    ) {
        this.medicalRecordDAO = medicalRecordDAO;
    }

    // GET ALL

    public List<MedicalRecord> getAllMedicalRecords() {

        return medicalRecordDAO.findAll();
    }

    // GET BY ID

    public MedicalRecord getMedicalRecordById(
            int id
    ) {

        return medicalRecordDAO.findById(id);
    }

    // GET BY PATIENT

    public List<MedicalRecord> getMedicalRecordsByPatient(
            int patientId
    ) {

        return medicalRecordDAO.findByPatientId(patientId);
    }

    // GET BY DOCTOR

    public List<MedicalRecord> getMedicalRecordsByDoctor(
            int doctorId
    ) {

        return medicalRecordDAO.findByDoctorId(doctorId);
    }

    // FILTER BY DIAGNOSIS

    public List<MedicalRecord> filterByDiagnosis(
            String diagnosis
    ) {

        return medicalRecordDAO.findByDiagnosis(diagnosis);
    }

    // FILTER BY TREATMENT

    public List<MedicalRecord> filterByTreatment(
            String treatment
    ) {

        return medicalRecordDAO.findByTreatment(treatment);
    }

    // CREATE

    public boolean createMedicalRecord(
            CreateMedicalRecordDTO dto
    ) {

        if (dto == null) {
            return false;
        }

        MedicalRecord medicalRecord =
                new MedicalRecord(
                        0,
                        dto.getPatientId(),
                        dto.getDoctorId(),
                        dto.getSymptoms(),
                        dto.getDiagnosis(),
                        dto.getTreatment()
                );

        return medicalRecordDAO.insert(
                medicalRecord
        );
    }

    // UPDATE

    public boolean updateMedicalRecord(
            UpdateMedicalRecordDTO dto
    ) {

        MedicalRecord existingRecord =
                medicalRecordDAO.findById(dto.getId());

        if (existingRecord == null) {
            return false;
        }

        MedicalRecord updatedRecord =
                new MedicalRecord(
                        dto.getId(),
                        existingRecord.getPatientId(),
                        existingRecord.getDoctorId(),
                        dto.getSymptoms(),
                        dto.getDiagnosis(),
                        dto.getTreatment()
                );

        return medicalRecordDAO.update(
                updatedRecord
        );
    }

    // DELETE

    public boolean deleteMedicalRecord(
            int id
    ) {

        MedicalRecord existingRecord =
                medicalRecordDAO.findById(id);

        if (existingRecord == null) {
            return false;
        }

        return medicalRecordDAO.delete(id);
    }
}