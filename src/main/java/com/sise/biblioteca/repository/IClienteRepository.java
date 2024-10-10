package com.sise.biblioteca.repository;

import com.sise.biblioteca.entities.Cliente;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

  Page<Cliente> findByEstado(boolean estado, Pageable pageable);

  Cliente findOneByIdClienteAndEstado(Integer idCliente, boolean estado);

  @Transactional
  @Modifying
  @Query("UPDATE Cliente a SET a.estado = false WHERE a.idCliente =:idCliente ")
  void remove(@Param("idCliente") Integer idCliente);
}
