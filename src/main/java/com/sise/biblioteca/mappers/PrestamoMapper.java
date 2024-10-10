package com.sise.biblioteca.mappers;

import com.sise.biblioteca.dto.Prestamo.CreatePrestamoDTO;
import com.sise.biblioteca.dto.Prestamo.UpdatePrestamoDTO;
import com.sise.biblioteca.entities.Cliente;
import com.sise.biblioteca.entities.Prestamo;

public class PrestamoMapper {
  public static Prestamo createDtoToPrestamo(CreatePrestamoDTO dto) {
    Prestamo prestamo = new Prestamo();

    Cliente cliente = new Cliente();
    cliente.setIdCliente(dto.getIdCliente());
    prestamo.setCliente(cliente);

    prestamo.setCantidad(dto.getCantidad());
    prestamo.setFechaPrestamo(dto.getFechaPrestamo());
    prestamo.setFechaDevolucion(dto.getFechaDevolucion());
    return prestamo;
  }

  public static Prestamo updateDtoToPrestamo(UpdatePrestamoDTO dto) {
    Prestamo prestamo = new Prestamo();

    Cliente cliente = new Cliente();
    cliente.setIdCliente(dto.getIdCliente());
    prestamo.setCliente(cliente);

    prestamo.setCantidad(dto.getCantidad());
    prestamo.setFechaPrestamo(dto.getFechaPrestamo());
    prestamo.setFechaDevolucion(dto.getFechaDevolucion());
    return prestamo;
  }
}
