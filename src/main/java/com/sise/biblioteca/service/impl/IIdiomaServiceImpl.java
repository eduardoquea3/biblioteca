package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Idioma;
import com.sise.biblioteca.repository.IIdiomaRepository;
import com.sise.biblioteca.service.IIdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IIdiomaServiceImpl implements IIdiomaService {

  @Autowired
  private IIdiomaRepository idiomaRepository;

  @Override
  public List<Idioma> getAll() {
    return idiomaRepository.findByEstado(true);
  }

  @Override
  public Idioma getById(Integer idIdioma) {
    return idiomaRepository.findOneByIdIdiomaAndEstado(idIdioma, true);
  }

  @Override
  public Idioma add(Idioma idioma) {
    return idiomaRepository.save(idioma);

  }

  @Override
  public Idioma edit(Idioma idioma) {
    return idiomaRepository.save(idioma);
  }

  @Override
  public void remove(Integer idIdioma) {
    idiomaRepository.remove(idIdioma);
  }

}
