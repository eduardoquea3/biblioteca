package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Idioma;
import com.sise.biblioteca.repository.IIdiomaRepository;
import com.sise.biblioteca.service.IIdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;



@Service
public class IdiomaServiceImpl implements IIdiomaService {

  @Autowired
  private IIdiomaRepository idiomaRepository;

  @Override
  public Page<Idioma> getAll(Pageable pageable) {
    return idiomaRepository.findByEstado(true,pageable);
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
