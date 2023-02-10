package com.matancita.yngreni.service;

import com.matancita.yngreni.domain.Rol;

import java.util.List;

public interface RolService {
    public List<Rol> listAll();
    public Rol getById(Long id);
    public void insert(Rol rol);
    public void update(Rol rol);
    public void delete(Rol rol);
}
