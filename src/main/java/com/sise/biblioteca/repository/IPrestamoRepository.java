package com.sise.biblioteca.repository;

import com.sise.biblioteca.entities.Prestamo;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPrestamoRepository extends JpaRepository<Prestamo, Integer> {

  Page<Prestamo> findByEstado(boolean estado, Pageable pageable);

  Prestamo findOneByIdPrestamoAndEstado(Integer idPrestamo, boolean estado);

  @Transactional
  @Modifying
  @Query("UPDATE Prestamo p SET p.estado = false WHERE p.idPrestamo =:idPrestamo")
  void remove(@Param("idPrestamo") Integer idPrestamo);
}
