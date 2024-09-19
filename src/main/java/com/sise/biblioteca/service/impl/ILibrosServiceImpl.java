package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Libros;
import com.sise.biblioteca.repository.ILibrosRepository;
import com.sise.biblioteca.service.ILibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ILibrosServiceImpl implements ILibrosService {

    @Autowired
    private final ILibrosRepository librosRepository;

  @Override
  public List<Libros> getAll() {
    return libroRepository.findByEstado(true);
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
