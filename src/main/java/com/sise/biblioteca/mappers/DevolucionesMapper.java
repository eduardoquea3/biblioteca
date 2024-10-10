package com.sise.biblioteca.mappers;

import com.sise.biblioteca.dto.Devolucion.CreateDevolucionDTO;
import com.sise.biblioteca.dto.Devolucion.UpdateDevolucionDTO;
import com.sise.biblioteca.entities.DetallePrestamo;
import com.sise.biblioteca.entities.Devolucion;

public class DevolucionesMapper {
  public static Devolucion createDtoToDevolucion(CreateDevolucionDTO dto) {
    Devolucion devolucion = new Devolucion();

    DetallePrestamo detallePrestamo = new DetallePrestamo();
    detallePrestamo.setIdDetallePrestamo(dto.getIdDetallePrestamo());
    devolucion.setDetallePrestamo(detallePrestamo);

    devolucion.setFechaDevolucion(dto.getFechaDevolucion());
    return devolucion;
  }

  public static Devolucion updateDtoToDevolucion(UpdateDevolucionDTO dto) {
    Devolucion devolucion = new Devolucion();

    DetallePrestamo detallePrestamo = new DetallePrestamo();
    detallePrestamo.setIdDetallePrestamo(dto.getIdDetallePrestamo());
    devolucion.setDetallePrestamo(detallePrestamo);

    devolucion.setFechaDevolucion(dto.getFechaDevolucion());
    return devolucion;
  }
}
