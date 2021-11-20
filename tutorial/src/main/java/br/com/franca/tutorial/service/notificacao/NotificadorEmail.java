package br.com.franca.tutorial.service.notificacao;

import br.com.franca.tutorial.domain.model.Cliente;

public class NotificadorEmail implements Notificador{

    private boolean caixaAlta;
    private String hostServerSMTP;

    public NotificadorEmail(boolean caixaAlta, String hostServerSMTP){
        this.caixaAlta = caixaAlta;
        this.hostServerSMTP = hostServerSMTP;
        System.out.println("Instanciando um Notificador de EMAIL");
    }

    public String notificar(Cliente cliente, String mensagem) {
        if (caixaAlta){
            mensagem.toUpperCase();
            System.out.printf("Notificando o cliente: %s através do e-mail:  %s a seguinte mensagem: %s com o servidorSMTP: %s",
                    cliente.getNome(), cliente.getEmail(), mensagem, hostServerSMTP);
        }

        return "EMAIL";
    }
}
