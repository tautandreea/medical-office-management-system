package com.cabinetmedical.usernotificationservice.notification.controllers;

import com.cabinetmedical.usernotificationservice.notification.domain.dto.NotificationRequestDTO;
import com.cabinetmedical.usernotificationservice.notification.domain.dto.NotificationResponseDTO;
import com.cabinetmedical.usernotificationservice.notification.service.NotificationService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(
            NotificationService notificationService
    ) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public NotificationResponseDTO sendNotification(
            @RequestBody NotificationRequestDTO request
    ) {

        return notificationService.sendNotification(request);
    }
}