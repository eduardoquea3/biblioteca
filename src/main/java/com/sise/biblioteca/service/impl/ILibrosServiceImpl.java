package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Libros;
import com.sise.biblioteca.repository.ILibrosRepository;
import com.sise.biblioteca.service.ILibrosService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;



@Service
public class ILibrosServiceImpl implements ILibrosService {

  @Autowired
  private ILibrosRepository libroRepository;

  @Override
  public Page<Libros> getAll(Pageable pageable) {
    return libroRepository.findByEstado(true,pageable);
  }

  @Override
  public Libros getById(Integer idLibros) {
    return libroRepository.findOneByIdLibroAndEstado(idLibros, true);
  }

  @Override
  public Libros add(Libros libros) {
    return libroRepository.save(libros);
  }

  @Override
  public Libros edit(Libros libros) {
    return libroRepository.save(libros);
  }

  @Override
  public void remove(Integer idLibros) {
    libroRepository.remove(idLibros);
  }

}
