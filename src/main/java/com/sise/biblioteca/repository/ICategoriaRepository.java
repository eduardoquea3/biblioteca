package com.sise.biblioteca.repository;

import com.sise.biblioteca.entities.Categoria;

import jakarta.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

  Page<Categoria> findByEstado(boolean estado, Pageable pageable);

  Categoria findOneByIdCategoriaAndEstado(Integer idCategoria, boolean estado);

  @Transactional
  @Modifying
  @Query("UPDATE Categoria c set c.estado = false WHERE c.idCategoria = :idCategoria")
  void remove(@Param("idCategoria") Integer idCategoria);

}
