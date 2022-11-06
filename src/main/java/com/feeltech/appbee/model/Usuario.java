package com.feeltech.appbee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.feeltech.appbee.model.enums.Perfil;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "email")
    private String email;

    @Column (name = "senha")
    private String senha;

    @Column (name = "cpf")
    private String cpf;

    @Column (name = "telefone")
    private String telefone;

    @Column (name = "cargo")
    private String cargo;

    @ManyToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="PERFIS")
    private Set<Integer> perfis = new HashSet<>();

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        perfis.add(perfil.getCod());
    }

}
