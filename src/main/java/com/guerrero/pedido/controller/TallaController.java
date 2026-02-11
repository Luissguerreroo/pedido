package com.guerrero.pedido.controller;

import com.guerrero.pedido.entity.Talla;
import com.guerrero.pedido.service.TallaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tallas") // localhost:8081/api/tallas
public class TallaController {

    @Autowired
    private TallaService service;

    // LISTAR TODOS
    @GetMapping
    public List<Talla> getAll() {
        return service.listar();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Talla> getById(@PathVariable Integer id) {
        Talla talla = service.buscarPorId(id);
        if (talla == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(talla);
    }

    // CREAR
    @PostMapping
    public ResponseEntity<Talla> create(@RequestBody Talla talla) {
        Talla creada = service.guardar(talla);
        return ResponseEntity.status(201).body(creada);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Talla> update(
            @PathVariable Integer id,
            @RequestBody Talla talla
    ) {
        Talla actualizada = service.actualizar(id, talla);
        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
