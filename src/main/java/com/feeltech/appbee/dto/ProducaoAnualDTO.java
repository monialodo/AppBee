package com.feeltech.appbee.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProducaoAnualDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double producaoCera;
    private Double producaoGeleiaReal;
    private Double producaoMel;
    private Double producaoPollen;
    private Double producaoPropolis;

    public ProducaoAnualDTO() {
    }

public ProducaoAnualDTO( Double producaoMel, Double producaoCera, Double producaoPollen,Double producaoGeleiaReal, Double producaoPropolis) {
        this.producaoMel = producaoMel;
        this.producaoCera = producaoCera;
        this.producaoPollen = producaoPollen;
        this.producaoGeleiaReal = producaoGeleiaReal;
        this.producaoPropolis = producaoPropolis;
    }








}
