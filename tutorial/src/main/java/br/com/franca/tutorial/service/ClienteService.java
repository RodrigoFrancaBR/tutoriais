package br.com.franca.tutorial.service;

import br.com.franca.tutorial.domain.model.Cliente;

public class ClienteService {
    public void ativar(Cliente cliente) {
        if (cliente.isAtivo()){
            throw new IllegalArgumentException("Não é possível ativar um cliente ativo!!");
        }
        cliente.setAtivo(true);
    }
}
