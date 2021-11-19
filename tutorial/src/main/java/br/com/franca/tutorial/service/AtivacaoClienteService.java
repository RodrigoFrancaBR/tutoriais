package br.com.franca.tutorial.service;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.notificacao.Notificador;
import br.com.franca.tutorial.notificacao.NotificadorEmail;
import br.com.franca.tutorial.notificacao.NotificadorSMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class AtivacaoClienteService {

     private Notificador notificador;
//    @Autowired
//    private List<Notificador> notificadores;

    public AtivacaoClienteService(Notificador notificador){
        System.out.println("Instanciando uma Ativacao de Cliente com um notificador: " + notificador);
        this.notificador = notificador;
    }

    public String ativar(Cliente cliente) {
        String resultado = "SMS OU EMAIL ?";

        System.out.println("AtivacaoClienteService :: ativar");

        String mensagem = "Cadastro ativo com sucesso!!";

        if (ObjectUtils.isEmpty(cliente) || cliente.isAtivo()){
            throw new IllegalArgumentException("Cliente deve ser válido");
        }

        cliente.setAtivo(true);

//        for(Notificador notificador: notificadores){
//            System.out.printf("Para cada notificador notifica com o notificador: %s ", notificador);
//            System.out.println("::::::::;");
//            resultado = notificador.notificar(cliente, mensagem);
//        }
        return this.notificador.notificar(cliente, mensagem);
        // return  resultado;
    }
}
