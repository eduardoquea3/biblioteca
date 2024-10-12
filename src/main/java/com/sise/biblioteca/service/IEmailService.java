package com.sise.biblioteca.service;

import com.sise.biblioteca.payload.request.EmailRequest;

public interface IEmailService {

  void sendWelcome(EmailRequest emailRequest) throws Exception;

  void sendNotice(EmailRequest emailRequest) throws Exception;
}
