package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.DetallePrestamo;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.repository.IDetallePrestamoRepository;
import com.sise.biblioteca.service.IDetallePrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DetallePrestamoServiceImpl implements IDetallePrestamoService {

  @Autowired private IDetallePrestamoRepository detallePrestamoRepository;

  @Override
  public Page<DetallePrestamo> getAll(Pageable pageable) {
    return detallePrestamoRepository.findByEstado(true, pageable);
  }

  @Override
  public DetallePrestamo getById(Integer idDetalleprestamo) throws ClientException {
    DetallePrestamo detallePrestamo =
        detallePrestamoRepository.findOneByIdDetallePrestamoAndEstado(idDetalleprestamo, true);
    if (detallePrestamo == null) throw new ClientException("No existe", HttpStatus.NOT_FOUND);
    return detallePrestamo;
  }

  @Override
  public DetallePrestamo add(DetallePrestamo detallePrestamo) {
    return detallePrestamoRepository.save(detallePrestamo);
  }

  @Override
  public DetallePrestamo edit(Integer id, DetallePrestamo newDetallePrestamo)
      throws ClientException {
    DetallePrestamo detallePrestamo =
        detallePrestamoRepository.findOneByIdDetallePrestamoAndEstado(id, true);
    if (detallePrestamo == null)
      throw new ClientException("Detalle Prestamo no existe", HttpStatus.NOT_FOUND);
    newDetallePrestamo.setIdDetallePrestamo(id);
    detallePrestamo = detallePrestamoRepository.save(newDetallePrestamo);
    return detallePrestamo;
  }

  @Override
  public void remove(Integer idDetalleprestamo) throws ClientException {
    DetallePrestamo detallePrestamo =
        detallePrestamoRepository.findOneByIdDetallePrestamoAndEstado(idDetalleprestamo, true);
    if (detallePrestamo == null)
      throw new ClientException("Detalle Prestamo no existe", HttpStatus.NOT_FOUND);
    detallePrestamoRepository.remove(idDetalleprestamo);
  }
}
