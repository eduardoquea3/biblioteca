package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.Categoria;

import java.util.List;

public interface ICategoriaService {
    List<Categoria> getAll();

    Categoria getById(Integer idCategoria);

    Categoria add(Categoria categoria);

    Categoria edit(Integer idCategoria);


    void remove(Integer IdCategoria);
}
