package br.com.franca.tutorial.notificacao;

import br.com.franca.tutorial.domain.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class NotificadorEmail implements Notificador{

    public NotificadorEmail(){
        System.out.println("Instanciando um Notificador de EMAIL através do @Component");
    }

    public String notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando o cliente: %s através do e-mail:  %s a seguinte mensagem: %s", cliente.getNome(), cliente.getEmail(), mensagem);
        return "EMAIL";
    }
}
