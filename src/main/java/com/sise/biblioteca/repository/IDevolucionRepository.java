package com.sise.biblioteca.repository;

import com.sise.biblioteca.entities.Devolucion;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDevolucionRepository extends JpaRepository<Devolucion, Integer> {

  Page<Devolucion> findByEstado(boolean estado, Pageable pageable);

  Devolucion findOneByIdDevolucionAndEstado(Integer idDevolucion, boolean estado);

  @Transactional
  @Modifying
  @Query("UPDATE Devolucion d SET d.estado = false WHERE d.idDevolucion = :idDevolucion")
  void remove(@Param("idDevolucion") Integer idDevolucion);
}
