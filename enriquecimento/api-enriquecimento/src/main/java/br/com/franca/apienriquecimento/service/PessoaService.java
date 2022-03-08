package br.com.franca.apienriquecimento.service;

import br.com.franca.apienriquecimento.controller.dto.PessoaDTO;
import br.com.franca.apienriquecimento.enuns.Erro;
import br.com.franca.apienriquecimento.exception.PessoaNaoEncontradaException;
import br.com.franca.apienriquecimento.model.Pessoa;
import br.com.franca.apienriquecimento.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.matcher.ModifierMatcher;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class PessoaService {
    private final ModelMapper mapper;
    private final PessoaRepository repository;

    public Pessoa findByCpf(String cpf) {
        log.info("inicio cpf: {}");
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new PessoaNaoEncontradaException(Erro.PESSOA_NAO_ENCONTRADA.getValor()));
    }

    public PessoaDTO save(PessoaDTO pessoaDTO) {

        Pessoa pessoaMap = mapper.map(pessoaDTO, Pessoa.class);

        Pessoa pessoa = repository.save(pessoaMap);
        PessoaDTO pessoaDTOSave = mapper.map(pessoa, PessoaDTO.class);

        return pessoaDTOSave;
    }
}
