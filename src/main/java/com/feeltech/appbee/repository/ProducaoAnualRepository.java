package com.feeltech.appbee.repository;

import com.feeltech.appbee.model.Colmeia;
import com.feeltech.appbee.model.Endereco;
import com.feeltech.appbee.model.ProducaoAnual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducaoAnualRepository extends JpaRepository<ProducaoAnual, Long> {

    ProducaoAnual findByColmeia(Colmeia colmeia);

    ProducaoAnual findByProducaoMel(Double producaoMel);

    ProducaoAnual findByProducaoCera(Double producaoCera);

    ProducaoAnual findByProducaoPollen(Double producaoPollen);

    ProducaoAnual findByProducaoGeleiaReal(Double producaoGeleiaReal);

    ProducaoAnual findByProducaoPropolis(Double producaoPropolis);

    ProducaoAnual findByAno(String ano);
}
