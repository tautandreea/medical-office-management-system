package com.cabinetmedical.statisticsexportservice.controllers.export;

import com.cabinetmedical.statisticsexportservice.services.export.UserExportService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/export/users")
public class UserExportController {

    private final UserExportService
            userExportService;

    public UserExportController(
            UserExportService userExportService
    ) {

        this.userExportService =
                userExportService;
    }

    @GetMapping
    public String exportUsers() {

        return userExportService
                .exportUsers();
    }
}