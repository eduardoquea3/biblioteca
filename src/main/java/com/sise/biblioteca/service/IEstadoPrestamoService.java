package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.EstadoPrestamo;
import com.sise.biblioteca.errors.ClientException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEstadoPrestamoService {

  Page<EstadoPrestamo> getAll(Pageable pageable);

  EstadoPrestamo getById(Integer idEstadoPrestamo) throws ClientException;

  EstadoPrestamo add(EstadoPrestamo estadoPrestamo);

  EstadoPrestamo edit(Integer id, EstadoPrestamo estadoPrestamo) throws ClientException;

  void remove(Integer idEstadoPrestamo) throws ClientException;
}
