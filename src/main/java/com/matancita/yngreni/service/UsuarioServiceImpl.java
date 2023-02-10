package com.matancita.yngreni.service;

import com.matancita.yngreni.dao.UsuarioDao;
import com.matancita.yngreni.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioDao usuarioDao;
    
    @Override
    @Transactional
    public List<Usuario> listAll() {
        return (List<Usuario>)usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void insert(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void update(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
}
