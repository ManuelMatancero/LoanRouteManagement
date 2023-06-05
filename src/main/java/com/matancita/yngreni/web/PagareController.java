package com.matancita.yngreni.web;

import com.matancita.yngreni.DTO.Messages;
import com.matancita.yngreni.domain.Pagare;
import com.matancita.yngreni.domain.RecibosGen;
import com.matancita.yngreni.service.PagareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pagare")
public class PagareController {

    @Autowired
    PagareService pagareService;

   // @PostMapping("/save")
   // public ResponseEntity<?> savePagare(@RequestBody List<Pagare> pagare){
    //    pagareService.insertAll(pagare);
     //   return ResponseEntity.ok(pagare);
    //}



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
        if(pagareExist!=null){
            pagareExist.setNoPagare(pagare.getNoPagare());
            pagareExist.setCapital(pagare.getCapital());
            pagareExist.setInteres(pagare.getInteres());
            pagareExist.setTotal(pagare.getTotal());
            pagareExist.setVencimiento(pagare.getVencimiento());
            pagareService.update(pagareExist);
            return  ResponseEntity.ok(pagareExist);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/printpagare/{id}")
    public ResponseEntity<?> printPagare(@PathVariable Long id){
        Pagare pagareToPrint = pagareService.getById(id);
        if(pagareToPrint!=null){
            RecibosGen recibosGen = new RecibosGen();
            recibosGen.setFecha(LocalDateTime.now());
            recibosGen.setValor(pagareToPrint.getTotal());
            pagareToPrint.setReciboGen(recibosGen);
            pagareService.update(pagareToPrint);
            return ResponseEntity.ok(pagareToPrint);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletepagare(@PathVariable Long id){
        Pagare pagare = pagareService.getById(id);
        if(pagare!=null){
            pagareService.delete(pagare);
            return ResponseEntity.ok(new Messages("Pagare eliminado"));
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
