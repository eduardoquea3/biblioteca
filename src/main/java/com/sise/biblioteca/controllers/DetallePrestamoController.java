package com.sise.biblioteca.controllers;

import com.sise.biblioteca.dto.DetallePrestamo.CreateDetallePrestamoDTO;
import com.sise.biblioteca.dto.DetallePrestamo.UpdateDetallePrestamoDTO;
import com.sise.biblioteca.entities.DetallePrestamo;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.mappers.DetallePrestamoMapper;
import com.sise.biblioteca.service.IDetallePrestamoService;
import com.sise.biblioteca.shared.BaseResponse;
import com.sise.biblioteca.shared.ValidateSort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@RestController
@RequestMapping("/detalleprestamo")
@Tag(name = "Detalle Prestamo")
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
public class DetallePrestamoController {

  @Autowired private IDetallePrestamoService detallePrestamoService;

  @Operation(summary = "Obtener todos los detalles de prestamo")
  @GetMapping("")
  public ResponseEntity<BaseResponse> listarDetallePrestamo(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestParam(required = false) String[] sortBy)
      throws ClientException {
    Sort sort = Sort.unsorted();
    if (sortBy != null) {
      ValidateSort.Validate(sortBy, DetallePrestamo.class);
      sort = sort.and(Sort.by(sortBy));
    }

    Pageable pageable = PageRequest.of(page, size, sort);
    Page<DetallePrestamo> detallesPrestamo = detallePrestamoService.getAll(pageable);

    return new ResponseEntity<>(BaseResponse.success(detallesPrestamo), HttpStatus.OK);
  }

  @Operation(summary = "Agregar detalle de prestamo")
  @PostMapping("")
  public ResponseEntity<BaseResponse> addDetallePrestamo(
      @RequestBody CreateDetallePrestamoDTO detallePrestamoDTO) {
    DetallePrestamo detallePrestamo =
        DetallePrestamoMapper.createDtoToDetallePrestamo(detallePrestamoDTO);
    detallePrestamo = detallePrestamoService.add(detallePrestamo);
    return new ResponseEntity<>(BaseResponse.success(detallePrestamoService), HttpStatus.CREATED);
  }

  @Operation(summary = "Actualizar detalle de prestamo")
  @PutMapping("/{idDetallePrestamo}")
  public ResponseEntity<BaseResponse> editDetallePrestamo(
      @PathVariable Integer idDetallePrestamo,
      @RequestBody UpdateDetallePrestamoDTO detallePrestamoDTO)
      throws ClientException {
    DetallePrestamo detallePrestamo =
        DetallePrestamoMapper.updateDtoToDetallePrestamo(detallePrestamoDTO);
    DetallePrestamo newDetallePrestamo =
        detallePrestamoService.edit(idDetallePrestamo, detallePrestamo);
    return new ResponseEntity<>(BaseResponse.success(newDetallePrestamo), HttpStatus.OK);
  }

  @Operation(summary = "Eliminar detalle de prestamo")
  @PatchMapping("/{idDetallePrestamo}")
  public ResponseEntity<BaseResponse> removeDetallePrestamo(@PathVariable Integer idDetallePrestamo)
      throws ClientException {
    detallePrestamoService.remove(idDetallePrestamo);
    return new ResponseEntity<>(
        BaseResponse.success(detallePrestamoService), HttpStatus.NO_CONTENT);
  }
}
