package com.cabinetmedical.statisticsexportservice.domain.statistics.factory;

import com.cabinetmedical.statisticsexportservice.domain.statistics.StatisticsStrategy;
import com.cabinetmedical.statisticsexportservice.domain.statistics.StatisticsType;

public abstract class StatisticsFactory {

    public abstract StatisticsStrategy
    createStrategy(
            StatisticsType type
    );
}