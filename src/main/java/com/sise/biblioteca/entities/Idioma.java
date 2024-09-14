package com.sise.biblioteca.entities;

import ch.qos.logback.core.model.NamedModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import  lombok.Data;

@Data
@Entity
@Table(name = "idiomas")
public class Idioma {

    @Id
    @Column(name = "ididioma")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idIdioma;

    @Column(name = "nombre")
    private String nombre;

    @Column(name="estado",insertable = false,updatable = false)
    @JsonIgnore
    private  byte estado;




}
