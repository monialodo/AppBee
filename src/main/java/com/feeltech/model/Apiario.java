package com.feeltech.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Apiario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name = "cep")
    private Endereco endereco;

    @OneToMany(mappedBy = "apiario")
    private List<Colmeia> colmeias;

}
