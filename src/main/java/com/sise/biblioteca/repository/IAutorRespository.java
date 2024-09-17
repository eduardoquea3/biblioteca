package com.sise.biblioteca.repository;

import com.sise.biblioteca.entities.Autor;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAutorRespository extends JpaRepository<Autor, Integer> {

  List<Autor> findByEstado(boolean estado);

  Autor findOneByIdAutorAndEstado(Integer idAutor, boolean estado);

  @Transactional
  @Modifying
  @Query("UPDATE Autor a SET a.estado = false WHERE a.idAutor = :idAutor")
  void remove(@Param("idAutor") Integer idAutor);

}
