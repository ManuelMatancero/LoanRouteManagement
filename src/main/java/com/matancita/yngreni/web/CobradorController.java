package com.matancita.yngreni.web;


import com.matancita.yngreni.domain.Cobrador;
import com.matancita.yngreni.domain.Cobrador;
import com.matancita.yngreni.service.CobradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cobrador")
@Transactional
public class CobradorController {

    @Autowired
    CobradorService cobradorService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCobrador(@RequestBody Cobrador cobrador){
        cobradorService.insert(cobrador);
        return ResponseEntity.ok(cobrador);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listCobradores() {
        List<Cobrador> cobradores = cobradorService.listAll();
        return ResponseEntity.ok(cobradores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cobrador> getObjectById(@PathVariable Long id) {
        Cobrador cobrador = cobradorService.getById(id);
        if (cobrador==null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(cobrador);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCobrador(@PathVariable Long id, @RequestBody Cobrador cobrador){
        Cobrador cobradorExist = cobradorService.getById(id);
        cobradorExist.setNombre(cobrador.getNombre());
        cobradorExist.setApellido(cobrador.getApellido());
        cobradorExist.setCedula(cobrador.getCedula());
        cobradorExist.setDireccion(cobrador.getDireccion());
        cobradorExist.setTelefono(cobrador.getTelefono());
        cobradorExist.setFechaIngreso(cobrador.getFechaIngreso());
        cobradorService.update(cobradorExist);
        return  ResponseEntity.ok(cobradorExist);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletecobrador(@PathVariable Long id){
        Cobrador cobrador = cobradorService.getById(id);
        cobradorService.delete(cobrador);
        return ResponseEntity.ok("Cobrador Eliminado");
    }




}
