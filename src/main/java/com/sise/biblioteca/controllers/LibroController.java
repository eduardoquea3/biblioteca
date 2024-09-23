package com.sise.biblioteca.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sise.biblioteca.shared.BaseResponse;

import java.util.List;
import com.sise.biblioteca.entities.Libros;
import com.sise.biblioteca.service.ILibrosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/libros")
public class LibroController {

  @Autowired
  private ILibrosService libroService;

  @GetMapping("")
  public ResponseEntity<BaseResponse> getAll() {
    try {
      List<Libros> libros = libroService.getAll();
      return new ResponseEntity<BaseResponse>(BaseResponse.success(libros), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

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

  @PostMapping("")
  public ResponseEntity<BaseResponse> add(@RequestBody Libros libro) {
    try {
      libroService.add(libro);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(libro), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

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
