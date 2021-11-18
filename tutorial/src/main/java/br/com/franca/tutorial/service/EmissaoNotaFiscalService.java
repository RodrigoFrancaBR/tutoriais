package br.com.franca.tutorial.service;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.domain.model.Produto;
import org.springframework.util.ObjectUtils;

public class EmissaoNotaFiscalService {
    public boolean emitir(Cliente cliente, Produto produto) {

        if (ObjectUtils.isEmpty(cliente) || ObjectUtils.isEmpty(produto)){
            throw new IllegalArgumentException("Cliente e Produto devem ser válidos");
        }

        System.out.printf("Emitindo nota fiscal para o cliente: %s do produto: %s no valor de: ", cliente.getNome(), produto.getNome(), produto.getValor());
        return true;
    }
}
