package br.com.franca.apienriquecimento.service;

import br.com.franca.apienriquecimento.enuns.Erro;
import br.com.franca.apienriquecimento.exception.PessoaNaoEncontradaException;
import br.com.franca.apienriquecimento.model.Pessoa;
import br.com.franca.apienriquecimento.repository.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa findById(Long id) {
        log.info("inicio id: {}");
        return repository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(Erro.PESSOA_NAO_ENCONTRADA.getValor()));
    }
}
