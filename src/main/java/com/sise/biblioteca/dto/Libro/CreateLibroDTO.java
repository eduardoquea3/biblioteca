package com.sise.biblioteca.dto.Libro;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateLibroDTO {
  /* ESTO QUEDA MUCHO A DISPOSICION DE COMO ESTARÁN LAS RESTRICCIONES DE LA BD,
  SI ALGUN CAMPO NO PUEDE SER NULL SEGUN LA BD, QUE COLOQUE EL @NOTBLANK ENCIMA*/

  @NotBlank(message = "El número de serie es obligatorio.")
  private String serialNumber;

  @NotBlank(message = "El nombre es obligatorio.")
  @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres.")
  private String nombre;

  @NotNull(message = "El autor es obligatorio.")
  private Integer idAutor;

  @NotNull(message = "El idioma es obligatorio.")
  private Integer idIdioma;

  @NotNull(message = "La editorial es obligatoria.")
  private Integer idEditorial;

  @NotNull(message = "La categoría es obligatoria.")
  private Integer idCategoria;

  @NotNull(message = "El subgénero es obligatorio.")
  private Integer idSubgenero;

  @Min(value = 1500, message = "El año debe ser mayor o igual a 1500.")
  @Max(value = 2024, message = "El año debe ser menor o igual a 2024.")
  private Integer anio;

  @Min(value = 1, message = "La cantidad de unidades debe ser al menos 1.")
  private Integer unidades;

  @Min(value = 1, message = "La cantidad de páginas debe ser al menos 1.")
  private Integer cantPaginas;

  @Pattern(
      regexp = "^(http|https)://.*$",
      message = "La URL de la imagen debe ser válida y comenzar con http o https.")
  private String urlImagen;
}
