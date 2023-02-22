package com.matancita.yngreni.web;

import com.matancita.yngreni.domain.Prestamo;
import com.matancita.yngreni.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;

    @PostMapping("/save")
    public ResponseEntity<?> savePrestamo(@RequestBody Prestamo prestamo){
        prestamoService.insert(prestamo);
        return ResponseEntity.ok(prestamo);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listPrestamos() {
        List<Prestamo> prestamos = prestamoService.listAll();
        return ResponseEntity.ok(prestamos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getObjectById(@PathVariable Long id) {
        Prestamo prestamo = prestamoService.getById(id);
        if (prestamo==null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(prestamo);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePrestamo(@PathVariable Long id, @RequestBody Prestamo prestamo){
        Prestamo prestamoExist = prestamoService.getById(id);
        prestamoExist.setFecha(prestamo.getFecha());
        prestamoExist.setMonto(prestamo.getMonto());
        prestamoExist.setTipoPrestamo(prestamo.getTipoPrestamo());
        prestamoExist.setVencimiento(prestamo.getVencimiento());
        prestamoExist.setInteres(prestamo.getInteres());
        prestamoExist.setCuotas(prestamo.getCuotas());
        prestamoExist.setAnulado(prestamo.getAnulado());
        prestamoExist.setCliente(prestamo.getCliente());
        prestamoService.update(prestamoExist);
        return  ResponseEntity.ok(prestamoExist);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePrestamo(@PathVariable Long id){
        Prestamo prestamo = prestamoService.getById(id);
        prestamoService.delete(prestamo);
        return ResponseEntity.ok("Prestamo Eliminado");
    }

}
