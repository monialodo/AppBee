package com.feeltech.appbee.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
