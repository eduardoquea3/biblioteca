package com.sise.biblioteca.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sise.biblioteca.shared.BaseResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


import com.sise.biblioteca.entities.Libros;
import com.sise.biblioteca.service.ILibrosService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Sort;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@RestController
@RequestMapping("/libros")
@Tag(name = "Libros")
public class LibroController {

  @Autowired
  private ILibrosService libroService;

  @Operation(summary = "obtener todos los libros")
  @GetMapping("")
  public ResponseEntity<Page<Libros>> listarLibros( 
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(required = false) String [] SortBy) {

    try {
       Pageable pegeable = (SortBy != null) ? PageRequest.of(page, size,Sort.by(SortBy).ascending()):PageRequest.of(page, size);
        
       Page<Libros> libros=libroService.getAll(pegeable);
        return new ResponseEntity<>(libros, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 

    }
  }

  @Operation(summary = "obtener libro mediante id")
  @GetMapping("/{idLibro}")
  public ResponseEntity<BaseResponse> getById(@PathVariable Integer idLibro) {
    try {
      Libros libro = libroService.getById(idLibro);
      if (libro == null)
        return new ResponseEntity<BaseResponse>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(libro), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Operation(summary = "agregar un nuevo libro")
  @PostMapping("")
  public ResponseEntity<BaseResponse> add(@RequestBody Libros libro) {
    try {
      libroService.add(libro);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(libro), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Operation(summary = "actualizar un libro mediante su id")
  @PutMapping("/{idLibro}")
  public ResponseEntity<BaseResponse> edit(@PathVariable Integer idLibro, @RequestBody Libros libro) {
    try {
      if (libroService.getById(idLibro) == null)
        return new ResponseEntity<BaseResponse>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      libro.setIdLibro(idLibro);
      libroService.edit(libro);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(libro), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Operation(summary = "eliminar logicamente un libro mediante el usuario")
  @PatchMapping("/{idLibro}")
  public ResponseEntity<BaseResponse> remove(@PathVariable Integer idLibro) {
    try {
      if (libroService.getById(idLibro) == null)
        return new ResponseEntity<>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      libroService.remove(idLibro);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
