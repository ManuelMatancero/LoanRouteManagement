package com.matancita.yngreni.web;

import com.matancita.yngreni.dao.UsuarioDao;
import com.matancita.yngreni.domain.Usuario;
import com.matancita.yngreni.service.UsuarioService;
import com.matancita.yngreni.service.UsuarioServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Transactional
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario){
        usuarioService.insert(usuario);
        return ResponseEntity.ok(usuario);
    }
    @GetMapping("/list")
    public ResponseEntity<?> listUsuarios() {
        List<Usuario> usuarios = usuarioService.listAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getObjectById(@PathVariable Long id) {
       Usuario usuario = usuarioService.getById(id);
        if (usuario==null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(usuario);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioExist = usuarioService.getById(id);
        usuarioExist.setUsuario(usuario.getUsuario());
        usuarioExist.setPassword(usuario.getPassword());
        usuarioExist.setEstatus(usuario.getEstatus());
        usuarioExist.setRol(usuario.getRol());
        usuarioService.update(usuarioExist);
        return  ResponseEntity.ok(usuarioExist);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteusuario(@PathVariable Long id){
        Usuario usuario = usuarioService.getById(id);
        usuarioService.delete(usuario);
        return ResponseEntity.ok("Usuario Eliminad");
    }

}
