package br.com.franca.tutorial.notificacao;

import br.com.franca.tutorial.domain.model.Cliente;

public class NotificadorSMS implements Notificador {

    @Override
    public String notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando o cliente: %s através do telefone:  %s a seguinte mensagem: %s", cliente.getNome(), cliente.getTelefone(), mensagem);
        return "SMS";
    }
}
