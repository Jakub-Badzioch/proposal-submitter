package com.towerbuilder.proposalsubmitter.service;

public interface EmailService {

    void sendMail(String toEmail, String subject, String text);
}
