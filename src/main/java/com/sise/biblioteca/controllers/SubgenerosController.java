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

import com.sise.biblioteca.entities.SubGenero;
import com.sise.biblioteca.service.ISubGeneroService;
import com.sise.biblioteca.shared.BaseResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/subgeneros")
@Tag(name = "subgeneros")
public class SubgenerosController {

  @Autowired
  private ISubGeneroService subgeneroService;

  @Operation(summary = "obtener todos los SubGeneros")
  @GetMapping("")
  public ResponseEntity<BaseResponse> getAll() {
    try {
      List<SubGenero> subgeneros = subgeneroService.getAll();
      return new ResponseEntity<BaseResponse>(BaseResponse.success(subgeneros), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @Operation(summary = "Agregar un SubGenero")
  @PostMapping("")
  public ResponseEntity<BaseResponse> add(@RequestBody SubGenero subgenero) {
    try {
      subgeneroService.add(subgenero);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(subgenero), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @Operation(summary = "Actualizar  SubGenero")

  @PutMapping("/{idSubgenero}")
  // change type class
  public ResponseEntity<BaseResponse> edit(@PathVariable Integer idSubgenero, @RequestBody SubGenero subgenero) {
    try {
      if (subgeneroService.getById(idSubgenero) == null)
        return new ResponseEntity<>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      subgenero.setIdSubgenero(idSubgenero);
      subgeneroService.edit(subgenero);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(subgenero), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @Operation(summary = "Eliminar logicamente SubGenero")

  @PatchMapping("/{idSubgenero}")
  public ResponseEntity<BaseResponse> remove(@PathVariable Integer idSubgenero) {
    try {
      if (subgeneroService.getById(idSubgenero) == null)
        return new ResponseEntity<>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      subgeneroService.remove(idSubgenero);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(idSubgenero), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
