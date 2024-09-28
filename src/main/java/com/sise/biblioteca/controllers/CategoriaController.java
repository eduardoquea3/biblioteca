package com.sise.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
  public ResponseEntity<BaseResponse> getCategorias() {
    try {
      List<Categoria> categorias = categoriaService.getAll();
      return new ResponseEntity<BaseResponse>(BaseResponse.success(categorias), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
   @Operation(summary = "Agregar una Categoria")
  @PostMapping("")
  public ResponseEntity<BaseResponse> addCategoria(@RequestBody Categoria categoria) {
    try {
      categoriaService.add(categoria);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(categoria), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
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
