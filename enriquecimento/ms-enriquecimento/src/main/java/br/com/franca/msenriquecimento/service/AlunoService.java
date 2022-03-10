package br.com.franca.msenriquecimento.service;

import br.com.franca.msenriquecimento.client.apienriquecimento.ApiEnriquecimentoService;
import br.com.franca.msenriquecimento.client.dto.PessoaResponse;
//import br.com.franca.msenriquecimento.domain.UsuarioAutenticado;
import br.com.franca.msenriquecimento.enums.Erro;
import br.com.franca.msenriquecimento.exceptions.AlunoNaoEncontradoException;
import br.com.franca.msenriquecimento.model.Aluno;
import br.com.franca.msenriquecimento.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class AlunoService {

    private final ModelMapper mapper;
    private final AlunoRepository repository;
    private final ApiEnriquecimentoService apiEnriquecimentoService;

    public Aluno findByCpf(String cpf) {
        log.info("inicio cpf: {}", cpf);
        return repository.findByCpf(cpf)
                .orElseGet(() -> enriquecerAluno(cpf));
    }

    private Aluno enriquecerAluno(String cpf) {
        log.info("inicio cpf: {}", cpf);
        var pessoaResponse = apiEnriquecimentoService.enriquecerAluno(cpf);
        var aluno = mapper.map(pessoaResponse, Aluno.class);
        return repository.save(aluno);
    }

//    // @Cacheable("enriquecimentoToken")
//    public Aluno efetuarLogin() {
//        PessoaResponse pessoa = pessoaService.findByCpf(cpf);
//        usarInterface.obterToken(null, null, null);
//
//        var usuarioAutenticado = client.obterToken(usuario, senha, cliente);
//
//        return usuarioAutenticado;
//    }
}
