package br.com.franca.tutorial.service;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.notificacao.NotificadorEmail;
import br.com.franca.tutorial.notificacao.NotificadorSMS;
import org.springframework.util.ObjectUtils;


public class AtivacaoClienteService {

    private NotificadorSMS notificadorSMS;
    private NotificadorEmail notificadorEmail;

    public AtivacaoClienteService(NotificadorSMS notificadorSMS) {
        this.notificadorSMS = notificadorSMS;
    }

    public AtivacaoClienteService(NotificadorEmail notificadorEmail) {
        this.notificadorEmail = notificadorEmail;
    }

    public String  ativar(Cliente cliente) {

        String mensagem = "Cadastro ativo com sucesso!!";

        if (ObjectUtils.isEmpty(cliente) || cliente.isAtivo()){
            throw new IllegalArgumentException("Cliente deve ser válido");
        }

        cliente.setAtivo(true);
        return this.notificadorSMS.notificar(cliente, mensagem);
    }
}
