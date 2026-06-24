package com.cabinetmedical.usernotificationservice.notification.domain.implementor;

public interface NotificationSender {

    void sendMessage(
            String receiver,
            String message
    );
}