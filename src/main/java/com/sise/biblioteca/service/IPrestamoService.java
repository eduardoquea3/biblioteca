package com.sise.biblioteca.service;
import org.springframework.data.domain.Pageable;

import com.sise.biblioteca.entities.Prestamo;
import com.sise.biblioteca.errors.ClientException;


import org.springframework.data.domain.Page;

public interface IPrestamoService {
      
   Page<Prestamo> getAll(Pageable pageable);

   Prestamo getById(Integer idPrestamo) throws ClientException;
   
   Prestamo add(Prestamo prestamo);
   
   Prestamo edit(Integer id, Prestamo prestamo) throws ClientException;

   void remove(Integer idPrestamo) throws ClientException;

   
}
