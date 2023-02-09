package com.matancita.yngreni.service;

import com.matancita.yngreni.dao.RutaDao;
import com.matancita.yngreni.domain.Ruta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RutaServiceImpl implements RutaService{

    @Autowired
    RutaDao rutaDao;
    @Override
    @Transactional(readOnly = true)
    public List<Ruta> listAll() {
        return rutaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Ruta getById(Ruta ruta) {
        return rutaDao.getReferenceById(ruta.getIdRuta());
    }

    @Override
    @Transactional
    public void insert(Ruta ruta) {
        rutaDao.save(ruta);
    }

    @Override
    @Transactional
    public void update(Ruta ruta) {
        rutaDao.save(ruta);
    }

    @Override
    @Transactional
    public void delete(Ruta ruta) {
        rutaDao.deleteById(ruta.getIdRuta());
    }
}
