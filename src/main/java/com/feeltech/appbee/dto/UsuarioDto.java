package com.feeltech.appbee.dto;

import com.feeltech.appbee.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UsuarioDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    private String cargo;

    public UsuarioDto(Usuario newUsuario) {
        this.nome = newUsuario.getNome();
        this.email = newUsuario.getEmail();
        this.cargo = newUsuario.getCargo();
    }
}
