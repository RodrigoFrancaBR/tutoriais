package br.com.franca.msenriquecimento.controller;

import br.com.franca.msenriquecimento.model.Aluno;
import br.com.franca.msenriquecimento.service.AlunoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/enriquecimento/alunos")
@RestController
public class AlunoController {

    private final AlunoService service;

    @GetMapping(path = "/cpf/{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Aluno findByCpf(@PathVariable String cpf) {
        log.info("inicio cpf: {}", cpf);
        return service.findByCpf(cpf);
    }
}
