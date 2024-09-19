package com.sise.biblioteca.repository;

import com.sise.biblioteca.entities.SubGenero;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISubGeneroRepository extends JpaRepository <SubGenero,Integer> {


  List<SubGenero> findByEstado(boolean estado);

  SubGenero findOneByIdSubgeneroAndEstado(Integer idSubgenero, boolean estado);

  @Transactional
  @Modifying
  @Query("UPDATE SubGenero s SET s.estado = false WHERE s.idSubgenero = :idSubgenero")
  void remove(@Param("idSubgenero") Integer idSubgenero);

}
