package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.Editorial;



import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface IEditorialService {

  Page<Editorial> getAll(Pageable pageable);

  Editorial getById(Integer idEditorial);

  Editorial add(Editorial editorial);

  Editorial edit(Editorial editorial);

  void remove(Integer idEditorial);

}
