package com.cabinetmedical.usernotificationservice.notification.infrastructure.sms;

import com.cabinetmedical.usernotificationservice.notification.domain.implementor.NotificationSender;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SmsSender implements NotificationSender {

    @Value("${twilio.phone.number}")
    private String twilioPhoneNumber;

    @Override
    public void sendMessage(
            String receiver,
            String message
    ) {

        Message.creator(
                new PhoneNumber(receiver),
                new PhoneNumber(twilioPhoneNumber),
                message
        ).create();
    }
}