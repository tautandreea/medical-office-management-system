package com.cabinetmedical.usernotificationservice.notification.domain.abstraction;

import com.cabinetmedical.usernotificationservice.notification.domain.implementor.NotificationSender;

public abstract class Notification {

    protected NotificationSender sender;

    protected String receiver;

    protected String message;

    public Notification(
            NotificationSender sender,
            String receiver,
            String message
    ) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public abstract void send();
}