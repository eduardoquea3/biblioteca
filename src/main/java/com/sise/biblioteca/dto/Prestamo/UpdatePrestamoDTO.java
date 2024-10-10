package com.sise.biblioteca.dto.Prestamo;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdatePrestamoDTO {
  @NotBlank(message = "El id del cliente es obligatorio!")
  private Integer idCliente;

  @NotBlank(message = "La cantidad es obligatoria!")
  private Integer cantidad;

  @NotNull(message = "La fecha de prestamo es obligatoria!")
  private Date fechaPrestamo;

  @NotNull(message = "La fecha de devolucion es obligatoria!")
  private Date fechaDevolucion;
}
