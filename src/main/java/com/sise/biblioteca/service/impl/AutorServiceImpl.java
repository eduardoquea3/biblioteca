package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Autor;
import com.sise.biblioteca.repository.IAutorRespository;
import com.sise.biblioteca.service.IAutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements IAutorService {

  @Autowired
  private IAutorRespository autorRespository;

  @Override
  public List<Autor> getAll() {
    return autorRespository.findByEstado(true);
  }

  @Override
  public Autor getById(Integer idAutor) {
    return autorRespository.findOneByIdAutorAndEstado(idAutor, true);
  }

  @Override
  public Autor add(Autor autor) {
    return autorRespository.save(autor);
  }

  @Override
  public Autor edit(Autor autor) {
    return autorRespository.save(autor);
  }

  @Override
  public void remove(Integer idAutor) {
    autorRespository.remove(idAutor);
  }

}
