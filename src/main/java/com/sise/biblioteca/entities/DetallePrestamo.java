package com.sise.biblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "detalleprestamos")
public class DetallePrestamo {

  @Id
  @Column(name = "iddetalleprestamo", insertable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idDetallePrestamo;

  @ManyToOne
  @JoinColumn(name = "idprestamo", nullable = false)
  private Prestamo prestamo;

  @ManyToOne
  @JoinColumn(name = "idlibro")
  private Libro libro;

  @ManyToOne
  @JoinColumn(name = "idestado")
  private EstadoPrestamo estadoPrestamo;

  @Column(name = "unidades")
  private Integer unidades;

  @Column(name = "estadoautidoria", insertable = false, updatable = false)
  @JsonIgnore
  private boolean estado;

}
