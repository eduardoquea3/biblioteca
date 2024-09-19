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

import com.sise.biblioteca.entities.Idioma;
import com.sise.biblioteca.service.IIdiomaService;
import com.sise.biblioteca.shared.BaseResponse;

@RestController
@RequestMapping("/idiomas")
public class IdiomasController {

  @Autowired
  private IIdiomaService idiomaService;

  @GetMapping("")
  public ResponseEntity<BaseResponse> getAll() {
    try {
      List<Idioma> idiomas = idiomaService.getAll();
      return new ResponseEntity<BaseResponse>(BaseResponse.success(idiomas), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("")
  public ResponseEntity<BaseResponse> add(@RequestBody Idioma idioma) {
    try {
      idiomaService.add(idioma);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(idioma), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{idIdioma}")
  public ResponseEntity<BaseResponse> edit(@PathVariable Integer idIdioma, @RequestBody Idioma idioma) {
    try {
      if (idiomaService.getById(idIdioma) == null)
        return new ResponseEntity<>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      idioma.setIdIdioma(idIdioma);
      idiomaService.edit(idioma);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PatchMapping("/{idIdioma}")
  public ResponseEntity<BaseResponse> remove(@PathVariable Integer idIdioma) {
    try {
      if (idiomaService.getById(idIdioma) == null)
        return new ResponseEntity<>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      idiomaService.remove(idIdioma);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
