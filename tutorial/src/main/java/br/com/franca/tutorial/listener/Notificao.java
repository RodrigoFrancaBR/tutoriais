package br.com.franca.tutorial.listener;

import br.com.franca.tutorial.domain.model.anotations.PrioridadeDoNotificador;
import br.com.franca.tutorial.domain.model.enums.Prioridade;
import br.com.franca.tutorial.event.ClienteAtivadoEvent;
import br.com.franca.tutorial.service.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Notificao {

    @PrioridadeDoNotificador(Prioridade.UM)
    @Autowired
    Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent clienteAtivadoEvent){
        System.out.println("Recebendo um evento de cliente ativado");

        String mensagem = "Seu cadastro no sistema está ativo!!";
        notificador.notificar(clienteAtivadoEvent.getCliente(), mensagem);
    }
}
