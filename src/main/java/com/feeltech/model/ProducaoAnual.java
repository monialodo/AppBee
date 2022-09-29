package com.feeltech.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class ProducaoAnual implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String ano;

    private Double producaoEmLitros;

    private String coloracao;

    private String viscosidade;



}
