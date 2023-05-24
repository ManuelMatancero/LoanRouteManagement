package com.matancita.yngreni.dao;

import com.matancita.yngreni.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    Usuario findByUsuario(String usuario);
}
