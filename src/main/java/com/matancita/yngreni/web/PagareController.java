package com.matancita.yngreni.web;

import com.matancita.yngreni.domain.Pagare;
import com.matancita.yngreni.service.PagareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagare")
public class PagareController {

    @Autowired
    PagareService pagareService;

    @PostMapping("/save")
    public ResponseEntity<?> savePagare(@RequestBody List<Pagare> pagare){
        pagareService.insertAll(pagare);
        return ResponseEntity.ok(pagare);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listPagares() {
        List<Pagare> pagares = pagareService.listAll();
        return ResponseEntity.ok(pagares);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagare> getObjectById(@PathVariable Long id) {
        Pagare pagare = pagareService.getById(id);
        if (pagare==null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(pagare);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePagare(@PathVariable Long id, @RequestBody Pagare pagare){
        Pagare pagareExist = pagareService.getById(id);
        pagareExist.setNoPagare(pagare.getNoPagare());
        pagareExist.setCapital(pagare.getCapital());
        pagareExist.setInteres(pagare.getInteres());
        pagareExist.setTotal(pagare.getTotal());
        pagareExist.setVencimiento(pagare.getVencimiento());
        pagareService.update(pagareExist);
        return  ResponseEntity.ok(pagareExist);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletepagare(@PathVariable Long id){
        Pagare pagare = pagareService.getById(id);
        pagareService.delete(pagare);
        return ResponseEntity.ok("Pagare Eliminado");
    }
}
