package com.matancita.yngreni.web;


import com.matancita.yngreni.DTO.Messages;
import com.matancita.yngreni.domain.Zona;
import com.matancita.yngreni.service.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zona")
public class ZonaController {

    @Autowired
    ZonaService zonaService;

    @PostMapping("/save")
    public ResponseEntity<?> saveZona(@RequestBody Zona zona){
        zonaService.insert(zona);
        return ResponseEntity.ok(zona);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listZonas() {
        List<Zona> zonas = zonaService.listAll();
        return ResponseEntity.ok(zonas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zona> getObjectById(@PathVariable Long id) {
        Zona zona = zonaService.getById(id);
        if (zona==null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(zona);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateZona(@PathVariable Long id, @RequestBody Zona zona){
        Zona zonaExist = zonaService.getById(id);
        if (zonaExist!=null){
            zonaExist.setNombre(zona.getNombre());
            zonaExist.setDireccion(zona.getDireccion());
            zonaExist.setEstatus(zona.getEstatus());
            zonaService.update(zonaExist);
            return  ResponseEntity.ok(zonaExist);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletezona(@PathVariable Long id){
        Zona zona = zonaService.getById(id);
        if(zona!=null){
            zonaService.delete(zona);
            return ResponseEntity.ok(new Messages("Zona Eliminada"));
        }else {
            return ResponseEntity.notFound().build();
        }

    }
}
