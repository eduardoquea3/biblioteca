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

import com.sise.biblioteca.entities.Categoria;
import com.sise.biblioteca.errors.ClientException;
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

  @Operation(summary = "Obtener todos las categorias")
  @GetMapping("")
  public ResponseEntity<BaseResponse> getCategoria(
      @RequestParam(defaultValue = "0") int page,

      @RequestParam(defaultValue = "5") int size,

      @RequestParam(required = false) String[] sortBy) {

    Sort sort = Sort.unsorted();
    if (sortBy != null)
      sort = sort.and(Sort.by(sortBy));

    Pageable pageable = PageRequest.of(page, size, sort);
    Page<Categoria> categorias = categoriaService.getAll(pageable);
    return new ResponseEntity<>(BaseResponse.success(categorias), HttpStatus.OK);
  }

  @Operation(summary = "Agregar categoria")
  @PostMapping("")
  public ResponseEntity<BaseResponse> add(@RequestBody Categoria categoria) {
    categoria = categoriaService.add(categoria);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(categoria), HttpStatus.CREATED);

  }

  @Operation(summary = "Actualizar categoria")
  @PutMapping("/{idCategoria}")
  public ResponseEntity<BaseResponse> edit(@PathVariable Integer idCategoria, @RequestBody Categoria categoria)
      throws ClientException {
    Categoria newCategoria = categoriaService.edit(idCategoria, categoria);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(newCategoria), HttpStatus.OK);
  }

  @Operation(summary = "Eliminar logicamente una categoria")
  @PatchMapping("/{idCategoria}")
  public ResponseEntity<BaseResponse> remove(@PathVariable Integer idCategoria) throws ClientException {
    categoriaService.remove(idCategoria);
    return new ResponseEntity<>(BaseResponse.success(), HttpStatus.NO_CONTENT);
  }

}
