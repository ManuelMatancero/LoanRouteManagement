package com.matancita.yngreni.service;

import com.matancita.yngreni.domain.Pagare;

import java.util.List;

public interface PagareService {

    public List<Pagare> listAll();
    public Pagare getById(Long id);
    public void insert(Pagare pagare);
    public void update(Pagare pagare);
    public void delete(Pagare pagare);
}
