package com.sise.biblioteca.service;


import org.springframework.data.domain.Pageable;

import com.sise.biblioteca.entities.EstadoPrestamo;
import com.sise.biblioteca.errors.ClientException;

import org.springframework.data.domain.Page;

public interface IEstadoPrestamoService {
      
      Page<EstadoPrestamo>getAll(Pageable pageable);

      EstadoPrestamo getById(Integer idEstadoPrestamo) throws ClientException;

      EstadoPrestamo add(EstadoPrestamo estadoPrestamo);

      EstadoPrestamo edit(Integer id,EstadoPrestamo estadoPrestamo) throws ClientException;

      void remove(Integer idEstadoPrestamo) throws ClientException;
}
