package com.sise.biblioteca.mappers;

import com.sise.biblioteca.dto.Cliente.CreateClienteDTO;
import com.sise.biblioteca.dto.Cliente.UpdateClienteDTO;
import com.sise.biblioteca.entities.Cliente;

public class ClienteMapper {
  public static Cliente createDtoToCliente(CreateClienteDTO dto) {
    Cliente cliente = new Cliente();
    cliente.setNombre(dto.getNombre());
    cliente.setApellidoPaterno(dto.getApellidoPaterno());
    cliente.setApellidoMaterno(dto.getApellidoMaterno());
    cliente.setTelefono(dto.getTelefono());
    cliente.setCorreo(dto.getCorreo());
    cliente.setDireccion(dto.getDireccion());
    cliente.setFecha(dto.getFecha());
    return cliente;
  }

  public static Cliente updateDtoToCliente(UpdateClienteDTO dto) {
    Cliente cliente = new Cliente();
    cliente.setNombre(dto.getNombre());
    cliente.setApellidoPaterno(dto.getApellidoPaterno());
    cliente.setApellidoMaterno(dto.getApellidoMaterno());
    cliente.setTelefono(dto.getTelefono());
    cliente.setCorreo(dto.getCorreo());
    cliente.setDireccion(dto.getDireccion());
    cliente.setFecha(dto.getFecha());
    return cliente;
  }
}
