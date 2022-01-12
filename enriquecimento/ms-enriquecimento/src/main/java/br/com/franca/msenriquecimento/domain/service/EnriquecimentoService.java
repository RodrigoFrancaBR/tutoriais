package br.com.franca.msenriquecimento.domain.service;

import br.com.franca.msenriquecimento.client.enriquecimento.IEnriquecimentoClient;
import br.com.franca.msenriquecimento.domain.UsuarioAutenticado;
import br.com.franca.msenriquecimento.domain.model.Cliente;
import br.com.franca.msenriquecimento.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EnriquecimentoService {
    private String usuario = "root";
    private String senha = "root";
    private String cliente = "Franca";

    @Autowired
    private IEnriquecimentoClient client;

    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Long id) {
        return repository.findById(id).orElseGet(() -> enriquecerCliente(id));
    }

    private Cliente enriquecerCliente(Long id) {
        return client.enriquecerCliente(id);
    }

    @Cacheable("enriquecimentoToken")
    public UsuarioAutenticado efetuarLogin() {
        var usuarioAutenticado = client.obterToken(usuario, senha, cliente);
        return usuarioAutenticado;
    }


}
