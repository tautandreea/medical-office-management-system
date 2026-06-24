package com.cabinetmedical.usernotificationservice.notification.infrastructure.email;

import com.cabinetmedical.usernotificationservice.notification.domain.implementor.NotificationSender;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender implements NotificationSender {

    private final JavaMailSender mailSender;

    public EmailSender(
            JavaMailSender mailSender
    ) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendMessage(
            String receiver,
            String message
    ) {

        SimpleMailMessage mail =
                new SimpleMailMessage();

        mail.setFrom("EMAILUL_TAU");

        mail.setTo(receiver);

        mail.setSubject("Actualizare cont");

        mail.setText(message);

        mailSender.send(mail);
    }
}