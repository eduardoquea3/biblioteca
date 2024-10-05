package com.sise.biblioteca.service.impl;


import com.sise.biblioteca.entities.Categoria;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.repository.ICategoriaRepository;
import com.sise.biblioteca.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;

@Service
public class CategoriaSerciveImpl implements ICategoriaService {

  @Autowired
  private ICategoriaRepository categoriaRepository;

  @Override
  public Page<Categoria> getAll(Pageable pageable) {
    return categoriaRepository.findByEstado(true, pageable);
  }

  @Override
  public Categoria getById(Integer idCategoria) throws ClientException {
    Categoria categoria = categoriaRepository.findOneByIdCategoriaAndEstado(idCategoria, true);
    if (categoria == null)
      throw new ClientException("La categoria no existe!", HttpStatus.NOT_FOUND);
    return categoria;
  }

  @Override
  public Categoria add(Categoria categoria) {
    return categoriaRepository.save(categoria);
  }

  @Override
  public Categoria edit(Integer id, Categoria newCategoria) throws ClientException {
    Categoria categoria = categoriaRepository.findOneByIdCategoriaAndEstado(id, true);
    if (categoria == null)
      throw new ClientException("La categoria no existe", HttpStatus.NOT_FOUND);
    newCategoria.setIdCategoria(id);
    categoria = categoriaRepository.save(newCategoria);
    return categoria;
  }

  @Override
  public void remove(Integer idCategoria) throws ClientException {
    Categoria categoria = categoriaRepository.findOneByIdCategoriaAndEstado(idCategoria, true);
    if (categoria == null)
      throw new ClientException("La categoria no existe", HttpStatus.NOT_FOUND);
    categoriaRepository.remove(idCategoria);
  }

}
