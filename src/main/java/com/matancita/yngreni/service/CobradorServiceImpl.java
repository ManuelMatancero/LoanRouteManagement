package com.matancita.yngreni.service;

import com.matancita.yngreni.dao.CobradorDao;
import com.matancita.yngreni.domain.Cobrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CobradorServiceImpl implements CobradorService{

    @Autowired
    CobradorDao cobradorDao;
    @Override
    @Transactional(readOnly = true)
    public List<Cobrador> listAll() {
        return cobradorDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cobrador getById(Cobrador cobrador) {
        return cobradorDao.getReferenceById(cobrador.getIdCobrador());
    }

    @Override
    @Transactional
    public void insert(Cobrador cobrador) {
        cobradorDao.save(cobrador);
    }

    @Override
    @Transactional
    public void update(Cobrador cobrador) {
        cobradorDao.save(cobrador);
    }

    @Override
    @Transactional
    public void delete(Cobrador cobrador) {
        cobradorDao.deleteById(cobrador.getIdCobrador());
    }
}
