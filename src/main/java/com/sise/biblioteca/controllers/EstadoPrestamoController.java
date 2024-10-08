package com.sise.biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode;
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

import com.sise.biblioteca.entities.EstadoPrestamo;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.service.IEstadoPrestamoService;
import com.sise.biblioteca.shared.BaseResponse;
import com.sise.biblioteca.shared.ValidateSort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/estadoprestamo")
@Tag(name = "Estado Prestamo")
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
class EstadoPrestamoController {

  @Autowired private IEstadoPrestamoService estadoPrestamoService;

  @Operation(summary = "Obtener todos los estados de prestamo")
  @GetMapping("")
  public ResponseEntity<BaseResponse> listarEstadosPrestamo(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestParam(required = false) String[] sortBy)
      throws ClientException {
    Sort sort = Sort.unsorted();
    if (sortBy != null) {
      ValidateSort.Validate(sortBy, EstadoPrestamo.class);
      sort = sort.and(Sort.by(sortBy));
    }
    Pageable pageable = PageRequest.of(page, size, sort);
    Page<EstadoPrestamo> estadosPrestamo = estadoPrestamoService.getAll(pageable);
    return new ResponseEntity<>(BaseResponse.success(estadosPrestamo), HttpStatus.OK);
  }

  @Operation(summary = "Agregar estado de prestamo")
  @PostMapping("")
  public ResponseEntity<BaseResponse> addEstadoPrestamo(
      @RequestBody EstadoPrestamo estadoPrestamo) {
    estadoPrestamo = estadoPrestamoService.add(estadoPrestamo);
    return new ResponseEntity<>(BaseResponse.success(estadoPrestamo), HttpStatus.CREATED);
  }

  @Operation(summary = "Actualizar estado de prestamo")
  @PutMapping("/{idEstadoPrestamo}")
  public ResponseEntity<BaseResponse> editEstadoPrestamo(
      @PathVariable Integer idEstadoPrestamo, @RequestBody EstadoPrestamo estadoPrestamo)
      throws ClientException {
    estadoPrestamo = estadoPrestamoService.edit(idEstadoPrestamo, estadoPrestamo);
    return new ResponseEntity<>(BaseResponse.success(estadoPrestamo), HttpStatus.OK);
  }

  @Operation(summary = "Eliminar estado de prestamo")
  @PatchMapping("/{idEstadoPrestamo}")
  public ResponseEntity<BaseResponse> removeEstadoPrestamo(@PathVariable Integer idEstadoPrestamo)
      throws ClientException {
    estadoPrestamoService.remove(idEstadoPrestamo);
    return new ResponseEntity<>(BaseResponse.success(), HttpStatus.NO_CONTENT);
  }
}
