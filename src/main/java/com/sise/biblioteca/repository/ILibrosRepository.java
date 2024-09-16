package com.sise.biblioteca.repository;

import com.sise.biblioteca.entities.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibrosRepository extends JpaRepository<Libros,Integer> {
}
