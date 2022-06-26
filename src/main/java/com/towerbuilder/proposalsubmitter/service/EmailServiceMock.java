package com.towerbuilder.proposalsubmitter.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!mail")
@Slf4j
public class EmailServiceMock implements EmailService{
    @Override
    public void sendMail(String toEmail, String subject, String text) {
        log.info(text);
    }


}

