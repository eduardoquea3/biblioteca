package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.SubGenero;
import com.sise.biblioteca.repository.ISubGeneroRepository;
import com.sise.biblioteca.service.ISubGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubGeneroServiceImpl implements ISubGeneroService {

  @Autowired
  private ISubGeneroRepository subGeneroRepository;

  @Override
  public List<SubGenero> getAll() {
    return subGeneroRepository.findByEstado(true);
  }

  @Override
  public SubGenero getById(Integer idSubGenero) {
    return subGeneroRepository.findOneByIdSubgeneroAndEstado(idSubGenero, true);
  }

  @Override
  public SubGenero add(SubGenero subGenero) {
    return subGeneroRepository.save(subGenero);
  }

  @Override
  public SubGenero edit(SubGenero subGenero) {
    return subGeneroRepository.save(subGenero);
  }

  @Override
  public void remove(Integer idSubGenero) {
    subGeneroRepository.remove(idSubGenero);
  }

}
