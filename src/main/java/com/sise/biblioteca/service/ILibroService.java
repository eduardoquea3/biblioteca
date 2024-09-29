package com.sise.biblioteca.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.sise.biblioteca.entities.Libro;
import com.sise.biblioteca.errors.ClientException;




public interface ILibroService {

  Page<Libro> getAll(Pageable pageable);

  Libro getById(Integer idLibro) throws ClientException;

  Libro add(Libro libro);

  Libro edit(Integer id, Libro newLibro) throws ClientException;

  void remove(Integer idLibro) throws ClientException;

}
