package br.com.franca.tutorial.service;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.notificacao.Notificador;
import br.com.franca.tutorial.notificacao.NotificadorEmail;
import br.com.franca.tutorial.notificacao.NotificadorSMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;
// classe com baixa coesão.. está com duas responsabilidades. Ativar e notificar.
public class AtivacaoClienteService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

     private Notificador notificador;
//    @Autowired
//    private List<Notificador> notificadores;

    public AtivacaoClienteService(Notificador notificador){
        System.out.println("Instanciando uma Ativacao de Cliente com um notificador: " + notificador);
        this.notificador = notificador;
    }

    public void methodName1(){
        System.out.println("mesma coisa que por @PostConstruct no método : chamado depois do contrutor");
    }

    public void methodName2(){
        System.out.println("mesma coisa que por @PreDestroy no método : chamado depois do contrutor");
    }

    public String ativar(Cliente cliente) {
        String resultado = "SMS OU EMAIL ?";

        System.out.println("AtivacaoClienteService :: ativar");

        String mensagem = "Cadastro ativo com sucesso!!";

        if (ObjectUtils.isEmpty(cliente) || cliente.isAtivo()){
            throw new IllegalArgumentException("Cliente deve ser válido");
        }

        cliente.setAtivo(true);

        eventPublisher.publishEvent(cliente);

//        for(Notificador notificador: notificadores){
//            System.out.printf("Para cada notificador notifica com o notificador: %s ", notificador);
//            System.out.println("::::::::;");
//            resultado = notificador.notificar(cliente, mensagem);
//        }
        return this.notificador.notificar(cliente, mensagem);
        // return  resultado;
    }
}
