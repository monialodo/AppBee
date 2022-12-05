package com.feeltech.appbee.service.interfaces;

import com.feeltech.appbee.dto.ProducaoAnualDTO;
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

    Double findByProducaoMel(String ano);

    Double findByProducaoCera(String ano);

    Double findByProducaoPollen(String ano);

    Double findByProducaoPropolis(String ano);

    Double findByProducaoGeleiaReal(String ano);

    ProducaoAnualDTO findByAno(String ano);


    Page<ProducaoAnual> findAllPage(Integer page, Integer size, String orderBy, String direction);
}