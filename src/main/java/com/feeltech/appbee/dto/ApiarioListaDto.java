package com.feeltech.appbee.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ApiarioListaDto implements Serializable {
    private static final long serialVersionUID = 1L;


    private String nomeApiario;
    private String nomeColmeia;
    private String especieColmeia;
    private String floradaColmeia;
    private String estado;

    public ApiarioListaDto() {
    }

    public ApiarioListaDto(String nomeApiario, String nomeColmeia, String especieColmeia, String floradaColmeia, String estado) {
        this.nomeApiario = nomeApiario;
        this.nomeColmeia = nomeColmeia;
        this.especieColmeia = especieColmeia;
        this.floradaColmeia = floradaColmeia;
        this.estado = estado;
    }








}
