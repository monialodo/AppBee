package com.feeltech.appbee.dto;

import lombok.*;

import java.io.Serializable;

@Data
public class CredenciaisDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String senha;
    private String token;

    public CredenciaisDTO() {
    }



}
