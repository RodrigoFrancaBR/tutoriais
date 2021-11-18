package br.com.franca.tutorial.notificacao;

import br.com.franca.tutorial.domain.model.Cliente;

public class NotificadorEmail implements Notificador{

    public String notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando o cliente: %s através do e-mail:  %s a seguinte mensagem: %s", cliente.getNome(), cliente.getEmail(), mensagem);
        return "EMAIL";
    }
}
