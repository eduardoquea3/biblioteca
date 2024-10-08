package com.sise.biblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "autores")
public class Autor {
  @Id
  @Column(name = "idautor")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idAutor;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "estadoauditoria", insertable = false, updatable = false)
  @JsonIgnore
  private boolean estado;
}
