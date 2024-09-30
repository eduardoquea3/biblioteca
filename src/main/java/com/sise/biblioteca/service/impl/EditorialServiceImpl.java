package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Editorial;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.repository.IEditorialRepository;
import com.sise.biblioteca.service.IEditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;

@Service
public class EditorialServiceImpl implements IEditorialService {

  @Autowired
  private IEditorialRepository editorialRepository;

  @Override
  public Page<Editorial> getAll(Pageable pageable) {
    return editorialRepository.findByEstado(true, pageable);
  }

  @Override
  public Editorial getById(Integer idEditorial) throws ClientException {
    Editorial editorial = editorialRepository.findOneByIdEditorialAndEstado(idEditorial, true);
    if (editorial == null)
      throw new ClientException("La editorial no existe!", HttpStatus.NOT_FOUND);
    return editorial;

  }

  @Override
  public Editorial add(Editorial editorial) {
    return editorialRepository.save(editorial);
  }

  @Override
  public Editorial edit(Integer id, Editorial newEditorial) throws ClientException {
    Editorial editorial = editorialRepository.findOneByIdEditorialAndEstado(id, true);
    if (editorial == null)
      throw new ClientException("La editorial no existe!", HttpStatus.NOT_FOUND);
    newEditorial.setIdEditorial(id);
    editorial = editorialRepository.save(newEditorial);
    return editorial;
  }

  @Override
  public void remove(Integer idEditorial) throws ClientException {
    Editorial editorial = editorialRepository.findOneByIdEditorialAndEstado(idEditorial, true);
    if (editorial == null)
      throw new ClientException("La editorial no existe!", HttpStatus.NOT_FOUND);
    editorialRepository.remove(idEditorial);
  }

}
