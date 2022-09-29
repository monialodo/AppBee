package com.feeltech.appbee.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
