package com.cabinetmedical.statisticsexportservice.controllers.statistics;

import com.cabinetmedical.statisticsexportservice.domain.statistics.StatisticsType;

import com.cabinetmedical.statisticsexportservice.services.statistics.StatisticsService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsService
            statisticsService;

    public StatisticsController(
            StatisticsService statisticsService
    ) {

        this.statisticsService =
                statisticsService;
    }

    @GetMapping("/{type}")
    public Object getStatistics(
            @PathVariable
            StatisticsType type
    ) {

        return statisticsService
                .generateStatistics(type);
    }
}