package com.towerbuilder.proposalsubmitter.service.email;

public interface EmailService {

    void sendMail(String toEmail, String subject, String text);
}
