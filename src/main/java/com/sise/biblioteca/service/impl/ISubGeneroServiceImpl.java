package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.SubGenero;
import com.sise.biblioteca.repository.ISubGeneroRepository;
import com.sise.biblioteca.service.ISubGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISubGeneroServiceImpl implements ISubGeneroService {

  @Autowired
  private ISubGeneroRepository subGeneroRepository;

  @Override
  public List<SubGenero> getAll() {
    return null;
  }

  @Override
  public SubGenero getById(Integer idSubGenero) {
    return null;
  }

  @Override
  public SubGenero add(SubGenero subGenero) {
    return null;
  }

  @Override
  public SubGenero edit(Integer idSubGenero) {
    return null;
  }

  @Override
  public void remove(Integer idSubGenero) {

  }

}
