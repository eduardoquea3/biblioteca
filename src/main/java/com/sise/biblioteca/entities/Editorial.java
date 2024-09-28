package com.sise.biblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "editoriales")
public class Editorial {

  @Id
  @Column(name = "ideditorial")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idEditorial;

  private String nombre;

  @Column(name = "estadoauditoria", insertable = false, updatable = false)
  @JsonIgnore
  private boolean estado;

}
