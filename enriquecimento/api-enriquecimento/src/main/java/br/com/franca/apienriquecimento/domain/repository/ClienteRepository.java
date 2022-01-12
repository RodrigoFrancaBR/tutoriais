package br.com.franca.apienriquecimento.domain.repository;

import br.com.franca.apienriquecimento.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
