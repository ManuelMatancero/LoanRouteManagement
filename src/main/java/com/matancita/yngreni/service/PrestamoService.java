package com.matancita.yngreni.service;

import com.matancita.yngreni.domain.Prestamo;

import java.util.List;

public interface PrestamoService {
    public List<Prestamo> listAll();
    public Prestamo getById(Prestamo prestamo);
    public void insert(Prestamo prestamo);
    public void update(Prestamo prestamo);
    public void delete(Prestamo prestamo);
}
