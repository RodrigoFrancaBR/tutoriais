package br.com.franca.tutorial.notificacao;

import br.com.franca.tutorial.domain.model.Cliente;

public interface Notificador {
    String notificar(Cliente cliente, String mensagem);
}
