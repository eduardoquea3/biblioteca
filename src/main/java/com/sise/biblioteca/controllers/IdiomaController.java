package com.sise.biblioteca.controllers;

import com.sise.biblioteca.dto.Idioma.CreateIdiomaDTO;
import com.sise.biblioteca.dto.Idioma.UpdateIdiomaDTO;
import com.sise.biblioteca.entities.Idioma;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.mappers.IdiomaMapper;
import com.sise.biblioteca.service.IIdiomaService;
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
@RequestMapping("/idiomas")
@Tag(name = "Idiomas")
public class IdiomaController {

  @Autowired private IIdiomaService idiomaService;

  @Operation(summary = "obtener todos los idiomas")
  @GetMapping("")
  public ResponseEntity<BaseResponse> getEdioma(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestParam(required = false) String[] sortBy)
      throws ClientException {

    Sort sort = Sort.unsorted();

    if (sortBy != null) {
      ValidateSort.Validate(sortBy, Idioma.class);
      sort = sort.and(Sort.by(sortBy));
    }

    Pageable pageable = PageRequest.of(page, size, sort);
    Page<Idioma> idiomas = idiomaService.getAll(pageable);

    return new ResponseEntity<>(BaseResponse.success(idiomas), HttpStatus.OK);
  }

  @Operation(summary = "Agregar idioma")
  @PostMapping("")
  public ResponseEntity<BaseResponse> add(@RequestBody CreateIdiomaDTO idiomaDTO) {
    Idioma idioma = IdiomaMapper.createDtoToIdioma(idiomaDTO);
    idioma = idiomaService.add(idioma);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(idioma), HttpStatus.CREATED);
  }

  @Operation(summary = "Actualizar idioma")
  @PutMapping("/{idIdioma}")
  public ResponseEntity<BaseResponse> edit(
      @PathVariable Integer idIdioma, @RequestBody UpdateIdiomaDTO idiomaDTO)
      throws ClientException {
    Idioma idioma = IdiomaMapper.updateDtoToIdioma(idiomaDTO);
    Idioma newIdioma = idiomaService.edit(idIdioma, idioma);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(newIdioma), HttpStatus.OK);
  }

  @Operation(summary = "Eliminar logicamente un idioma")
  @PatchMapping("/{idIdioma}")
  public ResponseEntity<BaseResponse> remove(@PathVariable Integer idIdioma)
      throws ClientException {
    idiomaService.remove(idIdioma);
    return new ResponseEntity<>(BaseResponse.success(), HttpStatus.NO_CONTENT);
  }
}
