package com.sise.biblioteca.mappers;

import com.sise.biblioteca.dto.Categoria.CreateCategoriaDTO;
import com.sise.biblioteca.dto.Categoria.UpdateCategoriaDTO;
import com.sise.biblioteca.entities.Categoria;

public class CategoriaMapper {
  public static Categoria createDtoToCategoria(CreateCategoriaDTO dto) {
    Categoria categoria = new Categoria();
    categoria.setNombre(dto.getNombre());
    return categoria;
  }

  public static Categoria updateDtoToCategoria(UpdateCategoriaDTO dto) {
    Categoria categoria = new Categoria();
    categoria.setNombre(dto.getNombre());
    return categoria;
  }
}
