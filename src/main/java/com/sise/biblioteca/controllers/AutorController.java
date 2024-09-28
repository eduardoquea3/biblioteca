package com.sise.biblioteca.controllers;

import java.util.List;

import org.springdoc.core.converters.models.Pageable;
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

import com.sise.biblioteca.entities.Autor;
import com.sise.biblioteca.service.IAutorService;
import com.sise.biblioteca.shared.BaseResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/autores")
@Tag(name = "Autores")
public class AutorController {

  @Autowired
  private IAutorService autorService;

  @Operation(summary = "obtener todos los Autores")
  @GetMapping("")
  public ResponseEntity<BaseResponse> listarAutores() {
    try {
      List<Autor> autores = autorService.getAll();
      return new ResponseEntity<BaseResponse>(BaseResponse.success(autores), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @Operation(summary = "Agregar un nuevo Autor ")
  @PostMapping("")
  public ResponseEntity<BaseResponse> addAutor(@RequestBody Autor autor) {
    try {
      autorService.add(autor);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(autor), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Operation(summary = "Actualizar Autor")

  @PutMapping("/{idAutor}")
  public ResponseEntity<BaseResponse> editAutor(@PathVariable Integer idAutor, @RequestBody Autor autor) {
    try {
      if (autorService.getById(idAutor) == null)
        return new ResponseEntity<BaseResponse>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      autor.setIdAutor(idAutor);
      autorService.edit(autor);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(autor), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @Operation(summary = "Eliminar logicamente Autor")
  @PatchMapping("/{idAutor}")
  public ResponseEntity<BaseResponse> removeAutor(@PathVariable Integer idAutor) {
    try {
      if (autorService.getById(idAutor) == null)
        return new ResponseEntity<BaseResponse>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      autorService.remove(idAutor);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(idAutor), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
