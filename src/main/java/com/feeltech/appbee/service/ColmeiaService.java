package com.feeltech.appbee.service;

import com.feeltech.appbee.model.Colmeia;
import com.feeltech.appbee.repository.ColmeiaRepository;
import com.feeltech.appbee.exceptionHander.NotFoundException;
import com.feeltech.appbee.service.interfaces.ColmeiaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColmeiaService implements ColmeiaServiceInterface {

    @Autowired
    private ColmeiaRepository colmeiaRepository;

    @Override
    public List<Colmeia> findAll() {
        return colmeiaRepository.findAll();
    }

    @Override
    public Colmeia findById(Long id) {
        Optional<Colmeia> colmeia = colmeiaRepository.findById(id);
        return colmeia.orElseThrow(() -> new NotFoundException(
                "Colmeia não encontrada! Id: " + id + ", Tipo: " + Colmeia.class.getName()));
    }

    @Override
    public void save(Colmeia colmeia) {

        Colmeia newColmeia = colmeiaRepository.findByNome(colmeia.getNome());
        if (newColmeia == null) {
            newColmeia = new Colmeia();
        }
        newColmeia.setNome(colmeia.getNome());
        newColmeia.setEspecie(colmeia.getEspecie());
        newColmeia.setFlorada(colmeia.getFlorada());
        newColmeia.setApiario(colmeia.getApiario());

        colmeiaRepository.save(newColmeia);
    }

    @Override
    public void deleteById(Long id) {
        Colmeia colmeia = findById(id);
        if (colmeia == null) {
            throw new NotFoundException("Colmeia não encontrada! Id: " + id + ", Tipo: " + Colmeia.class.getName());
        }
        colmeiaRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Colmeia colmeia) {
        Optional<Colmeia> newColmeia = colmeiaRepository.findById(colmeia.getId());
        if (newColmeia.isPresent()) {
            colmeiaRepository.save(colmeia);
        } else {
            throw new NotFoundException("Colmeia não encontrada! Id: " + id + ", Tipo: " + Colmeia.class.getName());
        }
    }

    @Override
    public Colmeia findByNome(String nome) {
        Colmeia colmeia = colmeiaRepository.findByNome(nome);
        if (colmeia == null) {
            throw new NotFoundException("Colmeia não encontrada! Nome: " + nome + ", Tipo: " + Colmeia.class.getName());
        }
        return colmeia;
    }


    @Override
    public List<Colmeia> findByEspecie(String especie) {
        List<Colmeia> colmeias = colmeiaRepository.findByEspecie(especie);
        if (colmeias == null) {
            throw new NotFoundException("Colmeia não encontrada! Especie: " + especie + ", Tipo: " + Colmeia.class.getName());
        }
        return colmeias;

    }

    @Override
    public Page <Colmeia> findAllPage(Integer page, Integer size, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        return colmeiaRepository.findAll(pageRequest);
    }
}
