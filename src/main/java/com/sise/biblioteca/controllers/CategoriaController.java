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

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.sise.biblioteca.entities.Categoria;
import com.sise.biblioteca.service.ICategoriaService;
import com.sise.biblioteca.shared.BaseResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/categorias")
@Tag(name = "Categorias")
public class CategoriaController {

  @Autowired
  private ICategoriaService categoriaService;

   @Operation(summary = "obtener todos las Categorias")
  @GetMapping("")
public ResponseEntity<Page<Categoria>> getCategoria(
      @RequestParam(defaultValue = "0") int page,

      @RequestParam(defaultValue = "5") int size,

      @RequestParam(required = false) String[] sortBy) {

    try {
      Pageable pageable = (sortBy != null) ? PageRequest.of(page, size, Sort.by(sortBy).ascending()) : PageRequest.of(page, size);

      Page<Categoria> categoria = categoriaService.getAll(pageable);

      return new ResponseEntity<>(categoria, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
  }
   @Operation(summary="Actualizar Categoria")
 @PutMapping("/{idCategoria}")
  public ResponseEntity<BaseResponse> edit(@PathVariable Integer idCategoria, @RequestBody Categoria categoria) {
    try {
      if (categoriaService.getById(idCategoria) == null)
        return new ResponseEntity<>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      categoria.setIdCategoria(idCategoria);
      categoriaService.edit(categoria);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(categoria), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @Operation(summary="Eliminar logicamente la categoria")
  @PatchMapping("/{idCategoria}")
  public ResponseEntity<BaseResponse> remove(@PathVariable Integer idCategoria) {
    try {
      if (categoriaService.getById(idCategoria) == null)
        return new ResponseEntity<>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      categoriaService.remove(idCategoria);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
