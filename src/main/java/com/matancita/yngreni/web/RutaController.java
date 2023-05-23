package com.matancita.yngreni.web;


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
        rutaExist.setNombre(ruta.getNombre());
        rutaExist.setDia(ruta.getDia());
        rutaExist.setZona(ruta.getZona());
        rutaService.update(rutaExist);
        return  ResponseEntity.ok(rutaExist);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteruta(@PathVariable Long id){
        Ruta ruta = rutaService.getById(id);
        rutaService.delete(ruta);
        return ResponseEntity.ok("Ruta Eliminado");
    }
}
