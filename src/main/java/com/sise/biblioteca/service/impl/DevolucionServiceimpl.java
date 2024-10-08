package com.sise.biblioteca.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sise.biblioteca.entities.Devolucion;
import com.sise.biblioteca.errors.ClientException;

import com.sise.biblioteca.repository.IDevolucionRepository;
import com.sise.biblioteca.service.IDevolucionService;



@Service 
public class DevolucionServiceimpl implements IDevolucionService {

      @Autowired

      private IDevolucionRepository devolucionRepository;

      @Override
      public Page<Devolucion> getAll(Pageable pageable) {
          return devolucionRepository.findByEstado(true, pageable);
      }

      @Override
      public Devolucion getById(Integer idDevolucion) throws ClientException {
            Devolucion devolucion = devolucionRepository.findOneByIdDevolucionAndEstado(idDevolucion, true);
            if(devolucion == null)
            throw new ClientException("Devolucion no existe", HttpStatus.NOT_FOUND);
            return devolucion;
      }

      @Override
      public Devolucion add(Devolucion devolucion) {
           return devolucionRepository.save(devolucion);
      }

      @Override
      public Devolucion edit(Integer id, Devolucion newDevolucion) throws ClientException {
          Devolucion devolucion = devolucionRepository.findOneByIdDevolucionAndEstado(id, true);
          if(devolucion == null)
          throw new ClientException("Devolucion  no existe",HttpStatus.NOT_FOUND);
          newDevolucion.setIdDevolucion(id);
         devolucion = devolucionRepository.save(newDevolucion);
          return devolucion;
          
      }

      @Override
      public void remove(Integer idDevolucion) throws ClientException {
           Devolucion devolucion = devolucionRepository.findOneByIdDevolucionAndEstado(idDevolucion, true);
           if(devolucion == null)
           throw new ClientException("Devolucion no existe", HttpStatus.NOT_FOUND);
           devolucionRepository.remove(idDevolucion);
      }

      
      
}
