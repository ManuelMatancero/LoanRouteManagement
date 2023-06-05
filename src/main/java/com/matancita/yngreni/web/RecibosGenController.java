package com.matancita.yngreni.web;


import com.matancita.yngreni.DTO.Messages;
import com.matancita.yngreni.domain.RecibosGen;
import com.matancita.yngreni.service.RecibosGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recibosGen")
public class RecibosGenController {


    @Autowired
    RecibosGenService recibosGenService;

    @PostMapping("/save")
    public ResponseEntity<?> saveRecibosGen(@RequestBody RecibosGen recibosGen){
        recibosGenService.insert(recibosGen);
        return ResponseEntity.ok(recibosGen);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listRecibosGens() {
        List<RecibosGen> recibosGens = recibosGenService.listAll();
        return ResponseEntity.ok(recibosGens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecibosGen> getObjectById(@PathVariable Long id) {
        RecibosGen recibosGen = recibosGenService.getById(id);
        if (recibosGen==null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(recibosGen);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRecibosGen(@PathVariable Long id, @RequestBody RecibosGen recibosGen){
        RecibosGen recibosGenExist = recibosGenService.getById(id);
        if(recibosGenExist!=null){
            recibosGenExist.setFecha(recibosGen.getFecha());
            recibosGenExist.setValor(recibosGen.getValor());
            recibosGenService.update(recibosGenExist);
            return  ResponseEntity.ok(recibosGenExist);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleterecibosGen(@PathVariable Long id){
        RecibosGen recibosGen = recibosGenService.getById(id);
        if(recibosGen!=null){
            recibosGenService.delete(recibosGen);
            return ResponseEntity.ok(new Messages("RecibosGen Eliminado"));
        }else {
            return ResponseEntity.notFound().build();
        }

    }

}
