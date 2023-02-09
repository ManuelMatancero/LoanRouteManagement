package com.matancita.yngreni.service;

import com.matancita.yngreni.dao.EmpresaDao;
import com.matancita.yngreni.domain.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    EmpresaDao empresaDao;
    @Override
    @Transactional(readOnly = true)
    public List<Empresa> listAll() {
        return empresaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Empresa getById(Empresa empresa) {
        return empresaDao.getReferenceById(empresa.getIdEmpresa());
    }

    @Override
    @Transactional
    public void insert(Empresa empresa) {
        empresaDao.save(empresa);
    }

    @Override
    @Transactional
    public void update(Empresa empresa) {
        empresaDao.save(empresa);
    }

    @Override
    @Transactional
    public void delete(Empresa empresa) {
        empresaDao.deleteById(empresa.getIdEmpresa());
    }
}
