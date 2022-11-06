package com.feeltech.appbee.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "colmeia")
public class Colmeia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "nome_colmeia")
    private String nome;

    @Column(name = "especie_colmeia")
    private String especie;

    @Column(name = "florada_colmeia")
    private String florada;

    @OneToMany(mappedBy = "colmeia")
    private List<ProducaoAnual> producaoAnual;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private Apiario apiario;


}
