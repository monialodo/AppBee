package com.feeltech.appbee.service.interfaces;

import com.feeltech.appbee.model.Colmeia;
import com.feeltech.appbee.model.ProducaoAnual;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProducaoAnualServiceInterface {

    List<ProducaoAnual> findAll();

    ProducaoAnual findById(Long id);

    void save(ProducaoAnual producaoAnual);

    void deleteById(Long id);

    void update(Long id, ProducaoAnual producaoAnual);

    ProducaoAnual findByColmeia(Colmeia colmeia);

    ProducaoAnual findByProducaoMel(Double producaoMel);

    ProducaoAnual findByProducaoCera(Double producaoCera);

    ProducaoAnual findByProducaoPollen(Double producaoPollen);

    ProducaoAnual findByProducaoPropolis(Double producaoPropolis);

    ProducaoAnual findByProducaoGeleiaReal(Double producaoGeleiaReal);

    ProducaoAnual findByAno(String ano);


    Page<ProducaoAnual> findAllPage(Integer page, Integer size, String orderBy, String direction);
}