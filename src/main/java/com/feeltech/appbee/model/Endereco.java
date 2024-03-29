package com.feeltech.appbee.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column (name = "cep")
    private String cep;

    @Column (name = "logradouro")
    private String logradouro;

    @NotNull
    @Column (name = "numero")
    private String numero;

    @Column (name = "complemento")
    private String complemento;

    @Column (name = "bairro")
    private String bairro;

    @Column (name = "cidade")
    private String localidade;

    @Column (name = "uf")
    private String uf;

    public Endereco(Long endereco_id) {
        this.id = endereco_id;
    }


    public Endereco(Long id, String cep, String numero) {
        this.id = id;
        this.cep = cep;
        this.numero = numero;
    }


}
