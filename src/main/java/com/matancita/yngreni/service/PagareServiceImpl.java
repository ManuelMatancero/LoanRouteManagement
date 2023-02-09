package com.matancita.yngreni.service;

import com.matancita.yngreni.dao.PagareDao;
import com.matancita.yngreni.domain.Pagare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagareServiceImpl implements PagareService{

    @Autowired
    PagareDao pagareDao;
    @Override
    @Transactional(readOnly = true)
    public List<Pagare> listAll() {
        return pagareDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pagare getById(Pagare pagare) {
        return pagareDao.getReferenceById(pagare.getIdPagare());
    }

    @Override
    @Transactional
    public void insert(Pagare pagare) {
        pagareDao.save(pagare);
    }

    @Override
    @Transactional
    public void update(Pagare pagare) {
        pagareDao.save(pagare);
    }

    @Override
    @Transactional
    public void delete(Pagare pagare) {
        pagareDao.deleteById(pagare.getIdPagare());
    }
}
