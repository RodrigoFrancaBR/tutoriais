package br.com.franca.tutorial.service;

import br.com.franca.tutorial.domain.model.Cliente;

import java.io.PrintStream;

public class NotificadorSMS {
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando o cliente: %s através do telefone:  %s a seguinte mensagem: %s", cliente.getNome(), cliente.getTelefone(), mensagem);
    }
}
