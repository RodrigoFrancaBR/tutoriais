package br.com.franca.msenriquecimento.service;

import br.com.franca.msenriquecimento.client.apienriquecimento.ApiEnriquecimentoService;
import br.com.franca.msenriquecimento.domain.model.Aluno;
import br.com.franca.msenriquecimento.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class AlunoService {

    private final ModelMapper mapper;
    private final AlunoRepository repository;
    private final ApiEnriquecimentoService apiEnriquecimentoService;

    public Aluno findByCpf(String cpf) {
        log.info("inicio service cpf: {}", cpf);
        return repository.findByCpf(cpf)
                .orElseGet(() -> enriquecerAluno(cpf));
    }

    private Aluno enriquecerAluno(String cpf) {
        log.info("inicio enriquecer cpf: {}", cpf);
        var pessoaResponse = apiEnriquecimentoService.enriquecerAluno(cpf);
        return mapper.map(pessoaResponse, Aluno.class);
    }
}
