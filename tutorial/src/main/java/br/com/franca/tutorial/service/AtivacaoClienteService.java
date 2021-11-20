package br.com.franca.tutorial.service;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.event.ClienteAtivadoEvent;
import br.com.franca.tutorial.service.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.util.ObjectUtils;

public class AtivacaoClienteService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    private Notificador notificador;

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

    public void ativar(Cliente cliente) {
        String resultado = "SMS OU EMAIL ?";

        System.out.println("AtivacaoClienteService :: ativar");

        String mensagem = "Cadastro ativo com sucesso!!";

        if (ObjectUtils.isEmpty(cliente) || cliente.isAtivo()){
            throw new IllegalArgumentException("Cliente deve ser válido");
        }

        cliente.setAtivo(true);

        eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
    }
}
