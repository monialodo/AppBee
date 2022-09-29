package com.feeltech.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Colmeia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private String especie;

    private String florada;

    @OneToOne
    private ProducaoAnual producaoAnual;

    @ManyToOne
    @JoinColumn(name = "apiario_id")
    private Apiario apiario;

}
