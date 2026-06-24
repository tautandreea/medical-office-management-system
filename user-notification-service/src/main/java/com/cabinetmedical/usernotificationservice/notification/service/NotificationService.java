package com.cabinetmedical.usernotificationservice.notification.service;

import com.cabinetmedical.usernotificationservice.notification.domain.abstraction.Notification;
import com.cabinetmedical.usernotificationservice.notification.domain.abstraction.UserUpdatedNotification;

import com.cabinetmedical.usernotificationservice.notification.domain.dto.NotificationRequestDTO;
import com.cabinetmedical.usernotificationservice.notification.domain.dto.NotificationResponseDTO;

import com.cabinetmedical.usernotificationservice.notification.domain.enums.NotificationType;

import com.cabinetmedical.usernotificationservice.notification.domain.implementor.NotificationSender;

import com.cabinetmedical.usernotificationservice.notification.infrastructure.email.EmailSender;
import com.cabinetmedical.usernotificationservice.notification.infrastructure.sms.SmsSender;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final EmailSender emailSender;

    private final SmsSender smsSender;

    public NotificationService(
            EmailSender emailSender,
            SmsSender smsSender
    ) {
        this.emailSender = emailSender;
        this.smsSender = smsSender;
    }

    public NotificationResponseDTO sendNotification(
            NotificationRequestDTO request
    ) {

        try {

            NotificationSender sender;

            String receiver;

            if (request.getType() == NotificationType.EMAIL) {

                sender = emailSender;

                receiver = request.getEmail();

            } else {

                sender = smsSender;

                receiver = request.getPhoneNumber();
            }

            Notification notification =
                    new UserUpdatedNotification(
                            sender,
                            receiver,
                            request.getMessage()
                    );

            notification.send();

            return new NotificationResponseDTO(
                    true,
                    "Notificare trimisa!"
            );

        } catch (Exception e) {

            return new NotificationResponseDTO(
                    false,
                    e.getMessage()
            );
        }
    }
}