package com.sise.biblioteca.repository;

import com.sise.biblioteca.entities.Idioma;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IIdiomaRepository extends JpaRepository<Idioma, Integer> {

  List<Idioma> findByEstado(boolean estado);

  Idioma findOneByIdIdiomaAndEstado(Integer idIdioma, boolean estado);

  @Transactional
  @Modifying
  @Query("UPDATE Idioma i SET i.estado = false WHERE i.idIdioma = :idIdioma")
  void remove(@Param("idIdioma") Integer idIdioma);

}
