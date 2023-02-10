package com.matancita.yngreni.service;

import com.matancita.yngreni.domain.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> listAll();
    public Cliente getById(Long id);
    public void insert(Cliente cliente);
    public void update(Cliente cliente);
    public void delete(Cliente cliente);
}
