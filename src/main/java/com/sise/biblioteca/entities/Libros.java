package com.sise.biblioteca.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import  lombok.Data;

import javax.naming.Name;

@Data
@Entity
@Table(name = "libros")
public class Libros {

    @Id
    @Column(name = "idlibro",insertable = false,updatable = false)
    private  Integer idLibro;

    @Column(name = "serialnumber")
    private String serialNumber;

    @Column(name = "nombre")
    private String nombre;


    @ManyToOne
    @JoinColumn(name = "idautor" ,insertable = false,updatable = false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "ididioma",insertable = false,updatable = false)
    private Idioma idioma;

    @ManyToOne
    @JoinColumn(name="ideditorial",insertable = false,updatable = false)
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name="idcategoria",insertable = false,updatable = false)
    private Categoria categoria;


    @ManyToOne
    @JoinColumn(name = "idsubgenero",insertable = false,updatable = false)
    private  SubGenero subGenero;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "unidades")
    private Integer unidades;

    @Column(name = "cantpaginas")
    private Integer cantidadPaginas;

    @Column(name = "urlimagen")
    private String urlImagen;

    @Column(name = "estado",insertable = false,updatable = false)
    @JsonIgnore
    private  byte estado;















}
