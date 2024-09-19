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

import com.sise.biblioteca.entities.Editorial;
import com.sise.biblioteca.service.IEditorialService;
import com.sise.biblioteca.shared.BaseResponse;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {

  @Autowired
  private IEditorialService editorialService;

  @GetMapping("")
  public ResponseEntity<BaseResponse> getAll() {
    try {
      List<Editorial> editoriales = editorialService.getAll();
      return new ResponseEntity<BaseResponse>(BaseResponse.success(editoriales), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("")
  public ResponseEntity<BaseResponse> add(@RequestBody Editorial editorial) {
    try {
      editorialService.add(editorial);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(editorial), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{idEditorial}")
  public ResponseEntity<BaseResponse> edit(@PathVariable Integer idEditorial, @RequestBody Editorial editorial) {
    try {
      if (editorialService.getById(idEditorial) == null)
        return new ResponseEntity<>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      editorial.setIdEditorial(idEditorial);
      editorialService.edit(editorial);
      return new ResponseEntity<BaseResponse>(BaseResponse.success(editorial), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PatchMapping("/{idEditorial}")
  public ResponseEntity<BaseResponse> remove(@PathVariable Integer idEditorial) {
    try {
      if (editorialService.getById(idEditorial) == null)
        return new ResponseEntity<>(BaseResponse.errorNotFound(), HttpStatus.NOT_FOUND);
      editorialService.remove(idEditorial);
      return new ResponseEntity<>(BaseResponse.success(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<BaseResponse>(BaseResponse.error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
