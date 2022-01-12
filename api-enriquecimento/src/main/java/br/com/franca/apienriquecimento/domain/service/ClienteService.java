package br.com.franca.apienriquecimento.domain.service;

import br.com.franca.apienriquecimento.domain.model.Cliente;
import br.com.franca.apienriquecimento.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Long id) {
        return repository.findById(id).get();
    }
}
