package com.feeltech.appbee.controller;

import com.feeltech.appbee.model.Colmeia;
import com.feeltech.appbee.service.ColmeiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colmeia")

public class ColmeiaController {

    @Autowired
    private ColmeiaService colmeiaService;

    @GetMapping
    public ResponseEntity<List<Colmeia>> findAll() {
        return ResponseEntity.ok(colmeiaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Colmeia> findById(@PathVariable Long id) {
        Colmeia colmeia = colmeiaService.findById(id);
        return ResponseEntity.ok().body(colmeia);
    }

    @GetMapping("/nome")
    public ResponseEntity<Colmeia> findByNome(@RequestParam String nome) {
        return ResponseEntity.ok(colmeiaService.findByNome(nome));
    }

    @GetMapping("/especie")
    public ResponseEntity<List<Colmeia>> findByEspecie(@RequestParam String especie) {
        return ResponseEntity.ok(colmeiaService.findByEspecie(especie));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Colmeia>> findAllPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "20") Integer size,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Colmeia> list = colmeiaService.findAllPage(page, size, orderBy, direction);

        return ResponseEntity.ok().body(list);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Colmeia> save(@RequestBody Colmeia colmeia) {
        colmeiaService.save(colmeia);
        return ResponseEntity.ok(colmeia);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Colmeia> update(@PathVariable Long id, @RequestBody Colmeia colmeia) {
        colmeiaService.update(id, colmeia);
        return ResponseEntity.ok(colmeia);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        colmeiaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}


