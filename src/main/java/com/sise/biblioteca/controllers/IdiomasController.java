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


import com.sise.biblioteca.entities.Idioma;
import com.sise.biblioteca.service.IIdiomaService;
import com.sise.biblioteca.shared.BaseResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/idiomas")
@Tag(name = "Idiomas")
public class IdiomasController {

  @Autowired
  private IIdiomaService idiomaService;

  @Operation(summary = "obtener todos los Idiomas")
  @GetMapping("")
 public ResponseEntity<Page<Idioma>> getEdioma(
      @RequestParam(defaultValue = "0") int page,

      @RequestParam(defaultValue = "5") int size,

      @RequestParam(required = false) String[] sortBy) {

    try {
      Pageable pageable = (sortBy != null) ? PageRequest.of(page, size, Sort.by(sortBy).ascending()) : PageRequest.of(page, size);

      Page<Idioma> idioma = idiomaService.getAll(pageable);

      return new ResponseEntity<>(idioma, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
  }

  @Operation(summary = "Agregar Idioma")
  @PostMapping("")
  public ResponseEntity<BaseResponse> add(@RequestBody Idioma idioma) {
    try {
      idiomaService.add(idioma);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(idioma), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @Operation(summary = "Actualizar Idioma")
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

  @Operation(summary = "Eliminar logicamente Idioma")

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
