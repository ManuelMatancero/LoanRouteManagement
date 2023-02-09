package com.matancita.yngreni.service;

import com.matancita.yngreni.dao.RecibosGenDao;
import com.matancita.yngreni.domain.RecibosGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecibosGenServiceImpl implements RecibosGenService{

    @Autowired
    RecibosGenDao recibosGenDao;
    @Override
    @Transactional(readOnly = true)
    public List<RecibosGen> listAll() {
        return recibosGenDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public RecibosGen getById(RecibosGen recibosGen) {
        return recibosGenDao.getReferenceById(recibosGen.getIdRecibosGen());
    }

    @Override
    @Transactional
    public void insert(RecibosGen recibosGen) {
        recibosGenDao.save(recibosGen);
    }

    @Override
    @Transactional
    public void update(RecibosGen recibosGen) {
        recibosGenDao.save(recibosGen);
    }

    @Override
    @Transactional
    public void delete(RecibosGen recibosGen) {
        recibosGenDao.deleteById(recibosGen.getIdRecibosGen());
    }
}
