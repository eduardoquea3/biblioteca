package com.sise.biblioteca.repository;

import com.sise.biblioteca.entities.Libro;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface ILibroRepository extends JpaRepository<Libro, Integer> {

  Page<Libro> findByEstado(boolean estado, Pageable pageable);

  Libro findOneByIdLibroAndEstado(Integer idLibro, boolean estado);

  @Transactional
  @Modifying
  @Query("UPDATE Libro a SET a.estado = false WHERE a.idLibro = :idLibro")
  void remove(@Param("idLibro") Integer idLibro);

}
