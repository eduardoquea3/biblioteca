package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.SubGenero;
import com.sise.biblioteca.errors.ClientException;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface ISubGeneroService {

  Page<SubGenero> getAll(Pageable pageable);

  SubGenero getById(Integer idSubGenero) throws ClientException;

  SubGenero add(SubGenero subGenero);

  SubGenero edit(Integer id, SubGenero subGenero) throws ClientException;

  void remove(Integer idSubGenero) throws ClientException;

}
