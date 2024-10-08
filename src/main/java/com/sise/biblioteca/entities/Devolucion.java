package com.sise.biblioteca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "devoluciones")
public class Devolucion {

  @Id
  @Column(name = "iddevolucion", insertable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idDevolucion;

  @OneToOne
  @JoinColumn(name = "iddetalleprestamo")
  private DetallePrestamo detallePrestamo;

  @Column(name = "fechadevolucion")
  private Date FechaDevolucion;

  @Column(name = "estadoauditoria", insertable = false, updatable = false)
  @JsonIgnore
  private boolean estado;

}
