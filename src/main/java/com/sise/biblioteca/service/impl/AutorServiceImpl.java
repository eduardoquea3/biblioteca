package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Autor;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.repository.IAutorRespository;
import com.sise.biblioteca.service.IAutorService;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl implements IAutorService {

  @Autowired
  private IAutorRespository autorRespository;

  @Override
  public Page<Autor> getAll(Pageable pageable) {
    return autorRespository.findByEstado(true, pageable);
  }

  @Override
  public Autor getById(Integer idAutor) throws ClientException {
    Autor autor = autorRespository.findOneByIdAutorAndEstado(idAutor, true);
    if (autor == null)
      throw new ClientException("El autor no existe!", HttpStatus.NOT_FOUND);
    return autor;
  }

  @Override
  public Autor add(Autor autor) {
    return autorRespository.save(autor);
  }

  @Override
  public Autor edit(Integer id, Autor newAutor) throws ClientException {
    Autor autor = autorRespository.findOneByIdAutorAndEstado(id, true);
    if (autor == null)
      throw new ClientException("El autor no existe", HttpStatus.NOT_FOUND);
    autor = autorRespository.save(newAutor);
    return autor;
  }

  @Override
  public void remove(Integer idAutor) throws ClientException {
    Autor autor = autorRespository.findOneByIdAutorAndEstado(idAutor, true);
    if (autor == null)
      throw new ClientException("El autor no existe", HttpStatus.NOT_FOUND);
    autorRespository.remove(idAutor);
  }

}
