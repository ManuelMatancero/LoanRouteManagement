package com.matancita.yngreni.service;

import com.matancita.yngreni.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> listAll();
    public Usuario getById(Usuario usuario);
    public void insert(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(Usuario usuario);
}
