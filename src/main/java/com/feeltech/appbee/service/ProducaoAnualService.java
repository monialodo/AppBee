package com.feeltech.appbee.service;

import com.feeltech.appbee.dto.ProducaoAnualDTO;
import com.feeltech.appbee.model.Colmeia;
import com.feeltech.appbee.model.ProducaoAnual;
import com.feeltech.appbee.repository.ProducaoAnualRepository;
import com.feeltech.appbee.exceptionHander.NotFoundException;
import com.feeltech.appbee.service.interfaces.ProducaoAnualServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProducaoAnualService implements ProducaoAnualServiceInterface {

    @Autowired
    private ProducaoAnualRepository producaoAnualRepository;

    @Override
    public List<ProducaoAnual> findAll() {
        return producaoAnualRepository.findAll();
    }

    @Override
    public ProducaoAnual findById(Long id) {
        Optional <ProducaoAnual> producaoAnual = producaoAnualRepository.findById(id);
        return producaoAnual.orElseThrow(() -> new NotFoundException(
                "Produção anual não encontrada! Id: " + id + ", Tipo: " + ProducaoAnual.class.getName()));
    }

    @Override
    public void save(ProducaoAnual producaoAnual) {
        producaoAnualRepository.save(producaoAnual);
    }

    @Override
    public void deleteById(Long id) {
        ProducaoAnual producaoAnual = findById(id);
        if (producaoAnual == null) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + id + ", Tipo: " + ProducaoAnual.class.getName());
        }
        producaoAnualRepository.deleteById(id);
    }

    @Override
    public void update(Long id, ProducaoAnual producaoAnual) {
        Optional<ProducaoAnual> newProducaoAnual = producaoAnualRepository.findById(producaoAnual.getId());
        if (!newProducaoAnual.isPresent()) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + id + ", Tipo: " + ProducaoAnual.class.getName());
        }
            producaoAnualRepository.save(producaoAnual);
    }

    @Override
    public ProducaoAnual findByColmeia(Colmeia colmeia) {
        ProducaoAnual producaoAnualColmeia = producaoAnualRepository.findByColmeia(colmeia);
        if (producaoAnualColmeia == null) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + colmeia.getId() + ", Tipo: " + ProducaoAnual.class.getName());
        }
        return producaoAnualColmeia;
    }

    @Override
    public Double findByProducaoMel(String ano) {
        Double totalProduzido = producaoAnualRepository.findByProducaoMel(ano);
        System.out.println("Producao anual mel: " + totalProduzido);

        if (totalProduzido == null) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + ano + ", Tipo: " + ProducaoAnual.class.getName());
        }
        return totalProduzido;
    }

    @Override
    public Double findByProducaoCera(String ano) {
        Double producaoAnualCera = producaoAnualRepository.findByProducaoCera(ano);
        if (producaoAnualCera == null) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + ano + ", Tipo: " + ProducaoAnual.class.getName());
        }
        return producaoAnualCera;
    }

    @Override
    public Double findByProducaoPollen(String ano) {
        Double producaoAnualPollen = producaoAnualRepository.findByProducaoPollen(ano);
        if (producaoAnualPollen == null) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + ano + ", Tipo: " + ProducaoAnual.class.getName());
        }
        return producaoAnualPollen;
    }

    @Override
    public Double findByProducaoPropolis(String ano) {
        Double producaoAnualPropolis = producaoAnualRepository.findByProducaoPropolis(ano);
        if (producaoAnualPropolis == null) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + ano + ", Tipo: " + ProducaoAnual.class.getName());
        }
        return producaoAnualPropolis;
    }

    @Override
    public Double findByProducaoGeleiaReal(String ano) {
        Double producaoAnualGeleiaReal = producaoAnualRepository.findByProducaoGeleiaReal(ano);
        if (producaoAnualGeleiaReal == null) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + ano + ", Tipo: " + ProducaoAnual.class.getName());
        }
        return producaoAnualGeleiaReal;
    }

    @Override
    public ProducaoAnualDTO findByAno(String ano) {
        ProducaoAnualDTO producaoAnualAno = producaoAnualRepository.findByAno(ano);
        if (producaoAnualAno == null) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + ano + ", Tipo: " + ProducaoAnual.class.getName());
        }
        return producaoAnualAno;



//        EntityManager em = producaoAnualRepository.findByAno(ano);
//        final Query sumQuery = em.createQuery("SELECT SUM(p.producaoMel) FROM ProducaoAnual p where p.ano = :ano");
//
//        sumQuery.setParameter("ano", ano);
//        final List result = sumQuery.getResultList();
//        System.out.println("Resultado: " + result);
//
//        return result;


    }

    @Override
    public Page<ProducaoAnual> findAllPage(Integer page, Integer size, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        return producaoAnualRepository.findAll(pageRequest);
    }
}
