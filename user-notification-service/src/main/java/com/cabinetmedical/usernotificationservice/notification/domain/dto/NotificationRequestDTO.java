package com.cabinetmedical.usernotificationservice.notification.domain.dto;

import com.cabinetmedical.usernotificationservice.notification.domain.enums.NotificationType;

public class NotificationRequestDTO {

    private String email;

    private String phoneNumber;

    private String message;

    private NotificationType type;

    public NotificationRequestDTO() {
    }

    public NotificationRequestDTO(
            String email,
            String phoneNumber,
            String message,
            NotificationType type
    ) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.message = message;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }
}