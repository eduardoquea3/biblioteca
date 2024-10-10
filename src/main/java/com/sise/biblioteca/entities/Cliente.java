package com.sise.biblioteca.entities;

import java.sql.Date;

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
@Table(name = "clientes")
public class Cliente {

  @Id
  @Column(name = "idcliente")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idCliente;

  @Column(name = "dni")
  private Integer dni;

  @Column(name = "nombres")
  private String nombre;

  @Column(name = "apellidopaterno")
  private String apellidoPaterno;

  @Column(name = "apellidomaterno")
  private String apellidoMaterno;

  @Column(name = "telefono")
  private String Telefono;

  @Column(name = "correo")
  private String correo;

  @Column(name = "direccion")
  private String direccion;

  @Column(name = "fechanacimiento")
  private Date fecha;

  @Column(name = "estadoauditoria", insertable = false, updatable = false)
  @JsonIgnore
  private boolean estado;

}
