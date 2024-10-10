package com.sise.biblioteca.dto.DetallePrestamo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateDetallePrestamoDTO {
  @NotBlank(message = "El id de prestamo es obligatorio!")
  private Integer idPrestamo;

  @NotBlank(message = "El id de libro es obligatorio!")
  private Integer idLibro;

  @NotBlank(message = "El id de estado prestamo es obligatorio!")
  private Integer idEstadoPrestamo;

  @NotBlank(message = "Las unidades es obligatoria!")
  private Integer unidades;
}
