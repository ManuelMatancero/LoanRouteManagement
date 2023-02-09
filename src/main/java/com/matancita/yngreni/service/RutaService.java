package com.matancita.yngreni.service;

import com.matancita.yngreni.domain.Ruta;

import java.util.List;

public interface RutaService {
    public List<Ruta> listAll();
    public Ruta getById(Ruta ruta);
    public void insert(Ruta ruta);
    public void update(Ruta ruta);
    public void delete(Ruta ruta);
}
