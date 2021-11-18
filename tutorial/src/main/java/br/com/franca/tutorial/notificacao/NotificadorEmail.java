package br.com.franca.tutorial.notificacao;

import br.com.franca.tutorial.domain.model.Cliente;

public class NotificadorEmail {

    public void notificar(Cliente cliente, String mensagem) {

        System.out.printf("Notificando o cliente: %s através do e-mail:  %s a seguinte mensagem: %s", cliente.getNome(), cliente.getTelefone(), mensagem);
    }
}
