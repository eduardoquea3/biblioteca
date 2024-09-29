package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.Idioma;




import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


public interface IIdiomaService {

  Page<Idioma> getAll(Pageable pageable);

  Idioma getById(Integer idIdioma);

  Idioma add(Idioma idioma);

  Idioma edit(Idioma idioma);

  void remove(Integer idIdioma);

}
