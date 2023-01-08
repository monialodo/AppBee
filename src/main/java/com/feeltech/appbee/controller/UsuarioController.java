package com.feeltech.appbee.controller;

import javax.validation.Valid;

import com.feeltech.appbee.dto.CredenciaisDTO;
import com.feeltech.appbee.dto.UsuarioDto;
import com.feeltech.appbee.model.Usuario;
import com.feeltech.appbee.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping(value = "/listar-funcionarios")
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping ("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/nome")
    public ResponseEntity<Usuario> findByNome(@RequestBody String nome) {
        return ResponseEntity.ok(usuarioService.findByNome(nome));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/email")
    public ResponseEntity<Usuario> findByEmail(@RequestBody String email) {
        return ResponseEntity.ok(usuarioService.findByEmail(email));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/perfis")
    public ResponseEntity<Usuario> findByRoles(@RequestBody String perfis) {
        return ResponseEntity.ok(usuarioService.findByPerfis(perfis));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/page")
    public ResponseEntity<Page<Usuario>> findAllPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "20") Integer size,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page <Usuario> list = usuarioService.findAllPage(page, size, orderBy, direction);
        return ResponseEntity.ok().body(list);
    }



    @PostMapping("/create-user")
    public ResponseEntity<HttpStatus> save(@Valid @RequestBody Usuario usuario) throws Exception {
        usuarioService.save(usuario);
        return ResponseEntity.ok().body(HttpStatus.CREATED);
    }

    @PostMapping("/create-password")
    public ResponseEntity<UsuarioDto> createPassword(@RequestBody CredenciaisDTO credenciaisDTO) throws Exception {
        usuarioService.createPassword(credenciaisDTO);
        return ResponseEntity.ok(usuarioService.createPassword(credenciaisDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.login(usuario));
    }

    @PostMapping("/forgot")
    public ResponseEntity<UsuarioDto> forgot(@RequestBody Usuario usuario) throws Exception {
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
