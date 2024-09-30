package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.Editorial;
import com.sise.biblioteca.errors.ClientException;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface IEditorialService {

  Page<Editorial> getAll(Pageable pageable);

  Editorial getById(Integer idEditorial) throws ClientException;

  Editorial add(Editorial editorial);

  Editorial edit(Integer id, Editorial editorial) throws ClientException;

  void remove(Integer idEditorial) throws ClientException;

}
