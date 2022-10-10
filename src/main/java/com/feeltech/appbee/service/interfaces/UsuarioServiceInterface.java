package com.feeltech.appbee.service.interfaces;

import com.feeltech.appbee.model.Usuario;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UsuarioServiceInterface {

    List<Usuario> findAll();

    Usuario findById(Long id);

    void save(Usuario usuario);

    void createPassword(Usuario usuario);

    void deleteById(Long id);

    void update(Long id, Usuario usuario);

    Usuario findByNome(String nome);

    Usuario findByEmail(String email);

    Usuario findByPerfis(String perfis);


    Usuario login(Usuario usuario);

    Usuario forgot(Usuario usuario);

    Page<Usuario> findAllPage(Integer page, Integer size, String orderBy, String direction);
}
