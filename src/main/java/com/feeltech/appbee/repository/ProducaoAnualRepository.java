package com.feeltech.appbee.repository;

import com.feeltech.appbee.dto.ProducaoAnualDTO;
import com.feeltech.appbee.model.Colmeia;
import com.feeltech.appbee.model.ProducaoAnual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;

public interface ProducaoAnualRepository extends JpaRepository<ProducaoAnual, Long> {

    ProducaoAnual findByColmeia(Colmeia colmeia);

    @Query("SELECT SUM(p.producaoMel) FROM ProducaoAnual p where p.ano = :ano")
    Double findByProducaoMel(String ano);

    @Query("SELECT SUM(p.producaoCera) FROM ProducaoAnual p where p.ano = :ano")
    Double findByProducaoCera(String ano);

    @Query("SELECT SUM(p.producaoPropolis) FROM ProducaoAnual p where p.ano = :ano")
    Double findByProducaoPropolis(String ano);

//    @Query("SELECT SUM(p.producaoMel), SUM(p.producaoCera), SUM(p.producaoPollen), SUM(p.producaoGeleiaReal), SUM(p.producaoPropolis) FROM ProducaoAnual p where p.ano = :ano")
//    EntityManager findByAno(String ano);

    @Query("SELECT new com.feeltech.appbee.dto.ProducaoAnualDTO(SUM(p.producaoMel), SUM(p.producaoCera), SUM(p.producaoPropolis)) FROM ProducaoAnual p where p.ano = :ano")
    ProducaoAnualDTO findByAno(String ano);


}
