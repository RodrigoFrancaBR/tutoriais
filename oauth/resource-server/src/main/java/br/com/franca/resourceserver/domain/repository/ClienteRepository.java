package br.com.franca.resourceServer.domain.repository;

import br.com.franca.resourceServer.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, RevisionRepository<Cliente, Long, Long> {
}
