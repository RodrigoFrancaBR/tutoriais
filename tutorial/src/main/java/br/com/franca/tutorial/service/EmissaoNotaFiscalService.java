package br.com.franca.tutorial.service;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.domain.model.Produto;
import br.com.franca.tutorial.notificacao.Notificador;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class EmissaoNotaFiscalService {

    private Notificador notificador;

    public EmissaoNotaFiscalService(Notificador notificador) {
        System.out.println("Instanciando uma Emissao de Nota Fiscal com um notificador: " + notificador);
        this.notificador = notificador;
    }

    public boolean emitir(Cliente cliente, Produto produto) {

        String mensagem = "Nota fiscal emitida com sucesso!!";

        if (ObjectUtils.isEmpty(cliente) || ObjectUtils.isEmpty(produto)){
            throw new IllegalArgumentException("Cliente e Produto devem ser válidos");
        }

        notificador.notificar(cliente,mensagem);
        return true;
    }
}
