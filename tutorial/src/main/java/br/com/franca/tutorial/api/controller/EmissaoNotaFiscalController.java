package br.com.franca.tutorial.api.controller;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.domain.model.Produto;
import br.com.franca.tutorial.service.EmissaoNotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class EmissaoNotaFiscalController {

    @Autowired
    private EmissaoNotaFiscalService service;

    @GetMapping("/emitir")
    public boolean emitir(){

        Cliente rodrigo = Cliente.builder()
                .nome("Rodrigo")
                .email("meuemail@email.com")
                .telefone("21985236417")
                .build();

        Produto computador = Produto.builder()
                .nome("Computador")
                .valor(new BigDecimal("5000.00"))
                .build();

        return service.emitir(rodrigo, computador);
    }
}
