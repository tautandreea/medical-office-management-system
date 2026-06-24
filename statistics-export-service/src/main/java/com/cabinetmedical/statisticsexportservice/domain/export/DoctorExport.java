package com.cabinetmedical.statisticsexportservice.domain.export;

import com.cabinetmedical.statisticsexportservice.domain.export.dto.DoctorDTO;

import java.util.List;

public class DoctorExport extends ExportData {

    private List<DoctorDTO> doctors;

    public DoctorExport(
            ExportFormat exportFormat,
            List<DoctorDTO> doctors
    ) {

        super(exportFormat);

        this.doctors = doctors;
    }

    public List<DoctorDTO> getDoctors() {
        return doctors;
    }

    @Override
    public String export() {

        return exportFormat.export(this);
    }
}