package com.sise.biblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categorias")
public class Categoria {

  @Id
  @Column(name = "idcategoria")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCategoria;

  @Column(name = "nombee")
  private String nombre;

  @Column(name = "estado", insertable = false, updatable = false)
  @JsonIgnore
  private boolean estado;

}
