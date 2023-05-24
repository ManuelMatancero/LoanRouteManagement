package com.matancita.yngreni.service;

import com.matancita.yngreni.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> listAll();
    public Usuario getById(Long id);
    public void insert(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(Usuario usuario);

    public Usuario findByUsuario(String usuario);
}
