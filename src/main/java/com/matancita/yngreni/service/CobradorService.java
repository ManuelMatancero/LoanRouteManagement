package com.matancita.yngreni.service;

import com.matancita.yngreni.domain.Cliente;
import com.matancita.yngreni.domain.Cobrador;

import java.util.List;

public interface CobradorService {


    public List<Cobrador> listAll();
    public Cobrador getById(Long id);
    public void insert(Cobrador cobrador);
    public void update(Cobrador cobrador);
    public void delete(Cobrador cobrador);
}
