package br.com.franca.resourceServer.domain.service;

import br.com.franca.resourceServer.domain.model.Cliente;
import br.com.franca.resourceServer.domain.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository repository;

    public List<Cliente> obter(){
        return repository.findAll();
    }

    public Optional<Cliente> obter(Long id){
        return repository.findById(id);
    }

    public Cliente salvar(Cliente cliente){
        return repository.save(cliente);
    }

    public void remover(Long id){
        repository.deleteById(id);
    }

    public void simular() {
        Cliente updated = setup();

        Revisions<Long, Cliente> revisions = repository.findRevisions(updated.getId());

        revisions.forEach(e->log.info("e: {}", e));

        Iterator<Revision<Long, Cliente>> revisionIterator = revisions.iterator();
    }

    private Cliente setup() {

        Cliente john = new Cliente();
        john.setNome("John");

        // create
        Cliente saved = repository.save(john);

        log.info("saved: {}", saved);

        saved.setNome("Jonny");

        // update
        Cliente updated = repository.save(saved);

        log.info("updated: {}", updated);

        // delete
        repository.delete(updated);

        log.info("updated: {}", updated);

        return updated;
    }
}
