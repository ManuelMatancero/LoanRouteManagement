package com.matancita.yngreni.web;


import com.matancita.yngreni.domain.Cobrador;
import com.matancita.yngreni.domain.Usuario;
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




}
