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
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.service.IEditorialService;
import com.sise.biblioteca.shared.BaseResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/editoriales")
@Tag(name = "Editoriales")
public class EditorialController {

  @Autowired
  private IEditorialService editorialService;

  @Operation(summary = "obtener todos las editoriales")
  @GetMapping("")
  public ResponseEntity<BaseResponse> getEditorial(
      @RequestParam(defaultValue = "0") int page,

      @RequestParam(defaultValue = "5") int size,

      @RequestParam(required = false) String[] sortBy) {

    Sort sort = Sort.unsorted();
    if (sortBy != null)
      sort = sort.and(Sort.by(sortBy));

    Pageable pageable = PageRequest.of(page, size, sort);
    Page<Editorial> editoriales = editorialService.getAll(pageable);

    return new ResponseEntity<>(BaseResponse.success(editoriales), HttpStatus.OK);
  }

  @Operation(summary = "Agregar editorial")
  @PostMapping("")
  public ResponseEntity<BaseResponse> add(@RequestBody Editorial editorial) {
    editorial = editorialService.add(editorial);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(editorial), HttpStatus.CREATED);
  }

  @Operation(summary = "Actualizar editorial")
  @PutMapping("/{idEditorial}")
  public ResponseEntity<BaseResponse> edit(@PathVariable Integer idEditorial, @RequestBody Editorial editorial)
      throws ClientException {
    Editorial newEditorial = editorialService.edit(idEditorial, editorial);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(newEditorial), HttpStatus.OK);
  }

  @Operation(summary = "Eliminar logicamente una editorial")
  @PatchMapping("/{idEditorial}")
  public ResponseEntity<BaseResponse> remove(@PathVariable Integer idEditorial) throws ClientException {
    editorialService.remove(idEditorial);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(), HttpStatus.NO_CONTENT);
  }

}
