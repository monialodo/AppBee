package com.feeltech.appbee.controller;

import com.feeltech.appbee.model.ProducaoAnual;
import com.feeltech.appbee.service.ProducaoAnualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producaoAnual")

public class ProducaoAnualController {

    @Autowired
    private ProducaoAnualService producaoAnualService;

    @GetMapping
    public ResponseEntity<List<ProducaoAnual>> findAll() {
        return ResponseEntity.ok(producaoAnualService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProducaoAnual> findById(@PathVariable Long id) {
        ProducaoAnual producaoAnual = producaoAnualService.findById(id);
        return ResponseEntity.ok().body(producaoAnual);
    }

    @GetMapping("/ano")
    public ResponseEntity<ProducaoAnual> findByAno(@RequestParam String ano) {
        return ResponseEntity.ok(producaoAnualService.findByAno(ano));
    }

    @GetMapping("/mel")
    public ResponseEntity<ProducaoAnual> findByProducaoMel(@RequestParam Double producaoMel) {
        return ResponseEntity.ok(producaoAnualService.findByProducaoMel(producaoMel));
    }

    @GetMapping("/polen")
    public ResponseEntity<ProducaoAnual> findByProducaoPolen(@RequestParam Double producaoPolen) {
        return ResponseEntity.ok(producaoAnualService.findByProducaoPollen(producaoPolen));
    }

    @GetMapping("/cera")
    public ResponseEntity<ProducaoAnual> findByProducaoCera(@RequestParam Double producaoCera) {
        return ResponseEntity.ok(producaoAnualService.findByProducaoCera(producaoCera));
    }

    @GetMapping("/propolis")
    public ResponseEntity<ProducaoAnual> findByProducaoPropolis(@RequestParam Double producaoPropolis) {
        return ResponseEntity.ok(producaoAnualService.findByProducaoPropolis(producaoPropolis));
    }

    @GetMapping("/geleia")
    public ResponseEntity<ProducaoAnual> findByProducaoGeleiaReal(@RequestParam Double producaoGeleiaReal) {
        return ResponseEntity.ok(producaoAnualService.findByProducaoGeleiaReal(producaoGeleiaReal));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ProducaoAnual>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "20") Integer size,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<ProducaoAnual> list = producaoAnualService.findAllPage(page, size, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<ProducaoAnual> save(@RequestBody ProducaoAnual producaoAnual) {
        producaoAnualService.save(producaoAnual);
        return ResponseEntity.ok(producaoAnual);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ProducaoAnual> update(@PathVariable Long id, @RequestBody ProducaoAnual producaoAnual) {
        producaoAnualService.update(id, producaoAnual);
        return ResponseEntity.ok(producaoAnual);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        producaoAnualService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}


