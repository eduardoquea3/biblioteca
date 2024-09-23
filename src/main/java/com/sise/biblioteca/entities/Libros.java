package com.sise.biblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "libros")
public class Libros {

  @Id
  @Column(name = "idlibro", insertable = false, updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idLibro;

  @Column(name = "serialnumber")
  private String serialNumber;

  @Column(name = "nombre")
  private String nombre;

  @ManyToOne
  @JoinColumn(name = "idautor", nullable = false)
  private Autor autor;

  @ManyToOne
  @JoinColumn(name = "ididioma", nullable = false)
  private Idioma idioma;

  @ManyToOne
  @JoinColumn(name = "ideditorial", nullable = false)
  private Editorial editorial;

  @ManyToOne
  @JoinColumn(name = "idcategoria", nullable = false)
  private Categoria categoria;

  @ManyToOne
  @JoinColumn(name = "idsubgenero", nullable = false)
  private SubGenero subGenero;

  @Column(name = "anio")
  private Integer anio;

  @Column(name = "unidades")
  private Integer unidades;

  @Column(name = "cantpaginas")
  private Integer cantidadPaginas;

  @Column(name = "urlimagen")
  private String urlImagen;

  @Column(name = "estado", insertable = false, updatable = false)
  @JsonIgnore
  private boolean estado;

}
