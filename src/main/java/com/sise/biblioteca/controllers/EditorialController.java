package com.sise.biblioteca.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.sise.biblioteca.entities.Editorial;
import com.sise.biblioteca.service.IEditorialService;
import com.sise.biblioteca.shared.BaseResponse;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {

  @Autowired
  private IEditorialService editorialService;

   @Operation(summary = "obtener todos las Editoriales")
  @GetMapping("")
  public ResponseEntity<Page<Editorial>> getEditorial(
      @RequestParam(defaultValue = "0") int page,

      @RequestParam(defaultValue = "5") int size,

      @RequestParam(required = false) String[] sortBy) {

    try {
      Pageable pageable = (sortBy != null) ? PageRequest.of(page, size, Sort.by(sortBy).ascending()) : PageRequest.of(page, size);

      Page<Editorial> editorial = editorialService.getAll(pageable);

      return new ResponseEntity<>(editorial, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
  }

  @Operation(summary = "Agregar Editoriales")

  @PostMapping("")
  public ResponseEntity<BaseResponse> add(@RequestBody Editorial editorial) {
    try {
      editorialService.add(editorial);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(editorial), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Operation(summary = "Actualizar Editorial")

  @PutMapping("/{idEditorial}")
  public ResponseEntity<BaseResponse> edit(@PathVariable Integer idEditorial, @RequestBody Editorial editorial) {
    try {
      if (editorialService.getById(idEditorial) == null)
        return new ResponseEntity<>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      editorial.setIdEditorial(idEditorial);
      editorialService.edit(editorial);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(editorial), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Operation(summary = "Eliminar logicamente Editorial")
  @PatchMapping("/{idEditorial}")
  public ResponseEntity<BaseResponse> remove(@PathVariable Integer idEditorial) {
    try {
      if (editorialService.getById(idEditorial) == null)
        return new ResponseEntity<>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      editorialService.remove(idEditorial);
      return new ResponseEntity<>(BaseResponse.success(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
