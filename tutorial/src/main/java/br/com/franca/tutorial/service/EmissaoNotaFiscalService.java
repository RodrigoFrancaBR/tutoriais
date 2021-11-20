package br.com.franca.tutorial.service;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.domain.model.Produto;
import br.com.franca.tutorial.domain.model.anotations.PrioridadeDoNotificador;
import br.com.franca.tutorial.domain.model.enums.Prioridade;
import br.com.franca.tutorial.service.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class EmissaoNotaFiscalService {

    @PrioridadeDoNotificador(Prioridade.UM)
    @Autowired
    private Notificador notificador;

    public boolean emitir(Cliente cliente, Produto produto) {
        String resultado = "SMS OU EMAIL ?";

        String mensagem = "Nota fiscal emitida com sucesso!!";

        if (ObjectUtils.isEmpty(cliente) || ObjectUtils.isEmpty(produto)){
            throw new IllegalArgumentException("Cliente e Produto devem ser válidos");
        }

        notificador.notificar(cliente,mensagem);
        System.out.println(resultado);

        return true;
    }
}
