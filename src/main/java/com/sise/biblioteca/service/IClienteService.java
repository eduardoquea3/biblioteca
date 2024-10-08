package com.sise.biblioteca.service;

import org.springframework.data.domain.Pageable;

import com.sise.biblioteca.entities.Cliente;
import com.sise.biblioteca.errors.ClientException;



import org.springframework.data.domain.Page;
public interface IClienteService {
      

      Page<Cliente> getAll(Pageable pageable);
      Cliente getById(Integer idCliente) throws ClientException;

      Cliente add(Cliente cliente);

      Cliente edit(Integer id, Cliente cliente) throws ClientException;

      void remove(Integer idCliente) throws ClientException;
}
