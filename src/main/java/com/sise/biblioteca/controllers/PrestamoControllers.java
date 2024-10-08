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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sise.biblioteca.entities.Prestamo;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.service.IPrestamoService;
import com.sise.biblioteca.shared.BaseResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/prestamos")
@Tag(name = "Prestamo")
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
public class PrestamoControllers {

      @Autowired
      private IPrestamoService prestamoService;

      @Operation(summary = "Obtener todos los Prestamos")
      @GetMapping("")
      public ResponseEntity<BaseResponse> listarPrestamos(
                  @RequestParam(defaultValue = "0") int page,
                  @RequestParam(defaultValue = "5") int size,
                  @RequestParam(required = false) String[] sorBy) {

            Sort sort = Sort.unsorted();
            if (sorBy != null)
                  sort = sort.and(Sort.by((sorBy)));
            Pageable pageable = PageRequest.of(page, size, sort);
            Page<Prestamo> prestamos = prestamoService.getAll(pageable);

            return new ResponseEntity<BaseResponse>(BaseResponse.success(prestamos), HttpStatus.OK);

      }

      @Operation(summary = "Obtener prestamos")
      @GetMapping("/{idPrestamo}")
      public ResponseEntity<BaseResponse> getById(@PathVariable Integer idPrestamo) throws ClientException {
            Prestamo prestamo = prestamoService.getById(idPrestamo);
            return new ResponseEntity<BaseResponse>(BaseResponse.success(prestamo), HttpStatus.OK);

      }

      @Operation(summary = "Agregar un Prestamo")
      @PostMapping("")
      public ResponseEntity<BaseResponse> add(@RequestBody Prestamo prestamo) {
            prestamo = prestamoService.add(prestamo);
            return new ResponseEntity<BaseResponse>(BaseResponse.success(prestamo), HttpStatus.CREATED);

      }

      @Operation(summary = "Actualizar el Prestamo")
      @PutMapping("/{idPrestamo}")
      public ResponseEntity<BaseResponse> edit(@PathVariable Integer idPrestamo, @RequestBody Prestamo prestamo)
                  throws ClientException {
            Prestamo newPrestamo = prestamoService.edit(idPrestamo, prestamo);
            return new ResponseEntity<BaseResponse>(BaseResponse.success(newPrestamo), HttpStatus.OK);

      }
      @Operation(summary = "Eliminar loogicamente un prestamo")
      @PatchMapping("/{idPrestamo}")
      public ResponseEntity<BaseResponse>remove(@PathVariable Integer idPrestamo)throws ClientException{
            prestamoService.remove(idPrestamo);
            return new ResponseEntity<BaseResponse>(BaseResponse.success(),HttpStatus.NO_CONTENT);
      }

}
