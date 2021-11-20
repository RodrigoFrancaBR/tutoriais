package br.com.franca.tutorial.service.notificacao;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.domain.model.anotations.PrioridadeDoNotificador;
import br.com.franca.tutorial.domain.model.enums.Prioridade;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@PrioridadeDoNotificador(Prioridade.UM)
@Component
public class NotificadorSMS implements Notificador
 {

    public NotificadorSMS(){
        System.out.println("Instanciando um Notificador de SMS através do @Component");
    }

    @Override
    public String notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando o cliente: %s através do telefone:  %s a seguinte mensagem: %s",
                cliente.getNome(), cliente.getTelefone(), mensagem);
        return "SMS";
    }
}
