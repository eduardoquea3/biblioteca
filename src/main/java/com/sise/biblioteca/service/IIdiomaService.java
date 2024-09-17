package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.Idioma;

import java.util.List;

public interface IIdiomaService {

  List<Idioma> getAll();

  Idioma getById(Integer idIdioma);

  Idioma add(Idioma idioma);

  Idioma edit(Idioma idioma);

  void remove(Integer idIdioma);

}
