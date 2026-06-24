package com.cabinetmedical.statisticsexportservice.domain.export;

public interface ExportFormat {

    ExportType getType();

    String export(
            ExportData exportData
    );
}