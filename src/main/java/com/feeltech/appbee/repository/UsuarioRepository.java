package com.feeltech.appbee.repository;

import com.feeltech.appbee.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNome(String nome);

    Usuario findByEmail(String email);

    Optional<Usuario> findByPerfis(String perfis);

    Usuario findByEmailAndSenha(String email, String senha);
}
