package br.com.franca.tutorial.api.controller;

import br.com.franca.tutorial.domain.model.Cliente;
import br.com.franca.tutorial.service.AtivacaoClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AtivacaoClienteController {

    private AtivacaoClienteService service;

    public AtivacaoClienteController(AtivacaoClienteService service){
        this.service = service;
    }

    @GetMapping("/ativar")
    public String ativar(){

        Cliente rodrigo = Cliente.builder()
                .nome("Rodrigo")
                .email("meuemail@email.com")
                .telefone("21985236417")
                .build();

        service.ativar(rodrigo);
        return "Success";
    }
}
