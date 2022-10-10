package com.feeltech.appbee.controller;

import com.feeltech.appbee.model.Usuario;
import com.feeltech.appbee.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping("/nome")
    public ResponseEntity<Usuario> findByNome(@RequestParam String nome) {
        return ResponseEntity.ok(usuarioService.findByNome(nome));
    }

    @GetMapping("/email")
    public ResponseEntity<Usuario> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(usuarioService.findByEmail(email));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/perfis")
    public ResponseEntity<Usuario> findByRoles(@RequestParam String perfis) {
        return ResponseEntity.ok(usuarioService.findByPerfis(perfis));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Usuario>> findAllPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "20") Integer size,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page <Usuario> list = usuarioService.findAllPage(page, size, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/create-password")
    public ResponseEntity<Usuario> createPassword(@RequestBody Usuario usuario) {
        usuarioService.createPassword(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.login(usuario));
    }

    @PostMapping("/forgot")
    public ResponseEntity<Usuario> forgot(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.forgot(usuario));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuarioService.update(id, usuario);
        return ResponseEntity.ok(usuario);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }





}
