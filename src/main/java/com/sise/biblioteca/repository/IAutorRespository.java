package com.sise.biblioteca.repository;

import com.sise.biblioteca.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAutorRespository  extends JpaRepository<Autor ,Integer> {

}
