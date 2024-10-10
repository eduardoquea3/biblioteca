package com.sise.biblioteca.mappers;

import com.sise.biblioteca.dto.Editorial.CreateEditorialDTO;
import com.sise.biblioteca.dto.Editorial.UpdateEditorialDTO;
import com.sise.biblioteca.entities.Editorial;

public class EditorialMapper {
  public static Editorial createDtoToEditorial(CreateEditorialDTO dto) {
    Editorial editorial = new Editorial();
    editorial.setNombre(dto.getNombre());
    return editorial;
  }

  public static Editorial updateDtoToEditorial(UpdateEditorialDTO dto) {
    Editorial editorial = new Editorial();
    editorial.setNombre(dto.getNombre());
    return editorial;
  }
}
