package com.sise.biblioteca.mappers;

import com.sise.biblioteca.dto.Idioma.CreateIdiomaDTO;
import com.sise.biblioteca.dto.Idioma.UpdateIdiomaDTO;
import com.sise.biblioteca.entities.Idioma;

public class IdiomaMapper {
  public static Idioma createDtoToIdioma(CreateIdiomaDTO dto) {
    Idioma idioma = new Idioma();
    idioma.setNombre(dto.getNombre());
    return idioma;
  }

  public static Idioma updateDtoToIdioma(UpdateIdiomaDTO dto) {
    Idioma idioma = new Idioma();
    idioma.setNombre(dto.getNombre());
    return idioma;
  }
}
