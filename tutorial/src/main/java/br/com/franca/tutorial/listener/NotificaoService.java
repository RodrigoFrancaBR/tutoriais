package br.com.franca.tutorial.listener;

import br.com.franca.tutorial.domain.model.Cliente;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificaoService {
    @EventListener
    public void clienteAtivadoListener(Cliente cliente ){
        System.out.println(cliente.toString());
    }
}
