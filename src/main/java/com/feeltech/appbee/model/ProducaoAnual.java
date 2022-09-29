package com.feeltech.appbee.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProducaoAnual implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String ano;

    private Double producaoMel;

    private Double producaoCera;

    private Double producaoPollen;

    private Double producaoPropolis;

    private Double producaoGeleiaReal;

}
