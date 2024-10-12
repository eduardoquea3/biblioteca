package com.sise.biblioteca.shared;

import com.sise.biblioteca.payload.request.EmailRequest;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailSender {

  private JavaMailSender javaMailSender;

  public EmailSender(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  public void sendEmail(EmailRequest emailRequest, String subject, String text) throws Exception {

    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);

    helper.setFrom("jarango121299@gmail.com", "Soy Jose");
    helper.setTo(emailRequest.getEmailTo());

    if (emailRequest.getEmailCC() != null && emailRequest.getEmailCC().length > 0) {
      helper.setCc(emailRequest.getEmailCC());
    }
    if (emailRequest.getEmailBCC() != null && emailRequest.getEmailBCC().length > 0) {
      helper.setBcc(emailRequest.getEmailBCC());
    }

    helper.setSubject(subject);
    helper.setText(text, true);

    javaMailSender.send(message);
  }
}
