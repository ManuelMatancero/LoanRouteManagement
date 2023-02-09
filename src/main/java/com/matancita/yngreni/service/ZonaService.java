package com.matancita.yngreni.service;

import com.matancita.yngreni.domain.Zona;

import java.util.List;

public interface ZonaService {

    public List<Zona> listAll();
    public Zona getById(Zona zona);
    public void insert(Zona zona);
    public void update(Zona zona);
    public void delete(Zona zona);
}
