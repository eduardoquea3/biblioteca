package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.Editorial;

import java.util.List;

public interface IEditorialService {
    List<Editorial> getAll();

    Editorial getById(Integer idEditorial);

    Editorial add(Editorial editorial);

    Editorial edit(Integer IdEditorial);

    void remove(Integer IdEditorial);
}
