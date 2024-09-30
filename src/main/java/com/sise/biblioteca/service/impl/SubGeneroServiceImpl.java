package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.SubGenero;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.repository.ISubGeneroRepository;
import com.sise.biblioteca.service.ISubGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;

@Service
public class SubGeneroServiceImpl implements ISubGeneroService {

  @Autowired
  private ISubGeneroRepository subGeneroRepository;

  @Override
  public Page<SubGenero> getAll(Pageable pageable) {
    return subGeneroRepository.findByEstado(true, pageable);
  }

  @Override
  public SubGenero getById(Integer idSubGenero) throws ClientException {
    SubGenero subgenero = subGeneroRepository.findOneByIdSubgeneroAndEstado(idSubGenero, true);
    if (subgenero == null)
      throw new ClientException("El subgenero no existe!", HttpStatus.NOT_FOUND);
    return subgenero;
  }

  @Override
  public SubGenero add(SubGenero subGenero) {
    return subGeneroRepository.save(subGenero);
  }

  @Override
  public SubGenero edit(Integer id, SubGenero newSubGenero) throws ClientException {
    SubGenero subgenero = subGeneroRepository.findOneByIdSubgeneroAndEstado(id, true);
    if (subgenero == null)
      throw new ClientException("El subgenero no existe!", HttpStatus.NOT_FOUND);
    subgenero = subGeneroRepository.save(newSubGenero);
    return subgenero;
  }

  @Override
  public void remove(Integer idSubGenero) throws ClientException {
    SubGenero subgenero = subGeneroRepository.findOneByIdSubgeneroAndEstado(idSubGenero, true);
    if (subgenero == null)
      throw new ClientException("El subgenero no existe!", HttpStatus.NOT_FOUND);
    subGeneroRepository.remove(idSubGenero);
  }

}
