package com.feeltech.appbee.controller;

import com.feeltech.appbee.model.Apiario;
import com.feeltech.appbee.service.ApiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiario")
public class ApiarioController {

    @Autowired
    private ApiarioService apiarioService;

    @GetMapping
    public ResponseEntity<List<Apiario>> findAll() {
        return ResponseEntity.ok(apiarioService.findAll());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Apiario> findById(@PathVariable Long id) {
        Apiario apiario = apiarioService.findById(id);
        return ResponseEntity.ok().body(apiario);
    }

    @GetMapping("/nome")
    public ResponseEntity<Apiario> findByNome(@RequestParam String nome) {
        return ResponseEntity.ok(apiarioService.findByNome(nome));
    }

    @GetMapping("/endereco")
    public ResponseEntity<List<Apiario>> findByEndereco(@RequestParam String endereco) {
        return ResponseEntity.ok(apiarioService.findByEndereco(endereco));
    }

    @GetMapping("/colmeia")
    public ResponseEntity<List<Apiario>> findByColmeias(@RequestParam String colmeia) {
        return ResponseEntity.ok(apiarioService.findByColmeias(colmeia));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Apiario>> findAllPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "20") Integer size,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Apiario> list = apiarioService.findAllPage(page, size, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Apiario> save(@RequestBody Apiario apiario) {
        apiarioService.save(apiario);
        return ResponseEntity.ok(apiario);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Apiario> update(@PathVariable Long id, @RequestBody Apiario apiario) {
        apiarioService.update(id, apiario);
        return ResponseEntity.ok(apiario);
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        apiarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
