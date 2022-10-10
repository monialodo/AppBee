package com.feeltech.appbee.service.interfaces;

import com.feeltech.appbee.model.Colmeia;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ColmeiaServiceInterface {

    List<Colmeia> findAll();

    Colmeia findById(Long id);

    void save(Colmeia colmeia);

    void deleteById(Long id);

    void update(Long id, Colmeia colmeia);

    Colmeia findByNome(String nome);

    List <Colmeia> findByEspecie(String especie);

    Page<Colmeia> findAllPage(Integer page, Integer size, String orderBy, String direction);
}
