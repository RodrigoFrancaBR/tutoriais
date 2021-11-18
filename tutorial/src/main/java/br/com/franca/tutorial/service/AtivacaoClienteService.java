package br.com.franca.tutorial.service;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.notificacao.Notificador;
import br.com.franca.tutorial.notificacao.NotificadorEmail;
import br.com.franca.tutorial.notificacao.NotificadorSMS;
import org.springframework.util.ObjectUtils;


public class AtivacaoClienteService {

    private Notificador notificador;

    public AtivacaoClienteService(Notificador notificador){
        this.notificador = notificador;
    }

    public String ativar(Cliente cliente) {

        String mensagem = "Cadastro ativo com sucesso!!";

        if (ObjectUtils.isEmpty(cliente) || cliente.isAtivo()){
            throw new IllegalArgumentException("Cliente deve ser válido");
        }

        cliente.setAtivo(true);
        return this.notificador.notificar(cliente, mensagem);
    }
}
