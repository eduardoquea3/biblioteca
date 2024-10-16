package com.sise.biblioteca.controllers;

import com.sise.biblioteca.dto.Autor.CreateAutorDTO;
import com.sise.biblioteca.dto.Autor.UpdateAutorDTO;
import com.sise.biblioteca.entities.Autor;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.mappers.AutorMapper;
import com.sise.biblioteca.service.IAutorService;
import com.sise.biblioteca.shared.BaseResponse;
import com.sise.biblioteca.shared.ValidateSort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
@RequestMapping("/autores")
@Tag(name = "Autores")
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
public class AutorController {

  @Autowired private IAutorService autorService;

  @Operation(summary = "Obtener todos los autores")
  @GetMapping("")
  public ResponseEntity<BaseResponse> listarAutores(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestParam(required = false) String[] sortBy)
      throws ClientException {

    Sort sort = Sort.unsorted();
    if (sortBy != null) {
      ValidateSort.Validate(sortBy, Autor.class);
      sort = sort.and(Sort.by(sortBy));
    }

    Pageable pageable = PageRequest.of(page, size, sort);
    Page<Autor> autores = autorService.getAll(pageable);

    return new ResponseEntity<>(BaseResponse.success(autores), HttpStatus.OK);
  }

  @Operation(summary = "Agregar autor ")
  @PostMapping("")
  public ResponseEntity<BaseResponse> addAutor(@Valid @RequestBody CreateAutorDTO autorDTO) {
    Autor autor = AutorMapper.createDtoToAutor(autorDTO);
    autor = autorService.add(autor);
    return new ResponseEntity<>(BaseResponse.success(autor), HttpStatus.CREATED);
  }

  @Operation(summary = "Actualizar autor")
  @PutMapping("/{idAutor}")
  public ResponseEntity<BaseResponse> editAutor(
      @PathVariable Integer idAutor, @RequestBody UpdateAutorDTO autorDTO) throws ClientException {
    Autor autor = AutorMapper.updateDtoToAutor(autorDTO);
    Autor newAutor = autorService.edit(idAutor, autor);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(newAutor), HttpStatus.OK);
  }

  @Operation(summary = "Eliminar logicamente un autor")
  @PatchMapping("/{idAutor}")
  public ResponseEntity<BaseResponse> removeAutor(@PathVariable Integer idAutor)
      throws ClientException {
    autorService.remove(idAutor);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(), HttpStatus.NO_CONTENT);
  }
}
