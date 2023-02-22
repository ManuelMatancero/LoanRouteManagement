package com.matancita.yngreni.web;

import com.matancita.yngreni.domain.Empresa;
import com.matancita.yngreni.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresa")
@Transactional
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping("/save")
    public ResponseEntity<?> saveEmpresa(@RequestBody Empresa empresa){
        empresaService.insert(empresa);
        return ResponseEntity.ok(empresa);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listEmpresas() {
        List<Empresa> empresas = empresaService.listAll();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getObjectById(@PathVariable Long id) {
        Empresa empresa = empresaService.getById(id);
        if (empresa==null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(empresa);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmpresa(@PathVariable Long id, @RequestBody Empresa empresa){
        Empresa empresaExist = empresaService.getById(id);
        empresaExist.setNombre(empresa.getNombre());
        empresaExist.setDireccion(empresa.getDireccion());
        empresaExist.setTelefono(empresa.getTelefono());
        empresaExist.setEmail(empresa.getEmail());
        empresaService.update(empresaExist);
        return  ResponseEntity.ok(empresaExist);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteempresa(@PathVariable Long id){
        Empresa empresa = empresaService.getById(id);
        empresaService.delete(empresa);
        return ResponseEntity.ok("Empresa Eliminado");
    }
}
