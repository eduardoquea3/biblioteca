package com.sise.biblioteca.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.sise.biblioteca.entities.Libros;




public interface ILibrosService {

  Page<Libros> getAll(Pageable pageable);

  Libros getById(Integer idLibros);

  Libros add(Libros libros);

  Libros edit(Libros libros);

  void remove(Integer idLibros);

}
