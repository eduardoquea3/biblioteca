package com.sise.biblioteca.controllers;

import com.sise.biblioteca.payload.request.EmailRequest;
import com.sise.biblioteca.service.IEmailService;
import com.sise.biblioteca.shared.BaseResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@Tag(name = "Email", description = "Controlador de email")
public class EmailController {

  @Autowired private IEmailService emailService;

  @PostMapping("/sendNotice")
  public ResponseEntity<BaseResponse> sendNotice(@RequestBody EmailRequest emailRequest) {
    try {
      emailService.sendNotice(emailRequest);
      return new ResponseEntity<>(BaseResponse.success("Hola"), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(
          BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/sendWelcome")
  public ResponseEntity<BaseResponse> sendWelcome(@RequestBody EmailRequest emailRequest) {
    try {
      emailService.sendWelcome(emailRequest);
      return new ResponseEntity<>(BaseResponse.success("Hola"), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(
          BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
