package br.com.franca.apienriquecimento.controller;

import br.com.franca.apienriquecimento.anotations.Auditavel;
import br.com.franca.apienriquecimento.controller.dto.PessoaDTO;
import br.com.franca.apienriquecimento.model.Pessoa;
import br.com.franca.apienriquecimento.service.PessoaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/enriquecimento/pessoas")
@RestController
public class PessoaController {

    private final PessoaService service;
    @Auditavel(nomeDaTabela = "tb_pessoas_findByCpf")
    @GetMapping(path = "/cpf/{cpf}", produces = MediaType.TEXT_XML_VALUE)
    public PessoaDTO findByCpf(@PathVariable String cpf) throws JsonProcessingException {
        log.info("inicio cpf: {}", cpf);
        return service.findByCpf(cpf);
    }

    @Auditavel(nomeDaTabela = "tb_pessoas_save")
    @PostMapping(produces = MediaType.TEXT_XML_VALUE)
    public ResponseEntity<PessoaDTO> save(@RequestBody PessoaDTO pessoaDTO) {
        log.info("inicio pessoaDTO: {}");
        PessoaDTO pessoaDTOSave = service.save(pessoaDTO);
        return ResponseEntity.ok(pessoaDTOSave);
    }
}
