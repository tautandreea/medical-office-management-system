package com.cabinetmedical.statisticsexportservice.domain.export;

public abstract class ExportData {

    protected ExportFormat exportFormat;

    public ExportData(
            ExportFormat exportFormat
    ) {
        this.exportFormat = exportFormat;
    }

    public ExportFormat getExportFormat() {
        return exportFormat;
    }

    public abstract String export();
}