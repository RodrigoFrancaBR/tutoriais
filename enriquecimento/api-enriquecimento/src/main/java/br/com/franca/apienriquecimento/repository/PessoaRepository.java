package br.com.franca.apienriquecimento.repository;

import br.com.franca.apienriquecimento.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
