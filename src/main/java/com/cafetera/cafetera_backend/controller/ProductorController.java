package com.cafetera.cafetera_backend.controller;

import com.cafetera.cafetera_backend.entity.Productor;
import com.cafetera.cafetera_backend.repository.ProductorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productores")
public class ProductorController {

    @Autowired
    private ProductorRepository productorRepository;

    // 📌 1. GET - Listar todos los productores
    @GetMapping
    public List<Productor> listar() {
        return productorRepository.findAll();
    }

    // 📌 2. POST - Crear un nuevo productor
    @PostMapping
    public ResponseEntity<Productor> crear(@Valid @RequestBody Productor productor) {
        Productor nuevo = productorRepository.save(productor);
        return ResponseEntity.ok(nuevo); // 200 OK
    }

    // 📌 3. PUT - Actualizar un productor existente
    @PutMapping("/{id}")
    public ResponseEntity<Productor> actualizar(
            @PathVariable String id,
            @Valid @RequestBody Productor productorDetalles) {

        return productorRepository.findById(id)
                .map(productor -> {
                    productor.setNombre(productorDetalles.getNombre());
                    productor.setCorreo(productorDetalles.getCorreo());
                    productor.setTelefono(productorDetalles.getTelefono());
                    Productor actualizado = productorRepository.save(productor);
                    return ResponseEntity.ok(actualizado); // 200 OK
                })
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    // 📌 4. DELETE - Eliminar un productor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable String id) {
        return productorRepository.findById(id)
                .map(productor -> {
                    productorRepository.delete(productor);
                    return ResponseEntity.noContent().build(); // 204 No Content
                })
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }
}