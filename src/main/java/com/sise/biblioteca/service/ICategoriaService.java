package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.Categoria;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


public interface ICategoriaService {

  Page<Categoria> getAll(Pageable pageable);

  Categoria getById(Integer idCategoria);

  Categoria add(Categoria categoria);

  Categoria edit(Categoria categoria);

  void remove(Integer idCategoria);

}
