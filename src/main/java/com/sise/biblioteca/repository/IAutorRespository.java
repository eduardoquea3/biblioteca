package com.sise.biblioteca.repository;

import com.sise.biblioteca.entities.Autor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface IAutorRespository extends JpaRepository<Autor, Integer> {
  @Query("SELECT  a FROM Autor a WHERE CAST(a.estado AS int) = :estado")
  List<Autor> findByEstado(@Param("estado") byte estado);

  // @Query("UPDATE Autor a SET a.estado = 0 WHERE a.idAutor = :idAutor")
  // void hidden(@Param("idAutor") Integer idAutor);

  // Autor getById(@Param("idAutor") Integer idAutor);
  // @Query("SELECT a FROM Autor a WHERE CAST(a.estado AS int) = 1 AND a.idAutor = :idAutor")
  // Autor findOneByIdAutorAndEstado(Integer idAutor, byte estado);
  // @Query("SELECT a FROM Autor a WHERE CAST(a.estado AS int) = 1 AND a.idAutor = :idAutor")
  // Autor getOne(@Param("idAutor")Integer idAutor);
}
