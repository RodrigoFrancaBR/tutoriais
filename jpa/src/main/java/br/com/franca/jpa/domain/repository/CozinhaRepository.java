package br.com.franca.jpa.domain.repository;


import br.com.franca.jpa.domain.model.Cozinha;

import java.util.List;

// podem ser orientado a persistencia ou a coleção
// repositorios por agregados
public interface CozinhaRepository {

    List<Cozinha> listar(); // todas
    Cozinha buscar(Long id); // porId
    Cozinha salvar(Cozinha cozinha); // adicionar
    void remover(Long cozinhaId);
}
