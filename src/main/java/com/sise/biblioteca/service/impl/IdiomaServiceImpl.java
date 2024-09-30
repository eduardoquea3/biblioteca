package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Idioma;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.repository.IIdiomaRepository;
import com.sise.biblioteca.service.IIdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;

@Service
public class IdiomaServiceImpl implements IIdiomaService {

  @Autowired
  private IIdiomaRepository idiomaRepository;

  @Override
  public Page<Idioma> getAll(Pageable pageable) {
    return idiomaRepository.findByEstado(true, pageable);
  }

  @Override
  public Idioma getById(Integer idIdioma) throws ClientException {
    Idioma idioma = idiomaRepository.findOneByIdIdiomaAndEstado(idIdioma, true);
    if (idioma == null)
      throw new ClientException("El idioma no existe", HttpStatus.NOT_FOUND);
    return idioma;
  }

  @Override
  public Idioma add(Idioma idioma) {
    return idiomaRepository.save(idioma);

  }

  @Override
  public Idioma edit(Integer id, Idioma newIdioma) throws ClientException {
    Idioma idioma = idiomaRepository.findOneByIdIdiomaAndEstado(id, true);
    if (idioma == null)
      throw new ClientException("El idioma no existe", HttpStatus.NOT_FOUND);
    newIdioma.setIdIdioma(id);
    idioma = idiomaRepository.save(newIdioma);
    return null;
  }

  @Override
  public void remove(Integer idIdioma) throws ClientException {
    Idioma idioma = idiomaRepository.findOneByIdIdiomaAndEstado(idIdioma, true);
    if (idioma == null)
      throw new ClientException("El idioma no existe", HttpStatus.NOT_FOUND);
    idiomaRepository.remove(idIdioma);
  }

}
