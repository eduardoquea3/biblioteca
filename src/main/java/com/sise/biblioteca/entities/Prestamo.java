package com.sise.biblioteca.entities;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "prestamos")
public class Prestamo {

  @Id
  @Column(name = "idprestamo", insertable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idPrestamo;

  @OneToOne
  @JoinColumn(name = "idcliente", nullable = false)
  private Cliente cliente;

  @Column(name = "cantidad")
  private Integer cantidad;

  @Column(name = "fechaprestamo")
  private Date fechaPrestamo;

  @Column(name = "fechadevolucion")
  private Date fechaDevolucion;

  @Column(name = "estadoauditoria", insertable = false, updatable = false)
  @JsonIgnore
  private boolean estado;

}
