package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.Categoria;
import com.sise.biblioteca.errors.ClientException;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface ICategoriaService {

  Page<Categoria> getAll(Pageable pageable);

  Categoria getById(Integer idCategoria) throws ClientException;

  Categoria add(Categoria categoria);

  Categoria edit(Integer id, Categoria categoria) throws ClientException;

  void remove(Integer idCategoria) throws ClientException;

}
