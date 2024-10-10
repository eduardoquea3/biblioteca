package com.sise.biblioteca.dto.Devolucion;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateDevolucionDTO {
  @NotBlank(message = "El id de detalle prestamo es obligatorio!")
  private Integer idDetallePrestamo;

  @NotNull(message = "La fecha de devolucion es obligatoria!")
  private Date fechaDevolucion;
}
