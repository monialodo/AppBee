package com.feeltech.appbee.service;

import com.feeltech.appbee.model.Endereco;
import com.feeltech.appbee.model.Usuario;
import com.feeltech.appbee.repository.EnderecoRepository;
import com.feeltech.appbee.repository.UsuarioRepository;
import com.feeltech.appbee.service.exception.NotFoundException;
import com.feeltech.appbee.service.interfaces.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UsuarioServiceInterface {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;


    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new NotFoundException(
                "Usuário não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
    }

    @Override
    public void save(Usuario usuario) {
        String cep = usuario.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findByCep(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.findByCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        usuario.setEndereco(endereco);


        Usuario newUsuario = usuarioRepository.findByEmail(usuario.getEmail());
        if(newUsuario == null) {
            newUsuario = new Usuario();
        }
        newUsuario.setNome(usuario.getNome());
        newUsuario.setEmail(usuario.getEmail());
        newUsuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        newUsuario.addPerfil(usuario.getPerfis().iterator().next());

        usuarioRepository.save(usuario);
    }

    @Override
    public void createPassword(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario login(Usuario usuario) {
        return usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
    }

    @Override
    public Usuario forgot(Usuario usuario) {
        return usuarioRepository.findByEmail(usuario.getEmail());
    }

    @Override
    public Page<Usuario> findAllPage(Integer page, Integer size, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        return usuarioRepository.findAll(pageRequest);
    }


    @Override
    public Usuario findByNome(String nome) {
     Optional <Usuario> usuario = usuarioRepository.findByNome(nome);
     return usuario.orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    @Override
    public Usuario findByEmail(String email) {
        Optional <Usuario> usuario = Optional.ofNullable(usuarioRepository.findByEmail(email));
        return usuario.orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    @Override
    public Usuario findByPerfis(String perfis) {
        Optional <Usuario> usuario = usuarioRepository.findByPerfis(perfis);

        return usuario.orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    @Override
    public void deleteById(Long id) {
        Usuario usuario = findById(id);
        if (usuario == null) {
            throw new NotFoundException( "Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Usuario usuario) {
        Usuario updateUser = findById(id);
        if (updateUser == null) {
            throw new NotFoundException( "Usuário não encontrado");
        }
        updateData(updateUser, usuario);
        usuarioRepository.save(updateUser);
    }

    @Transactional
    void updateData (Usuario updateUser, Usuario usuario) {
        if (usuario.getNome() != null) {
            updateUser.setNome(usuario.getNome());
        }
        if (usuario.getEmail() != null) {
            updateUser.setEmail(usuario.getEmail());
        }
        if (usuario.getSenha() != null) {
            updateUser.setSenha(usuario.getSenha());
        }
        if (usuario.getPerfis() != null) {
            updateUser.addPerfil(usuario.getPerfis().iterator().next());
        }

    }
}
