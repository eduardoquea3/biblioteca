package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Categoria;
import com.sise.biblioteca.repository.ICategoriaRepository;
import com.sise.biblioteca.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICategoriaSerciveImpl implements ICategoriaService {

  @Autowired
  private ICategoriaRepository categoriaRepository;

  @Override
  public List<Categoria> getAll() {
    return null;
  }

  @Override
  public Categoria getById(Integer idCategoria) {
    return null;
  }

  @Override
  public Categoria add(Categoria categoria) {
    return null;
  }

  @Override
  public Categoria edit(Integer idCategoria) {
    return null;
  }

  @Override
  public void remove(Integer IdCategoria) {

  }

}
