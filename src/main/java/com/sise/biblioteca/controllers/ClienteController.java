package com.sise.biblioteca.controllers;

import com.sise.biblioteca.entities.Cliente;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.service.IClienteService;
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
@RequestMapping("/clientes")
@Tag(name = "Clientes")
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
public class ClienteController {

  @Autowired private IClienteService clienteService;

  @Operation(summary = "Obtener todos los Clientes")
  @GetMapping("")
  public ResponseEntity<BaseResponse> listarClientes(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size,
      @RequestParam(required = false) String[] sortBy) throws ClientException {
    Sort sort = Sort.unsorted();
    if (sortBy != null) {
      ValidateSort.Validate(sortBy, Cliente.class);
      sort = sort.and(Sort.by((sortBy)));
    }

    Pageable pageable = PageRequest.of(page, size, sort);
    Page<Cliente> clientes = clienteService.getAll(pageable);

    return new ResponseEntity<>(BaseResponse.success(clientes), HttpStatus.OK);
  }

  @Operation(summary = "Obtener un Cliente")
  @GetMapping("/{idCliente}")
  public ResponseEntity<BaseResponse> getById(@PathVariable Integer idCliente)
      throws ClientException {
    Cliente cliente = clienteService.getById(idCliente);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(cliente), HttpStatus.OK);
  }

  @Operation(summary = "Agregar un Cliente")
  @PostMapping("")
  public ResponseEntity<BaseResponse> add(@RequestBody Cliente cliente) {

    cliente = clienteService.add(cliente);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(cliente), HttpStatus.CREATED);
  }

  @Operation(summary = "Actualizar el Cliente")
  @PutMapping("/{idCliente}")
  public ResponseEntity<BaseResponse> edit(
      @PathVariable Integer idCliente, @RequestBody Cliente cliente) throws ClientException {
    Cliente newCliente = clienteService.edit(idCliente, cliente);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(newCliente), HttpStatus.OK);
  }

  @Operation(summary = "Eliminar logicamente un Cliente")
  @PatchMapping("/{idCliente}")
  public ResponseEntity<BaseResponse> remove(@PathVariable Integer idCliente)
      throws ClientException {
    clienteService.remove(idCliente);
    return new ResponseEntity<BaseResponse>(BaseResponse.success(), HttpStatus.NO_CONTENT);
  }
}
