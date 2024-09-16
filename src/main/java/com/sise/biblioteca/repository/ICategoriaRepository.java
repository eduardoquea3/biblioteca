package com.sise.biblioteca.repository;

import com.sise.biblioteca.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
