package com.sise.biblioteca.controllers;

import com.sise.biblioteca.dto.Libro.CreateLibroDTO;
import com.sise.biblioteca.dto.Libro.UpdateLibroDTO;
import com.sise.biblioteca.entities.Libro;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.mappers.LibroMapper;
import com.sise.biblioteca.service.ILibroService;
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
@RequestMapping("/libros")
@Tag(name = "Libros")
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO) // Por el warning
// y por estandar
public class LibroController {

  @Autowired private ILibroService libroService;

  @Operation(summary = "Obtener todos los libros")
  @GetMapping("")
  public ResponseEntity<BaseResponse> listarLibros(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestParam(required = false) String[] sortBy)
      throws ClientException {

    Sort sort = Sort.unsorted();

    if (sortBy != null) {
      ValidateSort.Validate(sortBy, Libro.class);
      sort = sort.and(Sort.by(sortBy));
    }

    Pageable pageable = PageRequest.of(page, size, sort);
    Page<Libro> libros = libroService.getAll(pageable);
    return new ResponseEntity<>(BaseResponse.success(libros), HttpStatus.OK);
  }

  @Operation(summary = "Obtener libro mediante id")
  @GetMapping("/{idLibro}")
  public ResponseEntity<BaseResponse> getById(@PathVariable Integer idLibro)
      throws ClientException {
    Libro libro = libroService.getById(idLibro);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(libro), HttpStatus.OK);
  }

  @Operation(summary = "Agregar libro")
  @PostMapping("")
  public ResponseEntity<BaseResponse> add(@Valid @RequestBody CreateLibroDTO dto) {
    Libro libro = LibroMapper.createDtoToLibro(dto);
    libro = libroService.add(libro);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(libro), HttpStatus.CREATED);
  }

  @Operation(summary = "Actualizar libro")
  @PutMapping("/{idLibro}")
  public ResponseEntity<BaseResponse> edit(
      @PathVariable Integer idLibro, @RequestBody UpdateLibroDTO libroDTO) throws ClientException {
    Libro libro = LibroMapper.updateDtoToLibro(libroDTO);
    Libro newLibro = libroService.edit(idLibro, libro);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(newLibro), HttpStatus.OK);
  }

  @Operation(summary = "Eliminar logicamente un libro")
  @PatchMapping("/{idLibro}")
  public ResponseEntity<BaseResponse> remove(@PathVariable Integer idLibro) throws ClientException {
    libroService.remove(idLibro);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(), HttpStatus.NO_CONTENT);
  }
}
