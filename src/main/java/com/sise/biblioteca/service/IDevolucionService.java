package com.sise.biblioteca.service;
import org.springframework.data.domain.Pageable;

import com.sise.biblioteca.entities.Devolucion;
import com.sise.biblioteca.errors.ClientException;


import org.springframework.data.domain.Page;
public interface IDevolucionService {
      
      Page<Devolucion> getAll(Pageable pageable);

      Devolucion getById(Integer idDevolucion) throws ClientException;

      Devolucion add(Devolucion devolucion);

      Devolucion edit(Integer id, Devolucion devolucion) throws ClientException;

      void remove(Integer idDevolucion) throws ClientException;

}
