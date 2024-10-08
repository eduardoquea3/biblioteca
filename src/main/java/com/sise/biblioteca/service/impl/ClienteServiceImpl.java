package com.sise.biblioteca.service.impl;

import com.sise.biblioteca.entities.Cliente;
import com.sise.biblioteca.errors.ClientException;
import com.sise.biblioteca.repository.IClienteRepository;
import com.sise.biblioteca.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {

  @Autowired private IClienteRepository clienteRepository;

  @Override
  public Page<Cliente> getAll(Pageable pageable) {
    return clienteRepository.findByEstado(true, pageable);
  }

  @Override
  public Cliente getById(Integer idCliente) throws ClientException {
    Cliente cliente = clienteRepository.findOneByIdClienteAndEstado(idCliente, true);
    if (cliente == null) throw new ClientException("Cliente no existe !", HttpStatus.NOT_FOUND);
    return cliente;
  }

  @Override
  public Cliente add(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  @Override
  public Cliente edit(Integer id, Cliente newCliente) throws ClientException {
    Cliente cliente = clienteRepository.findOneByIdClienteAndEstado(id, true);
    if (cliente == null) throw new ClientException("Cliente no existe", HttpStatus.NOT_FOUND);
    newCliente.setIdCliente(id);
    cliente = clienteRepository.save(newCliente);
    return cliente;
  }

  @Override
  public void remove(Integer idCliente) throws ClientException {
    Cliente cliente = clienteRepository.findOneByIdClienteAndEstado(idCliente, true);
    if (cliente == null) throw new ClientException("Cliente no existe", HttpStatus.NOT_FOUND);
    clienteRepository.remove(idCliente);
  }
}
