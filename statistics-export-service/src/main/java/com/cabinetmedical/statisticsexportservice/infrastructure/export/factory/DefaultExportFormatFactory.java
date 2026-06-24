package com.cabinetmedical.statisticsexportservice.infrastructure.export.factory;

import com.cabinetmedical.statisticsexportservice.domain.export.ExportEntity;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportFormat;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportType;
import com.cabinetmedical.statisticsexportservice.domain.export.factory.ExportFormatFactory;

import com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.patient.PatientCsvExportFormat;
import com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.patient.PatientJsonExportFormat;
import com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.patient.PatientXmlExportFormat;
import com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.patient.PatientDocExportFormat;

import com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.doctor.DoctorCsvExportFormat;
import com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.doctor.DoctorJsonExportFormat;
import com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.doctor.DoctorXmlExportFormat;
import com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.doctor.DoctorDocExportFormat;

import com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.medicalrecord.MedicalRecordDocExportFormat;

import com.cabinetmedical.statisticsexportservice.infrastructure.export.formats.user.UserCsvExportFormat;

import org.springframework.stereotype.Component;

@Component
public class DefaultExportFormatFactory
        extends ExportFormatFactory {

    @Override
    public ExportFormat createFormat(
            ExportEntity entity,
            ExportType type
    ) {

        return switch (entity) {

            case PATIENT -> switch (type) {

                case CSV ->
                        new PatientCsvExportFormat();

                case JSON ->
                        new PatientJsonExportFormat();

                case XML ->
                        new PatientXmlExportFormat();

                case DOC ->
                        new PatientDocExportFormat();
            };

            case DOCTOR -> switch (type) {

                case CSV ->
                        new DoctorCsvExportFormat();

                case JSON ->
                        new DoctorJsonExportFormat();

                case XML ->
                        new DoctorXmlExportFormat();

                case DOC ->
                        new DoctorDocExportFormat();
            };

            case MEDICAL_RECORD -> switch (type) {

                case DOC ->
                        new MedicalRecordDocExportFormat();

                default ->
                        throw new IllegalArgumentException(
                                "MedicalRecord supports only DOC export"
                        );
            };

            case USER -> switch (type) {

                case CSV ->
                        new UserCsvExportFormat();

                default ->
                        throw new IllegalArgumentException(
                                "User supports only CSV export"
                        );
            };
        };
    }
}