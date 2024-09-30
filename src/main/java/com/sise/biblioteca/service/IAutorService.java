package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.Autor;
import com.sise.biblioteca.errors.ClientException;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface IAutorService {

  Page<Autor> getAll(Pageable pageable);

  Autor getById(Integer idAutor) throws ClientException;

  Autor add(Autor autor);

  Autor edit(Integer id, Autor autor) throws ClientException;

  void remove(Integer idAutor) throws ClientException;

}
