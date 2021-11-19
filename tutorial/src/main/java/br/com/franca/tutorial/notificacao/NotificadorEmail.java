package br.com.franca.tutorial.notificacao;

import br.com.franca.tutorial.domain.model.Cliente;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// @Component
public class NotificadorEmail implements Notificador{

    private boolean caixaAlta;
    private String hostServerSMTP;

//    public NotificadorEmail(){
//        System.out.println("Instanciando um Notificador de EMAIL através do @Component");
//    }

    public NotificadorEmail(boolean caixaAlta, String hostServerSMTP){
        this.caixaAlta = caixaAlta;
        this.hostServerSMTP = hostServerSMTP;
        // System.out.println("Instanciando um Notificador de EMAIL através do @Component");
        System.out.println("Instanciando um Notificador de EMAIL");
    }

    public String notificar(Cliente cliente, String mensagem) {
        if (caixaAlta){
            mensagem.toUpperCase();
            System.out.printf("Notificando o cliente: %s através do e-mail:  %s a seguinte mensagem: %s com o servidorSMTP: %s", cliente.getNome(), cliente.getEmail(), mensagem, hostServerSMTP);
        }

        return "EMAIL";
    }
}
