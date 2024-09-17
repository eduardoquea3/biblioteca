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

import com.sise.biblioteca.entities.Autor;
import com.sise.biblioteca.service.IAutorService;
import com.sise.biblioteca.shared.BaseResponse;


@RestController
@RequestMapping("/autores")
public class AutorController {

  @Autowired
  private IAutorService autorService;

  @GetMapping("")
  public ResponseEntity<BaseResponse> listarAutores() {
    try {
      List<Autor> autores = autorService.getAll();
      return new ResponseEntity<BaseResponse>(BaseResponse.success(autores), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("")
  public ResponseEntity<BaseResponse> add(@RequestBody Autor autor) {
    try {
      autorService.add(autor);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(autor), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{idAutor}")
  public ResponseEntity<BaseResponse> edit(@PathVariable Integer idAutor, @RequestBody Autor autor) {
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

  @PatchMapping("/{idAutor}")
  public ResponseEntity<BaseResponse> remove(@PathVariable Integer idAutor) {
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
