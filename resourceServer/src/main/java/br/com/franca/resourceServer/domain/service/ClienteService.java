package br.com.franca.resourceServer.domain.service;

import br.com.franca.resourceServer.domain.model.Cliente;
import br.com.franca.resourceServer.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository repository;

    public List<Cliente> obter(){
        return repository.findAll();
    }

    public Optional<Cliente> obter(Long id){
        return repository.findById(id);
    }

    public Cliente salvar(Cliente cliente){
        return repository.save(cliente);
    }

    public void remover(Long id){
        repository.deleteById(id);
    }
}
