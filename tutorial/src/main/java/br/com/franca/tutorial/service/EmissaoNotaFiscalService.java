package br.com.franca.tutorial.service;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.domain.model.Produto;
import br.com.franca.tutorial.domain.model.anotations.PrioridadeDoNotificador;
import br.com.franca.tutorial.domain.model.enums.Prioridade;
import br.com.franca.tutorial.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class EmissaoNotaFiscalService {

    // private Notificador notificador;
    @PrioridadeDoNotificador(Prioridade.DOIS)
    // @Qualifier("prioridade-0")
    @Autowired
    // private List<Notificador> notificadores;
    private Notificador notificador;

//    public EmissaoNotaFiscalService(Notificador notificador) {
//        System.out.println("Instanciando uma Emissao de Nota Fiscal com um notificador: " + notificador);
//        this.notificador = notificador;
//    }

    public boolean emitir(Cliente cliente, Produto produto) {
        String resultado = "SMS OU EMAIL ?";

        String mensagem = "Nota fiscal emitida com sucesso!!";

        if (ObjectUtils.isEmpty(cliente) || ObjectUtils.isEmpty(produto)){
            throw new IllegalArgumentException("Cliente e Produto devem ser válidos");
        }

//        for(Notificador notificador: notificadores){
//            System.out.printf("Para cada notificador notifica com o notificador: %s ", notificador);
//            System.out.println("::::::::;");
//            resultado = notificador.notificar(cliente, mensagem);
//        }

        notificador.notificar(cliente,mensagem);
        System.out.println(resultado);

        return true;
    }
}
