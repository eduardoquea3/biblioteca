package com.sise.biblioteca.service;

import com.sise.biblioteca.entities.DetallePrestamo;
import com.sise.biblioteca.errors.ClientException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDetallePrestamoService {

  Page<DetallePrestamo> getAll(Pageable pageable);

  DetallePrestamo getById(Integer idDetalleprestamo) throws ClientException;

  DetallePrestamo add(DetallePrestamo detallePrestamo);

  DetallePrestamo edit(Integer id, DetallePrestamo detallePrestamo) throws ClientException;

  void remove(Integer idDetalleprestamo) throws ClientException;
}
