package br.com.franca.apienriquecimento.controller;

import br.com.franca.apienriquecimento.controller.dto.PessoaDTO;
import br.com.franca.apienriquecimento.model.Pessoa;
import br.com.franca.apienriquecimento.service.PessoaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/enriquecimento/pessoas")
@RestController
public class PessoaController {

    private final PessoaService service;

    @GetMapping(path = "/cpf/{cpf}", produces = MediaType.TEXT_XML_VALUE)
    public Pessoa findByCpf(@PathVariable String cpf) {
        log.info("inicio id: {}");
        return service.findByCpf(cpf);
    }

    @PostMapping(produces = MediaType.TEXT_XML_VALUE)
    public ResponseEntity<PessoaDTO> save(@RequestBody PessoaDTO pessoaDTO) {
        log.info("inicio pessoaDTO: {}");
        PessoaDTO pessoaDTOSave = service.save(pessoaDTO);
        return ResponseEntity.ok(pessoaDTOSave);
    }
}
