package com.sise.biblioteca.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sise.biblioteca.entities.EstadoPrestamo;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.repository.IEstadoPrestamoRepository;
import com.sise.biblioteca.service.IEstadoPrestamoService;

@Service
public class EstadoPrestamoServiceImpl implements IEstadoPrestamoService {

     @Autowired
     private IEstadoPrestamoRepository estadoPrestamoRepository;

     @Override
     public Page<EstadoPrestamo> getAll(Pageable pageable) {

          return estadoPrestamoRepository.findByEstado(true, pageable);


     }

     @Override
     public EstadoPrestamo getById(Integer idEstado) throws ClientException {

          EstadoPrestamo estadoPrestamo =  estadoPrestamoRepository.findOneByIdEstadoPrestamoAndEstado(idEstado, true);
          if(estadoPrestamo == null )
          throw new ClientException("Estado Prestamo no existe", HttpStatus.NOT_FOUND);
          return estadoPrestamo;


     }

     @Override
     public EstadoPrestamo add(EstadoPrestamo estadoPrestamo) {
          return estadoPrestamoRepository.save(estadoPrestamo);
     }

     @Override
     public EstadoPrestamo edit(Integer id, EstadoPrestamo newEstadoPrestamo) throws ClientException {
          EstadoPrestamo estadoPrestamo = estadoPrestamoRepository.findOneByIdEstadoPrestamoAndEstado(id, true);
          if (estadoPrestamo == null)
          throw new ClientException(" no existe", HttpStatus.NOT_FOUND);

          newEstadoPrestamo.setIdEstadoPrestamo(id);
          estadoPrestamo = estadoPrestamoRepository.save(newEstadoPrestamo);
          return estadoPrestamo;
     }

     @Override
     public void remove(Integer idEstado) throws ClientException {
        EstadoPrestamo estadoPrestamo = estadoPrestamoRepository.findOneByIdEstadoPrestamoAndEstado(idEstado, true);
        if(estadoPrestamo == null)
        throw new ClientException("Estado Prestamo no existe", HttpStatus.NOT_FOUND);
        estadoPrestamoRepository.remove(idEstado);
     }
}