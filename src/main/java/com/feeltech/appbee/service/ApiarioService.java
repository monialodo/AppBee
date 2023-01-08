package com.feeltech.appbee.service;

import com.feeltech.appbee.model.Apiario;
import com.feeltech.appbee.model.Endereco;
import com.feeltech.appbee.repository.EnderecoRepository;
import com.feeltech.appbee.exceptionHander.NotFoundException;
import com.feeltech.appbee.service.interfaces.ApiarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.feeltech.appbee.repository.ApiarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApiarioService implements ApiarioServiceInterface {

    @Autowired
    private ApiarioRepository apiarioRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private EnderecoRepository enderecoRepository;


    @Override
    public List<Apiario> findAll() {
        return apiarioRepository.findAll();
    }

    @Override
    public Apiario findById(Long id) {
        Optional<Apiario> apiario = apiarioRepository.findById(id);

        return apiario.orElseThrow(() -> new NotFoundException(
                "Apiário não encontrado! Id: " + id + ", Tipo: " + Apiario.class.getName()));
    }

    @Override
    public Apiario findByNome(String nome) {
        Optional<Apiario> apiario = Optional.ofNullable(apiarioRepository.findByNome(nome));
        return apiario.orElseThrow(() -> new NotFoundException(
                "Apiário não encontrado! Nome: " + nome + ", Tipo: " + Apiario.class.getName()));

    }

    @Override
    public List<Apiario> findByEndereco(String cep) {
        Optional<Apiario> apiario = apiarioRepository.findByEndereco(cep);
        return (List<Apiario>) apiario.orElseThrow(() -> new NotFoundException(
                "Apiário não encontrado! Cep: " + cep + ", Tipo: " + Apiario.class.getName()));

    }

    @Override
    public List<Apiario> findByColmeias(String colmeias) {
        Optional<Apiario> apiario = apiarioRepository.findByColmeias(colmeias);
        return (List<Apiario>) apiario.orElseThrow(() -> new NotFoundException(
                "Apiário não encontrado! Colmeias: " + colmeias + ", Tipo: " + Apiario.class.getName()));
    }

    @Override
    public Page<Apiario> findAllPage(Integer page, Integer size, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        return apiarioRepository.findAll(pageRequest);
    }

    @Override
    public void save(Apiario apiario) {

        String cep = apiario.getEndereco().getCep();
        String numero = apiario.getEndereco().getNumero();
        Endereco endereco = enderecoRepository.findByCepAndNumero(cep, numero).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.findByCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        apiario.setEndereco(endereco);

        Apiario newApiario = apiarioRepository.findByNome(apiario.getNome());
        if(newApiario == null) {
            newApiario = new Apiario();
        }
        newApiario.setNome(apiario.getNome());
        newApiario.setEndereco(apiario.getEndereco());
        newApiario.setColmeias(apiario.getColmeias());

        apiarioRepository.save(newApiario);
    }

    @Override
    public void deleteById(Long id) {
        Apiario apiario = findById(id);
        if (apiario == null) {
            throw new NotFoundException("Apiário não encontrado! Id: " + id + ", Tipo: " + Apiario.class.getName());
        }
        apiarioRepository.deleteById(id);
    }


    @Override
    public void update(Long id, Apiario apiario) {
        Optional<Apiario> novoApiario = apiarioRepository.findById(id);
        if (novoApiario.isPresent()) {
            novoApiario.get().setNome(apiario.getNome());
            novoApiario.get().setEndereco(apiario.getEndereco());
            String cep = novoApiario.get().getEndereco().getCep();
            String numero = novoApiario.get().getEndereco().getNumero();
            Endereco endereco = enderecoRepository.findByCepAndNumero(cep, numero).orElseGet(() -> {
                Endereco novoEndereco = viaCepService.findByCep(cep);
                enderecoRepository.save(novoEndereco);
                return novoEndereco;
            });
            novoApiario.get().setEndereco(endereco);
            apiarioRepository.save(novoApiario.get());
        }
    }



}
