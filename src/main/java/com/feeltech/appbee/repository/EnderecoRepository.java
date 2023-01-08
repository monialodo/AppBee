package com.feeltech.appbee.repository;

import com.feeltech.appbee.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Optional<Endereco> findByCepAndNumero(String cep, String numero);
}
