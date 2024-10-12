package com.sise.biblioteca.payload.request;

import lombok.Data;

@Data
public class EmailRequest {
  private String [] emailTo;
  private String [] emailCC;
  private String [] emailBCC;
  private DataCorreo data;
}
