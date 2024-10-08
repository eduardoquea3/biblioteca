package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Prestamo;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.repository.IPrestamoRepository;
import com.sise.biblioteca.service.IPrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PrestamoServiceImpl implements IPrestamoService {

  @Autowired private IPrestamoRepository prestamoRepository;

  @Override
  public Page<Prestamo> getAll(Pageable pageable) {
    return prestamoRepository.findByEstado(true, pageable);
  }

  @Override
  public Prestamo getById(Integer idPrestamo) throws ClientException {
    Prestamo prestamo = prestamoRepository.findOneByIdPrestamoAndEstado(idPrestamo, true);
    if (prestamo == null) throw new ClientException("No existe Prestamo", HttpStatus.NOT_FOUND);
    return prestamo;
  }

  @Override
  public Prestamo add(Prestamo prestamo) {
    return prestamoRepository.save(prestamo);
  }

  @Override
  public Prestamo edit(Integer id, Prestamo newPrestamo) throws ClientException {
    Prestamo prestamo = prestamoRepository.findOneByIdPrestamoAndEstado(id, true);
    if (prestamo == null) throw new ClientException("Prestamo no existe", HttpStatus.NOT_FOUND);
    newPrestamo.setIdPrestamo(id);
    prestamo = prestamoRepository.save(newPrestamo);
    return prestamo;
  }

  @Override
  public void remove(Integer idPrestamo) throws ClientException {
    Prestamo prestamo = prestamoRepository.findOneByIdPrestamoAndEstado(idPrestamo, true);
    if (prestamo == null) throw new ClientException("Prestamo no existe", HttpStatus.NOT_FOUND);
    prestamoRepository.remove(idPrestamo);
  }
}
