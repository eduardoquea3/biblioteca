package com.sise.biblioteca.repository;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sise.biblioteca.entities.EstadoPrestamo;

import jakarta.transaction.Transactional;




public interface IEstadoPrestamoRepository extends JpaRepository<EstadoPrestamo ,Integer> {

     Page<EstadoPrestamo> findByEstado(boolean estado,Pageable pageable) ;

     EstadoPrestamo findOneByIdEstadoPrestamoAndEstado(Integer idEstadoPrestamo,boolean estado);

      @Transactional
      @Modifying
      @Query("UPDATE EstadoPrestamo e SET e.estado = false WHERE e.idEstadoPrestamo =:idEstadoPrestamo ")
     void remove(@Param("idEstadoPrestamo") Integer idEstadoPrestamo );
      
      
}
