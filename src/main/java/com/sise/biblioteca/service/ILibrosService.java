package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.Libros;

import java.util.List;

public interface ILibrosService {

  List<Libros> getAll();

  Libros getById(Integer idLibros);

  Libros add(Libros libros);

  Libros edit(Libros libros);

  void remove(Integer idLibros);

}
