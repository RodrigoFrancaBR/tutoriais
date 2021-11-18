package br.com.franca.tutorial.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AtivacaoClienteController {

    @GetMapping("/ativar")
    public String ativar(){
        return "Success";
    }
}
