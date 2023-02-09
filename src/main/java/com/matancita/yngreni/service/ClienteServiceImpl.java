package com.matancita.yngreni.service;

import com.matancita.yngreni.dao.ClienteDao;
import com.matancita.yngreni.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteDao clienteDao;
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listAll() {
        return clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getById(Cliente cliente) {
        return clienteDao.getReferenceById(cliente.getIdCliente());
    }

    @Override
    @Transactional
    public void insert(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void update(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.deleteById(cliente.getIdCliente());
    }
}
