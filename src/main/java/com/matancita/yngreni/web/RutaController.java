package com.matancita.yngreni.web;


import com.matancita.yngreni.DTO.Messages;
import com.matancita.yngreni.domain.Ruta;
import com.matancita.yngreni.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ruta")
public class RutaController {

    @Autowired
    RutaService rutaService;

    @PostMapping("/save")
    public ResponseEntity<?> saveRuta(@RequestBody Ruta ruta){
        rutaService.insert(ruta);
        return ResponseEntity.ok(ruta);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listRutas() {
        List<Ruta> rutas = rutaService.listAll();
        return ResponseEntity.ok(rutas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ruta> getObjectById(@PathVariable Long id) {
        Ruta ruta = rutaService.getById(id);
        if (ruta==null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(ruta);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRuta(@PathVariable Long id, @RequestBody Ruta ruta){
        Ruta rutaExist = rutaService.getById(id);
        if(rutaExist!=null){
            rutaExist.setNombre(ruta.getNombre());
            rutaExist.setDia(ruta.getDia());
            rutaExist.setZona(ruta.getZona());
            rutaExist.setCobrador(ruta.getCobrador());
            rutaService.update(rutaExist);
            return  ResponseEntity.ok(rutaExist);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteruta(@PathVariable Long id){
        Ruta ruta = rutaService.getById(id);
        if(ruta!=null){
            rutaService.delete(ruta);
            return ResponseEntity.ok(new Messages("Ruta Eliminada"));
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
