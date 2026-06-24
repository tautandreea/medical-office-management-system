package com.cabinetmedical.statisticsexportservice.services.statistics;

import com.cabinetmedical.statisticsexportservice.domain.statistics.StatisticsStrategy;
import com.cabinetmedical.statisticsexportservice.domain.statistics.StatisticsType;

import com.cabinetmedical.statisticsexportservice.services.statistics.factory.DefaultStatisticsFactory;

import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final DefaultStatisticsFactory
            statisticsFactory;

    public StatisticsService(
            DefaultStatisticsFactory statisticsFactory
    ) {

        this.statisticsFactory =
                statisticsFactory;
    }

    public Object generateStatistics(
            StatisticsType type
    ) {

        StatisticsStrategy strategy =
                statisticsFactory
                        .createStrategy(type);

        return strategy.generateStatistics();
    }
}