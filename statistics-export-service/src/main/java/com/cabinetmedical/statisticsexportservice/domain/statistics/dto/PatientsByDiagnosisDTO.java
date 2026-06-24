package com.cabinetmedical.statisticsexportservice.domain.statistics.dto;

public class PatientsByDiagnosisDTO {

    private String diagnostic;

    private int count;

    public PatientsByDiagnosisDTO() {
    }

    public PatientsByDiagnosisDTO(
            String diagnostic,
            int count
    ) {
        this.diagnostic = diagnostic;
        this.count = count;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(
            String diagnostic
    ) {
        this.diagnostic = diagnostic;
    }

    public int getCount() {
        return count;
    }

    public void setCount(
            int count
    ) {
        this.count = count;
    }
}