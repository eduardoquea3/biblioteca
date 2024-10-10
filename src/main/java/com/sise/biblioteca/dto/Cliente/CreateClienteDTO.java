package com.sise.biblioteca.dto.Cliente;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateClienteDTO {
  @NotBlank(message = "El dni es obligatorio!")
  @Size(max = 8, message = "El dni no puede tener más de 8 caracteres.")
  private String dni;

  @NotBlank(message = "El nombre es obligatorio!")
  @Size(max = 20, message = "El nombre no puede tener más de 20 caracteres.")
  private String nombre;

  @NotBlank(message = "El apellido paterno es obligatorio!")
  @Size(max = 20, message = "El apellido paterno no puede tener más de 20 caracteres.")
  private String apellidoPaterno;

  @NotBlank(message = "El apellido materno es obligatorio!")
  @Size(max = 20, message = "El apellido materno no puede tener más de 20 caracteres.")
  private String apellidoMaterno;

  @NotBlank(message = "El telefono es obligatorio!")
  private String Telefono;

  @NotBlank(message = "El correo es obligatorio!")
  private String correo;

  @NotBlank(message = "El direccion es obligatorio!")
  private String direccion;

  @NotBlank(message = "La fecha de nacimiento es obligatoria!")
  private Date fecha;
}
