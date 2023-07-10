package com.towerbuilder.proposalsubmitter.service.email.impl;

import com.towerbuilder.proposalsubmitter.service.email.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@Profile("mail")
public class EmailServiceImpl implements EmailService {

    // todo w przyszly m tyg getcurrentuser
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

    public void sendWithAttachment(byte[] file, String fileName, String toEmail, String subject, String text){
       javaMailSender.send(mimeMessage -> {
           final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
           helper.addAttachment(fileName, new ByteArrayResource(file));
           // to subj, size
       });
    }
}
