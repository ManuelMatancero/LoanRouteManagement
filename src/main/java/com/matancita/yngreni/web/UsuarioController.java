package com.matancita.yngreni.web;

import com.matancita.yngreni.dao.UsuarioDao;
import com.matancita.yngreni.domain.Usuario;
import com.matancita.yngreni.service.UsuarioService;
import com.matancita.yngreni.service.UsuarioServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    UsuarioDao usuarioDao;

    @RequestMapping(value = "/saveusuario", method = RequestMethod.POST)
    public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario){
        usuarioService.insert(usuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listUsuarios() {
        List<Usuario> usuarios = usuarioDao.findAll();
        return ResponseEntity.ok(usuarios);
    }

}
