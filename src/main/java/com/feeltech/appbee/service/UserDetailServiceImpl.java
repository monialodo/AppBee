package com.feeltech.appbee.service;

import com.feeltech.appbee.model.Usuario;
import com.feeltech.appbee.repository.UsuarioRepository;
import com.feeltech.appbee.security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new UserSecurity(usuario.getId(), usuario.getEmail(), usuario.getSenha(), usuario.getPerfis());
    }
}

