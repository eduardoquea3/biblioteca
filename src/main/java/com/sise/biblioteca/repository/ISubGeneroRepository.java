package com.sise.biblioteca.repository;

import com.sise.biblioteca.entities.SubGenero;

import jakarta.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISubGeneroRepository extends JpaRepository <SubGenero,Integer> {


  Page<SubGenero> findByEstado(boolean estado,Pageable pePageable);

  SubGenero findOneByIdSubgeneroAndEstado(Integer idSubgenero, boolean estado);

  @Transactional
  @Modifying
  @Query("UPDATE SubGenero s SET s.estado = false WHERE s.idSubgenero = :idSubgenero")
  void remove(@Param("idSubgenero") Integer idSubgenero);

}
