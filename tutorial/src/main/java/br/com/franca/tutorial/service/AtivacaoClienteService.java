package br.com.franca.tutorial.service;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.notificacao.NotificadorSMS;


public class AtivacaoClienteService {

    private NotificadorSMS notificadorSMS;

    public AtivacaoClienteService(NotificadorSMS notificadorSMS) {
        this.notificadorSMS = notificadorSMS;
    }

    public void ativar(Cliente cliente) {
        String mensagem = "Cadastro ativo com sucesso!!";

        if (cliente.isAtivo()){
            throw new IllegalArgumentException("Não é possível ativar um cliente ativo!!");
        }

        cliente.setAtivo(true);
        this.notificadorSMS.notificar(cliente, mensagem);
    }
}
