package com.matancita.yngreni.service;

import com.matancita.yngreni.domain.RecibosGen;

import java.util.List;

public interface RecibosGenService {

    public List<RecibosGen> listAll();
    public RecibosGen getById(Long id);
    public void insert(RecibosGen recibosGen);
    public void update(RecibosGen recibosGen);
    public void delete(RecibosGen recibosGen);
}
