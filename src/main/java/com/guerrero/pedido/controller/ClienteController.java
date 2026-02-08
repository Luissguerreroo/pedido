package com.guerrero.pedido.controller;

import com.guerrero.pedido.entity.Cliente;
import com.guerrero.pedido.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes") // localhost:8081/api/clientes
public class ClienteController {

    @Autowired
    private ClienteService service;

    // LISTAR TODOS
    @GetMapping
    public List<Cliente> getAll() {
        return service.listar();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
        Cliente cliente = service.buscarPorId(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    // CREAR
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Cliente creado = service.guardar(cliente);
        return ResponseEntity.status(201).body(creado);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(
            @PathVariable Integer id,
            @RequestBody Cliente cliente
    ) {
        Cliente actualizado = service.actualizar(id, cliente);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
