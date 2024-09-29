package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.SubGenero;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


public interface ISubGeneroService {

  Page<SubGenero> getAll(Pageable pageable);

  SubGenero getById(Integer idSubGenero);

  SubGenero add(SubGenero subGenero);

  SubGenero edit(SubGenero subGenero);

  void remove(Integer idSubGenero);

}
