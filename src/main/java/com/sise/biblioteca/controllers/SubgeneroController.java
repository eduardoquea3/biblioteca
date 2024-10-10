package com.sise.biblioteca.controllers;

import com.sise.biblioteca.dto.SubGenero.CreateSubgeneroDTO;
import com.sise.biblioteca.dto.SubGenero.UpdateSubgeneroDTO;
import com.sise.biblioteca.entities.SubGenero;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.mappers.SubgeneroMapper;
import com.sise.biblioteca.service.ISubGeneroService;
import com.sise.biblioteca.shared.BaseResponse;
import com.sise.biblioteca.shared.ValidateSort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@RestController
@RequestMapping("/subgeneros")
@Tag(name = "Subgeneros")
public class SubgeneroController {

  @Autowired private ISubGeneroService subgeneroService;

  @Operation(summary = "Obtener todos los subgeneros")
  @GetMapping("")
  public ResponseEntity<BaseResponse> getSubGenero(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestParam(required = false) String[] sortBy)
      throws ClientException {

    Sort sort = Sort.unsorted();

    if (sortBy != null) {
      ValidateSort.Validate(sortBy, SubGenero.class);
      sort = sort.and(Sort.by(sortBy));
    }

    Pageable pageable = PageRequest.of(page, size, sort);
    Page<SubGenero> subgeneros = subgeneroService.getAll(pageable);

    return new ResponseEntity<>(BaseResponse.success(subgeneros), HttpStatus.OK);
  }

  @Operation(summary = "Agregar subgenero")
  @PostMapping("")
  public ResponseEntity<BaseResponse> add(@RequestBody CreateSubgeneroDTO subgeneroDTO) {
    SubGenero subgenero = SubgeneroMapper.createDtoToSubgenero(subgeneroDTO);
    subgenero = subgeneroService.add(subgenero);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(subgenero), HttpStatus.CREATED);
  }

  @Operation(summary = "Actualizar subgenero")
  @PutMapping("/{idSubgenero}")
  public ResponseEntity<BaseResponse> edit(
      @PathVariable Integer idSubgenero, @RequestBody UpdateSubgeneroDTO subgeneroDTO)
      throws ClientException {
    SubGenero subgenero = SubgeneroMapper.updateDtoToSubgenero(subgeneroDTO);
    SubGenero newSubGenero = subgeneroService.edit(idSubgenero, subgenero);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(newSubGenero), HttpStatus.OK);
  }

  @Operation(summary = "Eliminar logicamente un subgenero")
  @PatchMapping("/{idSubgenero}")
  public ResponseEntity<BaseResponse> remove(@PathVariable Integer idSubgenero)
      throws ClientException {
    subgeneroService.remove(idSubgenero);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(), HttpStatus.NO_CONTENT);
  }
}
