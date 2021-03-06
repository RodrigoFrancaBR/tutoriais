package br.com.franca.apienriquecimento.service;

import br.com.franca.apienriquecimento.controller.dto.PessoaDTO;
import br.com.franca.apienriquecimento.enuns.Erro;
import br.com.franca.apienriquecimento.exception.PessoaNaoEncontradaException;
import br.com.franca.apienriquecimento.model.Pessoa;
import br.com.franca.apienriquecimento.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class PessoaService {
    private final ModelMapper mapper;
    private final PessoaRepository repository;

    public PessoaDTO findByCpf(String cpf) {
        log.info("inicio cpf: {}", cpf);
        return repository.findByCpf(cpf)
                .map(pessoa -> mapper.map(pessoa, PessoaDTO.class))
                .orElseThrow(() -> new PessoaNaoEncontradaException(Erro.PESSOA_NAO_ENCONTRADA.getValor()));
    }

    public PessoaDTO save(PessoaDTO pessoaDTO) {

        Pessoa pessoaMap =
                mapper.map(pessoaDTO, Pessoa.class);

        Pessoa pessoa =
                repository.save(pessoaMap);
        PessoaDTO pessoaDTOSave =
                mapper.map(pessoa, PessoaDTO.class);

        return pessoaDTOSave;
    }
}
