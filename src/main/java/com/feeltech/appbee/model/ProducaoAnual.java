package com.feeltech.appbee.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producao_anual")
public class ProducaoAnual implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column (name = "ano")
    private String ano;

    @Column (name = "producao_mel")
    private Double producaoMel;

    @Column (name = "producao_cera")
    private Double producaoCera;

    @Column (name = "producao_propolis")
    private Double producaoPropolis;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "colmeia_id")
    private Colmeia colmeia;


}
