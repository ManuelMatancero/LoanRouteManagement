package com.matancita.yngreni.web;

import com.matancita.yngreni.domain.Usuario;
import com.matancita.yngreni.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario){
        //Here i encoded the password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encPassword = encoder.encode(usuario.getPassword());
        usuario.setPassword(encPassword);
        //Check if there is a same usuario created in the database or an email
        boolean usuarioIsValid = true;
        List<Usuario> usuarios = usuarioService.listAll();
        for(Usuario usuarioname: usuarios){
            if (usuario.getUsuario().equals(usuarioname.getUsuario())) {
                usuarioIsValid = false;
                break;
            }
        }
        //Here if user is Valid the user will be crated only if email is also valid
        if(usuarioIsValid){

            usuarioService.insert(usuario);
            return ResponseEntity.ok(usuario);
        }else {
            return ResponseEntity.ok("The user is already in use");
        }

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
        //Here i encoded the password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encPassword = encoder.encode(usuario.getPassword());
        usuario.setPassword(encPassword);
        //Check if there is a same usuario created in the database or an email
        boolean usuarioIsValid = true;
        List<Usuario> usuarios = usuarioService.listAll();
        for(Usuario usuarioname: usuarios){
            if (usuario.getUsuario().equals(usuarioname.getUsuario())) {
                usuarioIsValid = false;
                break;
            }
        }
        //Here if usuario is Valid the user will be crated
        if(usuarioIsValid){
            Usuario usuarioExist = usuarioService.getById(id);
            usuarioExist.setUsuario(usuario.getUsuario());
            usuarioExist.setPassword(usuario.getPassword());
            usuarioExist.setEstatus(usuario.getEstatus());
            usuarioExist.setRol(usuario.getRol());
            usuarioExist.setEmpresa(usuario.getEmpresa());
            usuarioExist.setCobrador(usuario.getCobrador());

            usuarioService.update(usuarioExist);
            return  ResponseEntity.ok(usuarioExist);
        }else {
            return ResponseEntity.ok("The user is already in use");
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteusuario(@PathVariable Long id){
        Usuario usuario = usuarioService.getById(id);
        usuarioService.delete(usuario);
        return ResponseEntity.ok("Usuario Eliminado");
    }

}
