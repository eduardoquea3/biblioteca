package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Editorial;
import com.sise.biblioteca.repository.IEditorialRepository;
import com.sise.biblioteca.service.IEditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;




@Service
public class EditorialServiceImpl implements IEditorialService {

  @Autowired
  private IEditorialRepository editorialRepository;

  @Override
  public Page<Editorial> getAll(Pageable pageable) {
    return editorialRepository.findByEstado(true,pageable);
  }

  @Override
  public Editorial getById(Integer idEditorial) {
    return editorialRepository.findOneByIdEditorialAndEstado(idEditorial, true);

  }

  @Override
  public Editorial add(Editorial editorial) {
    return editorialRepository.save(editorial);
  }

  @Override
  public Editorial edit(Editorial editorial) {
    return editorialRepository.save(editorial);
  }

  @Override
  public void remove(Integer idEditorial) {
    editorialRepository.remove(idEditorial);
  }

}
