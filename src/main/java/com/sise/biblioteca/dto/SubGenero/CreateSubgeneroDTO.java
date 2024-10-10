package com.sise.biblioteca.dto.SubGenero;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateSubgeneroDTO {
  @NotBlank(message = "El nombre es obligatorio!")
  @Size(max = 20, message = "El nombre no puede tener más de 20 caracteres.")
  private String nombre;
}
