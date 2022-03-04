package br.com.franca.apienriquecimento.controller;

import br.com.franca.apienriquecimento.enuns.Erro;
import br.com.franca.apienriquecimento.model.Pessoa;
import br.com.franca.apienriquecimento.service.PessoaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/enriquecimento/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping(path = "id", produces = MediaType.TEXT_XML_VALUE)
    public Pessoa findById(@RequestParam Long id
                           // , @RequestParam String token
    ) {
        log.info("inicio id: {}, token: {}");
        return service.findById(id);

    }
}
