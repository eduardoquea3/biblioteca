package com.sise.biblioteca.mappers;

import com.sise.biblioteca.dto.EstadoPrestamo.CreateEstadoPrestamoDTO;
import com.sise.biblioteca.dto.EstadoPrestamo.UpdateEstadoPrestamoDTO;
import com.sise.biblioteca.entities.EstadoPrestamo;

public class EstadoPrestamoMapper {
  public static EstadoPrestamo createDtoToEstadoPrestamo(CreateEstadoPrestamoDTO dto) {
    EstadoPrestamo estadoPrestamo = new EstadoPrestamo();
    estadoPrestamo.setNombre(dto.getNombre());
    return estadoPrestamo;
  }

  public static EstadoPrestamo updateDtoToEstadoPrestamo(UpdateEstadoPrestamoDTO dto) {
    EstadoPrestamo estadoPrestamo = new EstadoPrestamo();
    estadoPrestamo.setNombre(dto.getNombre());
    return estadoPrestamo;
  }
}
