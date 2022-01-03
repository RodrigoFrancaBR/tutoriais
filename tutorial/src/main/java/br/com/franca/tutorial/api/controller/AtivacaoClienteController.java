package br.com.franca.tutorial.api.controller;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.service.AtivacaoClienteService;
import br.com.franca.tutorial.service.funcionalidades.Funcionalidades;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AtivacaoClienteController {

    @Autowired
    private AtivacaoClienteService service;

    @Autowired
    private Funcionalidades funcionalidade;

    @GetMapping("/ativar")
    public String ativar(){
        funcionalidade.executarFuncionalidade();
        Cliente rodrigo = Cliente.builder()
                .nome("Rodrigo")
                .email("meuemail@email.com")
                .telefone("21985236417")
                .build();

        service.ativar(rodrigo);
        return "Success";
    }
}
