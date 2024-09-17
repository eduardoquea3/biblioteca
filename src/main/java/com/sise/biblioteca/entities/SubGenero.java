package com.sise.biblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subgeneros")
public class SubGenero {

  @Id
  @Column(name = "idsubgenero")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idSubgenero;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "estado", insertable = false, updatable = false)
  @JsonIgnore
  private boolean estado;

}
