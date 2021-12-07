package br.com.franca.resourceServer.api.controller;

import br.com.franca.resourceServer.domain.model.Cliente;
import br.com.franca.resourceServer.domain.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "clientes")
public class ClienteController {

    // private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
    private final ClienteService service;
    private final ModelMapper mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> obter(){
        log.info("Obtendo os clientes");
        return service.obter();

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente obter(@PathVariable("id") Long clientId){
        return service.obter(clientId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente){
        return service.salvar(cliente);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void salvar(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        service.obter(id)
                .map(clienteBase -> {
                    mapper.map(cliente, clienteBase);
                    service.salvar(clienteBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable("id") Long id){
        service.obter(id)
                .map(cliente -> {
                    service.remover(cliente.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado."));
    }




}
