package com.feeltech.appbee.service;

import com.feeltech.appbee.model.Colmeia;
import com.feeltech.appbee.model.ProducaoAnual;
import com.feeltech.appbee.repository.ProducaoAnualRepository;
import com.feeltech.appbee.service.exception.NotFoundException;
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
    public ProducaoAnual findByProducaoMel(Double producaoMel) {
        ProducaoAnual producaoAnualMel = producaoAnualRepository.findByProducaoMel(producaoMel);
        if (producaoAnualMel == null) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + producaoMel + ", Tipo: " + ProducaoAnual.class.getName());
        }
        return producaoAnualMel;
    }

    @Override
    public ProducaoAnual findByProducaoCera(Double producaoCera) {
        ProducaoAnual producaoAnualCera = producaoAnualRepository.findByProducaoCera(producaoCera);
        if (producaoAnualCera == null) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + producaoCera + ", Tipo: " + ProducaoAnual.class.getName());
        }
        return producaoAnualCera;
    }

    @Override
    public ProducaoAnual findByProducaoPollen(Double producaoPollen) {
        ProducaoAnual producaoAnualPollen = producaoAnualRepository.findByProducaoPollen(producaoPollen);
        if (producaoAnualPollen == null) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + producaoPollen + ", Tipo: " + ProducaoAnual.class.getName());
        }
        return producaoAnualPollen;
    }

    @Override
    public ProducaoAnual findByProducaoPropolis(Double producaoPropolis) {
        ProducaoAnual producaoAnualPropolis = producaoAnualRepository.findByProducaoPropolis(producaoPropolis);
        if (producaoAnualPropolis == null) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + producaoPropolis + ", Tipo: " + ProducaoAnual.class.getName());
        }
        return producaoAnualPropolis;
    }

    @Override
    public ProducaoAnual findByProducaoGeleiaReal(Double producaoGeleiaReal) {
        ProducaoAnual producaoAnualGeleiaReal = producaoAnualRepository.findByProducaoGeleiaReal(producaoGeleiaReal);
        if (producaoAnualGeleiaReal == null) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + producaoGeleiaReal + ", Tipo: " + ProducaoAnual.class.getName());
        }
        return producaoAnualGeleiaReal;
    }

    @Override
    public ProducaoAnual findByAno(String ano) {
        ProducaoAnual producaoAnualAno = producaoAnualRepository.findByAno(ano);
        if (producaoAnualAno == null) {
            throw new NotFoundException("Produção anual não encontrada! Id: " + ano + ", Tipo: " + ProducaoAnual.class.getName());
        }
        return producaoAnualAno;
    }

    @Override
    public Page<ProducaoAnual> findAllPage(Integer page, Integer size, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        return producaoAnualRepository.findAll(pageRequest);
    }
}
