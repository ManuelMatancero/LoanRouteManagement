package com.matancita.yngreni.service;

import com.matancita.yngreni.dao.ZonaDao;
import com.matancita.yngreni.domain.Zona;
import com.matancita.yngreni.domain.Zona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ZonaServiceImpl implements ZonaService {
    @Autowired
    ZonaDao zonaDao;
    @Override
    @Transactional(readOnly = true)
    public List<Zona> listAll() {
        return zonaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Zona getById(Long id) {
        return zonaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insert(Zona zona) {
        zonaDao.save(zona);
    }

    @Override
    @Transactional
    public void update(Zona zona) {
        zonaDao.save(zona);
    }

    @Override
    @Transactional
    public void delete(Zona zona) {
        zonaDao.delete(zona);
    }
}
