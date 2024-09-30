package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.Idioma;
import com.sise.biblioteca.errors.ClientException;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface IIdiomaService {

  Page<Idioma> getAll(Pageable pageable);

  Idioma getById(Integer idIdioma) throws ClientException;

  Idioma add(Idioma idioma);

  Idioma edit(Integer id, Idioma idioma) throws ClientException;

  void remove(Integer idIdioma) throws ClientException;

}
