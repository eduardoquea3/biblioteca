package com.sise.biblioteca.repository;

import com.sise.biblioteca.entities.Editorial;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface IEditorialRepository extends JpaRepository<Editorial, Integer> {

  Page<Editorial> findByEstado(boolean estado, Pageable pageable);

  Editorial findOneByIdEditorialAndEstado(Integer idEditorial, boolean estado);

  @Transactional
  @Modifying
  @Query("UPDATE Editorial e SET e.estado = false WHERE e.idEditorial = :idEditorial")
  void remove(@Param("idEditorial") Integer idEditorial);

}
