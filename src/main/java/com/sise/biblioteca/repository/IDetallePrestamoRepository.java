package com.sise.biblioteca.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sise.biblioteca.entities.DetallePrestamo;

import jakarta.transaction.Transactional;

public interface IDetallePrestamoRepository extends JpaRepository<DetallePrestamo,Integer> {


    Page<DetallePrestamo>findByIdDetallePrestamo(boolean estado,Pageable pageable);

    DetallePrestamo findOneByIdDetallePrestamoAndEstado(Integer idDetallePrestamo, boolean estado);

    @Transactional
    @Modifying
    @Query("UPDATE DetallePrestamo d SET d.estado = false WHERE d.idDetallePrestamo = :idDetallePrestamo")
    void remove(@Param("idDetallePrestamo") Integer idDetallePrestamo);

 
}
