package com.feeltech.appbee.service.interfaces;

import com.feeltech.appbee.model.Apiario;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ApiarioServiceInterface {

    List<Apiario> findAll();

    Apiario findById(Long id);

    Page<Apiario> findAllPage(Integer page, Integer size, String orderBy, String direction);

    void save(Apiario apiario);

    void deleteById(Long id);


    void update(Long id, Apiario apiario);

    Apiario findByNome(String nome);

     List <Apiario> findByEndereco (String cep);

    List<Apiario> findByColmeias(String colmeias);

}
