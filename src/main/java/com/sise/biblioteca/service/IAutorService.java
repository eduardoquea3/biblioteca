package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.Autor;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface IAutorService {

  Page<Autor> getAll(Pageable pageable);

  Autor getById(Integer idAutor);

  Autor add(Autor autor);

  Autor edit(Autor autor);

  void remove(Integer idAutor);

}
