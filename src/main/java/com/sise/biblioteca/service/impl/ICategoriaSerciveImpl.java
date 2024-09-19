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
    return categoriaRepository.findByEstado(true);
  }

  @Override
  public Categoria getById(Integer idCategoria) {
    return categoriaRepository.findOneByIdCategoriaAndEstado(idCategoria, true);
  }

  @Override
  public Categoria add(Categoria categoria) {
    return categoriaRepository.save(categoria);
  }

  @Override
  public Categoria edit(Categoria categoria) {
    return categoriaRepository.save(categoria);
  }

  @Override
  public void remove(Integer idCategoria) {
    categoriaRepository.remove(idCategoria);
  }

}
