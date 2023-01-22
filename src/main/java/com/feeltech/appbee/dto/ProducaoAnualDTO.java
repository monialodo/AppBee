package com.feeltech.appbee.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProducaoAnualDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Double producaoCera;
    private Double producaoMel;
    private Double producaoPropolis;

    public ProducaoAnualDTO() {
    }

public ProducaoAnualDTO( Double producaoMel, Double producaoCera, Double producaoPropolis) {
        this.producaoMel = producaoMel;
        this.producaoCera = producaoCera;
        this.producaoPropolis = producaoPropolis;
    }








}
