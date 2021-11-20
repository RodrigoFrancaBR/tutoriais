package br.com.franca.tutorial.listener;

import br.com.franca.tutorial.domain.model.Produto;
import br.com.franca.tutorial.event.ClienteAtivadoEvent;
import br.com.franca.tutorial.service.EmissaoNotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EmissaoNotaFiscal {

    @Autowired
    EmissaoNotaFiscalService service;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent clienteAtivadoEvent){
        System.out.println("Recebendo um evento de cliente ativado");
        Produto exemplo = Produto.builder().nome("EXEMPLO").valor(new BigDecimal("00.00")).build();
        String mensagem = "Quando fizer alguma compra, esse é um exemplo de nota fiscal que iremos emitir para você !!";
        service.emitir(clienteAtivadoEvent.getCliente(), exemplo);
    }
}
