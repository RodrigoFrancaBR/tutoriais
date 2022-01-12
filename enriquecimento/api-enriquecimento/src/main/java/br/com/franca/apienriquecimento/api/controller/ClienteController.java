package br.com.franca.apienriquecimento.api.controller;

import br.com.franca.apienriquecimento.domain.model.Cliente;
import br.com.franca.apienriquecimento.domain.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/enriquecimento/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping(path = "id", produces = MediaType.TEXT_XML_VALUE)
    public Cliente findById(@RequestParam Long id, @RequestParam String token) {
        log.info("inicio findById()");

        log.info("token: {}", token);
        return service.findById(id);

    }
}
