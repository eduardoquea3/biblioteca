package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.SubGenero;

import java.util.List;

public interface ISubGeneroService {

  List<SubGenero> getAll();

  SubGenero getById(Integer idSubGenero);

  SubGenero add(SubGenero subGenero);

  SubGenero edit(Integer idSubGenero);

  void remove(Integer idSubGenero);

}
