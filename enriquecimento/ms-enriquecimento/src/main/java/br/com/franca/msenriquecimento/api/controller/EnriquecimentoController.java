package br.com.franca.msenriquecimento.api.controller;

import br.com.franca.msenriquecimento.domain.model.Cliente;
import br.com.franca.msenriquecimento.domain.service.EnriquecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/enriquecimento/clientes")
public class EnriquecimentoController {

    @Autowired
    private EnriquecimentoService service;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
