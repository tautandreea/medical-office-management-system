package com.cabinetmedical.statisticsexportservice.domain.export.factory;

import com.cabinetmedical.statisticsexportservice.domain.export.ExportEntity;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportFormat;
import com.cabinetmedical.statisticsexportservice.domain.export.ExportType;

public abstract class ExportFormatFactory {

    public abstract ExportFormat createFormat(
            ExportEntity entity,
            ExportType type
    );
}