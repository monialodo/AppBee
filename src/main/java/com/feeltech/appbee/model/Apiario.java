package com.feeltech.appbee.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "apiario")
public class Apiario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String cnpj;


    @ManyToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;


    @OneToMany(mappedBy = "apiario", cascade = CascadeType.ALL)
    private List<Colmeia> colmeias = new ArrayList<>();

    public Apiario(Long id, String nome, String cnpj, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
   }
}
