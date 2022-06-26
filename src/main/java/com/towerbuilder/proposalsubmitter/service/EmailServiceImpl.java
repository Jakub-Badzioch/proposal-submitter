package com.towerbuilder.proposalsubmitter.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Profile("mail")
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender javaMailSender;

    @Override
    public void sendMail(String toEmail, String subject, String text) {
        var mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        javaMailSender.send(mailMessage);
        log.info(mailMessage.toString());
    }
}
