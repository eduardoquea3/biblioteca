package com.sise.biblioteca.controllers;

import com.sise.biblioteca.dto.Devolucion.CreateDevolucionDTO;
import com.sise.biblioteca.dto.Devolucion.UpdateDevolucionDTO;
import com.sise.biblioteca.entities.Devolucion;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.mappers.DevolucionesMapper;
import com.sise.biblioteca.service.IDevolucionService;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devoluciones")
@Tag(name = "Devoluciones")
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
public class DevolucionesController {

  @Autowired private IDevolucionService devolucionService;

  @Operation(summary = "Obtener todos los devoluciones")
  @GetMapping("")
  public ResponseEntity<BaseResponse> listarDevoluciones(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestParam(required = false) String[] sortBy)
      throws ClientException {
    Sort sort = Sort.unsorted();
    if (sortBy != null) {
      ValidateSort.Validate(sortBy, Devolucion.class);
      sort = sort.and(Sort.by(sortBy));
    }

    Pageable pageable = PageRequest.of(page, size, sort);
    Page<Devolucion> devoluciones = devolucionService.getAll(pageable);

    return new ResponseEntity<>(BaseResponse.success(devoluciones), HttpStatus.OK);
  }

  @Operation(summary = "Agregar devolucion")
  @PostMapping("")
  public ResponseEntity<BaseResponse> addDevolucion(
      @RequestBody CreateDevolucionDTO devolucionDTO) {
    Devolucion devolucion = DevolucionesMapper.createDtoToDevolucion(devolucionDTO);
    devolucion = devolucionService.add(devolucion);
    return new ResponseEntity<>(BaseResponse.success(devolucion), HttpStatus.CREATED);
  }

  @Operation(summary = "Actualizar devolucion")
  @PutMapping("/{idDevolucion}")
  public ResponseEntity<BaseResponse> editDevolucion(
      @PathVariable Integer idDevolucion, @RequestBody UpdateDevolucionDTO devolucionDTO)
      throws ClientException {
    Devolucion devolucion = DevolucionesMapper.updateDtoToDevolucion(devolucionDTO);
    Devolucion newDevolucion = devolucionService.edit(idDevolucion, devolucion);
    return new ResponseEntity<>(BaseResponse.success(newDevolucion), HttpStatus.OK);
  }

  @Operation(summary = "Eliminar devolucion")
  @DeleteMapping("/{idDevolucion}")
  public ResponseEntity<BaseResponse> deleteDevolucion(@PathVariable Integer idDevolucion)
      throws ClientException {
    devolucionService.remove(idDevolucion);
    return new ResponseEntity<>(BaseResponse.success(), HttpStatus.NO_CONTENT);
  }
}
