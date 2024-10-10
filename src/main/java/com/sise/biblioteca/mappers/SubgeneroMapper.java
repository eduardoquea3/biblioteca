package com.sise.biblioteca.mappers;

import com.sise.biblioteca.dto.SubGenero.CreateSubgeneroDTO;
import com.sise.biblioteca.dto.SubGenero.UpdateSubgeneroDTO;
import com.sise.biblioteca.entities.SubGenero;

public class SubgeneroMapper {
  public static SubGenero createDtoToSubgenero(CreateSubgeneroDTO dto) {
    SubGenero subGenero = new SubGenero();
    subGenero.setNombre(dto.getNombre());
    return subGenero;
  }

  public static SubGenero updateDtoToSubgenero(UpdateSubgeneroDTO dto) {
    SubGenero subGenero = new SubGenero();
    subGenero.setNombre(dto.getNombre());
    return subGenero;
  }
}
