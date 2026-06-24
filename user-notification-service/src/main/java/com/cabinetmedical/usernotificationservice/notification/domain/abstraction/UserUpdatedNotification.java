package com.cabinetmedical.usernotificationservice.notification.domain.abstraction;

import com.cabinetmedical.usernotificationservice.notification.domain.implementor.NotificationSender;

public class UserUpdatedNotification extends Notification {

    public UserUpdatedNotification(
            NotificationSender sender,
            String receiver,
            String message
    ) {
        super(
                sender,
                receiver,
                message
        );
    }

    @Override
    public void send() {

        sender.sendMessage(
                receiver,
                message
        );
    }
}