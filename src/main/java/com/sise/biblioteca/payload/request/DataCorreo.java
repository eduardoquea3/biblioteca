package com.sise.biblioteca.payload.request;

import java.sql.Date;
import java.util.List;
import lombok.Data;

@Data
public class DataCorreo {
  private String cliente;
  private String dni;
  private Date fecha;
  private List<String> cabeceras;
  private List<List<String>> data;
}
