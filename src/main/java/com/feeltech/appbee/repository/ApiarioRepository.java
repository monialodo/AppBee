package com.feeltech.appbee.repository;

import com.feeltech.appbee.model.Apiario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiarioRepository extends JpaRepository<Apiario, Long> {

    Apiario findByNome(String nome);

    Optional<Apiario> findByEndereco(String cep);

    Optional<Apiario> findByColmeias(String colmeia);
}
