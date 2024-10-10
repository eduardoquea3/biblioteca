package com.sise.biblioteca.mappers;

import com.sise.biblioteca.dto.DetallePrestamo.CreateDetallePrestamoDTO;
import com.sise.biblioteca.dto.DetallePrestamo.UpdateDetallePrestamoDTO;
import com.sise.biblioteca.entities.DetallePrestamo;
import com.sise.biblioteca.entities.EstadoPrestamo;
import com.sise.biblioteca.entities.Libro;
import com.sise.biblioteca.entities.Prestamo;

public class DetallePrestamoMapper {
  public static DetallePrestamo createDtoToDetallePrestamo(CreateDetallePrestamoDTO dto) {
    DetallePrestamo detallePrestamo = new DetallePrestamo();

    Prestamo prestamo = new Prestamo();
    prestamo.setIdPrestamo(dto.getIdPrestamo());
    detallePrestamo.setPrestamo(prestamo);

    Libro libro = new Libro();
    libro.setIdLibro(dto.getIdLibro());
    detallePrestamo.setLibro(libro);

    EstadoPrestamo estadoPrestamo = new EstadoPrestamo();
    estadoPrestamo.setIdEstadoPrestamo(dto.getIdEstadoPrestamo());
    detallePrestamo.setEstadoPrestamo(estadoPrestamo);

    detallePrestamo.setUnidades(dto.getUnidades());
    return detallePrestamo;
  }

  public static DetallePrestamo updateDtoToDetallePrestamo(UpdateDetallePrestamoDTO dto) {
    DetallePrestamo detallePrestamo = new DetallePrestamo();

    Prestamo prestamo = new Prestamo();
    prestamo.setIdPrestamo(dto.getIdPrestamo());
    detallePrestamo.setPrestamo(prestamo);

    Libro libro = new Libro();
    libro.setIdLibro(dto.getIdLibro());
    detallePrestamo.setLibro(libro);

    EstadoPrestamo estadoPrestamo = new EstadoPrestamo();
    estadoPrestamo.setIdEstadoPrestamo(dto.getIdEstadoPrestamo());
    detallePrestamo.setEstadoPrestamo(estadoPrestamo);

    detallePrestamo.setUnidades(dto.getUnidades());
    return detallePrestamo;
  }
}
