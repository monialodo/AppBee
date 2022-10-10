package com.feeltech.appbee.repository;

import com.feeltech.appbee.model.Colmeia;
import com.feeltech.appbee.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColmeiaRepository extends JpaRepository<Colmeia, Long> {

    Colmeia findByNome(String nome);

    List<Colmeia> findByEspecie(String especie);
}
