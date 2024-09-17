package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.Autor;

import java.util.List;

public interface IAutorService {
    List<Autor> getAll();

    Autor getById(Integer idAutor);

    Autor add(Autor autor);

    Autor edit(Autor autor);

    void remove(Integer idAutor);
}
