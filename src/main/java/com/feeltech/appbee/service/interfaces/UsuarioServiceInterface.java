package com.feeltech.appbee.service.interfaces;

import com.feeltech.appbee.dto.CredenciaisDTO;
import com.feeltech.appbee.dto.UsuarioDto;
import com.feeltech.appbee.model.Usuario;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UsuarioServiceInterface {

    List<Usuario> findAll();

    Usuario findById(Long id);

    void save(Usuario usuario) throws Exception;

    void deleteById(Long id);

    void update(Long id, Usuario usuario);

    Usuario findByNome(String nome);

    Usuario findByEmail(String email);

    Usuario findByPerfis(String perfis);

    UsuarioDto createPassword(CredenciaisDTO credenciaisDTO) throws Exception;

    Usuario login(Usuario usuario);

    UsuarioDto forgot(Usuario usuario) throws Exception;

    Page<Usuario> findAllPage(Integer page, Integer size, String orderBy, String direction);
}
