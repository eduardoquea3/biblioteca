package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Libro;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.repository.ILibroRepository;
import com.sise.biblioteca.service.ILibroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;

@Service
public class LibroServiceImpl implements ILibroService {

  @Autowired
  private ILibroRepository libroRepository;

  @Override
  public Page<Libro> getAll(Pageable pageable) {
    return libroRepository.findByEstado(true, pageable);
  }

  @Override
  public Libro getById(Integer idLibro) throws ClientException {
    Libro libro = libroRepository.findOneByIdLibroAndEstado(idLibro, true);
    if (libro == null)
      throw new ClientException("El libro no existe!", HttpStatus.NOT_FOUND);
    return libro;
  }

  @Override
  public Libro add(Libro libro) {
    return libroRepository.save(libro);
  }

  @Override
  public Libro edit(Integer id, Libro newLibro) throws ClientException {
    Libro libro = libroRepository.findOneByIdLibroAndEstado(id, true);
    if (libro == null) throw new ClientException("El libro no existe", HttpStatus.NOT_FOUND);
    newLibro.setIdLibro(id);
    libro = libroRepository.save(newLibro);
    return libro;
  }

  @Override
  public void remove(Integer idLibro) throws ClientException {
    Libro libro = libroRepository.findOneByIdLibroAndEstado(idLibro, true);
    if (libro == null)
      throw new ClientException("El libro no existe", HttpStatus.NOT_FOUND);
    libroRepository.remove(idLibro);
  }

}
