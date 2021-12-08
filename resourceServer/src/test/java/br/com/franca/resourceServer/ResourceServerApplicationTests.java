package br.com.franca.resourceServer;


import br.com.franca.resourceServer.domain.model.Cliente;
import br.com.franca.resourceServer.domain.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.history.Revision;
import org.springframework.data.history.RevisionMetadata;
import org.springframework.data.history.RevisionMetadata.RevisionType;
import org.springframework.data.history.Revisions;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ResourceServerApplicationTests {
    @Autowired
    ClienteRepository repository;
    Cliente updated;

    @BeforeEach
    void setup() {

        Cliente john = new Cliente();
        john.setNome("John");

        // create
        Cliente saved = repository.save(john);
        assertThat(saved).isNotNull();

        saved.setNome("Jonny");

        // update
        Cliente updated = repository.save(saved);
        assertThat(updated).isNotNull();

        // delete
        repository.delete(updated);

        this.updated = updated;
    }

    @Test
    void contextLoads() {
        Cliente updated = this.updated;

        Revisions<Long, Cliente> revisions = repository.findRevisions(updated.getId());

        Iterator<Revision<Long, Cliente>> revisionIterator = revisions.iterator();

        checkNextRevision(revisionIterator, "John", RevisionMetadata.RevisionType.INSERT);
        checkNextRevision(revisionIterator, "Jonny", RevisionMetadata.RevisionType.UPDATE);
        checkNextRevision(revisionIterator, null, RevisionMetadata.RevisionType.DELETE);
        assertThat(revisionIterator.hasNext()).isFalse();
    }

    private void checkNextRevision(Iterator<Revision<Long, Cliente>> revisionIterator, String name,
                                   RevisionType revisionType) {

        assertThat(revisionIterator.hasNext()).isTrue();
        Revision<Long, Cliente> revision = revisionIterator.next();
        assertThat(revision.getEntity().getNome()).isEqualTo(name);
        assertThat(revision.getMetadata().getRevisionType()).isEqualTo(revisionType);
    }

}
