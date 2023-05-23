package com.matancita.yngreni.web;

import com.matancita.yngreni.domain.Cliente;
import com.matancita.yngreni.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {


    @Autowired
    ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCliente(@RequestBody Cliente cliente){
        clienteService.insert(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listClientes() {
        List<Cliente> clientes = clienteService.listAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getObjectById(@PathVariable Long id) {
        Cliente cliente = clienteService.getById(id);
        if (cliente==null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(cliente);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        Cliente clienteExist = clienteService.getById(id);
        clienteExist.setNombre(cliente.getNombre());
        clienteExist.setApellido(cliente.getApellido());
        clienteExist.setCedula(cliente.getCedula());
        clienteExist.setDireccion(cliente.getDireccion());
        clienteExist.setFechaNacimiento(cliente.getFechaNacimiento());
        clienteExist.setLugarTrabajo(cliente.getLugarTrabajo());
        clienteExist.setTelTrabajo(cliente.getTelTrabajo());
        clienteExist.setCelular(cliente.getCelular());
        clienteExist.setTelResidencia(cliente.getTelResidencia());
        clienteExist.setEmail(cliente.getEmail());
        clienteExist.setOcupacion(cliente.getOcupacion());
        clienteExist.setRecomendado(cliente.getRecomendado());
        clienteExist.setObservaciones(cliente.getObservaciones());
        clienteExist.setFechaIngreso(cliente.getFechaIngreso());
        clienteExist.setEstatus(cliente.getEstatus());
        clienteService.update(clienteExist);
        return  ResponseEntity.ok(clienteExist);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletecliente(@PathVariable Long id){
        Cliente cliente = clienteService.getById(id);
        clienteService.delete(cliente);
        return ResponseEntity.ok("Cliente Eliminado");
    }
}
